package mytharena.data.character.factory.minion.ghoul;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

import java.util.ArrayList;

/**
 * GhoulFactory class implements MinionAbstractFactory
 */
public class GhoulFactory implements MinionAbstractFactory {

    /**
     * Minion Ghoul factory method
     * @param name String name
     * @param health int health
     * @param loyalty String loyalty
     * @param dependency int dependency
     * @param minionArrayList ArrayList Minion minionArrayList
     * @return new Ghoul
     */
    @Override
    public Minion createMinion(String name, int health, String loyalty, int dependency, ArrayList<Minion> minionArrayList) {
        return new Ghoul(name, health, dependency);
    }

}
