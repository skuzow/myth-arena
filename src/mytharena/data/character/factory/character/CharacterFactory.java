package mytharena.data.character.factory.character;

import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class CharacterFactory {

    public Character createCharacter(CharacterAbstractFactory characterAbstractFactory) {
        return characterAbstractFactory.createCharacter();
    }
}
