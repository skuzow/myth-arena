package mytharena.data.character;

import mytharena.data.character.factory.ability.Ability;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.inventory.Inventory;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.modifier.Modifier;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Character abstract class implements Serializable
 */
public abstract class Character implements Serializable {

    /**
     * String name
     */
    private String name;

    /**
     * int gold
     */
    private int gold;

    /**
     * int health
     */
    private int health;

    /**
     * int power
     */
    private int power;

    /**
     * Ability ability
     */
    private Ability ability;

    /**
     * Inventory inventory
     */
    private Inventory inventory;

    /**
     * Equipment armor
     */
    private Equipment armor;

    /**
     * ArrayList Equipment weaponArrayList
     */
    private ArrayList<Equipment> weaponArrayList;

    /**
     * ArrayList Minion minionArrayList
     */
    private ArrayList<Minion> minionArrayList;

    /**
     * ArrayList Modifier fortitudeArrayList
     */
    private ArrayList<Modifier> fortitudeArrayList;

    /**
     * ArrayList Modifier weaknessArrayList
     */
    private ArrayList<Modifier> weaknessArrayList;

    /**
     * Character abstract class builder
     * @param name String name
     * @param gold int gold
     * @param health int health
     * @param power int power
     * @param ability Ability ability
     * @param inventory Inventory inventory
     * @param armor Equipment armor
     * @param weaponArrayList ArrayList Equipment weaponArrayList
     * @param minionArrayList ArrayList Minion minionArrayList
     * @param fortitudeArrayList ArrayList Modifier fortitudeArrayList
     * @param weaknessArrayList ArrayList Modifier weaknessArrayList
     */
    public Character(String name, int gold, int health, int power, Ability ability, Inventory inventory, Equipment armor, ArrayList<Equipment> weaponArrayList, ArrayList<Minion> minionArrayList, ArrayList<Modifier> fortitudeArrayList, ArrayList<Modifier> weaknessArrayList) {
        this.name = name;
        this.gold = gold;
        this.health = health;
        this.power = power;
        this.ability = ability;
        this.inventory = inventory;
        this.armor = armor;
        this.weaponArrayList = weaponArrayList;
        this.minionArrayList = minionArrayList;
        this.fortitudeArrayList = fortitudeArrayList;
        this.weaknessArrayList = weaknessArrayList;
    }

    /**
     * Sets String name
     * @param name String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets int gold
     * @param gold int gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Sets int health
     * @param health int health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets int power
     * @param power int power
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Sets Ability ability
     * @param ability Ability ability
     */
    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    /**
     * Sets Inventory inventory
     * @param inventory Inventory inventory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Sets Equipment armor
     * @param armor Equipment armor
     */
    public void setArmor(Equipment armor) {
        this.armor = armor;
    }

    /**
     * Sets ArrayList Equipment weaponArrayList
     * @param weaponArrayList ArrayList Equipment weaponArrayList
     */
    public void setWeaponArrayList(ArrayList<Equipment> weaponArrayList) {
        this.weaponArrayList = weaponArrayList;
    }

    /**
     * Sets ArrayList Minion minionArrayList
     * @param minionArrayList ArrayList Minion minionArrayList
     */
    public void setMinionArrayList(ArrayList<Minion> minionArrayList) {
        this.minionArrayList = minionArrayList;
    }

    /**
     * Sets ArrayList Modifier fortitudeArrayList
     * @param fortitudeArrayList ArrayList Modifier fortitudeArrayList
     */
    public void setFortitudeArrayList(ArrayList<Modifier> fortitudeArrayList) {
        this.fortitudeArrayList = fortitudeArrayList;
    }

    /**
     * Sets ArrayList Modifier weaknessArrayList
     * @param weaknessArrayList ArrayList Modifier weaknessArrayList
     */
    public void setWeaknessArrayList(ArrayList<Modifier> weaknessArrayList) {
        this.weaknessArrayList = weaknessArrayList;
    }

    /**
     * Gets String name
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets int gold
     * @return int gold
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * Gets int health
     * @return int health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Gets int power
     * @return int power
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Gets Ability ability
     * @return Ability ability
     */
    public Ability getAbility() {
        return this.ability;
    }

    /**
     * Gets Inventory inventory
     * @return Inventory inventory
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Gets Equipment armor
     * @return Equipment armor
     */
    public Equipment getArmor() {
        return this.armor;
    }

    /**
     * Gets ArrayList Equipment weaponArrayList
     * @return ArrayList Equipment weaponArrayList
     */
    public ArrayList<Equipment> getWeaponArrayList() {
        return this.weaponArrayList;
    }

    /**
     * Gets ArrayList Minion minionArrayList
     * @return ArrayList Minion minionArrayList
     */
    public ArrayList<Minion> getMinionArrayList() {
        return this.minionArrayList;
    }

    /**
     * Gets ArrayList Modifier fortitudeArrayList
     * @return ArrayList Modifier fortitudeArrayList
     */
    public ArrayList<Modifier> getFortitudeArrayList() {
        return this.fortitudeArrayList;
    }

    /**
     * Gets ArrayList Modifier weaknessArrayList
     * @return ArrayList Modifier weaknessArrayList
     */
    public ArrayList<Modifier> getWeaknessArrayList() {
        return this.weaknessArrayList;
    }

}
