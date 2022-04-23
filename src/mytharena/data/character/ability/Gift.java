package mytharena.data.character.ability;

import java.io.Serializable;

/**
 * Gift class extends Ability implements Serializable
 */
public class Gift extends Ability implements Serializable {

    /**
     * int rageMin
     */
    private final int rageMin;

    /**
     * Gift class constructor extends Ability
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     */
    public Gift(int attackModifier, int defenseModifier) {
        super(attackModifier, defenseModifier);
        this.rageMin = 0;
    }

    /**
     * Gets int rageMin
     * @return int rageMin
     */
    public int getRageMin() {
        return this.rageMin;
    }

}
