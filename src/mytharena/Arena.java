package mytharena;

import mytharena.command.*;
import mytharena.data.Data;
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
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.character.modifier.Modifier;
import mytharena.data.combat.Combat;
import mytharena.data.combat.Round;
import mytharena.data.notification.GeneralNotification;
import mytharena.data.user.Admin;
import mytharena.data.user.Player;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;
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
    private final MythArenaGui mythArenaGui = new MythArenaGui();
    /**
     * Data data
     */
    private Data data;
    /**
     * String serializablePath
     */
    private final String serializablePath = "./src/resources/serializable/data.bin";
    /**
     * HashMap String Command commandMap
     */
    private final HashMap<String, Command> commandMap = new HashMap<>();
    /**
     * User activeUser
     */
    private User activeUser;

    /**
     * Starts all, and have main loop of the application
     */
    public void start() {
        try {
            // retrieves data if serializable file exists
            File file = new File(this.serializablePath);
            if (file.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.serializablePath));
                this.data = (Data) in.readObject();
            } else {
                this.data = new Data();
                // default admin account
                this.data.getUserArrayList().add(new Admin("admin", "admin", this.data));
                // armor pool
                this.data.getArmorPool().add(new Armor("Platemail", 0, 2));
                this.data.getArmorPool().add(new Armor("Chainmail", 0, 1));
                this.data.getArmorPool().add(new Armor("Blademail", 3, 2));
                this.data.getArmorPool().add(new Armor("Cuirass", 0, 3));
                // weapon pool
                this.data.getWeaponPool().add(new Weapon("Broadsword", 1, 0, false));
                this.data.getWeaponPool().add(new Weapon("Claymore", 1, 1, false));
                this.data.getWeaponPool().add(new Weapon("Katana", 2, 0, false));
                this.data.getWeaponPool().add(new Weapon("Axe", 2, 2, true));
                this.data.getWeaponPool().add(new Weapon("Rapier", 3, 0, false));
                this.serializeData();
            }
            // create commands and insert them into commandMap with respective key
            this.commandMap.put("AdminMenu", new AdminMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("StartMenu", new StartMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("PlayerMenu", new PlayerMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("CharacterCreationMenu", new CharacterCreationMenu(this, this.data, this.mythArenaGui));
            // update player bans
            this.updateBans();
            // main loop
            while (true) {
                this.commandMap.get("StartMenu").execute();
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

   public void combat(Player player1, Player player2, int bet) {
        Character character1 = player1.getCharacter().clone();
        Character character2 = player2.getCharacter().clone();
        Date date = new Date();

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
                inflictDamage(character2,minionTotalHealth2,attackValue1);
            }
            if (character2AttackResult > 0) {
                inflictDamage(character1,minionTotalHealth1,attackValue2);
            }

            Round round = new Round(character1.getHealth(),character2.getHealth(),minionTotalHealth1,minionTotalHealth2,character1AttackResult,character2AttackResult);
            roundsArrayList.add(round);
        }
        Player winner;
        Player playerWithMinionsLeft = null;
        if (character1.getHealth() > 0) {
            winner = player1;
            if (minionTotalHealth1 > 0) {
                playerWithMinionsLeft = player1;
            }
        }else {
            winner = player2;
            if (minionTotalHealth2 > 0) {
                playerWithMinionsLeft = player2;
            }
        }
        Combat combat = new Combat(player2,player1,winner,date,roundsArrayList,bet,playerWithMinionsLeft);
        data.getCombatArrayList().add(combat);
        winner.getCharacter().setGold(winner.getCharacter().getGold() + bet);
       try {
           serializeData();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    private void inflictDamage(Character character, int minionTotalHealth, int damage) {
            if (minionTotalHealth > 0) {
                minionTotalHealth -= damage;
            }else {
                character.setHealth(character.getHealth() - damage);
                if (character instanceof Vampire vampire) {
                    if (vampire.getBloodPoints() < 7) {
                        vampire.setBloodPoints(vampire.getBloodPoints() + 4);
                    }else {
                        vampire.setBloodPoints(10);
                    }
                }
                if (character instanceof Werewolf werewolf) {
                    if (werewolf.getRage() < 3) {
                        werewolf.setRage(werewolf.getRage() + 1);
                    }
                }
                if (character instanceof Hunter hunter) {
                    if (hunter.getWill() > 1) {
                        hunter.setWill(hunter.getWill() - 1);
                    }else {
                        hunter.setWill(0);
                    }

                }
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
            }
        } else if (character instanceof Werewolf werewolf) {
            Gift ability = (Gift) werewolf.getAbility();
            if (werewolf.getRage() >= ability.getRageMin()) {
                abilityOffense += ability.getAttackModifier();
                abilityDefense += ability.getDefenseModifier();
            }
            // Calculate modifiers for werewolves during nighttime
            if (hour < 7 || hour >= 21) {
                for (Modifier strength : werewolf.getWeaknessArrayList()) {
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

        for(int i = 1; i  < 2; i++) {
            if (character.getEquippedWeaponArrayList().get(i) != null) {
                values[0] = character.getEquippedWeaponArrayList().get(i).getAttackModification();
                values[1] = character.getEquippedWeaponArrayList().get(i).getDefenseModification();
            }
        }
        return values;
    }
  
    /**
     * Sets User activeUser
     * @param activeUser User activeUser
     */
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
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
}
