package mytharena.data.character.factory.character;

import mytharena.data.Data;
import mytharena.data.character.ability.Ability;
import mytharena.data.character.factory.character.vampire.Vampire;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionFactory;
import mytharena.data.character.factory.minion.demon.DemonFactory;
import mytharena.data.character.factory.minion.ghoul.GhoulFactory;
import mytharena.data.character.factory.minion.human.HumanFactory;
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
    private ArrayList<Modifier> weaknessArrayList = new ArrayList<>();
    /**
     * ArrayList Minion minionArrayList
     */
    private ArrayList<Minion> minionArrayList = new ArrayList<>();
    /**
     * ArrayList Modifier fortitudeArrayList
     */
    private ArrayList<Modifier> fortitudeArrayList = new ArrayList<>();
    /**
     * ArrayList Equipment weaponArrayList
     */
    private ArrayList<Equipment> equippedWeaponArrayList = new ArrayList<>();
    /**
     * Ability ability
     */
    private Ability ability;

    /**
     * Character abstract class constructor
     * @param data Data data
     */
    public Character(Data data) {
        Random rand = new Random();
        this.gold = 100;
        this.health = 5;
        this.power = rand.nextInt(5) + 1;
        // Randomly gets 3 armor and 3 weapons
        ArrayList<Equipment> armorArrayList = new ArrayList<>();
        ArrayList<Equipment> weaponArrayList = new ArrayList<>();
        for (int cont = 0; cont < 3; cont++) {
            armorArrayList.add(data.getArmorPool().get(rand.nextInt(data.getArmorPool().size())));
            weaponArrayList.add(data.getWeaponPool().get(rand.nextInt(data.getWeaponPool().size())));
        }
        this.setInventory(new Inventory(weaponArrayList, armorArrayList));
        // By default, the first weapon/armor in inventory will be equipped
        this.setArmor(getInventory().getArmorArrayList().get(0));
        ArrayList<Equipment> equippedWeaponArrayList = new ArrayList<>();
        equippedWeaponArrayList.add(getInventory().getWeaponArrayList().get(0));
        this.setEquippedWeaponArrayList(equippedWeaponArrayList);
        // Get minion count
        double roll = Math.random();
        int minionsCount;
        if (roll < 0.1) {
            minionsCount = 3;
        } else if (roll < 0.25) {
            minionsCount = 2;
        } else if (roll < 0.45) {
            minionsCount = 1;
        } else {
            minionsCount = 0;
        }
        // Generate proper minions
        MinionFactory minionFactory = new MinionFactory();
        for (int i = 0; i < minionsCount; i++) {
            if (this instanceof Vampire) {
                if (Math.random() < 0.5) {
                    this.minionArrayList.add(minionFactory.createMinion(new DemonFactory()));
                } else {
                    this.minionArrayList.add(minionFactory.createMinion(new GhoulFactory()));
                }
            } else {
                double randomMinion = Math.random();
                if (randomMinion < 0.33) {
                    this.minionArrayList.add(minionFactory.createMinion(new DemonFactory()));
                } else if (randomMinion < 0.66) {
                    this.minionArrayList.add(minionFactory.createMinion(new GhoulFactory()));
                } else {
                    this.minionArrayList.add(minionFactory.createMinion(new HumanFactory()));
                }
            }
        }
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
     * Sets ArrayList Modifier weaknessArrayList
     * @param weaknessArrayList ArrayList Modifier weaknessArrayList
     */
    public void setWeaknessArrayList(ArrayList<Modifier> weaknessArrayList) {
        this.weaknessArrayList = weaknessArrayList;
    }

    /**
     * Sets ArrayList Minion minionArrayList
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
        return this.ability;
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
        return this.fortitudeArrayList;
    }

    /**
     * Gets int power
     * @return int power
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Gets ArrayList Modifier weaknessArrayList
     * @return ArrayList Modifier weaknessArrayList
     */
    public ArrayList<Modifier> getWeaknessArrayList() {
        return this.weaknessArrayList;
    }

    /**
     * Gets ArrayList Minion minionArrayList
     * @return ArrayList Minion minionArrayList
     */
    public ArrayList<Minion> getMinionArrayList() {
        return this.minionArrayList;
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

