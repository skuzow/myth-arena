package mytharena.data.character.factory.ability.talent;

import mytharena.data.character.factory.ability.AbilityAbstractFactory;
import mytharena.data.character.factory.ability.Ability;

/**
 * TalentFactory class implements AbilityAbstractFactory
 */
public class TalentFactory implements AbilityAbstractFactory {

    /**
     * Ability talent generator
     * @param name
     * @param attackModifier
     * @param defenseModifier
     * @param rageMin
     * @param cost
     * @return
     */
    @Override
    public Ability createAbility(String name, int attackModifier, int defenseModifier, int rageMin, int cost) {
        return new Talent(name,attackModifier,defenseModifier);
    }
}
