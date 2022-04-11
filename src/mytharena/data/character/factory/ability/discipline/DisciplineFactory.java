package mytharena.data.character.factory.ability.discipline;

import mytharena.data.character.factory.ability.Ability;
import mytharena.data.character.factory.ability.AbilityAbstractFactory;

/**
 * DisciplineFactory class implements AbilityAbstractFactory
 */
public class DisciplineFactory implements AbilityAbstractFactory {

    /**
     * Ability discipline generator
     * @param name
     * @param attackModifier
     * @param defenseModifier
     * @param rageMin
     * @param cost
     * @return
     */
    @Override
    public Ability createAbility(String name, int attackModifier, int defenseModifier, int rageMin, int cost) {
        return new Discipline(name,attackModifier,defenseModifier,cost);
    }
}
