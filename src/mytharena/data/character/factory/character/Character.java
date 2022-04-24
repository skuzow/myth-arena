package mytharena.data.character.factory.character;

import mytharena.data.character.ability.Ability;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.inventory.Inventory;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.modifier.Modifier;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Character abstract class implements Serializable
 */
public abstract class Character implements Serializable {

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
     * ArrayList Minion minionArrayList
     */
    private ArrayList<Minion> minionArrayList;

    /**
     * ArrayList Modifier fortitudeArrayList
     */
    private ArrayList<Modifier> fortitudeArrayList;

    /**
     * ArrayList Equipment weaponArrayList
     */
    private ArrayList<Equipment> equippedWeaponArrayList;

    /**
     * Ability ability
     */
    private Ability ability;

    public Character() {
        gold = 100;
        Random rand = new Random();

        this.health = 5;
        this.power = rand.nextInt(5)+1;
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
     * ArrayList Modifier weaknessArrayList
     * @param weaknessArrayList ArrayList Modifier weaknessArrayList
     */
    public void setWeaknessArrayList(ArrayList<Modifier> weaknessArrayList) {
        this.weaknessArrayList = weaknessArrayList;
    }

    /**
     * ArrayList Minion minionArrayList
     * @param minionArrayList ArrayList Minion minionArrayList
     */
    public void setMinionArrayList(ArrayList<Minion> minionArrayList) {
        this.minionArrayList = minionArrayList;
    }

    /**
     * Sets ArrayList Equipment weaponArrayList
     * @param equippedWeaponArrayList ArrayList Equipment weaponArrayList
     */
    public void setEquippedWeaponArrayList(ArrayList<Equipment> equippedWeaponArrayList) {
        this.equippedWeaponArrayList = equippedWeaponArrayList;
    }

    /**
     * Sets ArrayList Modifier fortitudeArrayList
     * @param fortitudeArrayList ArrayList Modifier fortitudeArrayList
     */
    public void setFortitudeArrayList(ArrayList<Modifier> fortitudeArrayList) {
        this.fortitudeArrayList = fortitudeArrayList;
    }

    /**
     * Sets Ability ability
     * @param ability Ability ability
     */
    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    /**
     * Gets Ability ability
     * @return Ability ability
     */
    public Ability getAbility() {
        return ability;
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
     * Gets ArrayList Modifier fortitudeArrayList
     * @return ArrayList Modifier fortitudeArrayList
     */
    public ArrayList<Modifier> getFortitudeArrayList() {
        return fortitudeArrayList;
    }

    /**
     * Gets int power
     * @return int power
     */
    public int getPower() {
        return this.power;
    }

    /**
     * ArrayList Modifier weaknessArrayList
     * @return ArrayList Modifier weaknessArrayList
     */
    public ArrayList<Modifier> getWeaknessArrayList() {
        return weaknessArrayList;
    }

    /**
     * Get ArrayList Minion minionArrayList
     * @return ArrayList Minion minionArrayList
     */
    public ArrayList<Minion> getMinionArrayList() {
        return minionArrayList;
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

