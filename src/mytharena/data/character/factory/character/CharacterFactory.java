package mytharena.data.character.factory.character;

/**
 * CharacterFactory class
 */
public class CharacterFactory {

    /**
     * createCharacter method
     * @param characterAbstractFactory CharacterAbstractFactory characterAbstractFactory
     * @return new Character
     */
    public Character createCharacter(CharacterAbstractFactory characterAbstractFactory) {
        return characterAbstractFactory.createCharacter();
    }

}
