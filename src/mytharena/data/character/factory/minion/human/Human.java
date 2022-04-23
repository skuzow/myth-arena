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
    private final Loyalty loyalty;


    public Human() {
        loyalty = Loyalty.values()[new Random().nextInt(Loyalty.values().length)];
    }

    /**
     * Gets String loyalty
     * @return String loyalty
     */
    public Loyalty getLoyalty() {
        return this.loyalty;
    }

}
