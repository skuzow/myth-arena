package mytharena.data.character.factory.ability;

/**
 * AbilityAbstractFactory interface
 */
public interface AbilityAbstractFactory {

    /**
     * Ability abstract factory
     * @param name String name
     * @param attackModifier attackModifier
     * @param defenseModifier int defenseModifier
     * @param rageMin int rageMin
     * @param cost int cost
     * @return new Ability
     */
    Ability createAbility(String name, int attackModifier, int defenseModifier, int rageMin, int cost);

}
