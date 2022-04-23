package mytharena.data.character.factory.character.hunter;

import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class HunterFactory implements CharacterAbstractFactory {

    public HunterFactory() {
    }

    /**
     * AbilityAbstractFactory interface method
     * @return Ability
     */
    @Override
    public Character createCharacter() {
        return new Hunter();
    }
}
