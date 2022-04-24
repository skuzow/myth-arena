package mytharena.data.character.factory.character.hunter;

import mytharena.data.Data;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class HunterFactory implements CharacterAbstractFactory {

    private final Data data;
    public HunterFactory(Data data) {
        this.data = data;
    }

    /**
     * AbilityAbstractFactory interface method
     * @return Ability
     */
    @Override
    public Character createCharacter() {
        return new Hunter(data);
    }
}
