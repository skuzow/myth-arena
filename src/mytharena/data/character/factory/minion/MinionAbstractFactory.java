package mytharena.data.character.factory.minion;

import java.util.ArrayList;

/**
 * MinionAbstractFactory interface
 */
public interface MinionAbstractFactory {

    /**
     * Minion abstract factory
     * @param name String name
     * @param health int health
     * @param loyalty String loyalty
     * @param dependency int dependency
     * @param minionArrayList ArrayList Minion minionArrayList
     * @return new Ability
     */
    Minion createMinion(String name, int health, String loyalty, int dependency, ArrayList<Minion> minionArrayList);

}
