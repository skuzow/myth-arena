package mytharena.data.character;

import mytharena.data.character.factory.ability.Ability;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.inventory.Inventory;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.modifier.Modifier;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Werewolf class extends Character implements Serializable
 */
public class Werewolf extends Character implements Serializable {

    /**
     * int rage
     */
    private final int rage;

    /**
     * Werewolf abstract class builder
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
     * @param rage int rage
     */
    public Werewolf(String name, int gold, int health, int power, Ability ability, Inventory inventory, Equipment armor, ArrayList<Equipment> weaponArrayList, ArrayList<Minion> minionArrayList, ArrayList<Modifier> fortitudeArrayList, ArrayList<Modifier> weaknessArrayList, int rage) {
        super(name, gold, health, power, ability, inventory, armor, weaponArrayList, minionArrayList, fortitudeArrayList, weaknessArrayList);
        this.rage = rage;
    }

    /**
     * Gets int rage
     * @return int rage
     */
    public int getRage() {
        return this.rage;
    }

}
