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
        cost = rand.nextInt(3) + 1;
    }

    /**
     * Sets int cost
     * @param cost int cost
     * @return boolean inside bounds
     */
    public boolean setCost(int cost) {
        if (cost <= 3 && cost >= 1) {
            this.cost = cost;
            return true;
        }
        return false;
    }

    /**
     * Gets int cost
     * @return int cost
     */
    public int getCost() {
        return this.cost;
    }

}
