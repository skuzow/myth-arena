package mytharena.data.character.ability;

import mytharena.data.character.ability.Ability;

import java.io.Serializable;
import java.util.Random;

/**
 * Discipline class extends Ability implements Serializable
 */
public class Discipline extends Ability implements Serializable {

    /**
     * int cost
     */
    private final int cost;

    /**
     * Discipline class constructor extends Ability
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     */
    public Discipline(int attackModifier, int defenseModifier) {
        super(attackModifier, defenseModifier);
        Random rand = new Random();
        cost = rand.nextInt(4);
    }

    /**
     * Gets int cost
     * @return int cost
     */
    public int getCost() {
        return this.cost;
    }

}
