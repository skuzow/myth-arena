package mytharena.data.character.inventory;

import mytharena.data.character.inventory.equipment.Equipment;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Inventory class implements Serializable
 */
public class Inventory implements Serializable {

    /**
     * ArrayList Equipment weaponArrayList
     */
    private final ArrayList<Equipment> weaponArrayList;

    /**
     * ArrayList Equipment armorArrayList
     */
    private final ArrayList<Equipment> armorArrayList;

    /**
     * Inventory class builder
     * @param weaponArrayList ArrayList Equipment weaponArrayList
     * @param armorArrayList ArrayList Equipment armorArrayList
     */
    public Inventory(ArrayList<Equipment> weaponArrayList, ArrayList<Equipment> armorArrayList) {
        this.weaponArrayList = weaponArrayList;
        this.armorArrayList = armorArrayList;
    }

    /**
     * Gets Equipment weaponArrayList
     * @return Equipment weaponArrayList
     */
    public ArrayList<Equipment> getWeaponArrayList() {
        return this.weaponArrayList;
    }

    /**
     * Gets ArrayList Equipment armorArrayList
     * @return ArrayList Equipment armorArrayList
     */
    public ArrayList<Equipment> getArmorArrayList() {
        return this.armorArrayList;
    }

}
