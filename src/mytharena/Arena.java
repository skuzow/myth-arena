package mytharena;

import mytharena.command.Command;
import mytharena.command.AdminMenu;
import mytharena.command.StartMenu;
import mytharena.command.PlayerMenu;
import mytharena.data.Data;
import mytharena.data.user.Admin;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;

import java.io.*;
import java.util.HashMap;

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
                this.serializeData();
            }
            // create commands and insert them into commandMap with respective key
            this.commandMap.put("AdminMenu", new AdminMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("StartMenu", new StartMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("PlayerMenu", new PlayerMenu(this, this.data, this.mythArenaGui));
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
     * Gets specific Command command in commandMap with String key
     * @param key String key
     * @return Command command
     */
    public Command getCommand(String key) {
        return this.commandMap.get(key);
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User user) {
        activeUser = user;
    }

}
