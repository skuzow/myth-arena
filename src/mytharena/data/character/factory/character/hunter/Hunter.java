package mytharena.data.character.factory.character.hunter;

import mytharena.data.Data;
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
    private int will;

    /**
     * Hunter class constructor extends Character
     */
    public Hunter(Data data) {
        super(data);
        Random rand = new Random();
        will = rand.nextInt(3) + 1;
        setAbility(new Talent(rand.nextInt(3) + 1, rand.nextInt(3) + 1));
    }

    /**
     * Sets int will
     * @param will int will
     * @return boolean inside bounds
     */
    public boolean setWill(int will) {
        if (will <= 3 && will >= 0) {
            this.will = will;
            return true;
        }
        return false;
    }

    /**
     * Gets int will
     * @return int will
     */
    public int getWill() {
        return this.will;
    }

}
