package mytharena.data.character.factory.ability.gift;

import mytharena.data.character.factory.ability.Ability;
import mytharena.data.character.factory.ability.AbilityAbstractFactory;

/**
 * GiftFactory class implements AbilityAbstractFactory
 */
public class GiftFactory implements AbilityAbstractFactory {

    /**
     * Ability gift generator
     * @param name
     * @param attackModifier
     * @param defenseModifier
     * @param rageMin
     * @param cost
     * @return
     */
    @Override
    public Ability createAbility(String name, int attackModifier, int defenseModifier, int rageMin, int cost) {
        return new Gift(name,attackModifier,defenseModifier,rageMin);
    }
}
