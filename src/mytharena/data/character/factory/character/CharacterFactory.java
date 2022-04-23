package mytharena.data.character.factory.character;

public class CharacterFactory {

    public Character createCharacter(CharacterAbstractFactory characterAbstractFactory) {
        return characterAbstractFactory.createCharacter();
    }
}
