package mytharena.data.character.factory.minion;

import java.io.Serializable;

/**
 * Minion abstract class implements Serializable
 */
public abstract class Minion implements Serializable {

    /**
     * String name
     */
    private final String name;

    /**
     * int health
     */
    private final int health;

    /**
     * Minion abstract class constructor implements Serializable
     * @param name String name
     * @param health String health
     */
    public Minion(String name, int health) {
        this.name = name;
        this.health = health;
    }

    /**
     * Gets String name
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets int health
     * @return int health
     */
    public int getHealth() {
        return this.health;
    }

}
