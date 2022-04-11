package mytharena.data.character.factory.ability.gift;

import mytharena.data.character.factory.ability.Ability;

import java.io.Serializable;

/**
 * Gift class extends Ability implements Serializable
 */
public class Gift extends Ability implements Serializable {

    /**
     * int rage
     */
    private int rage;

    /**
     * Ability abstract class builder
     *
     * @param name            String name
     * @param attackModifier  int attackModifier
     * @param defenseModifier int defenseModifier
     */
    public Gift(String name, int attackModifier, int defenseModifier, int rage) {
        super(name, attackModifier, defenseModifier);
        this.rage = rage;
    }
}
