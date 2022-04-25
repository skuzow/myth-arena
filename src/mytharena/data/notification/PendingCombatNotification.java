package mytharena.data.notification;

import mytharena.data.user.Player;

import java.io.Serializable;

/**
 * PendingCombatNotification class extends Notification implements Serializable
 */
public class PendingCombatNotification extends Notification implements Serializable {

    /**
     * Player challenger
     */
    private Player challenger;

    private int bet;

    /**
     * Notification abstract class constructor
     *
     * @param title String title
     * @param body  String body
     */
    public PendingCombatNotification(String title, String body, Player challenger, int bet) {
        super(title, body);
        this.challenger = challenger;
        this.bet = bet;
    }

    /**
     * Gets Player challenger
     * @return Player challenger
     */
    public Player getChallenger() {
        return challenger;
    }

    public int getBet() {
        return bet;
    }
}

