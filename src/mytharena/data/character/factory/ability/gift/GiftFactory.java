package mytharena.data.character.factory.ability.gift;

import mytharena.data.character.factory.ability.Ability;
import mytharena.data.character.factory.ability.AbilityAbstractFactory;

/**
 * GiftFactory class implements AbilityAbstractFactory
 */
public class GiftFactory implements AbilityAbstractFactory {

    /**
     * Ability Gift factory method
     * @param name String name
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     * @param rageMin int rageMin
     * @param cost int cost
     * @return new Gift
     */
    @Override
    public Ability createAbility(String name, int attackModifier, int defenseModifier, int rageMin, int cost) {
        return new Gift(name, attackModifier, defenseModifier, rageMin);
    }
    
}
