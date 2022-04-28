package mytharena.data.combat;

import mytharena.data.user.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Combat class implements Serializable
 */
public class Combat implements Serializable {

    /**
     * Player loser
     */
    private final Player loser;

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

    private final ArrayList<Round> rounds;

    /**
     * int obtainedGold
     */
    private final int bet;
    /**
     * ArrayList Minion minionSurvivorArrayList
     */
    private final Player playerWithMinionsLeft;

    /**
     * Combat class constructor
     * @param loser Player loser
     * @param winner Player winner
     * @param date Date date
     * @param rounds int rounds
     * @param bet int obtainedGold
     * @param playerWithMinionsLeft Player playerWithMinionsLeft
     */
    public Combat(Player winner, Player loser, Date date, ArrayList<Round> rounds, int bet, Player playerWithMinionsLeft) {
        this.loser = loser;
        this.winner = winner;
        this.date = date;
        this.rounds = rounds;
        this.bet = bet;
        this.playerWithMinionsLeft = playerWithMinionsLeft;
    }

    /**
     * Gets Player loser
     * @return Player loser
     */
    public Player getLoser() {
        return loser;
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
    public ArrayList<Round> getRounds() {
        return this.rounds;
    }

    /**
     * Gets int obtainedGold
     * @return int obtainedGold
     */
    public int getBet() {
        return this.bet;
    }

    public Player getPlayerWithMinionsLeft() {
        return playerWithMinionsLeft;
    }
}
