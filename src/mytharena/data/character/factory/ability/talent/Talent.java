package mytharena.data.character.factory.ability.talent;

import mytharena.data.character.factory.ability.Ability;

import java.io.Serializable;

/**
 * Talent class extends Ability implements Serializable
 */
public class Talent extends Ability implements Serializable {

    /**
     * Talent class builder extends Ability
     * @param name String name
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     */
    public Talent(String name, int attackModifier, int defenseModifier) {
        super(name, attackModifier, defenseModifier);
    }

}
