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
    private ArrayList<Equipment> weaponArrayList;
    /**
     * ArrayList Equipment armorArrayList
     */
    private ArrayList<Equipment> armorArrayList;

    /**
     * Inventory class constructor
     * @param weaponArrayList ArrayList Equipment weaponArrayList
     * @param armorArrayList ArrayList Equipment armorArrayList
     */
    public Inventory(ArrayList<Equipment> weaponArrayList, ArrayList<Equipment> armorArrayList) {
        this.weaponArrayList = weaponArrayList;
        this.armorArrayList = armorArrayList;
    }

    /**
     * Sets ArrayList Equipment weaponArrayList
     * @param weaponArrayList ArrayList Equipment weaponArrayList
     */
    public void setWeaponArrayList(ArrayList<Equipment> weaponArrayList) {
        this.weaponArrayList = weaponArrayList;
    }

    /**
     * Sets ArrayList Equipment armorArrayList
     * @param armorArrayList ArrayList Equipment armorArrayList
     */
    public void setArmorArrayList(ArrayList<Equipment> armorArrayList) {
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
