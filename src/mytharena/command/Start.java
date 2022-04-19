package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.user.Admin;
import mytharena.data.user.Player;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;

import java.io.IOException;
import java.util.Objects;

/**
 * Start class extends Command
 */
public class Start extends Command {

    /**
     * Start class constructor extends Command
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public Start(Arena arena, Data data, MythArenaGui mythArenaGui) {
        super(arena, data, mythArenaGui);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() throws IOException {
        super.getMythArenaGui().setFormMode();
        super.getMythArenaGui().setTitle("LOGIN");
        super.getMythArenaGui().setDescription("");
        super.getMythArenaGui().setField(0,"Username");
        super.getMythArenaGui().setField(1,"Password");
        super.getMythArenaGui().setField(2,null);
        super.getMythArenaGui().setOption(0,"Sign up");
        super.getMythArenaGui().setOption(1,"Log in");
        char c = super.getMythArenaGui().waitEvent(30);

        switch (c) {
            case 'A' -> register();
            case 'B' -> login();
        }
    }

    /**
     * Log in to a session
     */
    private void login() throws IOException {
            String user = super.getMythArenaGui().getFieldText(0);
            String pass = super.getMythArenaGui().getFieldText(1);

            // Check if user exists
            int i = 0;
            boolean isValid = false;
            while (i < super.getData().getUserArrayList().size() && !isValid) {
                if (super.getData().getUserArrayList().get(i).getUsername().equals(user) && super.getData().getUserArrayList().get(i).getPassword().equals(pass)) {
                    isValid = true;
                }
                i++;
            }

            if(isValid) {
                User activeUser = super.getData().getUserArrayList().get(i-1);
                super.getArena().setActiveUser(activeUser);
                // Check if it's an Admin account
                if (activeUser instanceof Admin) {
                    super.getArena().getCommand("AdminMenu").execute();
                } else {
                    super.getArena().getCommand("PlayerMenu").execute();
                }
            }else {
                super.getMythArenaGui().setDescription("Incorrect username or password");
                super.getMythArenaGui().waitEvent(2);
            }
    }

    /**
     * Register a player into UserArrayList
     */
    private  void register() throws IOException {
            super.getMythArenaGui().setTitle("Create new account");
            super.getMythArenaGui().setDescription("Complete the form to register");
            super.getMythArenaGui().setField(2,"Nickname");
            super.getMythArenaGui().setOption(0,"Cancel");
            super.getMythArenaGui().setOption(1,"Register");

            boolean isValid = false;

            while(!isValid) {
                char c = super.getMythArenaGui().waitEvent(30);
                switch (c) {
                    case 'A' -> {
                        // Cancel register operation
                        isValid = true;
                        c = '\u0000';
                    }
                    case 'B' -> {
                        // Register account
                        // Must pass all criteria to work
                        String user = super.getMythArenaGui().getFieldText(0);
                        String pass = super.getMythArenaGui().getFieldText(1);
                        String nick = super.getMythArenaGui().getFieldText(2);
                        if (user == null || user.length() < 4 && pass == null || pass.length() < 4 && nick == null || nick.length() < 4) {
                            super.getMythArenaGui().setDescription("All fields must be filled in to register. Fields must have atleast 4 characters.");
                        } else {
                            // Check if username or nickname is taken
                            boolean isUnique = true;
                            int i = 0;
                            while(i < super.getData().getUserArrayList().size() && isUnique) {
                                if(user.equals(super.getData().getUserArrayList().get(i).getUsername())){
                                    super.getMythArenaGui().setDescription("Username is taken");
                                    isUnique = false;
                                }
                                if(nick.equals(super.getData().getUserArrayList().get(i).getUsername())){
                                    super.getMythArenaGui().setDescription("Nickname is taken");
                                    isUnique = false;
                                }
                                i++;
                            }

                            if(isUnique) {
                                Player player = new Player(user, pass, super.getData(), nick);
                                super.getData().getUserArrayList().add(player);
                                super.getArena().serializeData();
                                super.getMythArenaGui().setDescription("Account has been created succesfully!");
                                super.getMythArenaGui().waitEvent(1);
                                isValid = true;
                            }
                        }
                    }
                }
            }
    }

}