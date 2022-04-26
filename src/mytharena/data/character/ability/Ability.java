package mytharena.data.character.ability;

import java.io.Serializable;

/**
 * Ability abstract class implements Serializable
 */
public abstract class Ability implements Serializable {

    /**
     * int attackModifier
     */
    private int attackModifier;
    /**
     * int defenseModifier
     */
    private int defenseModifier;

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
     * Sets int attackModifier
     * @param attackModifier int attackModifier
     */
    public void setAttackModifier(int attackModifier) {
        this.attackModifier = attackModifier;
    }

    /**
     * Sets int defenseModifier
     * @param defenseModifier int defenseModifier
     */
    public void setDefenseModifier(int defenseModifier) {
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
