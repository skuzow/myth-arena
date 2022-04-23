package mytharena.data;

import mytharena.data.character.inventory.equipment.Armor;
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.combat.Combat;
import mytharena.data.combat.PendingCombat;
import mytharena.data.user.User;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Data class implements Serializable
 */
public class Data implements Serializable {

    /**
     * ArrayList User userArrayList
     */
    private final ArrayList<User> userArrayList = new ArrayList<>();

    /**
     * ArrayList User bannedPlayerArrayList
     */
    private final ArrayList<User> bannedPlayerArrayList = new ArrayList<>();

    /**
     * ArrayList Weapon weaponPool
     */
    private final ArrayList<Weapon> weaponPool = new ArrayList<>();

    /**
     * ArrayList Armor armorPool
     */
    private final ArrayList<Armor> armorPool = new ArrayList<>();

    /**
     * ArrayList Combat combatArrayList
     */
    private final ArrayList<Combat> combatArrayList = new ArrayList<>();

    /**
     * ArrayList PendingCombat pendingCombatArrayList
     */
    private final ArrayList<PendingCombat> pendingCombatArrayList = new ArrayList<>();

    /**
     * Gets ArrayList User userArrayList
     * @return ArrayList User userArrayList
     */
    public ArrayList<User> getUserArrayList() {
        return this.userArrayList;
    }

    /**
     * Gets ArrayList User bannedPlayerArrayList
     * @return ArrayList User bannedPlayerArrayList
     */
    public ArrayList<User> getBannedPlayerArrayList() {
        return this.bannedPlayerArrayList;
    }

    /**
     * Gets ArrayList Combat combatArrayList
     * @return ArrayList Combat combatArrayList
     */
    public ArrayList<Combat> getCombatArrayList() {
        return this.combatArrayList;
    }

    /**
     * Gets ArrayList PendingCombat pendingCombatArrayList
     * @return ArrayList PendingCombat pendingCombatArrayList
     */
    public ArrayList<PendingCombat> getPendingCombatArrayList() {
        return this.pendingCombatArrayList;
    }

    /**
     * Get ArrayList Weapon weaponPool
     * @return ArrayList Weapon weaponPool
     */
    public ArrayList<Weapon> getWeaponPool() {
        return weaponPool;
    }

    /**
     * ArrayList Armor armorPool
     * @return ArrayList Armor armorPool
     */
    public ArrayList<Armor> getArmorPool() {
        return armorPool;
    }

}
