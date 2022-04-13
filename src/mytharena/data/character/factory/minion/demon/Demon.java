package mytharena.data.character.factory.minion.demon;

import mytharena.data.character.factory.minion.Minion;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Demon class extends Minion implements Serializable
 */
public class Demon extends Minion implements Serializable {

    /**
     * ArrayList Minion minionArrayList
     */
    private ArrayList<Minion> minionArrayList;

    /**
     * Demon class constructor extends Minion
     * @param name String name
     * @param health int health
     * @param minionArrayList ArrayList Minion minionArrayList
     */
    public Demon(String name, int health, ArrayList<Minion> minionArrayList) {
        super(name,health);
        this.minionArrayList = minionArrayList;
    }

    /**
     * Gets ArrayList Minion minionArrayList
     * @return ArrayList Minion minionArrayList
     */
    public ArrayList<Minion> getMinionArrayList() {
        return minionArrayList;
    }
}
