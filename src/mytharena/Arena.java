package mytharena;

import mytharena.command.*;
import mytharena.data.Data;
import mytharena.data.character.inventory.equipment.Armor;
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.user.Admin;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;

import java.io.*;
import java.util.ArrayList;
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
                // add Armor pool
                data.getArmorPool().add(new Armor("Platemail",0,2));
                data.getArmorPool().add(new Armor("Chainmail",0,1));
                data.getArmorPool().add(new Armor("Blademail",3,2));
                data.getArmorPool().add(new Armor("Cuirass", 0,3));

                // add Weapon pool
                data.getWeaponPool().add(new Weapon("Broadsword",1,0,false));
                data.getWeaponPool().add(new Weapon("Claymore",1,1,false));
                data.getWeaponPool().add(new Weapon("Katana",2,0,false));
                data.getWeaponPool().add(new Weapon("Axe",2,2,true));
                data.getWeaponPool().add(new Weapon("Rapier",3,0,false));

                // default admin account
                this.data.getUserArrayList().add(new Admin("admin", "admin", this.data));
                this.serializeData();
            }
            // create commands and insert them into commandMap with respective key
            this.commandMap.put("AdminMenu", new AdminMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("StartMenu", new StartMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("PlayerMenu", new PlayerMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("CharacterCreationMenu", new CharacterCreationMenu(this, this.data, this.mythArenaGui));
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

    /**
     * Gets User activeUser
     * @return User activeUser
     */
    public User getActiveUser() {
        return this.activeUser;
    }

    /**
     * Sets User activeUser
     * @param activeUser User activeUser
     */
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

}
