package mytharena.data.character.inventory.equipment;

import java.io.Serializable;

/**
 * Equipment abstract class implements Serializable
 */
public abstract class Equipment implements Serializable {

    /**
     * String name
     */
    private final String name;

    /**
     * int attackModification
     */
    private final int attackModification;

    /**
     * int defenseModification
     */
    private final int defenseModification;

    /**
     * Equipment abstract class constructor
     * @param name String name
     * @param attackModification int attackModification
     * @param defenseModification int defenseModification
     */
    public Equipment(String name, int attackModification, int defenseModification) {
        this.name = name;
        this.attackModification = attackModification;
        this.defenseModification = defenseModification;
    }

    /**
     * Gets String name
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets int attackModification
     * @return int attackModification
     */
    public int getAttackModification() {
        return this.attackModification;
    }

    /**
     * Gets int defenseModification
     * @return int defenseModification
     */
    public int getDefenseModification() {
        return this.defenseModification;
    }

}
