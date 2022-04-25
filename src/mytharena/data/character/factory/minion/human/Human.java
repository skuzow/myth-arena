package mytharena.data.character.factory.minion.human;

import mytharena.data.character.factory.minion.Minion;

import java.io.Serializable;
import java.util.Random;

/**
 * Human class extends Minion implements Serializable
 */
public class Human extends Minion implements Serializable {

    /**
     *  String loyalty
     */
    private Loyalty loyalty;

    /**
     * Human class constructor extends Minion
     */
    public Human() {
        this.loyalty = Loyalty.values()[ new Random().nextInt(Loyalty.values().length) ];
    }

    /**
     * Sets Loyalty loyalty
     * @param loyalty Loyalty loyalty
     */
    public void setLoyalty(Loyalty loyalty) {
        this.loyalty = loyalty;
    }

    /**
     * Gets String loyalty
     * @return String loyalty
     */
    public Loyalty getLoyalty() {
        return this.loyalty;
    }

}
