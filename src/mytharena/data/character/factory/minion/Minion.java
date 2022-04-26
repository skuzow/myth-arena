package mytharena.data.character.factory.minion;

import java.io.Serializable;
import java.util.Random;

/**
 * Minion abstract class implements Serializable
 */
public abstract class Minion implements Serializable {

    /**
     * int health
     */
    private int health;

    /**
     * Minion class constructor
     */
    public Minion() {
        Random rand = new Random();
        this.health = rand.nextInt(3) + 1;
    }

    /**
     * Sets int health
     * @param health int health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets int health
     * @return int health
     */
    public int getHealth() {
        return this.health;
    }

}
