package mytharena.data.character.factory.minion.human;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

import java.util.ArrayList;

/**
 * HumanFactory class implements MinionAbstractFactory
 */
public class HumanFactory implements MinionAbstractFactory {

    /**
     * Minion Human factory method
     * @param name String name
     * @param health int health
     * @param loyalty String loyalty
     * @param dependency int dependency
     * @param minionArrayList ArrayList Minion minionArrayList
     * @return new Human
     */
    @Override
    public Minion createMinion(String name, int health, String loyalty, int dependency, ArrayList<Minion> minionArrayList) {
        return new Human(name,health,loyalty);
    }
}
