package mytharena.data.combat;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.user.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Combat class implements Serializable
 */
public class Combat implements Serializable {

    /**
     * Player challenger
     */
    private final Player challenger;

    /**
     * Player challenged
     */
    private final Player challenged;

    /**
     * Player winner
     */
    private final Player winner;

    /**
     * Date date
     */
    private final Date date;

    /**
     * int rounds
     */
    private final int rounds;

    /**
     * int obtainedGold
     */
    private final int obtainedGold;

    /**
     * ArrayList Minion minionSurvivorArrayList
     */
    private final ArrayList<Minion> minionSurvivorArrayList;

    /**
     * Combat class constructor
     * @param challenger Player challenger
     * @param challenged Player challenged
     * @param winner Player winner
     * @param date Date date
     * @param rounds int rounds
     * @param obtainedGold int obtainedGold
     * @param minionSurvivorArrayList ArrayList Minion minionSurvivorArrayList
     */
    public Combat(Player challenger, Player challenged, Player winner, Date date, int rounds, int obtainedGold, ArrayList<Minion> minionSurvivorArrayList) {
        this.challenger = challenger;
        this.challenged = challenged;
        this.winner = winner;
        this.date = date;
        this.rounds = rounds;
        this.obtainedGold = obtainedGold;
        this.minionSurvivorArrayList = minionSurvivorArrayList;
    }

    /**
     * Gets Player challenger
     * @return Player challenger
     */
    public Player getChallenger() {
        return this.challenger;
    }

    /**
     * Gets Player challenged
     * @return Player challenged
     */
    public Player getChallenged() {
        return this.challenged;
    }

    /**
     * Gets Player winner
     * @return Player winner
     */
    public Player getWinner() {
        return this.winner;
    }

    /**
     * Gets Date date
     * @return Date date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Gets int rounds
     * @return int rounds
     */
    public int getRounds() {
        return this.rounds;
    }

    /**
     * Gets int obtainedGold
     * @return int obtainedGold
     */
    public int getObtainedGold() {
        return this.obtainedGold;
    }

    /**
     * Gets ArrayList Minion minionSurvivorArrayList
     * @return ArrayList Minion minionSurvivorArrayList
     */
    public ArrayList<Minion> getMinionSurvivorArrayList() {
        return this.minionSurvivorArrayList;
    }

}
