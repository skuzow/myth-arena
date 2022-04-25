package mytharena.data.character.ability;

import java.io.Serializable;
import java.util.Random;

/**
 * Discipline class extends Ability implements Serializable
 */
public class Discipline extends Ability implements Serializable {

    /**
     * int cost
     */
    private int cost;

    /**
     * Discipline class constructor extends Ability
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     */
    public Discipline(int attackModifier, int defenseModifier) {
        super(attackModifier, defenseModifier);
        Random rand = new Random();
        this.cost = rand.nextInt(4);
    }

    /**
     * Sets int cost
     * @param cost int cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Gets int cost
     * @return int cost
     */
    public int getCost() {
        return this.cost;
    }

}
