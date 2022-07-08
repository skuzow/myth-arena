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
     * String rarity
     */
    private final String rarity;

    /**
     * Weapon class constructor extends Equipment
     * @param name String name
     * @param attackModification int attackModification
     * @param defenseModification int defenseModification
     * @param twoHands boolean twoHands
     * @param rarity String rarity
     */
    public Weapon(String name, int attackModification, int defenseModification, boolean twoHands, String rarity) {
        super(name, attackModification, defenseModification);
        this.twoHands = twoHands;
        this.rarity = rarity;
    }

    /**
     * Gets boolean twoHands
     * @return boolean twoHands
     */
    public boolean isTwoHands() {
        return this.twoHands;
    }

    /**
     * Gets String rarity
     * @return String rarity
     */
    public String getRarity() {
        return this.rarity;
    }

}
