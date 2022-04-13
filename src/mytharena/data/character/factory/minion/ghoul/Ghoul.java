package mytharena.data.character.factory.minion.ghoul;

import mytharena.data.character.factory.minion.Minion;

import java.io.Serializable;

/**
 * Ghoul class extends Minion implements Serializable
 */
public class Ghoul extends Minion implements Serializable {

    /**
     * int dependency
     */
    private final int dependency;

    /**
     * Ghoul class constructor extends Minion
     * @param name String name
     * @param health int health
     * @param dependency int dependency
     */
    public Ghoul(String name, int health, int dependency) {
        super(name, health);
        this.dependency = dependency;
    }

    /**
     * Gets int dependency
     * @return int dependency
     */
    public int getDependency() {
        return this.dependency;
    }

}
