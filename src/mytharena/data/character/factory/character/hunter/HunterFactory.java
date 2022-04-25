package mytharena.data.character.factory.character.hunter;

import mytharena.data.Data;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class HunterFactory implements CharacterAbstractFactory {

    /**
     * Data data
     */
    private final Data data;

    /**
     * HunterFactory class constructor
     * @param data Data data
     */
    public HunterFactory(Data data) {
        this.data = data;
    }

    /**
     * HunterFactory createCharacter method
     * @return new Hunter
     */
    @Override
    public Character createCharacter() {
        return new Hunter(this.data);
    }

}
