package mytharena.data.character.factory.minion;

import java.io.Serializable;

/**
 * Minion abstract class implements Serializable
 */
public abstract class Minion implements Serializable {

    /**
     * String name
     */
    private String name;

    /**
     * int attackModifier
     */
    private int health;

    /**
     * Minion abstract class constructor
     * @param name
     * @param health
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
        return name;
    }

    /**
     * Gets int health
     * @return int health
     */
    public int getHealth() {
        return health;
    }
}
