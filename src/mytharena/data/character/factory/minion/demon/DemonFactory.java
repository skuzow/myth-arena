package mytharena.data.character.factory.minion.demon;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

import java.util.ArrayList;

/**
 * DemonFactory class implements MinionAbstractFactory
 */
public class DemonFactory implements MinionAbstractFactory {

    /**
     * String name
     */
    private final String name;

    /**
     * int health
     */
    private final int health;

    /**
     * ArrayList Minion minionArrayList
     */
    private final ArrayList<Minion> minionArrayList;

    /**
     * DemonFactory constructor implements MinionAbstractFactory
     * @param name String name
     * @param health int health
     * @param minionArrayList ArrayList Minion minionArrayList
     */
    public DemonFactory(String name, int health, ArrayList<Minion> minionArrayList) {
        this.name = name;
        this.health = health;
        this.minionArrayList = minionArrayList;
    }

    /**
     * DemonFactory createMinion method
     * @return new Demon
     */
    @Override
    public Minion createMinion() {
        return new Demon(name, health, minionArrayList);
    }

}
