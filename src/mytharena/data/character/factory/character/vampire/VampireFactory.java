package mytharena.data.character.factory.character.vampire;

import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class VampireFactory implements CharacterAbstractFactory {

    /**
     * String name
     */
    private String name;

    /**
     * VampireFactory Constructor
     * @param name String name
     */
    public VampireFactory(String name) {
        this.name = name;
    }

    /**
     * AbilityAbstractFactory interface method
     *
     * @return Ability
     */
    @Override
    public Character createCharacter() {
        return new Vampire(name);
    }
}
