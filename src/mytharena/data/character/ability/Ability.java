package mytharena.data.character.ability;

import java.io.Serializable;

/**
 * Ability abstract class implements Serializable
 */
public abstract class Ability implements Serializable {

    /**
     * int attackModifier
     */
    private final int attackModifier;

    /**
     * int defenseModifier
     */
    private final int defenseModifier;

    /**
     * Ability abstract class constructor
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     */
    public Ability(int attackModifier, int defenseModifier) {
        this.attackModifier = attackModifier;
        this.defenseModifier = defenseModifier;
    }

    /**
     * Gets int attackModifier
     * @return int attackModifier
     */
    public int getAttackModifier() {
        return this.attackModifier;
    }

    /**
     * Gets int defenseModifier
     * @return int defenseModifier
     */
    public int getDefenseModifier() {
        return this.defenseModifier;
    }

}
