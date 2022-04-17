package mytharena.data.character.inventory.equipment;

import java.io.Serializable;

/**
 * Weapon class extends Equipment implements Serializable
 */
public class Weapon extends Equipment implements Serializable {

    /**
     * boolean twoHands
     */
    private final boolean twoHands;

    /**
     * Weapon class constructor extends Equipment
     * @param name String name
     * @param attackModification int attackModification
     * @param defenseModification int defenseModification
     * @param twoHands boolean twoHands
     */
    public Weapon(String name, int attackModification, int defenseModification, boolean twoHands) {
        super(name, attackModification, defenseModification);
        this.twoHands = twoHands;
    }

    /**
     * Gets boolean twoHands
     * @return boolean twoHands
     */
    public boolean isTwoHands() {
        return this.twoHands;
    }

}
