package mytharena.data.character.ability;

import java.io.Serializable;

/**
 * Talent class extends Ability implements Serializable
 */
public class Talent extends Ability implements Serializable {

    /**
     * Talent class constructor extends Ability
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     */
    public Talent(int attackModifier, int defenseModifier) {
        super(attackModifier, defenseModifier);
    }

}
