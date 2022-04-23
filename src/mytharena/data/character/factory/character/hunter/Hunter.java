package mytharena.data.character.factory.character.hunter;

import mytharena.data.character.ability.Ability;
import mytharena.data.character.ability.Talent;
import mytharena.data.character.factory.character.Character;

import java.io.Serializable;
import java.util.Random;


/**
 * Hunter class extends Character implements Serializable
 */
public class Hunter extends Character implements Serializable {

    /**
     * int will
     */
    private final int will;

    public Hunter() {
        Random rand = new Random();
        will = rand.nextInt(3)+1;
        setAbility(new Talent(rand.nextInt(3)+1,rand.nextInt(3)+1));
    }

    /**
     * Gets int will
     * @return int will
     */
    public int getWill() {
        return this.will;
    }

}
