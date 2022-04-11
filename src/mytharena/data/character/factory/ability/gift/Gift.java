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
    private int rageMin;

    /**
     * Gift class builder extends Ability
     * @param name String name
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     * @param rageMin int rageMin
     */
    public Gift(String name, int attackModifier, int defenseModifier, int rageMin) {
        super(name, attackModifier, defenseModifier);
        this.rageMin = rageMin;
    }
    
}
