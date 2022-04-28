package mytharena.data.character.factory.character.werewolf;

import mytharena.data.Data;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class WerewolfFactory implements CharacterAbstractFactory {

    /**
     * Data data
     */
    private final Data data;

    /**
     * WerewolfFactory class constructor
     * @param data Data data
     */
    public WerewolfFactory(Data data) {
        this.data = data;
    }

    /**
     * WerewolfFactory interface method
     * @return new Werewolf
     */
    @Override
    public Character createCharacter() {
        return new Werewolf(this.data);
    }

}
