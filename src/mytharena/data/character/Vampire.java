package mytharena.data.character;

import mytharena.data.character.factory.ability.Ability;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.inventory.Inventory;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.modifier.Modifier;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Vampire class extends Character implements Serializable
 */
public class Vampire extends Character implements Serializable {

    /**
     * int age
     */
    private final int age;

    /**
     * int bloodPoints
     */
    private final int bloodPoints;

    /**
     * Vampire abstract class builder
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
     * @param age int age
     * @param bloodPoints int bloodPoints
     */
    public Vampire(String name, int gold, int health, int power, Ability ability, Inventory inventory, Equipment armor, ArrayList<Equipment> weaponArrayList, ArrayList<Minion> minionArrayList, ArrayList<Modifier> fortitudeArrayList, ArrayList<Modifier> weaknessArrayList, int age, int bloodPoints) {
        super(name, gold, health, power, ability, inventory, armor, weaponArrayList, minionArrayList, fortitudeArrayList, weaknessArrayList);
        this.age = age;
        this.bloodPoints = bloodPoints;
    }

    /**
     * Gets int age
     * @return int age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets int bloodPoints
     * @return int bloodPoints
     */
    public int getBloodPoints() {
        return this.bloodPoints;
    }

}
