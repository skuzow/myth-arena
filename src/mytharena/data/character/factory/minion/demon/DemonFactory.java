package mytharena.data.character.factory.minion.demon;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

import java.util.ArrayList;

/**
 * DemonFactory class implements MinionAbstractFactory
 */
public class DemonFactory implements MinionAbstractFactory {

    /**
     * Minion Demon factory method
     * @param name String name
     * @param health int health
     * @param loyalty String loyalty
     * @param dependency int dependency
     * @param minionArrayList ArrayList<Minion> minionArrayList
     * @return new Demon
     */
    @Override
    public Minion createMinion(String name, int health, String loyalty, int dependency, ArrayList<Minion> minionArrayList) {
        return new Demon(name,health,minionArrayList);
    }
}
