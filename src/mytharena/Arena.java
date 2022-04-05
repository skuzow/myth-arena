package mytharena;

import mytharena.commands.AdminMenu;
import mytharena.commands.Combat;
import mytharena.commands.Start;
import mytharena.commands.UserMenu;

import java.io.*;
import java.util.HashMap;

/**
 * Arena class
 */
public class Arena {

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
     * Starts all, and have main loop of the application
     */
    public void start() {
        try {
            File file = new File(this.serializablePath);
            if (file.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.serializablePath));
                this.data = (Data) in.readObject();
            } else {
                this.data = new Data();
                this.serializeData();
            }
            // create commands and insert them into commandMap with respective key
            this.commandMap.put("AdminMenu", new AdminMenu(this, this.data));
            this.commandMap.put("Combat", new Combat(this, this.data));
            this.commandMap.put("Start", new Start(this, this.data));
            this.commandMap.put("UserMenu", new UserMenu(this, this.data));
            // main loop
            while (true) {
                this.commandMap.get("Start").execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Serializes Data
     */
    private void serializeData() throws IOException {
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

}
