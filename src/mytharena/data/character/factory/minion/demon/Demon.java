package mytharena.data.character.factory.minion.demon;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.ghoul.Ghoul;
import mytharena.data.character.factory.minion.human.Human;

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
     */
    public Demon() {
        // gets minion count
        double roll = Math.random();
        int minionsCount;
        if (roll < 0.1) {
            minionsCount = 3;
        } else if (roll < 0.25) {
            minionsCount = 2;
        } else if (roll < 0.45) {
            minionsCount = 1;
        } else {
            minionsCount = 0;
        }
        // generates proper minions
        for (int cont = 0; cont < minionsCount; cont++) {
            double randomMinion = Math.random();
            if (randomMinion < 0.33) {
                this.minionArrayList.add(new Demon());
            } else if (randomMinion < 0.66) {
                this.minionArrayList.add(new Ghoul());
            } else {
                this.minionArrayList.add(new Human());
            }
        }
    }

    /**
     * Sets ArrayList Minion minionArrayList
     * @param minionArrayList ArrayList Minion minionArrayList
     */
    public void setMinionArrayList(ArrayList<Minion> minionArrayList) {
        this.minionArrayList = minionArrayList;
    }

    /**
     * Gets ArrayList Minion minionArrayList
     * @return ArrayList Minion minionArrayList
     */
    public ArrayList<Minion> getMinionArrayList() {
        return this.minionArrayList;
    }

}
