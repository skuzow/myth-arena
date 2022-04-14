package mytharena.data.character.factory;

import mytharena.data.character.factory.ability.AbilityAbstractFactory;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

/**
 * Controller class
 */
public class Controller {

    /**
     * MinionAbstractFactory minionFactory
     */
    private final MinionAbstractFactory minionFactory;

    /**
     * AbilityAbstractFactory abilityFactory
     */
    private final AbilityAbstractFactory abilityFactory;

    /**
     * Controller class constructor
     * @param minionFactory MinionAbstractFactory minionFactory
     * @param abilityFactory AbilityAbstractFactory abilityFactory
     */
    public Controller(MinionAbstractFactory minionFactory, AbilityAbstractFactory abilityFactory) {
        this.minionFactory = minionFactory;
        this.abilityFactory = abilityFactory;
    }

    /**
     * Gets MinionAbstractFactory getMinionFactory
     * @return MinionAbstractFactory getMinionFactory
     */
    public MinionAbstractFactory getMinionFactory() {
        return minionFactory;
    }

    /**
     * Gets AbilityAbstractFactory getAbilityFactory
     * @return AbilityAbstractFactory getAbilityFactory
     */
    public AbilityAbstractFactory getAbilityFactory() {
        return abilityFactory;
    }

}
