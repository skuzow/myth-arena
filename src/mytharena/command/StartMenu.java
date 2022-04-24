package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.user.Admin;
import mytharena.data.user.Player;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;

import java.io.IOException;

/**
 * Start class extends Command
 */
public class StartMenu extends Command {

    /**
     * Start class constructor extends Command
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public StartMenu(Arena arena, Data data, MythArenaGui mythArenaGui) {
        super(arena, data, mythArenaGui);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {
        super.getMythArenaGui().setFormMode();
        super.getMythArenaGui().setTitle("Login");
        super.getMythArenaGui().setDescription(null);
        super.getMythArenaGui().setField(0, "Username");
        super.getMythArenaGui().setField(1, "Password");
        super.getMythArenaGui().setOption(0, "Sign up");
        super.getMythArenaGui().setOption(1, "Log in");
        super.getMythArenaGui().setField(2, null);
        switch (super.getMythArenaGui().waitEvent(30)) {
            case 'A' -> this.register();
            case 'B' -> this.login();
        }
    }

    /**
     * Log in to a session
     */
    private void login() {
        String user = super.getMythArenaGui().getFieldText(0);
        String pass = super.getMythArenaGui().getFieldText(1);
        // Check if user exists
        int i = 0;
        boolean isValid = false;
        while (i < super.getData().getUserArrayList().size() && !isValid) {
            if (user.equals(super.getData().getUserArrayList().get(i).getUsername()) && pass.equals(super.getData().getUserArrayList().get(i).getPassword())) {
                isValid = true;
            }
            i++;
        }
        // Proceed to corresponding menu if it's valid
        if (isValid) {
            User activeUser = super.getData().getUserArrayList().get(i - 1);
            super.getArena().setActiveUser(activeUser);
            super.getMythArenaGui().clearFieldText(0);
            super.getMythArenaGui().clearFieldText(1);
            // Check if it's an Admin account
            if (activeUser instanceof Admin) {
                super.getArena().getCommand("AdminMenu").execute();
            } else {
                super.getArena().getCommand("PlayerMenu").execute();
            }
        } else {
            super.getMythArenaGui().setDescription("Incorrect username or password");
            super.getMythArenaGui().clearFieldText(1);
            super.getMythArenaGui().waitEvent(2);
        }
    }

    /**
     * Register a player into UserArrayList
     */
    private void register() {
        super.getMythArenaGui().setTitle("Signup");
        super.getMythArenaGui().setDescription("Complete the form to create new account");
        super.getMythArenaGui().setField(2, "Nickname");
        super.getMythArenaGui().setOption(0, "Cancel");
        super.getMythArenaGui().setOption(1, "Done");
        boolean isValid = false;
        while (!isValid) {
            switch (super.getMythArenaGui().waitEvent(30)) {
                // Cancel register operation
                case 'A' -> isValid = true;
                // Register account
                // Must pass all criteria to work
                case 'B' -> {
                    String user = super.getMythArenaGui().getFieldText(0);
                    String pass = super.getMythArenaGui().getFieldText(1);
                    String nick = super.getMythArenaGui().getFieldText(2);
                    if (user == null || user.length() < 4 && pass == null || pass.length() < 4 && nick == null || nick.length() < 4) {
                        super.getMythArenaGui().setDescription("All fields must be filled in to register. Fields must have at least 4 characters");
                    } else {
                        // Check if username or nickname is taken
                        boolean isUnique = true;
                        int i = 0;
                        while (i < super.getData().getUserArrayList().size() && isUnique) {
                            if (user.equals(super.getData().getUserArrayList().get(i).getUsername())){
                                super.getMythArenaGui().setDescription("Username is taken");
                                isUnique = false;
                            }
                            if (nick.equals(super.getData().getUserArrayList().get(i).getUsername())){
                                super.getMythArenaGui().setDescription("Nickname is taken");
                                isUnique = false;
                            }
                            i++;
                        }
                        // Create player user and save it in data serializing it
                        if (isUnique) {
                            try {
                                super.getData().getUserArrayList().add(new Player(user, pass, super.getData(), nick));
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Account has been created successfully!");
                                super.getMythArenaGui().waitEvent(1);
                                super.getMythArenaGui().clearFieldText(0);
                                super.getMythArenaGui().clearFieldText(1);
                                super.getMythArenaGui().clearFieldText(2);
                                isValid = true;
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
