package mytharena.data.character.factory.ability.discipline;

import mytharena.data.character.factory.ability.Ability;
import mytharena.data.character.factory.ability.AbilityAbstractFactory;

/**
 * DisciplineFactory class implements AbilityAbstractFactory
 */
public class DisciplineFactory implements AbilityAbstractFactory {

    /**
     * Ability Discipline factory method
     * @param name String name
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     * @param rageMin int rageMin
     * @param cost int cost
     * @return new Discipline
     */
    @Override
    public Ability createAbility(String name, int attackModifier, int defenseModifier, int rageMin, int cost) {
        return new Discipline(name, attackModifier, defenseModifier, cost);
    }

}
