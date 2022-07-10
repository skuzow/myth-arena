package mytharena;

import mytharena.command.*;
import mytharena.data.Data;
import mytharena.data.character.Marketable;
import mytharena.data.character.ability.Discipline;
import mytharena.data.character.ability.Gift;
import mytharena.data.character.ability.Talent;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.hunter.Hunter;
import mytharena.data.character.factory.character.vampire.Vampire;
import mytharena.data.character.factory.character.werewolf.Werewolf;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.demon.Demon;
import mytharena.data.character.inventory.equipment.Armor;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.character.modifier.Modifier;
import mytharena.data.combat.Combat;
import mytharena.data.combat.Round;
import mytharena.data.market.Offer;
import mytharena.data.notification.CombatResultsNotification;
import mytharena.data.user.Admin;
import mytharena.data.user.Player;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;
import org.json.simple.JSONArray;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Map;

/**
 * Arena class
 */
public class Arena {

    /**
     * MythArenaGui mythArenaGui
     */
    private MythArenaGui mythArenaGui;
    /**
     * Data data
     */
    private Data data;
    /**
     * HashMap String Command commandMap
     */
    private final HashMap<String, Command> commandMap = new HashMap<>();
    /**
     * User activeUser
     */
    private User activeUser;
    /**
     * String serializablePath
     */
    private final String serializablePath = "./src/resources/serializable/data.bin";

    /**
     * Starts all, and have main loop of the application
     * @param gui boolean gui
     */
    public void start(boolean gui) {
        try {
            // retrieves data if serializable file exists
            File file = new File(this.serializablePath);
            if (file.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.serializablePath));
                this.data = (Data) in.readObject();
            } else {
                this.data = new Data();
                // default admin account
                this.data.getUserArrayList().add(new Admin("admin", "admin123", this.data));
                // armor pool
                this.data.getArmorPool().add(new Armor("Platemail", 0, 2,"Normal"));
                this.data.getArmorPool().add(new Armor("Chainmail", 0, 1,"Normal"));
                this.data.getArmorPool().add(new Armor("Blademail", 3, 2,"Epic"));
                this.data.getArmorPool().add(new Armor("Cuirass", 0, 3,"Legendary"));
                // weapon pool
                this.data.getWeaponPool().add(new Weapon("Broadsword", 1, 0, false, "Normal"));
                this.data.getWeaponPool().add(new Weapon("Claymore", 1, 1, false, "Epic"));
                this.data.getWeaponPool().add(new Weapon("Katana", 2, 0, false, "Legendary"));
                this.data.getWeaponPool().add(new Weapon("Axe", 2, 2, true, "Normal"));
                this.data.getWeaponPool().add(new Weapon("Rapier", 3, 0, false, "Normal"));
                this.serializeData();
            }
            // update player bans
            this.updateBans();
            // gui = true => normal use / gui = false => test use
            if (gui) {
                // init gui
                this.mythArenaGui = new MythArenaGui();
                // create commands and insert them into commandMap with respective key
                this.commandMap.put("AdminMenu", new AdminMenu(this, this.data, this.mythArenaGui));
                this.commandMap.put("StartMenu", new StartMenu(this, this.data, this.mythArenaGui));
                this.commandMap.put("PlayerMenu", new PlayerMenu(this, this.data, this.mythArenaGui));
                // main loop
                while (true) {
                    this.commandMap.get("StartMenu").execute();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Serializes Data
     */
    public void serializeData() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.serializablePath));
        out.writeObject(this.data);
        out.flush();
        out.close();
    }

    /**
     * Update bans
     */
    public void updateBans() {
        Date currentDate = new Date();
        ArrayList<Player> unBanPlayerArrayList = new ArrayList<>();
        for (Map.Entry<Player, Date> entry : this.data.getBannedPlayerMap().entrySet()) {
            // checks if player ban has to be removed
            if (currentDate.after(entry.getValue())) {
                unBanPlayerArrayList.add(entry.getKey());
            }
        }
        // unbans passed ban players
        for (Player player : unBanPlayerArrayList) {
            this.data.getBannedPlayerMap().remove(player);
        }
    }

    /**
     * Delete active user menu
     */
    public void deleteActiveUserMenu() {
        this.mythArenaGui.setMessageMode();
        this.mythArenaGui.setTitle("One step of deleting your account");
        this.mythArenaGui.setDescription("Be sure about this, there is no roll back!");
        this.mythArenaGui.setImage(0, "/resources/images/warning.png");
        this.mythArenaGui.setOption(0, "I don't want to delete my account");
        this.mythArenaGui.setOption(1, "Im sure about deleting my account");
        // account deletion
        if (this.mythArenaGui.waitEvent(30) == 'B') {
            try {
                this.data.getUserArrayList().remove(this.activeUser);
                this.serializeData();
                // for exiting to start menu
                this.setActiveUser(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Transfer market offer items to buyer when buy or back to seller if offer was denied
     * @param offer Offer offer
     * @param player Player player => buyer or seller
     */
    public void transferMarketOfferItems(Offer offer, Player player) {
        for (ArrayList<? extends Marketable> pack : offer.getItemList()) {
            if (pack.get(0) instanceof Weapon) {
                player.getCharacter().getInventory().getWeaponArrayList().addAll((ArrayList<? extends Equipment>) pack);
            } else if (pack.get(0) instanceof Armor) {
                player.getCharacter().getInventory().getArmorArrayList().addAll((ArrayList<? extends Equipment>) pack);
            } else {
                player.getCharacter().getMinionArrayList().addAll((ArrayList<? extends Minion>) pack);
            }
        }
        // player = buyer
        if (player != offer.getSeller()) {
            offer.setBuyer(player);
            this.data.getPurchasedOffers().add(offer);
            player.getCharacter().setGold(player.getCharacter().getGold() - offer.getPrice());
            offer.getSeller().getCharacter().setGold(offer.getSeller().getCharacter().getGold() + offer.getPrice());
            this.data.getMarketOffers().remove(offer);
        // player = seller
        } else {
            this.data.getPendingMarketOffers().remove(offer);
        }
    }

    /**
     * Checks compatibility between offer and player subscriptions
     * @param offer Offer offer
     * @param player Player player
     * @return boolean compatible
     */
    public boolean checkCompatibility(Offer offer, Player player) {
        boolean compatible = false;
        for (ArrayList<Marketable> itemList : offer.getItemList()){
            // Check character type
            Map characterSub = (Map) player.getMarketSubscriptions().get("Character");
            compatible = (boolean) characterSub.get(offer.getSeller().getCharacter().getClass().getSimpleName());
            if (compatible) break;

            // Check item type
            Map typeSub = (Map) player.getMarketSubscriptions().get("Type");
            if (typeSub.get(itemList.get(0).getClass().getSimpleName()) != null) {
                compatible = (boolean) typeSub.get(itemList.get(0).getClass().getSimpleName());
                if (compatible) break;
            }else {
                compatible = (boolean) typeSub.get("Minion");
                if (compatible) break;
            }

            // Check if within price range
            JSONArray priceRangeSub = (JSONArray) player.getMarketSubscriptions().get("Price");
            Long minLong = (Long) priceRangeSub.get(0);
            Long maxLong = (Long) priceRangeSub.get(1);
            compatible = offer.getPrice() >= minLong.intValue() && offer.getPrice() <= maxLong.intValue();
            if (compatible) break;

            //Checks depending on item type
            if (itemList.get(0) instanceof Weapon) {
                //Check weapon values
                Map value = (Map) player.getMarketSubscriptions().get("Value");
                Map weaponSub = (Map) value.get("Weapon");
                for (Marketable item : itemList) {
                    Weapon weapon = (Weapon) item;
                    Long attackLong = (Long) weaponSub.get("AttackModification");
                    if (attackLong != null) {
                        int attackModification = attackLong.intValue();
                        compatible = weapon.getAttackModification() == attackModification;
                        if (compatible) break;
                    }

                    Long defenseLong = (Long) weaponSub.get("DefenseModification");
                    if (defenseLong != null) {
                        int defenseModification = defenseLong.intValue();
                        compatible = weapon.getDefenseModification() == defenseModification;
                        if (compatible) break;
                    }

                    //Check weapon rarity
                    Map raritySub = (Map) player.getMarketSubscriptions().get("Rarity");
                    compatible = (boolean) raritySub.get(weapon.getRarity());
                    if (compatible) break;
                }
            } else if (itemList.get(0) instanceof Armor) {
                // Check armor values
                Map value = (Map) player.getMarketSubscriptions().get("Value");
                Map armorSub = (Map) value.get("Armor");
                for (Marketable item : itemList) {
                    Armor armor = (Armor) item;
                    Long attackLong = (Long) armorSub.get("AttackModification");
                    if (attackLong != null) {
                        int attackModification = attackLong.intValue();
                        compatible = armor.getAttackModification() == attackModification;
                        if (compatible) break;
                    }
                    Long defenseLong = (Long) armorSub.get("DefenseModification");
                    if (defenseLong != null) {
                        int defenseModification = defenseLong.intValue();
                        compatible = armor.getDefenseModification() == defenseModification;
                        if (compatible) break;
                    }
                    Map raritySub = (Map) player.getMarketSubscriptions().get("Rarity");
                    compatible = (boolean) raritySub.get(armor.getRarity());
                    if (compatible) break;
                }
            } else {
                //Check minion types
                Map minionType = (Map) player.getMarketSubscriptions().get("Minion");
                ArrayList<Minion> total = new ArrayList<>();
                ArrayList<? extends Marketable> minionArrayList = itemList;
                displayMinionPack((ArrayList<Minion>) minionArrayList,total);
                for (Minion minion : total) {
                    compatible = (boolean) minionType.get(minion.getClass().getSimpleName());
                    if (compatible) break;
                }
            }
        }
        return compatible;
    }

    /**
     * Displays minion pack recursive
     * @param minionPack ArrayList Minion minionPack
     * @param total ArrayList Minion total
     */
    public void displayMinionPack(ArrayList<Minion> minionPack, ArrayList<Minion> total) {
        for (Minion minion : minionPack) {
            if (minion instanceof Demon demon) {
                displayMinionPack(demon.getMinionArrayList(), total);
                total.add(demon);
            } else {
                total.add(minion);
            }
        }
    }

    /**
     * Serialize multiple elements
     * @param notValid StringBuilder notValid
     * @param outBounds StringBuilder outBounds
     * @param modified StringBuilder modified
     * @return boolean exit
     */
    public boolean serializeMultiple(StringBuilder notValid, StringBuilder outBounds, StringBuilder modified) {
        if (notValid.isEmpty()) {
            if (outBounds.isEmpty()) {
                try {
                    this.serializeData();
                    this.mythArenaGui.setDescription(modified + "value changed successfully!");
                    this.mythArenaGui.clearFieldText(0);
                    this.mythArenaGui.clearFieldText(1);
                    this.mythArenaGui.clearFieldText(2);
                    this.mythArenaGui.waitEvent(1);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                this.mythArenaGui.setDescription(outBounds + "have values out of bounds!");
            }
        } else {
            this.mythArenaGui.setDescription(notValid + "have not valid values");
        }
        return false;
    }

    /**
     * Sets User activeUser
     * @param activeUser User activeUser
     */
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    /**
     * Gets Data data
     * @return Data data
     */
    public Data getData() {
        return this.data;
    }

    /**
     * Gets specific Command command in commandMap with String key
     * @param key String key
     * @return Command command
     */
    public Command getCommand(String key) {
        return this.commandMap.get(key);
    }

    /**
     * Gets User activeUser
     * @return User activeUser
     */
    public User getActiveUser() {
        return this.activeUser;
    }

    /**
     * Combat Arena Tool
     * @param player1 Player player1
     * @param player2 Player player2
     * @param bet int bet
     * @param gui boolean gui
     */
    public void combat(Player player1, Player player2, int bet, boolean gui) {
        if (gui) {
            mythArenaGui.setCombatMode();
            mythArenaGui.setTitle("Combat in progress");
            mythArenaGui.setDescription(null);
            mythArenaGui.setOption(0,null);
            mythArenaGui.setOption(1,null);
            mythArenaGui.setHealthBar(0,5,5);
            mythArenaGui.setHealthBar(1,5,5);
            mythArenaGui.setCombatInfo(0,"VS");
            mythArenaGui.setCombatInfo(1, player1.getNickname());
            mythArenaGui.setCombatInfo(2,player2.getNickname());
            mythArenaGui.waitEvent(2);
        }
        Character character1 = player1.getCharacter().clone();
        Character character2 = player2.getCharacter().clone();
        Date date = new Date();
        int roundCount = 1;

        ArrayList<Round> roundsArrayList = new ArrayList<>();

        // Get weapon offense and defense for character 1
        int[] weaponModifierValues1 = calculateWeaponModifier(character1);
        int weaponOffense1 = weaponModifierValues1[0];
        int weaponDefense1 = weaponModifierValues1[1];

        // Get weapon offense and defense for character 2
        int[] weaponModifierValues2 = calculateWeaponModifier(character2);
        int weaponOffense2 = weaponModifierValues2[0];
        int weaponDefense2 = weaponModifierValues2[1];

        // Calculate minions total health
        int minionTotalHealth1 = calculateMinionsTotalHealth(character1.getMinionArrayList());
        int minionTotalHealth2 = calculateMinionsTotalHealth(character2.getMinionArrayList());

        while (character1.getHealth() > 0 && character2.getHealth() > 0) {
            if (gui) {
                mythArenaGui.setCombatInfo(0,"Round: "+ roundCount);
                mythArenaGui.setHealthBar(0,character1.getHealth(),5);
                mythArenaGui.setHealthBar(1,character2.getHealth(),5);
            }
            // Calculate character 1 ability, weaknesses and strengths
            int[] values1 = calculateCharacterModifiers(character1);
            int abilityOffense1 = values1[0];
            int abilityDefense1 = values1[1];
            int modifier1 = values1[2];

            // Calculate character 2 ability, weaknesses and strengths
            int[] values2 = calculateCharacterModifiers(character2);
            int abilityOffense2 = values2[0];
            int abilityDefense2 = values2[1];
            int modifier2 = values2[2];


            // Calculate attack and block potential of character 1
            int attackPotential1 = character1.getPower() + weaponOffense1 + abilityOffense1 + modifier1 + character1.getArmor().getAttackModification();
            int blockPotential1 = character1.getArmor().getDefenseModification() + abilityDefense1 + modifier1 + weaponDefense1;

            // Calculate attack and block potential of character 2
            int attackPotential2 = character2.getPower() + weaponOffense2 + abilityOffense2 + modifier2 + character1.getArmor().getAttackModification();
            int blockPotential2 = character2.getArmor().getDefenseModification() + abilityDefense2 + modifier2 + weaponDefense2;

            // Calculate attack and block value for player 1
            int attackValue1 = calculateValue(attackPotential1);
            int blockValue1 = calculateValue(blockPotential1);

            // Calculate attack and block value for player 2
            int attackValue2 = calculateValue(attackPotential2);
            int blockValue2 = calculateValue(blockPotential2);

            // Calculate both results
            int character1AttackResult = blockValue2 - attackValue1;
            int character2AttackResult = blockValue1 - attackValue2;

            if (character1AttackResult > 0) {
                if (character1 instanceof Vampire vampire) {
                    if (vampire.getBloodPoints() < 7) {
                        vampire.setBloodPoints(vampire.getBloodPoints() + 4);
                    }else {
                        vampire.setBloodPoints(10);
                    }
                }
                if (minionTotalHealth2 > 0){
                    minionTotalHealth2 -= attackValue1;
                }else {
                    character2.setHealth(character2.getHealth() - attackValue1);
                    if (character2 instanceof Werewolf werewolf) {
                        if (werewolf.getRage() < 3) {
                            werewolf.setRage(werewolf.getRage() + 1);
                        }
                    }
                    if (character2 instanceof Hunter hunter) {
                        if (hunter.getWill() > 1) {
                            hunter.setWill(hunter.getWill() - 1);
                        }else {
                            hunter.setWill(0);
                        }
                    }
                }
            }

            if (character2AttackResult > 0) {
                if (character2 instanceof Vampire vampire) {
                    if (vampire.getBloodPoints() < 7) {
                        vampire.setBloodPoints(vampire.getBloodPoints() + 4);
                    }else {
                        vampire.setBloodPoints(10);
                    }
                }
                if (minionTotalHealth1 > 0){
                    minionTotalHealth1 -= attackValue2;
                }else {
                    character1.setHealth(character1.getHealth() - attackValue2);
                    if (character2 instanceof Werewolf werewolf) {
                        if (werewolf.getRage() < 3) {
                            werewolf.setRage(werewolf.getRage() + 1);
                        }
                    }
                    if (character2 instanceof Hunter hunter) {
                        if (hunter.getWill() > 1) {
                            hunter.setWill(hunter.getWill() - 1);
                        }else {
                            hunter.setWill(0);
                        }

                    }
                }
            }
            if (gui) {
                mythArenaGui.waitEvent(1);
            }
            roundCount++;
            // If the attack did no damage then we save it as 0 in Combat class
            Round round = new Round(character1.getHealth(),character2.getHealth(),minionTotalHealth1,minionTotalHealth2,(Math.max(character1AttackResult, 0)),(Math.max(character2AttackResult, 0)));
            roundsArrayList.add(round);
        }
        Player winner;
        Player loser;
        Player playerWithMinionsLeft = null;

        // Check for battle result
        if (character1.getHealth() > 0) {
            winner = player1;
            loser = player2;
            if (minionTotalHealth1 > 0) {
                playerWithMinionsLeft = player1;
            }
        }else if (character1.getHealth() <= 0 && character2.getHealth() <= 0) {
            winner = null;
            loser = null;
        }else{
            winner = player2;
            loser = player1;
            if (minionTotalHealth2 > 0) {
                playerWithMinionsLeft = player2;
            }
        }
        Combat combat = new Combat(winner,loser,date,roundsArrayList,bet,playerWithMinionsLeft);
        data.getCombatArrayList().add(combat);
        if (winner != null) {
            winner.getCharacter().setGold(winner.getCharacter().getGold() + bet);
            winner.setGoldWonInBattle(winner.getGoldWonInBattle() + bet);
            loser.getCharacter().setGold(loser.getCharacter().getGold() - bet);
            loser.setGoldLostInBattle(loser.getGoldLostInBattle() + bet);
            if (gui) {
                mythArenaGui.setCombatInfo(0,winner.getNickname() + " wins!");
            }
        } else if (gui) {
            mythArenaGui.setCombatInfo(0,"DRAW!");
        }
        if (player1.isSubscriber()) {
            player1.getNotificationArrayList().add(new CombatResultsNotification("Battle vs " + player2.getNickname() + " results","Click on any of the following rounds below to see details",combat));
        }
        if (player2.isSubscriber()) {
            player2.getNotificationArrayList().add(new CombatResultsNotification("Battle vs " + player1.getNickname() + " results","Click on any of the following rounds below to see details",combat));
        }
        if (gui) {
            mythArenaGui.setHealthBar(0,character1.getHealth(),5);
            mythArenaGui.setHealthBar(1,character2.getHealth(),5);
            mythArenaGui.setCombatInfo(1,null);
            mythArenaGui.setCombatInfo(2,null);
            mythArenaGui.setOption(1,"Exit");
            mythArenaGui.waitEvent(10);
        }
        try {
           serializeData();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    /**
     * Checks String str can be converted to integer
     * @param str String str
     * @return boolean
     */
    public boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private int calculateMinionsTotalHealth(ArrayList<Minion> minionArrayList) {
        for(Minion minion : minionArrayList) {
            if (minion instanceof Demon) {
                calculateMinionsTotalHealth(((Demon) minion).getMinionArrayList());
            }
            return minion.getHealth();
        }
        return 0;
    }

    private int calculateValue(int potential) {
        Random rand = new Random();
        int numberSuccess = 0;
        for(int i = 0; i < potential; i++) {
            int roll = rand.nextInt(6)+1;
            if (roll > 4) {
                numberSuccess += 1;
            }
        }
        return numberSuccess;
    }

    private int[] calculateCharacterModifiers(Character character) {

        int[] values = new int[3];

        //Get date
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(localDateFormat.format(new Date()));

        int abilityOffense = 0;
        int abilityDefense = 0;
        int modifier = 0;

        if (character instanceof Vampire vampire) {
            Discipline vampireDiscipline = (Discipline) vampire.getAbility();
            if (vampireDiscipline.getCost() <= vampire.getBloodPoints()) {
                abilityOffense += vampireDiscipline.getAttackModifier();
                abilityDefense += vampireDiscipline.getDefenseModifier();
                if (vampire.getBloodPoints() >= 5) {
                    abilityOffense += 2;
                }

                vampire.setBloodPoints(vampire.getBloodPoints() - vampireDiscipline.getCost());
            }
            // Calculate modifiers for Vampire during daytime
            if (hour >= 7 && hour < 21) {
                for (Modifier weakness : vampire.getWeaknessArrayList()) {
                    switch (weakness.getSensibility()) {
                        case 1 -> modifier -= 1;
                        case 2 -> modifier -= 2;
                        case 3 -> modifier -= 3;
                        case 4 -> modifier -= 4;
                        case 5 -> modifier -= 5;
                    }
                }
            }
        } else if (character instanceof Werewolf werewolf) {
            Gift ability = (Gift) werewolf.getAbility();
            if (werewolf.getRage() >= ability.getRageMin()) {
                abilityOffense += ability.getAttackModifier();
                abilityDefense += ability.getDefenseModifier();
            }
            // Calculate modifiers for werewolves during nighttime
            if (hour < 7 || hour >= 21) {
                for (Modifier strength : werewolf.getFortitudeArrayList()) {
                    switch (strength.getSensibility()) {
                        case 1 -> modifier += 1;
                        case 2 -> modifier += 2;
                        case 3 -> modifier += 3;
                        case 4 -> modifier += 4;
                        case 5 -> modifier += 5;
                    }
                }
            }
        }else {
            Talent ability = (Talent) character.getAbility();
            abilityOffense += ability.getAttackModifier();
            abilityDefense += ability.getDefenseModifier();
        }
        values[0] = abilityOffense;
        values[1] = abilityDefense;
        values[2] = modifier;
        return values;
    }

    private int[] calculateWeaponModifier(Character character) {
        int [] values = new int[2];

        for(int i = 0; i  < character.getEquippedWeaponArrayList().size(); i++) {
            values[0] += character.getEquippedWeaponArrayList().get(i).getAttackModification();
            values[1] += character.getEquippedWeaponArrayList().get(i).getDefenseModification();
        }
        return values;
    }

}
