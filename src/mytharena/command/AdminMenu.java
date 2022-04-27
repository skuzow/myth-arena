package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.character.factory.character.hunter.Hunter;
import mytharena.data.character.factory.character.vampire.Vampire;
import mytharena.data.character.factory.character.werewolf.Werewolf;
import mytharena.data.combat.PendingCombat;
import mytharena.data.notification.GeneralNotification;
import mytharena.data.notification.PendingCombatNotification;
import mytharena.data.user.Admin;
import mytharena.data.user.Player;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;

import java.io.IOException;
import java.util.*;

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
            super.getMythArenaGui().setOption(2, "Validate combats");
            super.getMythArenaGui().setOption(3, "Manage characters");
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
                // validate combats
                case 'C' -> this.validateCombats();
                // manage characters
                case 'D' -> this.manageCharacters();
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
            super.getArena().updateBans();
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
                    if (super.getData().getBannedPlayerMap().containsKey(user)) {
                        playerUsernameArrayList.add(((Player) user).getNickname() + " banned until " + super.getData().getBannedPlayerMap().get(user));
                    } else {
                        playerUsernameArrayList.add(((Player) user).getNickname());
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
                        if (!super.getData().getBannedPlayerMap().containsKey(selectedPlayer)) {
                            // adds player from bannedPlayerMap saving it in data serializing it
                            try {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(new Date());
                                // adds 24h since current date, for unban date
                                calendar.add(Calendar.DAY_OF_MONTH, 1);
                                Date unBanDate = calendar.getTime();
                                super.getData().getBannedPlayerMap().put(selectedPlayer, unBanDate);
                                selectedPlayer.getNotificationArrayList().add(new GeneralNotification(
                                    "You have been banned by an administrator", "Banned until " + unBanDate
                                ));
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Banned selected player: " + selectedPlayer.getNickname());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            super.getMythArenaGui().setDescription("Selected player is already banned: " + selectedPlayer.getNickname());
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
                        if (super.getData().getBannedPlayerMap().containsKey(selectedPlayer)) {
                            // removes player from bannedPlayerMap deleting it in data serializing it
                            try {
                                super.getData().getBannedPlayerMap().remove(selectedPlayer);
                                selectedPlayer.getNotificationArrayList().add(new GeneralNotification(
                                        "You have been unbanned by an administrator", "Your ban was revoked"
                                ));
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Unbanned selected player: " + selectedPlayer.getNickname());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            super.getMythArenaGui().setDescription("Selected player has to be banned at first: " + selectedPlayer.getNickname());
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
                        pendingCombat.getChallenger().getNickname() + " : " +
                                pendingCombat.getChallenger().getCharacter().getGold() + " gold -> " +
                                pendingCombat.getChallenged().getNickname() + " : " +
                                pendingCombat.getChallenged().getCharacter().getGold() + " gold || " +
                                pendingCombat.getBet() + " gold bet"
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
                                    "Challenger user: " + pendingCombat.getChallenger().getNickname() + " : " +
                                            pendingCombat.getChallenger().getCharacter().getGold() + " gold\n" +
                                            "Click what you want to do with it",
                                    pendingCombat.getChallenger(), 20
                            ));
                            super.getData().getPendingCombatArrayList().remove(pendingCombat);
                            super.getArena().serializeData();
                            super.getMythArenaGui().setDescription("Approved selected combat: " + pendingCombat.getChallenger().getNickname() + " -> " + pendingCombat.getChallenged().getNickname());
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
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(new Date());
                            // adds 24h since current date, for unban date
                            calendar.add(Calendar.DAY_OF_MONTH, 1);
                            Date unBanDate = calendar.getTime();
                            super.getData().getBannedPlayerMap().put(pendingCombat.getChallenger(), unBanDate);
                            // 24h ban notification for challenger
                            pendingCombat.getChallenger().getNotificationArrayList().add(new GeneralNotification(
                                    "Your pending combat has been denied",
                                    "Challenged user: " + pendingCombat.getChallenged().getNickname() + " : " +
                                            pendingCombat.getChallenged().getCharacter().getGold() + " gold || " +
                                            "As a result you have been banned for 24h, until " + unBanDate
                            ));
                            super.getData().getPendingCombatArrayList().remove(pendingCombat);
                            super.getArena().serializeData();
                            super.getMythArenaGui().setDescription("Denied selected combat: " + pendingCombat.getChallenger().getNickname() + " -> " + pendingCombat.getChallenged().getNickname());
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
                    playerInfoArrayList.add(((Player) user).getNickname());
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
     * @param selectedPlayer Player selectedPlayer
     */
    private void editCharacter(Player selectedPlayer) {
        boolean exit = false;
        while (!exit) {
            super.getMythArenaGui().setListMode();
            super.getMythArenaGui().setTitle("Character Editor Tool");
            super.getMythArenaGui().setDescription("Select what you want to change\nYou are currently editing the character of " + selectedPlayer.getNickname());
            super.getMythArenaGui().setOption(0, null);
            super.getMythArenaGui().setOption(1, null);
            super.getMythArenaGui().setOption(2, "Back to Manage Characters");
            super.getMythArenaGui().setOption(3, "Edit selected attribute");
            ArrayList<String> attributeArrayList = new ArrayList<>();
            // types of character display
            if (selectedPlayer.getCharacter() instanceof Hunter) {
                attributeArrayList.add("Hunter");
            } else if (selectedPlayer.getCharacter() instanceof Vampire) {
                attributeArrayList.add("Vampire");
            } else if (selectedPlayer.getCharacter() instanceof Werewolf) {
                attributeArrayList.add("Werewolf");
            }
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
                            // character type
                            case 0 -> {
                                switch (attributeArrayList.get(0)) {
                                    case "Hunter" -> this.editHunter(selectedPlayer);
                                    case "Vampire" -> this.editVampire(selectedPlayer);
                                    case "Werewolf" -> this.editWerewolf(selectedPlayer);
                                }
                            }
                            // gold
                            case 1 -> this.editGold(selectedPlayer);
                            // health
                            case 2 -> this.editHealth(selectedPlayer);
                            // power
                            case 3 -> {

                            }
                            // inventory
                            case 4 -> {

                            }
                            // armor
                            case 5 -> {

                            }
                            // weaknesses
                            case 6 -> {

                            }
                            // minions
                            case 7 -> {

                            }
                            // fortitudes
                            case 8 -> {

                            }
                            // weapons
                            case 9 -> {

                            }
                            // ability
                            case 10 -> {

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
     * Hunter editor for character editor tool
     * @param selectedPlayer Player selectedPlayer
     */
    private void editHunter(Player selectedPlayer) {
        super.getMythArenaGui().setFormMode();
        super.getMythArenaGui().setTitle("Hunter editor for " + selectedPlayer.getNickname());
        super.getMythArenaGui().setDescription("Type the amount you want to change");
        super.getMythArenaGui().setField(0, "Bounds 0-3 || Amount of Will || Current value: " + ((Hunter) selectedPlayer.getCharacter()).getWill());
        super.getMythArenaGui().setField(1, null);
        super.getMythArenaGui().setField(2, null);
        super.getMythArenaGui().setOption(0, "Exit without saving");
        super.getMythArenaGui().setOption(1, "Continue saving it");
        boolean exit = false;
        while (!exit) {
            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> exit = true;
                case 'B' -> {
                    String value = super.getMythArenaGui().getFieldText(0);
                    if (super.getArena().isInteger(value)) {
                        if (((Hunter) selectedPlayer.getCharacter()).setWill(Integer.parseInt(value))) {
                            try {
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Will value changed successfully!");
                                super.getMythArenaGui().clearFieldText(0);
                                exit = true;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            super.getMythArenaGui().setDescription("Value outside bounds!");
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please type a valid value");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
            }
        }
    }

    /**
     * Vampire editor for character editor tool
     * @param selectedPlayer Player selectedPlayer
     */
    private void editVampire(Player selectedPlayer) {
        super.getMythArenaGui().setFormMode();
        super.getMythArenaGui().setTitle("Vampire editor for " + selectedPlayer.getNickname());
        super.getMythArenaGui().setDescription("Type the amount you want to change");
        super.getMythArenaGui().setField(0, "Bounds 0-inf || Amount of Age || Current value: " + ((Vampire) selectedPlayer.getCharacter()).getAge());
        super.getMythArenaGui().setField(1, "Bounds 0-10 || Amount of BloodPoints || Current value: " + ((Vampire) selectedPlayer.getCharacter()).getBloodPoints());
        super.getMythArenaGui().setField(2, null);
        super.getMythArenaGui().setOption(0, "Exit without saving");
        super.getMythArenaGui().setOption(1, "Continue saving it");
        boolean exit = false;
        while (!exit) {
            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> exit = true;
                case 'B' -> {
                    String value1 = super.getMythArenaGui().getFieldText(0);
                    String value2 = super.getMythArenaGui().getFieldText(1);
                    StringBuilder notValid = new StringBuilder();
                    StringBuilder outBounds = new StringBuilder();
                    StringBuilder modified = new StringBuilder();
                    // age
                    if (!Objects.equals(value1, "")) {
                        String value1Info = "Age ";
                        if (super.getArena().isInteger(value1)) {
                            if (((Vampire) selectedPlayer.getCharacter()).setAge(Integer.parseInt(value1))) {
                                modified.append(value1Info);
                            } else {
                                outBounds.append(value1Info);
                            }
                        } else {
                            notValid.append(value1Info);
                        }
                    }
                    // bloodpoints
                    if (!Objects.equals(value2, "")) {
                        String value2Info = "BloodPoints ";
                        if (super.getArena().isInteger(value2)) {
                            if (((Vampire) selectedPlayer.getCharacter()).setBloodPoints(Integer.parseInt(value2))) {
                                modified.append(value2Info);
                            } else {
                                outBounds.append(value2Info);
                            }
                        } else {
                            notValid.append(value2Info);
                        }
                    }
                    // general stuff
                    if (notValid.isEmpty()) {
                        if (outBounds.isEmpty()) {
                            try {
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription(modified + "value changed successfully!");
                                super.getMythArenaGui().clearFieldText(0);
                                super.getMythArenaGui().clearFieldText(1);
                                exit = true;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            super.getMythArenaGui().setDescription(outBounds + "have values out of bounds!");
                        }
                    } else {
                        super.getMythArenaGui().setDescription(notValid + "have not valid values");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
            }
        }
    }

    /**
     * Werewolf editor for character editor tool
     * @param selectedPlayer Player selectedPlayer
     */
    private void editWerewolf(Player selectedPlayer) {
        super.getMythArenaGui().setFormMode();
        super.getMythArenaGui().setTitle("Werewolf editor for " + selectedPlayer.getNickname());
        super.getMythArenaGui().setDescription("Type the amount you want to change");
        super.getMythArenaGui().setField(0, "Bounds 0-3 || Amount of Rage || Current value: " + ((Werewolf) selectedPlayer.getCharacter()).getRage());
        super.getMythArenaGui().setField(1, null);
        super.getMythArenaGui().setField(2, null);
        super.getMythArenaGui().setOption(0, "Exit without saving");
        super.getMythArenaGui().setOption(1, "Continue saving it");
        boolean exit = false;
        while (!exit) {
            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> exit = true;
                case 'B' -> {
                    String value = super.getMythArenaGui().getFieldText(0);
                    if (super.getArena().isInteger(value)) {
                        if (((Werewolf) selectedPlayer.getCharacter()).setRage(Integer.parseInt(value))) {
                            try {
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Rage value changed successfully!");
                                super.getMythArenaGui().clearFieldText(0);
                                exit = true;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            super.getMythArenaGui().setDescription("Value outside bounds!");
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please type a valid value");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
            }
        }
    }

    /**
     * Gold editor for character editor tool
     * @param selectedPlayer Player selectedPlayer
     */
    private void editGold(Player selectedPlayer) {
        super.getMythArenaGui().setFormMode();
        super.getMythArenaGui().setTitle("Gold editor for " + selectedPlayer.getNickname());
        super.getMythArenaGui().setDescription("Type the amount you want to change");
        super.getMythArenaGui().setField(0, "Bounds 0-inf || Amount of Gold || Current value: " + selectedPlayer.getCharacter().getGold());
        super.getMythArenaGui().setField(1, null);
        super.getMythArenaGui().setField(2, null);
        super.getMythArenaGui().setOption(0, "Exit without saving");
        super.getMythArenaGui().setOption(1, "Continue saving it");
        boolean exit = false;
        while (!exit) {
            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> exit = true;
                case 'B' -> {
                    String value = super.getMythArenaGui().getFieldText(0);
                    if (super.getArena().isInteger(value)) {
                        int valueInt = Integer.parseInt(value);
                        if (valueInt > 0) {
                            try {
                                selectedPlayer.getCharacter().setGold(valueInt);
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Gold value changed successfully!");
                                super.getMythArenaGui().clearFieldText(0);
                                exit = true;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            super.getMythArenaGui().setDescription("Negative values are not valid!");
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please type a valid value");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
            }
        }
    }

    /**
     * Health editor for character editor tool
     * @param selectedPlayer Player selectedPlayer
     */
    private void editHealth(Player selectedPlayer) {
        super.getMythArenaGui().setFormMode();
        super.getMythArenaGui().setTitle("Health editor for " + selectedPlayer.getNickname());
        super.getMythArenaGui().setDescription("Type the amount you want to change");
        super.getMythArenaGui().setField(0, "Bounds 0-5 || Amount of Health || Current value: " + selectedPlayer.getCharacter().getHealth());
        super.getMythArenaGui().setField(1, null);
        super.getMythArenaGui().setField(2, null);
        super.getMythArenaGui().setOption(0, "Exit without saving");
        super.getMythArenaGui().setOption(1, "Continue saving it");
        boolean exit = false;
        while (!exit) {
            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> exit = true;
                case 'B' -> {
                    String value = super.getMythArenaGui().getFieldText(0);
                    if (super.getArena().isInteger(value)) {
                        if (selectedPlayer.getCharacter().setHealth(Integer.parseInt(value))) {
                            try {
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Health value changed successfully!");
                                super.getMythArenaGui().clearFieldText(0);
                                exit = true;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            super.getMythArenaGui().setDescription("Value outside bounds!");
                        }
                    } else {
                        super.getMythArenaGui().setDescription("Please type a valid value");
                    }
                    super.getMythArenaGui().waitEvent(1);
                }
            }
        }
    }

}
