package mytharena.data.character.factory.ability;

import java.io.Serializable;

/**
 * Ability abstract class implements Serializable
 */
public abstract class Ability implements Serializable {

    /**
     * String name
     */
    private final String name;

    /**
     * int attackModifier
     */
    private final int attackModifier;

    /**
     * int defenseModifier
     */
    private final int defenseModifier;

    /**
     * Ability abstract class builder
     * @param name String name
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     */
    public Ability(String name, int attackModifier, int defenseModifier) {
        this.name = name;
        this.attackModifier = attackModifier;
        this.defenseModifier = defenseModifier;
    }

    /**
     * Gets String name
     * @return String name
     */
    public String getName() {
        return this.name;
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
