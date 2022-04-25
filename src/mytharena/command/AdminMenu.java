package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.combat.PendingCombat;
import mytharena.data.notification.GeneralNotification;
import mytharena.data.notification.PendingCombatNotification;
import mytharena.data.user.Admin;
import mytharena.data.user.Player;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;

import java.io.IOException;
import java.util.ArrayList;

/**
 * AdminMenu class extends Command
 */
public class AdminMenu extends Command {

    /**
     * AdminMenu class constructor extends Command
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public AdminMenu(Arena arena, Data data, MythArenaGui mythArenaGui) {
        super(arena, data, mythArenaGui);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {
        while (super.getArena().getActiveUser() != null) {
            super.getMythArenaGui().setButtonMode();
            super.getMythArenaGui().setTitle("Welcome to Myth Arena " + super.getArena().getActiveUser().getUsername());
            super.getMythArenaGui().setDescription("Admin Panel");
            super.getMythArenaGui().setOption(0, "Manage admins");
            super.getMythArenaGui().setOption(1, "Manage players");
            super.getMythArenaGui().setOption(2, "Manage characters");
            super.getMythArenaGui().setOption(3, "Validate combats");
            super.getMythArenaGui().setOption(4, null);
            super.getMythArenaGui().setOption(5, null);
            super.getMythArenaGui().setOption(6, null);
            super.getMythArenaGui().setOption(7, null);
            super.getMythArenaGui().setOption(8, "Log out");
            super.getMythArenaGui().setOption(9, "Delete account");
            switch (super.getMythArenaGui().waitEvent(30)) {
                // manage admins
                case 'A' -> this.manageAdmins();
                // manage players
                case 'B' -> this.managePlayers();
                // manage characters
                case 'C' -> this.manageCharacters();
                // validate combats
                case 'D' -> this.validateCombats();
                // log out
                case 'I' -> super.getArena().setActiveUser(null);
                // delete account
                case 'J' -> this.getArena().deleteActiveUserMenu();
            }
        }
    }

    /**
     * Manage admins
     */
    private void manageAdmins() {
        boolean exit = false;
        while (!exit) {
            this.getMythArenaGui().setListMode();
            super.getMythArenaGui().setTitle("Admin Manager Tool");
            super.getMythArenaGui().setDescription("Select what you want to change");
            super.getMythArenaGui().setOption(0, "Unregister selected admin");
            super.getMythArenaGui().setOption(1, "Register new admin");
            super.getMythArenaGui().setOption(2, "Back to Admin Menu");
            super.getMythArenaGui().setOption(3, null);
            ArrayList<Admin> adminArrayList = new ArrayList<>();
            ArrayList<String> adminUsernameArrayList = new ArrayList<>();
            for (User user : super.getData().getUserArrayList()) {
                if (user instanceof Admin) {
                    adminArrayList.add((Admin) user);
                    adminUsernameArrayList.add(user.getUsername());
                }
            }
            super.getMythArenaGui().setList(adminUsernameArrayList);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // remove selected admin
                case 'A' -> {
                    int selected = super.getMythArenaGui().getLastSelectedListIndex();
                    if (selected != -1) {
                        try {
                            Admin selectedAdmin = adminArrayList.get(selected);
                            super.getData().getUserArrayList().remove(selectedAdmin);
                            super.getArena().serializeData();
                            super.getMythArenaGui().setDescription("Removed selected admin: " + selectedAdmin.getUsername());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please select one element of the list before continue");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
                // register admin
                case 'B' -> this.registerAdmin();
                // exit manage admins
                case 'C' -> exit = true;
            }
        }
    }

    /**
     * Register admin into UserArrayList
     */
    private void registerAdmin() {
        super.getMythArenaGui().setFormMode();
        super.getMythArenaGui().setTitle("Admin Register Form");
        super.getMythArenaGui().setDescription("Fill the fields for creating an admin account");
        super.getMythArenaGui().setOption(0, "Back to Manage Admins");
        super.getMythArenaGui().setOption(1, "Register Admin");
        super.getMythArenaGui().setField(0, "Username");
        super.getMythArenaGui().setField(1, "Password");
        super.getMythArenaGui().setField(2, null);
        boolean exit = false;
        while (!exit) {
            switch (super.getMythArenaGui().waitEvent(30)) {
                // exit register admin
                case 'A' -> exit = true;
                // try to create admin user
                case 'B' -> {
                    String user = super.getMythArenaGui().getFieldText(0);
                    String pass = super.getMythArenaGui().getFieldText(1);
                    // checks if all fields have at least 4 characters
                    if (user == null || user.length() < 4 && pass == null || pass.length() < 4) {
                        super.getMythArenaGui().setDescription("All fields must be filled in to register. Fields must have at least 4 characters");
                    } else {
                        // checks if username is taken
                        boolean isUnique = true;
                        int i = 0;
                        while (i < super.getData().getUserArrayList().size() && isUnique) {
                            if (user.equals(super.getData().getUserArrayList().get(i).getUsername())){
                                super.getMythArenaGui().setDescription("Username is taken");
                                isUnique = false;
                            }
                            i++;
                        }
                        // creates admin user and save it in data serializing it
                        if (isUnique) {
                            try {
                                super.getData().getUserArrayList().add(new Admin(user, pass, super.getData()));
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Admin account has been created successfully!");
                                super.getMythArenaGui().waitEvent(1);
                                super.getMythArenaGui().clearFieldText(0);
                                super.getMythArenaGui().clearFieldText(1);
                                exit = true;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Manage Players
     */
    private void managePlayers() {
        boolean exit = false;
        while (!exit) {
            this.getMythArenaGui().setListMode();
            super.getMythArenaGui().setTitle("Player Manager Tool");
            super.getMythArenaGui().setDescription("Select what you want to change");
            super.getMythArenaGui().setOption(0, "Ban 24h selected player");
            super.getMythArenaGui().setOption(1, "Unban selected player");
            super.getMythArenaGui().setOption(2, "Back to Admin Menu");
            super.getMythArenaGui().setOption(3, null);
            ArrayList<Player> playerArrayList = new ArrayList<>();
            ArrayList<String> playerUsernameArrayList = new ArrayList<>();
            for (User user : super.getData().getUserArrayList()) {
                if (user instanceof Player) {
                    playerArrayList.add((Player) user);
                    if (super.getData().getBannedPlayerArrayList().contains(user)) {
                        // TODO: display remaining ban time & auto unban when time finishes
                        playerUsernameArrayList.add(user.getUsername() + " banned :(");
                    } else {
                        playerUsernameArrayList.add(user.getUsername());
                    }
                }
            }
            super.getMythArenaGui().setList(playerUsernameArrayList);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // ban 24h selected player
                case 'A' -> {
                    int selected = super.getMythArenaGui().getLastSelectedListIndex();
                    if (selected != -1) {
                        // checks if player is not already banned
                        Player selectedPlayer = playerArrayList.get(selected);
                        if (!super.getData().getBannedPlayerArrayList().contains(selectedPlayer)) {
                            // adds player from bannedPlayerArrayList saving it in data serializing it
                            try {
                                super.getData().getBannedPlayerArrayList().add(selectedPlayer);
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Banned selected player: " + selectedPlayer.getUsername());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            super.getMythArenaGui().setDescription("Selected player is already banned: " + selectedPlayer.getUsername());
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please select one element of the list before continue");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
                // unban selected player if banned
                case 'B' -> {
                    int selected = super.getMythArenaGui().getLastSelectedListIndex();
                    if (selected != -1) {
                        // checks if player is already banned
                        Player selectedPlayer = playerArrayList.get(selected);
                        if (super.getData().getBannedPlayerArrayList().contains(selectedPlayer)) {
                            // removes player from bannedPlayerArrayList deleting it in data serializing it
                            try {
                                super.getData().getBannedPlayerArrayList().remove(selectedPlayer);
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Unbanned selected player: " + selectedPlayer.getUsername());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            super.getMythArenaGui().setDescription("Selected player has to be banned at first: " + selectedPlayer.getUsername());
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please select one element of the list before continue");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
                // exit manage players
                case 'C' -> exit = true;
            }
        }
    }

    /**
     * Manage Characters
     */
    private void manageCharacters() {
        boolean exit = false;
        while (!exit) {
            super.getMythArenaGui().setListMode();
            super.getMythArenaGui().setTitle("Character Manager Tool");
            super.getMythArenaGui().setDescription("Select what you want to change");
            super.getMythArenaGui().setOption(0, "Remove selected character");
            super.getMythArenaGui().setOption(1, "Edit selected character");
            super.getMythArenaGui().setOption(2, "Back to Admin Menu");
            super.getMythArenaGui().setOption(3, null);
            ArrayList<Player> playerArrayList = new ArrayList<>();
            ArrayList<String> playerInfoArrayList = new ArrayList<>();
            for (User user : super.getData().getUserArrayList()) {
                if (user instanceof Player && ((Player) user).getCharacter() != null) {
                    playerArrayList.add((Player) user);
                    playerInfoArrayList.add(user.getUsername());
                }
            }
            super.getMythArenaGui().setList(playerInfoArrayList);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // delete selected user character
                case 'A' -> {
                    int selected = super.getMythArenaGui().getLastSelectedListIndex();
                    if (selected != -1) {
                        try {
                            playerArrayList.get(selected).setCharacter(null);
                            super.getArena().serializeData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please select one element of the list before continue");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
                case 'B' -> {
                    int selected = super.getMythArenaGui().getLastSelectedListIndex();
                    if (selected != -1) {
                        this.editCharacter(playerArrayList.get(selected));
                    } else {
                        super.getMythArenaGui().setDescription("Please select one element of the list before continue");
                        super.getMythArenaGui().waitEvent(1);
                    }
                }
                // exit validate combats
                case 'C' -> exit = true;
            }
        }
    }

    /**
     * Character editor
     * @param player Player player
     */
    public void editCharacter(Player player) {
        boolean exit = false;
        while (!exit) {
            super.getMythArenaGui().setListMode();
            super.getMythArenaGui().setTitle("Character Editor Tool");
            super.getMythArenaGui().setDescription("Select what you want to change\nYou are currently editing the character of " + player.getUsername());
            super.getMythArenaGui().setOption(0, null);
            super.getMythArenaGui().setOption(1, null);
            super.getMythArenaGui().setOption(2, "Back to Manage Characters");
            super.getMythArenaGui().setOption(3, "Edit selected attribute");
            ArrayList<String> attributeArrayList = new ArrayList<>();
            attributeArrayList.add("Gold");
            attributeArrayList.add("Health");
            attributeArrayList.add("Power");
            attributeArrayList.add("Inventory");
            attributeArrayList.add("Armor");
            attributeArrayList.add("Weaknesses");
            attributeArrayList.add("Minions");
            attributeArrayList.add("Fortitudes");
            attributeArrayList.add("Weapons");
            attributeArrayList.add("Ability");
            super.getMythArenaGui().setList(attributeArrayList);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // exit manage characters
                case 'C' -> exit = true;
                // enter modifier menu of selected character attribute
                case 'D' -> {
                    int selected = super.getMythArenaGui().getLastSelectedListIndex();
                    if (selected != -1) {
                        switch (selected) {
                            // gold
                            case 0 -> {

                            }
                            // health
                            case 1 -> {

                            }
                            // power
                            case 2 -> {

                            }
                            // inventory
                            case 3 -> {

                            }
                            // armor
                            case 4 -> {

                            }
                            // weaknesses
                            case 5 -> {

                            }
                            // minions
                            case 6 -> {

                            }
                            // fortitudes
                            case 7 -> {

                            }
                            // weapons
                            case 8 -> {

                            }
                            // ability
                            case 9 -> {

                            }
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please select one element of the list before continue");
                        super.getMythArenaGui().waitEvent(1);
                    }
                }
            }
        }
    }

    /**
     * Validate Combats
     */
    private void validateCombats() {
        boolean exit = false;
        while (!exit) {
            super.getMythArenaGui().setListMode();
            super.getMythArenaGui().setTitle("Combat Validator Tool");
            super.getMythArenaGui().setDescription("Select what you want to change");
            super.getMythArenaGui().setOption(0, "Approve selected combat");
            super.getMythArenaGui().setOption(1, "Deny selected combat");
            super.getMythArenaGui().setOption(2, "Back to Admin Menu");
            super.getMythArenaGui().setOption(3, null);
            ArrayList<String> pendingCombatInfoArrayList = new ArrayList<>();
            for (PendingCombat pendingCombat : super.getData().getPendingCombatArrayList()) {
                pendingCombatInfoArrayList.add(
                    pendingCombat.getChallenger().getUsername() + " : " +
                    pendingCombat.getChallenger().getCharacter().getGold() + " gold |-> " +
                    pendingCombat.getChallenged().getUsername() + " : " +
                    pendingCombat.getChallenged().getCharacter().getGold() + " gold"
                );
            }
            super.getMythArenaGui().setList(pendingCombatInfoArrayList);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // approve selected combat
                case 'A' -> {
                    int selected = super.getMythArenaGui().getLastSelectedListIndex();
                    if (selected != -1) {
                        PendingCombat pendingCombat = super.getData().getPendingCombatArrayList().get(selected);
                        try {
                            // accepted combat notification for challenged
                            pendingCombat.getChallenged().getNotificationArrayList().add(new PendingCombatNotification(
                                "Another player has challenged you to a combat",
                                "Challenger user: " + pendingCombat.getChallenger().getUsername() + " : " +
                                pendingCombat.getChallenger().getCharacter().getGold() + " gold\n" +
                                "Click what you want to do with it",
                                pendingCombat.getChallenger(), 20
                            ));
                            super.getData().getPendingCombatArrayList().remove(pendingCombat);
                            super.getArena().serializeData();
                            super.getMythArenaGui().setDescription("Approved selected combat: " + pendingCombat.getChallenger().getUsername() + " -> " + pendingCombat.getChallenged().getUsername());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please select one element of the list before continue");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
                // deny selected combat
                case 'B' -> {
                    int selected = super.getMythArenaGui().getLastSelectedListIndex();
                    if (selected != -1) {
                        PendingCombat pendingCombat = super.getData().getPendingCombatArrayList().get(selected);
                        try {
                            super.getData().getBannedPlayerArrayList().add(pendingCombat.getChallenger());
                            // 24h ban notification for challenger
                            pendingCombat.getChallenger().getNotificationArrayList().add(new GeneralNotification(
                                "Your pending combat has been denied",
                                "Challenged user: " + pendingCombat.getChallenged().getUsername() + " : " +
                                pendingCombat.getChallenged().getCharacter().getGold() + " gold\n" +
                                "As a result you have been banned for 24h"
                            ));
                            super.getData().getPendingCombatArrayList().remove(pendingCombat);
                            super.getArena().serializeData();
                            super.getMythArenaGui().setDescription("Denied selected combat: " + pendingCombat.getChallenger().getUsername() + " -> " + pendingCombat.getChallenged().getUsername());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please select one element of the list before continue");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
                // exit validate combats
                case 'C' -> exit = true;
            }
        }
    }

}
