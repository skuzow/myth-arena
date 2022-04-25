package mytharena.data.character.factory.minion.ghoul;

import mytharena.data.character.factory.minion.Minion;

import java.io.Serializable;
import java.util.Random;

/**
 * Ghoul class extends Minion implements Serializable
 */
public class Ghoul extends Minion implements Serializable {

    /**
     * int dependency
     */
    private int dependency;

    /**
     * Ghoul class constructor extends Minion
     */
    public Ghoul() {
        Random rand = new Random();
        this.dependency = rand.nextInt(5) + 1;
    }

    /**
     * Sets int dependency
     * @param dependency int dependency
     */
    public void setDependency(int dependency) {
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
