package mytharena.data.combat;

import mytharena.data.user.Player;

import java.io.Serializable;

/**
 * PendingCombat class implements Serializable
 */
public class PendingCombat implements Serializable {

    /**
     * Player challenger
     */
    private final Player challenger;

    /**
     * Player challenged
     */
    private final Player challenged;

    /**
     * PendingCombat class builder
     * @param challenger Player challenger
     * @param challenged Player challenged
     */
    public PendingCombat(Player challenger, Player challenged) {
        this.challenger = challenger;
        this.challenged = challenged;
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

}
