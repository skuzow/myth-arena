package mytharena.data.character.factory.character.vampire;

import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class VampireFactory implements CharacterAbstractFactory {

    public VampireFactory() {
    }

    /**
     * AbilityAbstractFactory interface method
     *
     * @return Ability
     */
    @Override
    public Character createCharacter() {
        return new Vampire();
    }
}
