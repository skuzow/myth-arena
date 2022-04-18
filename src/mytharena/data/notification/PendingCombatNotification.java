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

    /**
     * Notification abstract class constructor
     *
     * @param title String title
     * @param body  String body
     */
    public PendingCombatNotification(String title, String body, Player challenger) {
        super(title, body);
        this.challenger = challenger;
    }

    /**
     * Gets Player challenger
     * @return Player challenger
     */
    public Player getChallenger() {
        return challenger;
    }

}

