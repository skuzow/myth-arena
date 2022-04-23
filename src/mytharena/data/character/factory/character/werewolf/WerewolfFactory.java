package mytharena.data.character.factory.character.werewolf;

import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class WerewolfFactory implements CharacterAbstractFactory {

    public WerewolfFactory() {

    }


    /**
     * AbilityAbstractFactory interface method
     *
     * @return Ability
     */
    @Override
    public Character createCharacter() {
        return new Werewolf();
    }
}
