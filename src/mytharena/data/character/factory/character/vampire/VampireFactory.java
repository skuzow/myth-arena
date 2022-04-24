package mytharena.data.character.factory.character.vampire;

import mytharena.data.Data;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class VampireFactory implements CharacterAbstractFactory {

    private final Data data;
    public VampireFactory(Data data) {
        this.data = data;
    }

    /**
     * AbilityAbstractFactory interface method
     *
     * @return Ability
     */
    @Override
    public Character createCharacter() {
        return new Vampire(data);
    }
}
