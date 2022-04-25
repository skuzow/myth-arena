package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.combat.PendingCombat;
import mytharena.data.notification.GeneralNotification;
import mytharena.data.notification.Notification;
import mytharena.data.notification.PendingCombatNotification;
import mytharena.data.user.Player;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;

import java.io.IOException;
import java.util.ArrayList;

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
            super.getMythArenaGui().setOption(5, "View notifications");
            super.getMythArenaGui().setOption(6, "View ranking");
            super.getMythArenaGui().setOption(7, "Log out");
            getMythArenaGui().setOption(8,null);
            getMythArenaGui().setOption(9, null);

            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> getGold();
                case 'B' -> challengeUser();
                case 'C' -> createCharacter();
                case 'D' -> deleteCharacter();
                case 'E' -> selectEquipment();
                case 'F' -> viewNotifications();
                case 'G' -> viewRanking();
                case 'H' -> getArena().setActiveUser(null);
            }
        }
    }

    public void getGold() {
        if (player.getCharacter() == null) {
            super.getMythArenaGui().setDescription("No character found");
        }else {
            boolean exit = false;
            while (!exit) {
                getMythArenaGui().setListMode();
                getMythArenaGui().setTitle("Gold history");
                ArrayList<String> message = new ArrayList<>();
                message.add("Current gold: " + Integer.toString(player.getCharacter().getGold()) + " gold");
                message.add("Gold lost in battle: 2M");
                message.add("Gold won in battle: 1M");
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

    public void viewNotifications() {
        if (player.getNotificationArrayList().size() == 0) {
            getMythArenaGui().setDescription("You don't have notifications");
        }
        boolean exit = false;
        while (!exit) {
            getMythArenaGui().setListMode();
            getMythArenaGui().setTitle("Notifications");
            getMythArenaGui().setOption(0, null);
            getMythArenaGui().setOption(1, null);
            getMythArenaGui().setOption(2, "Back");
            getMythArenaGui().setOption(3, "Open");
            ArrayList<String> notificationList = new ArrayList<>();
            for (Notification notification : player.getNotificationArrayList()) {
                notificationList.add(notification.getTitle());
            }
            getMythArenaGui().setList(notificationList);
            if (getMythArenaGui().waitEvent(30) == 'D') {
                int index = getMythArenaGui().getLastSelectedListIndex();
                if (index != -1) {
                    Notification notification = player.getNotificationArrayList().get(getMythArenaGui().getLastSelectedListIndex());
                    ArrayList<String> notificationContent = new ArrayList<>();
                    notificationContent.add(notification.getTitle());
                    notificationContent.add(notification.getBody());
                    getMythArenaGui().setList(notificationContent);

                    char choice = getMythArenaGui().waitEvent(30);
                        if (notification instanceof PendingCombatNotification) {
                            PendingCombatNotification pendingCombatNotification = (PendingCombatNotification) notification;
                            getMythArenaGui().setOption(0, "Decline");
                            getMythArenaGui().setOption(1, "Accept");
                            getMythArenaGui().setOption(2, "Back");
                            if (choice == 'A') {
                                pendingCombatNotification.getChallenger().getNotificationArrayList().add(new GeneralNotification(
                                        "Your challenge request has been declined.",
                                        "Challenged user: " + player.getUsername() + "has declined your challenge, therefore conceding 10% of the bet to you. "
                                ));
                            } else if (choice == 'B') {
                                getArena().combat();
                            }

                        } else {
                            getMythArenaGui().setOption(0, null);
                            getMythArenaGui().setOption(1, null);
                            getMythArenaGui().setOption(2, "Delete");
                            getMythArenaGui().setOption(3, "Close");
                            if (choice == 'C') {
                                player.getNotificationArrayList().remove(notification);
                            }
                        }
                    } else {
                        getMythArenaGui().setDescription("Must select an item in the list to open!");
                    }
                } else {
                    exit = true;
                }
            }
    }

    public void viewRanking() {

    }

    public void deleteCharacter() {
        if (player.getCharacter() != null) {
            boolean exit = false;
            while (!exit) {
                getMythArenaGui().setMessageMode();
                getMythArenaGui().setTitle(null);
                getMythArenaGui().setDescription("Are you sure you want to delete your character?");
                getMythArenaGui().setOption(0, "No, I love my character :)");
                getMythArenaGui().setOption(1, "Yes, I'm sure :(");
                char choice = getMythArenaGui().waitEvent(30);
                if (choice == 'B') {
                    player.setCharacter(null);
                    getMythArenaGui().setDescription("Character has been deleted");
                } else if (choice == 'A') {
                    exit = true;
                }
                try {
                    getArena().serializeData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            getMythArenaGui().setDescription("What character?");
        }
    }

    public void createCharacter() {
        super.getArena().getCommand("CharacterCreationMenu").execute();
    }

    public void challengeUser() {
        if (player.getCharacter() != null) {
            getMythArenaGui().setListMode();
            getMythArenaGui().setOption(0, null);
            getMythArenaGui().setOption(1, null);
            getMythArenaGui().setOption(2, "Cancel");
            getMythArenaGui().setOption(3, "Next");

            boolean exit = false;
            while (!exit) {
                ArrayList<String> listOptions = new ArrayList<>();
                for (User user : getData().getUserArrayList()) {
                    if (user instanceof Player) {
                        listOptions.add(user.getUsername());
                    }
                }
                getMythArenaGui().setList(listOptions);
                char choice = getMythArenaGui().waitEvent(30);
                if (choice == 'D') {
                    int index = getMythArenaGui().getLastSelectedListIndex();
                    if (index != -1) {
                        User challengedPlayer = getData().getUserArrayList().get(index + 1);
                        if (challengedPlayer instanceof Player) {
                            if (challengedPlayer != player) {
                                PendingCombat pendingCombat = new PendingCombat(player, (Player) challengedPlayer, 20);
                                getData().getPendingCombatArrayList().add(pendingCombat);
                                getMythArenaGui().setDescription("Your challenge request has been sent!");
                                getMythArenaGui().waitEvent(3);
                                try {
                                    getArena().serializeData();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                getMythArenaGui().setDescription("You can't challenge yourself");
                            }
                        }
                    } else {
                        getMythArenaGui().setDescription("You must select an item in the list to challenge!");
                    }
                } else if (choice == 'C') {
                    exit = true;
                }
            }
        }else {
            getMythArenaGui().setDescription("No character found");
        }
    }

    public void selectEquipment() {
        if (player.getCharacter() != null) {
            getMythArenaGui().setListMode();
            boolean exit = false;
            while (!exit) {
                getMythArenaGui().setOption(0, "Unequip all");
                getMythArenaGui().setOption(1, "Equip");
                getMythArenaGui().setOption(2, "Cancel");
                getMythArenaGui().setOption(3, "Next");
                ArrayList<String> listWeapons = new ArrayList<>();
                getMythArenaGui().setDescription("Select your weapons. TIP: You may equip two single-handed weapons simultaneously");
                for (Equipment item : player.getCharacter().getInventory().getWeaponArrayList()) {
                        Weapon weapon = (Weapon) item;
                        listWeapons.add(weapon.getName() + "     Type: " + (weapon.isTwoHands() ? "Two-hander" : "One-hander") + "     " + "Offense: " + Integer.toString(weapon.getAttackModification()) + "     " + "Defense: " + Integer.toString(weapon.getDefenseModification()));
                }
                listWeapons.add("----------------------------------------------------------------------------------");
                listWeapons.add("Current weapons:");

                int equippedWeaponCount = 0;
                for (Equipment equippedWeapon: player.getCharacter().getEquippedWeaponArrayList()) {
                    listWeapons.add("Slot "+ Integer.toString(equippedWeaponCount+1) +": "+ equippedWeapon.getName());
                    equippedWeaponCount++;
                }

                int freeSlotCount = player.getCharacter().getEquippedWeaponArrayList().size();
                while (freeSlotCount < 2) {
                    listWeapons.add("Slot "+ Integer.toString(freeSlotCount+1) +": Free");
                    freeSlotCount++;
                }

                getMythArenaGui().setList(listWeapons);
                char choice = getMythArenaGui().waitEvent(30);
                if (choice == 'D') {
                    if(!player.getCharacter().getEquippedWeaponArrayList().isEmpty()) {
                        getMythArenaGui().setDescription("Select your armor");
                        getMythArenaGui().setOption(0,null);
                        getMythArenaGui().setOption(1, "Equip");
                        getMythArenaGui().setOption(2, "Back");
                        getMythArenaGui().setOption(3, "Finish");

                        boolean isFinished = false;
                        while(!isFinished) {
                            ArrayList<String> listArmor = new ArrayList<>();
                            for (Equipment armor : player.getCharacter().getInventory().getArmorArrayList()) {
                                listArmor.add(armor.getName());
                            }
                            listArmor.add("----------------------------------------------------------------------------------");
                            listArmor.add("Current armor:");
                            listArmor.add(player.getCharacter().getArmor().getName());
                            getMythArenaGui().setList(listArmor);
                            char option = getMythArenaGui().waitEvent(30);
                            if (option == 'D') {
                                try {
                                    getArena().serializeData();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                isFinished = true;
                                exit = true;
                            } else if (option == 'B') {
                                int index = getMythArenaGui().getLastSelectedListIndex();
                                if (index != -1) {
                                    player.getCharacter().setArmor(player.getCharacter().getInventory().getArmorArrayList().get(index));
                                }
                            } else if (option == 'C') {
                                isFinished = true;
                            }
                        }
                    }else {
                        getMythArenaGui().setDescription("You must equip at least one weapon to continue");
                        getMythArenaGui().waitEvent(2);
                    }
                } else if (choice == 'C') {
                    exit = true;
                }else if (choice == 'B') {
                    if (!player.getCharacter().getEquippedWeaponArrayList().isEmpty()) {
                        // If character has equipped weapon
                        Weapon currentWeapon = (Weapon) player.getCharacter().getEquippedWeaponArrayList().get(0);
                        if (!currentWeapon.isTwoHands()) {
                            int listIndex = getMythArenaGui().getLastSelectedListIndex();
                            if (listIndex < 3 && listIndex != -1) {
                                Equipment item = player.getCharacter().getInventory().getWeaponArrayList().get(listIndex);
                                Weapon weapon = (Weapon) item;
                                if (!player.getCharacter().getEquippedWeaponArrayList().contains(weapon)) {
                                    if (!weapon.isTwoHands()) {
                                        int size = player.getCharacter().getEquippedWeaponArrayList().size();
                                        if (size < 2) {
                                            player.getCharacter().getEquippedWeaponArrayList().add(1, player.getCharacter().getInventory().getWeaponArrayList().get(listIndex));
                                        } else {
                                            player.getCharacter().getEquippedWeaponArrayList().set(1, player.getCharacter().getEquippedWeaponArrayList().get(0));
                                            player.getCharacter().getEquippedWeaponArrayList().set(0, player.getCharacter().getInventory().getWeaponArrayList().get(listIndex));
                                        }
                                    }else {
                                        getMythArenaGui().setDescription("You must unequip your weapon to use a two-handed weapon!");
                                        getMythArenaGui().waitEvent(2);
                                    }
                                }
                            }
                        } else {
                            getMythArenaGui().setDescription("You currently have a two-handed weapon equipped. You can only use two single-handers for dual-wielding");
                            getMythArenaGui().waitEvent(5);
                        }
                    }else {
                        // If no equipped weapons
                        int listIndex = getMythArenaGui().getLastSelectedListIndex();
                        if (listIndex < 3 && listIndex != -1) {
                            Equipment item = player.getCharacter().getInventory().getWeaponArrayList().get(listIndex);
                            Weapon weapon = (Weapon) item;
                            if (!player.getCharacter().getEquippedWeaponArrayList().contains(weapon)) {
                                player.getCharacter().getEquippedWeaponArrayList().add(weapon);
                            }
                        }
                    }
                }else if(choice == 'A') {
                    player.getCharacter().getEquippedWeaponArrayList().clear();
                }
            }
        }else {
            getMythArenaGui().setDescription("No character found");
        }

    }

}
