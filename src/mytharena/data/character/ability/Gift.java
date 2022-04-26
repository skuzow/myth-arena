package mytharena.data.character.ability;

import java.io.Serializable;
import java.util.Random;

/**
 * Gift class extends Ability implements Serializable
 */
public class Gift extends Ability implements Serializable {

    /**
     * int rageMin
     */
    private final int rageMin;

    /**
     * Gift class constructor extends Ability
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     */
    public Gift(int attackModifier, int defenseModifier) {
        super(attackModifier, defenseModifier);
        Random rand = new Random();
        this.rageMin = rand.nextInt(3);
    }

    /**
     * Gets int rageMin
     * @return int rageMin
     */
    public int getRageMin() {
        return this.rageMin;
    }

}
