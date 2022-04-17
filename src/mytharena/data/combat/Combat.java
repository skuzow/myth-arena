package mytharena.data.combat;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.user.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Combat class implements Serializable
 */
public class Combat implements Serializable {

    /**
     * User challenger
     */
    private final User challenger;

    /**
     * User challenged
     */
    private final User challenged;

    /**
     * User winner
     */
    private final User winner;

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
     * @param challenger User challenger
     * @param challenged User challenged
     * @param winner User winner
     * @param date Date date
     * @param rounds int rounds
     * @param obtainedGold int obtainedGold
     * @param minionSurvivorArrayList ArrayList Minion minionSurvivorArrayList
     */
    public Combat(User challenger, User challenged, User winner, Date date, int rounds, int obtainedGold, ArrayList<Minion> minionSurvivorArrayList) {
        this.challenger = challenger;
        this.challenged = challenged;
        this.winner = winner;
        this.date = date;
        this.rounds = rounds;
        this.obtainedGold = obtainedGold;
        this.minionSurvivorArrayList = minionSurvivorArrayList;
    }

    /**
     * Gets User challenger
     * @return User challenger
     */
    public User getChallenger() {
        return this.challenger;
    }

    /**
     * Gets User challenged
     * @return User challenged
     */
    public User getChallenged() {
        return this.challenged;
    }

    /**
     * Gets User winner
     * @return User winner
     */
    public User getWinner() {
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
