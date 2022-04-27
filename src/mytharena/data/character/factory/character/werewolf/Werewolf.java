package mytharena.data.character.factory.character.werewolf;

import mytharena.data.Data;
import mytharena.data.character.ability.Gift;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.modifier.Modifier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Werewolf class extends Character implements Serializable
 */
public class Werewolf extends Character implements Serializable {

    /**
     * int rage
     */
    private int rage;

    /**
     * Werewolf class constructor extends Character
     * @param data Data data
     */
    public Werewolf(Data data) {
        super(data);
        Random rand = new Random();
        this.rage = 0;
        super.setAbility(new Gift(rand.nextInt(3) + 1,rand.nextInt(3) + 1));
        ArrayList<Modifier> fortitudeArrayList = new ArrayList<>();
        fortitudeArrayList.add(new Modifier("Luna llena", rand.nextInt(5) + 1));
        super.setFortitudeArrayList(fortitudeArrayList);
    }

    /**
     * Sets int rage
     * @param rage int rage
     */
    public void setRage(int rage) {
        this.rage = rage;
    }

    /**
     * Gets int rage
     * @return int rage
     */
    public int getRage() {
        return this.rage;
    }
}
