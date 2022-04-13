package mytharena.data.character.factory.minion.human;

import mytharena.data.character.factory.minion.Minion;

import java.io.Serializable;

/**
 * Human class extends Minion implements Serializable
 */
public class Human extends Minion implements Serializable {

    /**
     *  String loyalty
     */
    private String loyalty;

    /**
     * Human class constructor extends Minion
     * @param name
     * @param health
     * @param loyalty
     */
    public Human(String name, int health, String loyalty) {
        super(name,health);
        this.loyalty = loyalty;
    }

    /**
     * Gets String loyalty
     * @return String loyalty
     */
    public String getLoyalty() {
        return loyalty;
    }
}
