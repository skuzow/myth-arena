package mytharena;

import mytharena.commands.AdminMenu;
import mytharena.commands.Combat;
import mytharena.commands.Start;
import mytharena.commands.UserMenu;
import mytharena.data.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Arena class
 */
public class Arena {

    /**
     * HashMap String Command commandMap
     */
    private final HashMap<String, Command> commandMap = new HashMap<>();

    /**
     * ArrayList User userArrayList
     */
    private final ArrayList<User> userArrayList = new ArrayList<>();

    /**
     * ArrayLis Combat combatArrayList
     */
    private final ArrayList<Combat> combatArrayList = new ArrayList<>();

    /**
     * Starts all, and have main loop of the application
     */
    public void start() {
        // create commands and insert them into commandMap with respective key
        this.commandMap.put("AdminMenu", new AdminMenu(this));
        this.commandMap.put("Combat", new Combat(this));
        this.commandMap.put("Start", new Start(this));
        this.commandMap.put("UserMenu", new UserMenu(this));
        // main loop
        while(true) {
            this.commandMap.get("Start").execute();
        }
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
     * Gets ArrayList User userArrayList
     * @return ArrayList User userArrayList
     */
    public ArrayList<User> getUserArrayList() {
        return this.userArrayList;
    }

    /**
     * Gets ArrayList Combat combatArrayList
     * @return ArrayList Combat combatArrayList
     */
    public ArrayList<Combat> getCombatArrayList() {
        return this.combatArrayList;
    }

}
