package mytharena;

import mytharena.commands.Combat;
import mytharena.data.User;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {

    /**
     * ArrayList User userArrayList
     */
    private final ArrayList<User> userArrayList = new ArrayList<>();

    /**
     * ArrayList Combat combatArrayList
     */
    private final ArrayList<Combat> combatArrayList = new ArrayList<>();

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
