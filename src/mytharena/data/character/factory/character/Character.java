package mytharena.data.character.factory.character;

import mytharena.data.character.ability.Ability;
import mytharena.data.character.inventory.Inventory;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.modifier.Modifier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

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
     * Inventory inventory
     */
    private Inventory inventory;

    /**
     * Equipment armor
     */
    private Equipment armor;

    /**
     * ArrayList Modifier weaknessArrayList
     */
    private ArrayList<Modifier> weaknessArrayList;

    /**
     * ArrayList Modifier fortitudeArrayList
     */
    private ArrayList<Modifier> fortitudeArrayList;

    public ArrayList<Modifier> getWeaknessArrayList() {
        return weaknessArrayList;
    }

    public void setWeaknessArrayList(ArrayList<Modifier> weaknessArrayList) {
        this.weaknessArrayList = weaknessArrayList;
    }

    public ArrayList<Modifier> getFortitudeArrayList() {
        return fortitudeArrayList;
    }

    public void setFortitudeArrayList(ArrayList<Modifier> fortitudeArrayList) {
        this.fortitudeArrayList = fortitudeArrayList;
    }

    /**
     * ArrayList Equipment weaponArrayList
     */
    private ArrayList<Equipment> equippedWeaponArrayList;

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    private Ability ability;

    /**
     * Character abstract class constructor
     * @param name String name
     */
    public Character(String name) {
        this.name = name;
        gold = 0;
        Random rand = new Random();

        this.health = rand.nextInt(3)+1;
        this.power = rand.nextInt(5)+1;
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
     * @param equippedWeaponArrayList ArrayList Equipment weaponArrayList
     */
    public void setEquippedWeaponArrayList(ArrayList<Equipment> equippedWeaponArrayList) {
        this.equippedWeaponArrayList = equippedWeaponArrayList;
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
    public ArrayList<Equipment> getEquippedWeaponArrayList() {
        return this.equippedWeaponArrayList;
    }

}

