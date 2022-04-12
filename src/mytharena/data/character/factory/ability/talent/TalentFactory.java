package mytharena.data.character.factory.ability.talent;

import mytharena.data.character.factory.ability.AbilityAbstractFactory;
import mytharena.data.character.factory.ability.Ability;

/**
 * TalentFactory class implements AbilityAbstractFactory
 */
public class TalentFactory implements AbilityAbstractFactory {

    /**
     * Ability Talent factory method
     * @param name String name
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     * @param rageMin int rageMin
     * @param cost int cost
     * @return new Talent
     */
    @Override
    public Ability createAbility(String name, int attackModifier, int defenseModifier, int rageMin, int cost) {
        return new Talent(name, attackModifier, defenseModifier);
    }

}
