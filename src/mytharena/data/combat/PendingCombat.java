package mytharena.data.combat;

import mytharena.data.user.User;

import java.io.Serializable;

/**
 * PendingCombat class implements Serializable
 */
public class PendingCombat implements Serializable {

    /**
     * User challenger
     */
    private final User challenger;

    /**
     * User challenged
     */
    private final User challenged;

    /**
     * PendingCombat class builder
     * @param challenger User challenger
     * @param challenged User challenged
     */
    public PendingCombat(User challenger, User challenged) {
        this.challenger = challenger;
        this.challenged = challenged;
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

}
