package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.character.Marketable;
import mytharena.data.character.factory.character.CharacterFactory;
import mytharena.data.character.factory.character.hunter.HunterFactory;
import mytharena.data.character.factory.character.vampire.VampireFactory;
import mytharena.data.character.factory.character.werewolf.WerewolfFactory;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.demon.Demon;
import mytharena.data.character.inventory.equipment.Armor;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.combat.Combat;
import mytharena.data.combat.PendingCombat;
import mytharena.data.combat.Round;
import mytharena.data.market.Offer;
import mytharena.data.notification.CombatResultsNotification;
import mytharena.data.notification.GeneralNotification;
import mytharena.data.notification.Notification;
import mytharena.data.notification.PendingCombatNotification;
import mytharena.data.user.Player;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * PlayerMenu class extends Command
 */
public class PlayerMenu extends Command {

    /**
     * Player player
     */
    private Player player;

    /**
     * PlayerMenu class constructor extends Command
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public PlayerMenu(Arena arena, Data data, MythArenaGui mythArenaGui) {
        super(arena, data, mythArenaGui);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {
        player = (Player) super.getArena().getActiveUser();
        while (getArena().getActiveUser() != null) {
            super.getMythArenaGui().setButtonMode();
            super.getMythArenaGui().setTitle("Welcome to Myth Arena " + player.getUsername());
            getMythArenaGui().setDescription(null);
            super.getMythArenaGui().setOption(0, "Check gold");
            super.getMythArenaGui().setOption(1, "Challenge user");
            super.getMythArenaGui().setOption(2, "Create character");
            super.getMythArenaGui().setOption(3, "Delete character");
            super.getMythArenaGui().setOption(4, "Select equipment");
            super.getMythArenaGui().setOption(5, "Buy/Sell items");
            super.getMythArenaGui().setOption(6, "View ranking");
            super.getMythArenaGui().setOption(7, "View notifications");
            getMythArenaGui().setOption(8,"Logout");
            getMythArenaGui().setOption(9, null);

            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> getGold();
                case 'B' -> challengeUser();
                case 'C' -> createCharacter();
                case 'D' -> deleteCharacter();
                case 'E' -> selectEquipment();
                case 'F' -> viewMarket();
                case 'G' -> viewRanking();
                case 'H' -> viewNotifications();
                case 'I' -> getArena().setActiveUser(null);
            }
        }
    }

    /**
     * View Market
     */
    private void viewMarket() {
        boolean exitMarket = false;
        while(!exitMarket) {
            super.getMythArenaGui().setButtonMode();
            super.getMythArenaGui().setTitle("Welcome to the Market Place");
            super.getMythArenaGui().setDescription("Select the operation you wish to make");
            super.getMythArenaGui().setOption(0, null);
            super.getMythArenaGui().setOption(1, null);
            super.getMythArenaGui().setOption(2, null);
            super.getMythArenaGui().setOption(3, null);
            super.getMythArenaGui().setOption(4, null);
            super.getMythArenaGui().setOption(5, null);
            super.getMythArenaGui().setOption(6, "Sell");
            super.getMythArenaGui().setOption(7, "Buy");
            super.getMythArenaGui().setOption(8, "Back");
            super.getMythArenaGui().setOption(9, "Notification settings");
            switch (getMythArenaGui().waitEvent(30)) {
                // sell
                case 'G' -> {
                    // exit if no character
                    if (this.player.getCharacter() == null) {
                        super.getMythArenaGui().setDescription("You can't sell in the market without a character!");
                        super.getMythArenaGui().waitEvent(3);
                    } else {
                        this.sellMarket();
                    }
                }
                // buy
                case 'H' -> {
                    // exit if no character
                    if (this.player.getCharacter() == null) {
                        super.getMythArenaGui().setDescription("You can't buy in the market without a character!");
                        super.getMythArenaGui().waitEvent(3);
                    } else {
                        this.buyMarket();
                    }
                }
                // exit
                case 'I' -> exitMarket = true;
                // notification settings
                case 'J' -> this.marketNotification();
            }
        }
    }

    /**
     * Sell Market
     */
    private void sellMarket() {
        // copy lists for modifying inside here
        ArrayList<Equipment> armorList = new ArrayList<>(this.player.getCharacter().getInventory().getArmorArrayList());
        ArrayList<Equipment> weaponList = new ArrayList<>(this.player.getCharacter().getInventory().getWeaponArrayList());
        ArrayList<Minion> minionList = new ArrayList<>(this.player.getCharacter().getMinionArrayList());
        // pack to save in offer after
        ArrayList<Marketable> armorPack = new ArrayList<>();
        ArrayList<Marketable> weaponPack = new ArrayList<>();
        ArrayList<Marketable> minionPack = new ArrayList<>();
        int totalPrice = 0;
        boolean exitSell = false;
        while (!exitSell) {
            ArrayList<String> displayList = new ArrayList<>();
            // armors
            if (!armorList.isEmpty()) {
                for (Equipment armor : armorList) {
                    displayList.add(
                        "Armor: " + armor.getName() +
                        " || AttackModification: " + armor.getAttackModification() +
                        " || DefenseModification: " + armor.getDefenseModification()
                    );
                }
            }
            // weapons
            if (!weaponList.isEmpty()) {
                for (Equipment weapon : weaponList) {
                    displayList.add(
                        "Weapon: " + weapon.getName() +
                        " || AttackModification: " + weapon.getAttackModification() +
                        " || DefenseModification: " + weapon.getDefenseModification() +
                        " || TwoHands: " + ((Weapon) weapon).isTwoHands()
                    );
                }
            }
            // minions
            if (!minionList.isEmpty()) {
                ArrayList<Minion> total = new ArrayList<>();
                displayMinionPack(minionList,total);
                displayList.add("Minions: " + total.size());
            }
            // list itself
            super.getMythArenaGui().setListMode();
            super.getMythArenaGui().setTitle("Choose the item you want to sell");
            super.getMythArenaGui().setOption(0, "Cancel");
            super.getMythArenaGui().setOption(1, "Select");
            super.getMythArenaGui().setList(displayList);
            switch (getMythArenaGui().waitEvent(30)) {
                case 'A' -> exitSell = true;
                case 'B' -> {
                    int index = super.getMythArenaGui().getLastSelectedListIndex();
                    // if item selected
                    if (index != -1) {
                        int price = itemPriceGetter();
                        if (price != -1) {
                            totalPrice += price;
                            int armorMaxIndex = armorList.size();
                            int weaponMaxIndex = weaponList.size() + armorMaxIndex;
                            // armor selected
                            if (index < armorMaxIndex) {
                                Equipment armor = armorList.get(index);
                                armorPack.add(armor);
                                armorList.remove(armor);
                            // weapon selected
                            } else if (index < weaponMaxIndex) {
                                index -= armorMaxIndex;
                                Equipment weapon = weaponList.get(index);
                                weaponPack.add(weapon);
                                weaponList.remove(weapon);
                            // minion selected
                            } else {
                                minionPack = new ArrayList<>(minionList);
                                minionList = new ArrayList<>();
                            }
                            boolean exitConfirmation = false;
                            while (!exitConfirmation) {
                                super.getMythArenaGui().setMessageMode();
                                super.getMythArenaGui().setTitle(null);
                                super.getMythArenaGui().setDescription("Do you wish to add more items to your offer?");
                                super.getMythArenaGui().setOption(0, "Finish");
                                super.getMythArenaGui().setOption(1, "Add more");
                                // save offer
                                switch (super.getMythArenaGui().waitEvent(30)) {
                                    case 'A' -> {
                                        try {
                                            // create offer
                                            ArrayList<ArrayList<Marketable>> itemList = new ArrayList<>();
                                            // use stuff lists because all of them are updated without items inside offer
                                            if (!armorPack.isEmpty()) {
                                                itemList.add(armorPack);
                                                player.getCharacter().getInventory().setArmorArrayList(armorList);
                                            }
                                            if (!weaponPack.isEmpty()) {
                                                itemList.add(weaponPack);
                                                player.getCharacter().getInventory().setWeaponArrayList(weaponList);
                                            }
                                            if (!minionPack.isEmpty()) {
                                                itemList.add(minionPack);
                                                player.getCharacter().setMinionArrayList(minionList);
                                            }
                                            Offer offer = new Offer(player, totalPrice, itemList);
                                            super.getData().getMarketOffers().add(offer);
                                            for (User user : getData().getUserArrayList()) {
                                                if (user instanceof Player buyer) {
                                                    if (checkCompatibility(offer, buyer)) {
                                                        buyer.notifyPlayer();
                                                    }
                                                }
                                            }
                                            super.getArena().serializeData();
                                            super.getMythArenaGui().setDescription("Offer successfully created!");
                                            super.getMythArenaGui().waitEvent(3);
                                            exitConfirmation = true;
                                            exitSell = true;
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    case 'B' -> exitConfirmation = true;
                                }
                            }
                        }
                        // goes back to item list sell
                    } else {
                        getMythArenaGui().setDescription("You must select an item to sell!");
                    }
                }
            }
        }
    }

    /**
     * Item Sell Price Getter
     * @return int price
     */
    private int itemPriceGetter() {
        super.getMythArenaGui().setFormMode();
        super.getMythArenaGui().setTitle(null);
        super.getMythArenaGui().setDescription(null);
        super.getMythArenaGui().setField(0, "Name a price for this item:");
        super.getMythArenaGui().setField(1, null);
        super.getMythArenaGui().setField(2, null);
        super.getMythArenaGui().setOption(0, "Back");
        super.getMythArenaGui().setOption(1, "Continue");
        boolean exit = false;
        while (!exit) {
            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> exit = true;
                case 'B' -> {
                    String value = super.getMythArenaGui().getFieldText(0);
                    if (super.getArena().isInteger(value)) {
                        int price = Integer.parseInt(value);
                        if (price > 0) {
                            super.getMythArenaGui().setDescription("Price successfully saved!");
                            super.getMythArenaGui().waitEvent(1);
                            super.getMythArenaGui().clearFieldText(0);
                            return price;
                        } else {
                            super.getMythArenaGui().setDescription("Price needs to be higher than 0!");
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Invalid price provided!");
                    }
                    super.getMythArenaGui().waitEvent(3);
                }
            }
        }
        return -1;
    }



    /**
     * Buy Market
     */
    private void buyMarket() {
        boolean exit = false;
        while(!exit) {
            getMythArenaGui().setListMode();
            getMythArenaGui().setTitle("Choose the item you want to buy");
            getMythArenaGui().setDescription(null);
            getMythArenaGui().setOption(0, "Back");
            getMythArenaGui().setOption(1, "Open");
            ArrayList<String> displayList = new ArrayList<>();
            for (Offer offer : getData().getMarketOffers()) {
                displayList.add("Offer price: " + offer.getPrice());
            }
            getMythArenaGui().setList(displayList);

            switch (getMythArenaGui().waitEvent(30)) {
                // View offer
                case 'B' -> {
                    int index = getMythArenaGui().getLastSelectedListIndex();
                    if (index != -1) {
                        boolean exitOffer = false;
                        while(!exitOffer) {
                            // Display contents of offer
                            Offer offer = getData().getMarketOffers().get(index);
                            ArrayList<String> offerList = new ArrayList<>();
                            for (ArrayList<Marketable> pack : offer.getItemList()) {
                                for (Marketable item : pack) {
                                    if (item instanceof Weapon weapon) {
                                        offerList.add("Weapon: " + weapon.getName() +
                                            " || AttackModification: " + weapon.getAttackModification() +
                                            " || DefenseModification: " + weapon.getDefenseModification() +
                                            " || TwoHands: " + weapon.isTwoHands()
                                        );
                                    } else if (item instanceof Armor armor) {
                                        offerList.add("Armor: " + armor.getName() +
                                            " || AttackModification: " + armor.getAttackModification() +
                                            " || DefenseModification: " + armor.getDefenseModification()
                                        );
                                    } else {
                                        Minion minion = (Minion) item;
                                        if (minion instanceof Demon demon) {
                                            ArrayList<Minion> total = new ArrayList<>();
                                            displayMinionPack(demon.getMinionArrayList(), total);
                                            total.add(demon);
                                            for (Minion minion1 : total) {
                                                offerList.add("Minion type: " + minion1.getClass().getSimpleName() +
                                                    " || Health: " + minion1.getHealth()
                                                );
                                            }
                                        } else {
                                            offerList.add("Minion type: " + minion.getClass().getSimpleName() +
                                                " || Health: " + minion.getHealth()
                                            );
                                        }
                                    }
                                }
                            }
                            getMythArenaGui().setList(offerList);
                            getMythArenaGui().setOption(0,"Back");
                            getMythArenaGui().setOption(1,"Buy");

                            if (getMythArenaGui().waitEvent(30) == 'A') {
                                exitOffer = true;
                            } else {
                                if (offer.getPrice() <= player.getCharacter().getGold()) {
                                    transferItems(offer,player);
                                    getMythArenaGui().setDescription("Purchased successfully");
                                    getMythArenaGui().waitEvent(2);
                                    try {
                                        getArena().serializeData();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    exitOffer = true;
                                } else {
                                    getMythArenaGui().setDescription("You don't have enough gold!");
                                    getMythArenaGui().waitEvent(3);
                                }
                            }
                        }
                    } else {
                        getMythArenaGui().setDescription("You must select an offer to open");
                    }
                }
                // exit buy market
                case 'A' -> exit = true;
            }
        }
    }

    private void transferItems(Offer offer, Player buyer) {
        for (ArrayList<? extends Marketable> pack : offer.getItemList()) {
            if (pack.get(0) instanceof Weapon) {
                buyer.getCharacter().getInventory().getWeaponArrayList().addAll((ArrayList<? extends Equipment>) pack);
            } else if (pack.get(0) instanceof Armor) {
                buyer.getCharacter().getInventory().getArmorArrayList().addAll((ArrayList<? extends Equipment>) pack);
            } else {
                buyer.getCharacter().getMinionArrayList().addAll((ArrayList<? extends Minion>) pack);
            }
        }
        getData().getMarketOffers().remove(offer);
        offer.setBuyer(buyer);
        getData().getPurchasedOffers().add(offer);
        buyer.getCharacter().setGold(buyer.getCharacter().getGold()-offer.getPrice());
        offer.getSeller().getCharacter().setGold(offer.getSeller().getCharacter().getGold()+offer.getPrice());
    }

    private boolean checkCompatibility(Offer offer, Player player) {
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
            }else {
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
    private void displayMinionPack(ArrayList<Minion> minionPack, ArrayList<Minion> total) {
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
     * Market notification
     */
    private void marketNotification() {
        ArrayList<String> genericDisplayList = new ArrayList<>();
        genericDisplayList.add("Type");
        genericDisplayList.add("Rarity");
        genericDisplayList.add("Minion");
        genericDisplayList.add("Character");
        genericDisplayList.add("Value");
        genericDisplayList.add("Loyalty");
        genericDisplayList.add("Price");
        boolean exit = false;
        while (!exit) {
            super.getMythArenaGui().setListMode();
            super.getMythArenaGui().setTitle("Choose a category of subscription");
            super.getMythArenaGui().setDescription(null);
            super.getMythArenaGui().setOption(0, "Back");
            super.getMythArenaGui().setOption(1, "Select");
            super.getMythArenaGui().setList(genericDisplayList);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // exit market notification
                case 'A' -> exit = true;
                // enter type
                case 'B' -> {
                    int index = super.getMythArenaGui().getLastSelectedListIndex();
                    switch (index) {
                        // no selected
                        case -1 -> {
                            super.getMythArenaGui().setDescription("You must select a category to open!");
                            super.getMythArenaGui().waitEvent(3);
                        }
                        // type
                        case 0 -> {
                            ArrayList<String> specificList = new ArrayList<>();
                            specificList.add("Armor");
                            specificList.add("Weapon");
                            specificList.add("Minion");
                            this.boolModifyMarketNotification(genericDisplayList.get(index), specificList);
                        }
                        // rarity
                        case 1 -> {
                            ArrayList<String> specificList = new ArrayList<>();
                            specificList.add("Legendary");
                            specificList.add("Epic");
                            specificList.add("Normal");
                            this.boolModifyMarketNotification(genericDisplayList.get(index), specificList);
                        }
                        // minion
                        case 2 -> {
                            ArrayList<String> specificList = new ArrayList<>();
                            specificList.add("Demon");
                            specificList.add("Ghoul");
                            specificList.add("Human");
                            this.boolModifyMarketNotification(genericDisplayList.get(index), specificList);
                        }
                        // character type
                        case 3 -> {
                            ArrayList<String> specificList = new ArrayList<>();
                            specificList.add("Hunter");
                            specificList.add("Vampire");
                            specificList.add("Werewolf");
                            this.boolModifyMarketNotification(genericDisplayList.get(index), specificList);
                        }
                        // value
                        case 4 -> {
                            ArrayList<String> specificList = new ArrayList<>();
                            specificList.add("AttackModification");
                            specificList.add("DefenseModification");
                            HashMap<String, ArrayList<String>> complexMap = new HashMap<>();
                            complexMap.put("Armor", specificList);
                            complexMap.put("Weapon", specificList);
                            this.longModifyMarketNotificationMap(genericDisplayList.get(index), complexMap);
                        }
                        // loyalty
                        case 5 -> this.longModifyMarketNotification(genericDisplayList.get(index));
                        // price range
                        case 6 -> this.longModifyMarketNotificationList(genericDisplayList.get(index));
                    }
                }
            }
        }
    }

    /**
     * Boolean Modify Market Notification
     * @param category String category
     * @param specificList ArrayList String specificList
     */
    private void boolModifyMarketNotification(String category, ArrayList<String> specificList) {
        boolean exit = false;
        while (!exit) {
            JSONObject playerCategorySubscriptions = (JSONObject) player.getMarketSubscriptions().get(category);
            ArrayList<String> specificDisplayList = new ArrayList<>();
            // display subscriptions with enable or disabled
            for (String subscription : specificList) {
                specificDisplayList.add(subscription +
                    " || Status: " + ((boolean) playerCategorySubscriptions.get(subscription) ? "Enabled" : "Disabled")
                );
            }
            super.getMythArenaGui().setTitle("Choose a type of subscription");
            super.getMythArenaGui().setDescription(null);
            super.getMythArenaGui().setOption(0, "Back");
            super.getMythArenaGui().setOption(1, "Toggle");
            super.getMythArenaGui().setList(specificDisplayList);
            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> exit = true;
                case 'B' -> {
                    int index = super.getMythArenaGui().getLastSelectedListIndex();
                    if (index != -1) {
                        String chooseSubscription = specificList.get(index);
                        // disable item
                        if ((boolean) playerCategorySubscriptions.get(chooseSubscription)) {
                            try {
                                playerCategorySubscriptions.put(chooseSubscription, false);
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Successfully disabled subscription for " + chooseSubscription);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        // enable item
                        } else {
                            try {
                                playerCategorySubscriptions.put(chooseSubscription, true);
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Successfully enabled subscription for " + chooseSubscription);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        super.getMythArenaGui().waitEvent(1);
                    } else {
                        super.getMythArenaGui().setDescription("You must select a type to open!");
                        super.getMythArenaGui().waitEvent(3);
                    }
                }
            }
        }
    }

    /**
     * Long Modify Market Notification Map
     * @param category String category
     * @param complexMap HashMap String ArrayList String
     */
    private void longModifyMarketNotificationMap(String category, HashMap<String, ArrayList<String>> complexMap) {
        boolean exitList = false;
        while (!exitList) {
            JSONObject playerCategorySubscriptions = (JSONObject) player.getMarketSubscriptions().get(category);
            ArrayList<String> specificDisplayList;
            // display subscriptions
            specificDisplayList = this.iterateMap(playerCategorySubscriptions, complexMap);
            super.getMythArenaGui().setListMode();
            super.getMythArenaGui().setTitle("Choose a type of subscription");
            super.getMythArenaGui().setDescription(null);
            super.getMythArenaGui().setOption(0, "Back");
            super.getMythArenaGui().setOption(1, "Modify");
            super.getMythArenaGui().setList(specificDisplayList);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // exit
                case 'A' -> exitList = true;
                // enter form mode to modify value
                case 'B' -> {
                    int index = super.getMythArenaGui().getLastSelectedListIndex();
                    if (index != -1) {
                        boolean exitField = false;
                        while (!exitField) {
                            super.getMythArenaGui().setFormMode();
                            super.getMythArenaGui().setTitle("Modify values you want to change");
                            super.getMythArenaGui().setDescription("To disable a subscription set it to -1");
                            super.getMythArenaGui().setField(0, specificDisplayList.get(index));
                            super.getMythArenaGui().setField(1, null);
                            super.getMythArenaGui().setField(2, null);
                            switch (super.getMythArenaGui().waitEvent(30)) {
                                case 'A' -> exitField = true;
                                case 'B' -> {
                                    String fieldValueString = super.getMythArenaGui().getFieldText(0);
                                    if (super.getArena().isInteger(fieldValueString) && Integer.parseInt(fieldValueString) >= -1) {
                                        long lastValue = this.getValueIterateMap(playerCategorySubscriptions, complexMap, index);
                                        long fieldValue = Long.parseLong(fieldValueString);
                                        try {
                                            this.setValueIterateMap(playerCategorySubscriptions, complexMap, index, fieldValue);
                                            super.getMythArenaGui().clearFieldText(0);
                                            super.getArena().serializeData();
                                            if (lastValue == -1) {
                                                super.getMythArenaGui().setDescription("Successfully disabled subscription");
                                            } else {
                                                super.getMythArenaGui().setDescription("Successfully enabled subscription with " + fieldValue  + " value");
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        // update display
                                        specificDisplayList = this.iterateMap(playerCategorySubscriptions, complexMap);
                                        super.getMythArenaGui().waitEvent(1);
                                    } else {
                                        super.getMythArenaGui().setDescription("Invalid value");
                                        super.getMythArenaGui().clearFieldText(0);
                                        super.getMythArenaGui().waitEvent(3);
                                    }
                                }
                            }
                        }
                    } else {
                        super.getMythArenaGui().setDescription("You must select a type to open!");
                        super.getMythArenaGui().waitEvent(3);
                    }
                }
            }
        }
    }

    /**
     * Iterates map given and generate specificDisplayList with map inside values
     * @param playerCategorySubscriptions JSONObject playerCategorySubscriptions
     * @param complexMap HashMap String ArrayList String complexMap
     * @return specificDisplayList ArrayList String specificDisplayList
     */
    private ArrayList<String> iterateMap(JSONObject playerCategorySubscriptions, HashMap<String, ArrayList<String>> complexMap) {
        ArrayList<String> specificDisplayList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : complexMap.entrySet()) {
            String key = entry.getKey();
            JSONObject deepPlayerCategorySubscriptions = (JSONObject) playerCategorySubscriptions.get(key);
            for (String subscription : entry.getValue()) {
                long subscriptionValue = (long) deepPlayerCategorySubscriptions.get(subscription);
                specificDisplayList.add(key + " : " + subscription +
                    " || Status: " + (subscriptionValue != -1 ? subscriptionValue : "Disabled")
                );
            }
        }
        return specificDisplayList;
    }

    /**
     * Gets value Iterating given map
     * @param playerCategorySubscriptions JSONObject playerCategorySubscriptions
     * @param complexMap HashMap String ArrayList String complexMap
     * @param index int index
     */
    private long getValueIterateMap(JSONObject playerCategorySubscriptions, HashMap<String, ArrayList<String>> complexMap, int index) {
        int cont = 0;
        for (Map.Entry<String, ArrayList<String>> entry : complexMap.entrySet()) {
            JSONObject deepPlayerCategorySubscriptions = (JSONObject) playerCategorySubscriptions.get(entry.getKey());
            for (String subscription : entry.getValue()) {
                if (cont == index) return (long) deepPlayerCategorySubscriptions.get(subscription);
                cont++;
            }
        }
        return -2;
    }

    /**
     * Sets value Iterating given map
     * @param playerCategorySubscriptions JSONObject playerCategorySubscriptions
     * @param complexMap HashMap String ArrayList String complexMap
     * @param index int index
     * @param value long value
     */
    private void setValueIterateMap(JSONObject playerCategorySubscriptions, HashMap<String, ArrayList<String>> complexMap, int index, long value) {
        int cont = 0;
        for (Map.Entry<String, ArrayList<String>> entry : complexMap.entrySet()) {
            JSONObject deepPlayerCategorySubscriptions = (JSONObject) playerCategorySubscriptions.get(entry.getKey());
            for (String subscription : entry.getValue()) {
                if (cont == index) {
                    deepPlayerCategorySubscriptions.put(subscription, value);
                    return;
                }
                cont++;
            }
        }
    }

    /**
     * Long Modify Market Notification
     * @param category String category
     */
    private void longModifyMarketNotification(String category) {
        boolean exit = false;
        while (!exit) {
            JSONObject marketSubscriptions = player.getMarketSubscriptions();
            long subscriptionValue = (Long) marketSubscriptions.get(category);
            String subInformation = category + " || Status: " + (subscriptionValue != -1 ? subscriptionValue : "Disabled");
            super.getMythArenaGui().setFormMode();
            super.getMythArenaGui().setTitle("Modify values you want to change");
            super.getMythArenaGui().setDescription("To disable a subscription set it to -1");
            super.getMythArenaGui().setOption(0, "Back");
            super.getMythArenaGui().setOption(1, "Modify");
            super.getMythArenaGui().setField(0, subInformation);
            super.getMythArenaGui().setField(1, null);
            super.getMythArenaGui().setField(2, null);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // exit
                case 'A' -> exit = true;
                // modify value
                case 'B' -> {
                    String fieldValueString = super.getMythArenaGui().getFieldText(0);
                    if (super.getArena().isInteger(fieldValueString) && Integer.parseInt(fieldValueString) >= -1) {
                        long fieldValue = Long.parseLong(fieldValueString);
                        try {
                            marketSubscriptions.put(category, fieldValue);
                            super.getMythArenaGui().clearFieldText(0);
                            super.getArena().serializeData();
                            if (fieldValue == -1) {
                                super.getMythArenaGui().setDescription("Successfully disabled subscription");
                            } else {
                                super.getMythArenaGui().setDescription("Successfully enabled subscription with " + fieldValue  + " value");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        super.getMythArenaGui().waitEvent(1);
                    } else {
                        super.getMythArenaGui().setDescription("Invalid value");
                        super.getMythArenaGui().clearFieldText(0);
                        super.getMythArenaGui().waitEvent(3);
                    }
                }
            }
        }
    }

    /**
     * Long Modify Market Notification List
     * @param category String category
     */
    private void longModifyMarketNotificationList(String category) {
        boolean exit = false;
        while (!exit) {
            JSONObject marketSubscriptions = player.getMarketSubscriptions();
            JSONArray categoryValues = (JSONArray) marketSubscriptions.get(category);
            ArrayList<Long> values = new ArrayList<>();
            Iterator<String> iterator = categoryValues.iterator();
            while (iterator.hasNext()) {
                Long value = Long.valueOf(String.valueOf(iterator.next()));
                values.add(value);
            }
            // values.get(0) -> minValue
            // values.get(1) -> maxValue
            super.getMythArenaGui().setFormMode();
            super.getMythArenaGui().setTitle("Modify values you want to change");
            super.getMythArenaGui().setDescription("To disable a subscription, set it min to 0 & max to -1");
            super.getMythArenaGui().setOption(0, "Back");
            super.getMythArenaGui().setOption(1, "Modify");
            super.getMythArenaGui().setField(0, category + " Min || Status: " + (values.get(0) != 0 ? values.get(0) : "Disabled"));
            super.getMythArenaGui().setField(1, category + " Max || Status: " + (values.get(1) != -1 ? values.get(1) : "Disabled"));
            super.getMythArenaGui().setField(2, null);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // exit
                case 'A' -> exit = true;
                // modify values
                case 'B' -> {
                    String fieldMinValueString = super.getMythArenaGui().getFieldText(0);
                    String fieldMaxValueString = super.getMythArenaGui().getFieldText(1);
                    StringBuilder notValid = new StringBuilder();
                    StringBuilder outBounds = new StringBuilder();
                    StringBuilder modified = new StringBuilder();
                    JSONArray newValues = categoryValues;
                    // min value
                    if (!Objects.equals(fieldMinValueString, "")) {
                        String minInfo = "PriceMin ";
                        if (super.getArena().isInteger(fieldMinValueString)) {
                            if (Integer.parseInt(fieldMinValueString) >= 0) {
                                newValues.set(0, Long.parseLong(fieldMinValueString));
                                modified.append(minInfo);
                            } else {
                                outBounds.append(minInfo);
                            }
                        } else {
                            notValid.append(minInfo);
                        }
                    }
                    // max value
                    if (!Objects.equals(fieldMaxValueString, "")) {
                        String MaxInfo = "PriceMax ";
                        if (super.getArena().isInteger(fieldMaxValueString)) {
                            if (Integer.parseInt(fieldMaxValueString) >= -1) {
                                newValues.set(1, Long.parseLong(fieldMaxValueString));
                                modified.append(MaxInfo);
                            } else {
                                outBounds.append(MaxInfo);
                            }
                        } else {
                            notValid.append(MaxInfo);
                        }
                    }
                    // save new values if changed
                    marketSubscriptions.put(category, newValues);
                    super.getMythArenaGui().clearFieldText(0);
                    super.getMythArenaGui().clearFieldText(1);
                    super.getArena().serializeMultiple(notValid, outBounds, modified);
                }
            }
            super.getMythArenaGui().waitEvent(2);
        }
    }

    /**
     * Get gold
     */
    private void getGold() {
        if (player.getCharacter() == null) {
            super.getMythArenaGui().setDescription("No character found");
            getMythArenaGui().waitEvent(3);
        } else {
            boolean exit = false;
            while (!exit) {
                getMythArenaGui().setListMode();
                getMythArenaGui().setTitle("Gold history");
                ArrayList<String> message = new ArrayList<>();
                message.add("Current gold: " + player.getCharacter().getGold() + " gold");
                message.add("Gold lost in battle: " + player.getGoldLostInBattle() + " gold");
                message.add("Gold won in battle: " + player.getGoldWonInBattle() + " gold");
                getMythArenaGui().setList(message);
                getMythArenaGui().setOption(0, null);
                getMythArenaGui().setOption(1, null);
                getMythArenaGui().setOption(2, null);
                getMythArenaGui().setOption(3, "Exit");
                if (getMythArenaGui().waitEvent(30) == 'D') {
                    exit = true;
                }
            }
        }
    }

    /**
     * View Notifications
     */
    private void viewNotifications() {
        // Checks if you have notification. We need to alert the player, otherwise, said player might think it's bugged.
        if (player.getNotificationArrayList().size() == 0) {
            getMythArenaGui().setDescription("You don't have notifications");
        }
        boolean exit = false;
        while (!exit) {
            // Main settings
            getMythArenaGui().setListMode();
            getMythArenaGui().setTitle("Notifications");
            getMythArenaGui().setDescription("You have combat notification " + (player.isSubscriber() ? "on" : "off"));
            getMythArenaGui().setOption(0, null);
            getMythArenaGui().setOption(1, "Turn Combat Notification " + (player.isSubscriber() ? "off":"on"));
            getMythArenaGui().setOption(2, "Back");
            getMythArenaGui().setOption(3, "Open");
            // List of notifications
            ArrayList<String> notificationList = new ArrayList<>();
            for (Notification notification : player.getNotificationArrayList()) {
                notificationList.add(notification.getTitle());
            }
            getMythArenaGui().setList(notificationList);
            // Opens notification at the current list index
            switch (getMythArenaGui().waitEvent(30)) {
                case 'D' -> {
                    int index = getMythArenaGui().getLastSelectedListIndex();
                    // Must select an item from list for button to work
                    if (index != -1) {
                        // Display the content of notification on the screen
                        Notification notification = player.getNotificationArrayList().get(getMythArenaGui().getLastSelectedListIndex());
                        ArrayList<String> notificationContent = new ArrayList<>();
                        notificationContent.add(notification.getTitle());
                        getMythArenaGui().setList(notificationContent);
                        // Accept/Decline options added for PendingCombatNotification.
                        if (notification instanceof PendingCombatNotification pendingCombatNotification) {
                            getMythArenaGui().setTitle("Battle request");
                            getMythArenaGui().setDescription("Note: declining a battle request will result in paying 10% of the proposed bet as penalty!");
                            getMythArenaGui().setOption(0, "Decline");
                            getMythArenaGui().setOption(1, "Accept");
                            getMythArenaGui().setOption(2, "Back");
                            getMythArenaGui().setOption(3, null);
                            char c = getMythArenaGui().waitEvent(30);
                            if (c == 'A') {// If Player declines. We must inform the challenger of this event. Player must pay 10% of the bet
                                pendingCombatNotification.getChallenger().getNotificationArrayList().add(new GeneralNotification(
                                        "Your challenge request has been declined.",
                                        player.getUsername() + " has declined your challenge, therefore conceding 10% of the bet to you"
                                ));
                                int amount = pendingCombatNotification.getBet();
                                int pay = (int) (amount * 0.10);
                                pendingCombatNotification.getChallenger().getCharacter().setGold(pendingCombatNotification.getChallenger().getCharacter().getGold() + pay);
                                player.getCharacter().setGold(player.getCharacter().getGold() - pay);
                                player.getNotificationArrayList().remove(pendingCombatNotification);
                                try {
                                    getArena().serializeData();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                getMythArenaGui().setDescription("Combat declined");
                                getMythArenaGui().waitEvent(2);
                                exit = true;
                            } else if (c == 'B') {// If player accepts. We start combat
                                getArena().combat(player, pendingCombatNotification.getChallenger(), pendingCombatNotification.getBet(), true);
                                player.getNotificationArrayList().remove(pendingCombatNotification);
                                try {
                                    getArena().serializeData();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                exit = true;
                            }
                        // CombatResultsNotification
                        } else if (notification instanceof CombatResultsNotification combatResultsNotification) {
                            boolean exitResult = false;
                            while (!exitResult) {
                                getMythArenaGui().setTitle("Battle result");
                                getMythArenaGui().setDescription(null);
                                getMythArenaGui().setOption(0, null);
                                getMythArenaGui().setOption(1, "Open");
                                getMythArenaGui().setOption(2, "Delete");
                                getMythArenaGui().setOption(3, "Back");
                                ArrayList<String> combatResults = new ArrayList<>();
                                combatResults.add(combatResultsNotification.getTitle());
                                combatResults.add("Bet: " + combatResultsNotification.getCombat().getBet());
                                combatResults.add("Winner: " + combatResultsNotification.getCombat().getWinner().getNickname());
                                combatResults.add("Loser: " + combatResultsNotification.getCombat().getLoser().getNickname());
                                combatResults.add("Date: " + combatResultsNotification.getCombat().getDate());
                                combatResults.add("Player with minions left: " + (
                                    combatResultsNotification.getCombat().getPlayerWithMinionsLeft() == null
                                    ? "NONE" : combatResultsNotification.getCombat().getPlayerWithMinionsLeft().getNickname())
                                );
                                combatResults.add(combatResultsNotification.getBody());
                                for (int i = 1; i <= ((CombatResultsNotification) notification).getCombat().getRounds().size(); i++) {
                                    combatResults.add("Round: " + i);
                                }
                                getMythArenaGui().setList(combatResults);
                                switch (getMythArenaGui().waitEvent(30)) {
                                    case 'B' -> {
                                        int roundIndex = getMythArenaGui().getLastSelectedListIndex();
                                        if (roundIndex != -1) {
                                            if (roundIndex > 6) {
                                                boolean closeRound = false;
                                                while (!closeRound) {
                                                    Round round = combatResultsNotification.getCombat().getRounds().get(roundIndex - 7);
                                                    int roundNumber = roundIndex - 6;
                                                    ArrayList<String> roundResults = new ArrayList<>();
                                                    roundResults.add("Round: " + roundNumber);
                                                    roundResults.add("Player 1 health: " + round.getCharacter1Health());
                                                    roundResults.add("Player 2 health: " + round.getCharacter2Health());
                                                    roundResults.add("Player 1 minions total health: " + round.getCharacter1MinionTotalHealth());
                                                    roundResults.add("Player 1 minions total health: " + round.getCharacter1MinionTotalHealth());
                                                    roundResults.add("Player 1 attack result: " + round.getCharacter1AttackResult() + " damage");
                                                    roundResults.add("Player 2 attack result: " + round.getCharacter2AttackResult() + " damage");
                                                    getMythArenaGui().setList(roundResults);
                                                    getMythArenaGui().setOption(0, null);
                                                    getMythArenaGui().setOption(1, null);
                                                    getMythArenaGui().setOption(2, null);
                                                    getMythArenaGui().setOption(3, "Back");
                                                    // Exit round
                                                    if (getMythArenaGui().waitEvent(30) == 'D') {
                                                        closeRound = true;
                                                    }
                                                }
                                            } else {
                                                getMythArenaGui().setDescription("You must select a valid round to open!");
                                                getMythArenaGui().waitEvent(1);
                                            }
                                        } else {
                                            getMythArenaGui().setDescription("You must select a round on the list to open!");
                                            getMythArenaGui().waitEvent(2);
                                        }
                                    }
                                    // Delete
                                    case 'C' -> {
                                        player.getNotificationArrayList().remove(notification);
                                        try {
                                            getArena().serializeData();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        exitResult = true;
                                    }
                                    // Exit notification
                                    case 'D' -> exitResult = true;
                                }
                            }
                        // GeneralNotification
                        } else {
                            // what's up (～￣▽￣)～
                            // getMythArenaGui().setDescription("Hi");
                            boolean exitGeneralNotification = false;
                            while (!exitGeneralNotification) {
                                ArrayList<String> display = new ArrayList<>();
                                display.add(notification.getBody());
                                getMythArenaGui().setList(display);
                                getMythArenaGui().setDescription("Notification Info");
                                getMythArenaGui().setOption(0, null);
                                getMythArenaGui().setOption(1, null);
                                getMythArenaGui().setOption(2, "Back");
                                getMythArenaGui().setOption(3, "Delete");
                                char c = getMythArenaGui().waitEvent(30);
                                if (c == 'C') {
                                    exitGeneralNotification = true;
                                }else if(c == 'D') {
                                    player.getNotificationArrayList().remove(notification);
                                    try {
                                        getArena().serializeData();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    exitGeneralNotification = true;
                                }
                            }
                        }
                    } else {
                        getMythArenaGui().setDescription("You must select an item on the list to open!");
                        getMythArenaGui().waitEvent(1);
                    }
                }
                // Exit notification list
                case 'C' ->
                        exit = true;
                // Subscribe/Unsubscribe
                case 'B' -> {
                    player.setSubscriber(!player.isSubscriber());
                    try {
                        getArena().serializeData();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * View Ranking
     */
    private void viewRanking() {
        super.getMythArenaGui().setListMode();
        super.getMythArenaGui().setTitle("Ranking");
        super.getMythArenaGui().setDescription(null);
        super.getMythArenaGui().setOption(0, null);
        super.getMythArenaGui().setOption(1, null);
        super.getMythArenaGui().setOption(2, "Exit");
        super.getMythArenaGui().setOption(3, null);
        // gets player unSortedplayerMap with win values
        HashMap<Player, Integer> unSortedplayerMap = new HashMap<>();
        for (Combat combat : super.getData().getCombatArrayList()) {
            Player winner = combat.getWinner();
            if (unSortedplayerMap.containsKey(winner)) {
                unSortedplayerMap.replace(winner, unSortedplayerMap.get(winner) + 1);
            } else {
                unSortedplayerMap.put(winner, 1);
            }
        }
        // sorts it
        HashMap<Player, Integer> sortedPlayerMap =
            unSortedplayerMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        // makes info for input in list mode
        ArrayList<String> rankInfoArrayList = new ArrayList<>();
        int rankPosition = 1;
        for (Map.Entry<Player, Integer> entry : sortedPlayerMap.entrySet()) {
            rankInfoArrayList.add(rankPosition + " -> " + entry.getKey().getNickname() + " with " + entry.getValue() + " wins");
            rankPosition++;
        }
        super.getMythArenaGui().setList(rankInfoArrayList);
        boolean exit = false;
        while (!exit) {
            if (super.getMythArenaGui().waitEvent(30) == 'C') {
                exit = true;
            }
        }
    }

    /**
     * Delete character
     */
    private void deleteCharacter() {
        // Must have character to be deleted
        if (player.getCharacter() != null) {
            boolean exit = false;
            while (!exit) {
                getMythArenaGui().setMessageMode();
                getMythArenaGui().setTitle(null);
                getMythArenaGui().setImage(0,"/resources/images/warning.png");
                getMythArenaGui().setDescription("Are you sure you want to delete your character?");
                getMythArenaGui().setOption(0, "No, I love my character :)");
                getMythArenaGui().setOption(1, "Yes, I'm sure :(");
                char choice = getMythArenaGui().waitEvent(30);
                // Deletes character
                switch (choice) {
                    case 'B' -> {
                        player.setCharacter(null);
                        try {
                            getArena().serializeData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        getMythArenaGui().setDescription("Character has been deleted");
                        exit = true;
                    }
                    case 'A' ->
                            // Cancels Operation
                            exit = true;
                }
            }
        } else {
            getMythArenaGui().setDescription("No character found");
            getMythArenaGui().waitEvent(3);
        }
    }

    /**
     * Create character
     */
    private void createCharacter() {
        getMythArenaGui().setListMode();
        getMythArenaGui().setOption(0,null);
        getMythArenaGui().setOption(1,null);
        getMythArenaGui().setOption(2,"Cancel");
        getMythArenaGui().setOption(3,"Create");
        getMythArenaGui().setTitle("Character Creator Tool");
        getMythArenaGui().setDescription("Select the type of your new Character");
        boolean exit = false;
        while (!exit) {
            ArrayList<String> characterTypes = new ArrayList<>();
            characterTypes.add("Hunter");
            characterTypes.add("Vampire");
            characterTypes.add("Werewolf");
            getMythArenaGui().setList(characterTypes);
            char choice = getMythArenaGui().waitEvent(30);
            switch (choice) {
                case 'D' -> {
                    int index = getMythArenaGui().getLastSelectedListIndex();
                    if (index != -1) {
                        CharacterFactory characterFactory = new CharacterFactory();
                        switch (index) {
                            case 0 -> player.setCharacter(characterFactory.createCharacter(new HunterFactory(getData())));
                            case 1 -> player.setCharacter(characterFactory.createCharacter(new VampireFactory(getData())));
                            case 2 -> player.setCharacter(characterFactory.createCharacter(new WerewolfFactory(getData())));
                        }
                        try {
                            getArena().serializeData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        super.getMythArenaGui().setDescription("Character has been created!");
                        super.getMythArenaGui().waitEvent(1);
                        exit = true;
                    } else {
                        getMythArenaGui().setDescription("You must select a type before continuing");
                    }
                }
                case 'C' -> exit = true;
            }
        }
    }

    /**
     * Challenge user
     */
    private void challengeUser() {
        // Update bans & check if player is still combat banned
        getArena().updateBans();
        if (!getData().getBannedPlayerMap().containsKey(player)) {
            // Must have character to challenge
            if (player.getCharacter() != null) {
                boolean exit = false;
                while (!exit) {
                    // Main settings
                    getMythArenaGui().setListMode();
                    getMythArenaGui().setTitle("Challenge User Menu");
                    getMythArenaGui().setOption(0, null);
                    getMythArenaGui().setOption(1, null);
                    getMythArenaGui().setOption(2, "Cancel");
                    getMythArenaGui().setOption(3, "Challenge");
                    // List of players
                    ArrayList<Player> playerArrayList = new ArrayList<>();
                    ArrayList<String> playerNicknameArrayList = new ArrayList<>();
                    for (User user : getData().getUserArrayList()) {
                        // Filter not active user & player have character
                        if (user instanceof Player && user != getArena().getActiveUser() && ((Player) user).getCharacter() != null) {
                            playerArrayList.add((Player) user);
                            playerNicknameArrayList.add(((Player) user).getNickname());
                        }
                    }
                    getMythArenaGui().setList(playerNicknameArrayList);
                    // Challenge player at current list index
                    switch (getMythArenaGui().waitEvent(30)) {
                        case 'D' -> {
                            int index = getMythArenaGui().getLastSelectedListIndex();
                            // You can't advance if you didn't pick an item on the list
                            if (index != -1) {
                                // Use previous playerArrayList to get proper player with index on the list
                                Player challengedPlayer = playerArrayList.get(index);
                                getMythArenaGui().setFormMode();
                                getMythArenaGui().setField(1, null);
                                getMythArenaGui().setField(2, null);
                                getMythArenaGui().setTitle("Betting Menu");
                                getMythArenaGui().setDescription("Type the amount of gold you want to bet");
                                getMythArenaGui().setOption(0, "Exit");
                                getMythArenaGui().setOption(1, "Bet");
                                getMythArenaGui().setField(0, "Bet:");
                                // Bet the given amount and make a pending combat to be saved in Arena
                                if (getMythArenaGui().waitEvent(30) == 'B') {
                                    if (getArena().isInteger(getMythArenaGui().getFieldText(0))) {
                                        int amount = Integer.parseInt(getMythArenaGui().getFieldText(0));
                                        // Bet has to be strictly more than 0. Player must have said amount of gold to bet.
                                        if (amount > 0) {
                                            if ((player.getCharacter().getGold() - amount) >= 0) {
                                                PendingCombat pendingCombat = new PendingCombat(player, challengedPlayer, amount);
                                                selectEquipment();
                                                getData().getPendingCombatArrayList().add(pendingCombat);
                                                getMythArenaGui().setDescription("Your challenge request has been sent!");
                                                getMythArenaGui().clearFieldText(0);
                                                getMythArenaGui().waitEvent(1);
                                                try {
                                                    getArena().serializeData();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            } else {
                                                getMythArenaGui().setDescription("You're betting more gold than you currently have!");
                                            }
                                        } else {
                                            getMythArenaGui().setDescription("Invalid amount");
                                        }
                                    } else {
                                        getMythArenaGui().setDescription("Write numbers only. No spaces or comma");
                                    }
                                }
                            } else {
                                getMythArenaGui().setDescription("You must select an item in the list to challenge!");
                            }
                        }
                        case 'C' ->
                                // Ends the while loop, thus ending the operation
                                exit = true;
                    }
                }
            } else {
                getMythArenaGui().setDescription("No character found");
                getMythArenaGui().waitEvent(3);
            }
        } else {
            getMythArenaGui().setDescription("You can't enter to this option because you have been banned, check notifications for more information");
            getMythArenaGui().waitEvent(3);
        }
    }

    /**
     * Select equipment
     */
    private void selectEquipment() {
        // Must have character to select equipments
        if (player.getCharacter() != null) {
            getMythArenaGui().setListMode();
            boolean exit = false;
            while (!exit) {
                // Main settings
                getMythArenaGui().setTitle("Weapon Selection Menu");
                getMythArenaGui().setOption(0, "Unequip all");
                getMythArenaGui().setOption(1, "Equip");
                getMythArenaGui().setOption(2, "Cancel");
                getMythArenaGui().setOption(3, "Next");
                // List of weapons, indicating types, offense and defense.
                ArrayList<String> listWeapons = new ArrayList<>();
                getMythArenaGui().setDescription("Select your weapons. TIP: You may equip two single-handed weapons simultaneously");
                for (Equipment item : player.getCharacter().getInventory().getWeaponArrayList()) {
                        Weapon weapon = (Weapon) item;
                        listWeapons.add(weapon.getName() + "     Type: " + (weapon.isTwoHands() ? "Two-hander" : "One-hander") + "     " + "Offense: " + weapon.getAttackModification() + "     " + "Defense: " + weapon.getDefenseModification());
                }
                listWeapons.add("----------------------------------------------------------------------------------");
                listWeapons.add("Current weapons:");
                // List of weapon slots and their respective status (Free/Occupied)
                int equippedWeaponCount = 0;
                for (Equipment equippedWeapon: player.getCharacter().getEquippedWeaponArrayList()) {
                    listWeapons.add("Slot "+ (equippedWeaponCount+1) +": "+ equippedWeapon.getName());
                    equippedWeaponCount++;
                }
                int freeSlotCount = player.getCharacter().getEquippedWeaponArrayList().size();
                while (freeSlotCount < 2) {
                    listWeapons.add("Slot "+ (freeSlotCount+1) +": Free");
                    freeSlotCount++;
                }
                getMythArenaGui().setList(listWeapons);
                // Once you click next, you'll have to select your character's armor
                switch (getMythArenaGui().waitEvent(30)) {
                    case 'D':
                        // You can't continue without equipping a weapon
                        if (!player.getCharacter().getEquippedWeaponArrayList().isEmpty()) {
                            getMythArenaGui().setDescription("Select your armor");
                            getMythArenaGui().setOption(0, null);
                            getMythArenaGui().setOption(1, "Equip");
                            getMythArenaGui().setOption(2, "Back");
                            getMythArenaGui().setOption(3, "Finish");
                            boolean isFinished = false;
                            // Make a loop. In case he selects the same armor, he can stay on this operation
                            while (!isFinished) {
                                // List of armors
                                ArrayList<String> listArmor = new ArrayList<>();
                                for (Equipment armor : player.getCharacter().getInventory().getArmorArrayList()) {
                                    listArmor.add(armor.getName());
                                }
                                listArmor.add("----------------------------------------------------------------------------------");
                                listArmor.add("Current armor:");
                                // Armor currently equipped
                                listArmor.add(player.getCharacter().getArmor().getName());
                                getMythArenaGui().setList(listArmor);
                                // Once finished, we serialize the data and exit both loops
                                switch (getMythArenaGui().waitEvent(30)) {
                                    case 'D' -> {
                                        try {
                                            getArena().serializeData();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        isFinished = true;
                                        exit = true;
                                    }
                                    case 'B' -> {
                                        // Equip the current item at the list index
                                        int index = getMythArenaGui().getLastSelectedListIndex();
                                        if (index != -1) {
                                            player.getCharacter().setArmor(player.getCharacter().getInventory().getArmorArrayList().get(index));
                                        }
                                    }
                                    case 'C' ->
                                            // He can go back to selecting weapon
                                            isFinished = true;
                                }
                            }
                        } else {
                            getMythArenaGui().setDescription("You must equip at least one weapon to continue");
                            getMythArenaGui().waitEvent(2);
                        }
                        break;
                    case 'C':
                        // Cancels operation. Goes back to menu
                        exit = true;
                        //Equip the weapon at current list index
                        break;
                    case 'B':
                        if (!player.getCharacter().getEquippedWeaponArrayList().isEmpty()) {
                            Weapon currentWeapon = (Weapon) player.getCharacter().getEquippedWeaponArrayList().get(0);
                            // if character has weapon, we must check if he's holding a two-handed weapon. If it is the case, he can't equip any more weapons unless he unequips said weapon.
                            if (!currentWeapon.isTwoHands()) {
                                int listIndex = getMythArenaGui().getLastSelectedListIndex();
                                if (listIndex < 3 && listIndex != -1) {
                                    Equipment item = player.getCharacter().getInventory().getWeaponArrayList().get(listIndex);
                                    Weapon weapon = (Weapon) item;
                                    // If character has single-handed weapon then he can equip another one-handed weapon.
                                    if (!player.getCharacter().getEquippedWeaponArrayList().contains(weapon)) {
                                        if (!weapon.isTwoHands()) {
                                            int size = player.getCharacter().getEquippedWeaponArrayList().size();
                                            if (size < 2) {
                                                player.getCharacter().getEquippedWeaponArrayList().add(1, player.getCharacter().getInventory().getWeaponArrayList().get(listIndex));
                                            } else {
                                                player.getCharacter().getEquippedWeaponArrayList().set(1, player.getCharacter().getEquippedWeaponArrayList().get(0));
                                                player.getCharacter().getEquippedWeaponArrayList().set(0, player.getCharacter().getInventory().getWeaponArrayList().get(listIndex));
                                            }
                                        } else {
                                            getMythArenaGui().setDescription("You must unequip your weapon to use a two-handed weapon!");
                                            getMythArenaGui().waitEvent(2);
                                        }
                                    }
                                }
                            } else {
                                getMythArenaGui().setDescription("You currently have a two-handed weapon equipped. You can only use two single-handers for dual-wielding");
                                getMythArenaGui().waitEvent(5);
                            }
                        } else {
                            // If no equipped weapons, we add weapon at index 0
                            int listIndex = getMythArenaGui().getLastSelectedListIndex();
                            // Has to select a valid Weapon. Anything below index 2 are not on the real list. Must select weapon from list to equip.
                            if (listIndex < 3 && listIndex != -1) {
                                Equipment item = player.getCharacter().getInventory().getWeaponArrayList().get(listIndex);
                                Weapon weapon = (Weapon) item;
                                player.getCharacter().getEquippedWeaponArrayList().add(weapon);
                            }
                        }
                        break;
                    case 'A':
                        // Unequip all weapons. Why? I dont know how to do it one by one. It complicates it a lot.
                        player.getCharacter().getEquippedWeaponArrayList().clear();
                        break;
                }
            }
        } else {
            getMythArenaGui().setDescription("No character found");
            getMythArenaGui().waitEvent(3);
        }

    }

}
