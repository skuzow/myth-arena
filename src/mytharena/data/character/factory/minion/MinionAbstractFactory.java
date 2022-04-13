package mytharena.data.character.factory.minion;

import java.util.ArrayList;

/**
 * MinionAbstractFactory interface
 */
public interface MinionAbstractFactory {

    /**
     * Minion abstract factory
     * @param name
     * @param health
     * @param loyalty
     * @param dependency
     * @param minionArrayList
     * @return new Ability
     */
    Minion createMinion(String name, int health, String loyalty, int dependency, ArrayList<Minion> minionArrayList);
}
