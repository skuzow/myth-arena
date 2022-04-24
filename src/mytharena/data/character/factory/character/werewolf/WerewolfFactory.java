package mytharena.data.character.factory.character.werewolf;

import mytharena.data.Data;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class WerewolfFactory implements CharacterAbstractFactory {

    private final Data data;

    public WerewolfFactory(Data data) {
        this.data = data;
    }


    /**
     * AbilityAbstractFactory interface method
     *
     * @return Ability
     */
    @Override
    public Character createCharacter() {
        return new Werewolf(data);
    }
}
