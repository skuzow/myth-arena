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
     * @param name
     * @param health
     * @param loyalty
     * @param dependency
     * @param minionArrayList
     * @return new Demon
     */
    @Override
    public Minion createMinion(String name, int health, String loyalty, int dependency, ArrayList<Minion> minionArrayList) {
        return new Demon(name,health,minionArrayList);
    }
}
