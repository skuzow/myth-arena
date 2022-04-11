package mytharena.data.character.factory.ability;

/**
 * AbilityAbstractFactory interface
 */
public interface AbilityAbstractFactory {

    /**
     * Ability class generator
     * @param name
     * @param attackModifier
     * @param defenseModifier
     * @param rageMin
     * @param cost
     * @return
     */
    Ability createAbility(String name, int attackModifier, int defenseModifier, int rageMin, int cost);

}
