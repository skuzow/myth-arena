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
     * @return boolean inside bounds
     */
    public boolean setAttackModifier(int attackModifier) {
        if (attackModifier <= 3 && attackModifier >= 0) {
            this.attackModifier = attackModifier;
            return true;
        }
        return false;
    }

    /**
     * Sets int defenseModifier
     * @param defenseModifier int defenseModifier
     * @return boolean inside bounds
     */
    public boolean setDefenseModifier(int defenseModifier) {
        if (defenseModifier <= 3 && defenseModifier >= 0) {
            this.defenseModifier = defenseModifier;
            return true;
        }
        return false;
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
