package mytharena.data.character.factory.character.vampire;

import mytharena.data.Data;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class VampireFactory implements CharacterAbstractFactory {

    /**
     * Data data
     */
    private final Data data;

    /**
     * HunterFactory class constructor
     * @param data Data data
     */
    public VampireFactory(Data data) {
        this.data = data;
    }

    /**
     * HunterFactory createCharacter method
     * @return new Vampire
     */
    @Override
    public Character createCharacter() {
        return new Vampire(this.data);
    }

}
