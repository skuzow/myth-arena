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
    private final int health;


    public Minion() {
        Random rand = new Random();
        health = rand.nextInt(3)+1;
    }

    /**
     * Gets int health
     * @return int health
     */
    public int getHealth() {
        return this.health;
    }

}
