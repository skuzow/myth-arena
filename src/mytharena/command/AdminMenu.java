package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.user.Admin;
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
            super.getMythArenaGui().setOption(1, "Manage users");
            super.getMythArenaGui().setOption(2, "Manage characters");
            super.getMythArenaGui().setOption(3, "Validate combats");
            super.getMythArenaGui().setOption(4, null);
            super.getMythArenaGui().setOption(5, null);
            super.getMythArenaGui().setOption(6, null);
            super.getMythArenaGui().setOption(7, null);
            super.getMythArenaGui().setOption(8, "Log out");
            super.getMythArenaGui().setOption(9, null);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // manage admins
                case 'A' -> this.manageAdmins();
                // manage users
                case 'B' -> {

                }
                // manage characters
                case 'C' -> {

                }
                // validate combats
                case 'D' -> {

                }
                // log out
                case 'I' -> super.getArena().setActiveUser(null);
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
            super.getMythArenaGui().setOption(2, "Back to AdminMenu");
            super.getMythArenaGui().setOption(3, null);
            ArrayList<User> adminArrayList = new ArrayList<>();
            ArrayList<String> adminUsernameArrayList = new ArrayList<>();
            for (User user : super.getData().getUserArrayList()) {
                if (user instanceof Admin) {
                    adminArrayList.add(user);
                    adminUsernameArrayList.add(user.getUsername());
                }
            }
            super.getMythArenaGui().setList(adminUsernameArrayList);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // remove selected admin
                case 'A' -> {
                    int selected = super.getMythArenaGui().getLastSelectedListIndex();
                    super.getMythArenaGui().setDescription("Removed selected admin: " + selected);
                    super.getData().getUserArrayList().remove(adminArrayList.get(selected));
                    super.getMythArenaGui().waitEvent(1);
                }
                // register admin
                case 'B' -> this.registerAdmin();
                case 'C' -> exit = true;
            }
        }
    }

    /**
     * Register a admin into UserArrayList
     */
    private void registerAdmin() {
        super.getMythArenaGui().setFormMode();
        super.getMythArenaGui().setTitle("Admin Register Form");
        super.getMythArenaGui().setDescription("Fill the fields for creating an admin account");
        super.getMythArenaGui().setOption(0, "Back to Admin Manager Tool");
        super.getMythArenaGui().setOption(0, "Register Admin");
        super.getMythArenaGui().setField(0, "Username");
        super.getMythArenaGui().setField(1, "Password");
        super.getMythArenaGui().setField(2, null);
        boolean exitRegisterAdmin = false;
        while (!exitRegisterAdmin) {
            switch (super.getMythArenaGui().waitEvent(30)) {
                // exits register admin
                case 'A' -> exitRegisterAdmin = true;
                // tries to create admin user
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
                                exitRegisterAdmin = true;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

}
