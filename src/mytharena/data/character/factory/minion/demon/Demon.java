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


    public Demon() {

    }

    /**
     * Gets ArrayList Minion minionArrayList
     * @return ArrayList Minion minionArrayList
     */
    public ArrayList<Minion> getMinionArrayList() {
        return this.minionArrayList;
    }

}
