package mytharena.data.character.factory.character.werewolf;

import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.CharacterAbstractFactory;

public class WerewolfFactory implements CharacterAbstractFactory {

    private String name;
    public WerewolfFactory(String name) {
        this.name = name;
    }


    /**
     * AbilityAbstractFactory interface method
     *
     * @return Ability
     */
    @Override
    public Character createCharacter() {
        return new Werewolf(name);
    }
}
