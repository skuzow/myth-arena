package mytharena.data.character.factory.character.vampire;

import mytharena.data.Data;
import mytharena.data.character.ability.Ability;
import mytharena.data.character.ability.Discipline;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.inventory.Inventory;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.modifier.Modifier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Vampire class extends Character implements Serializable
 */
public class Vampire extends Character implements Serializable {

    /**
     * int age
     */
    private final int age;

    /**
     * int bloodPoints
     */
    private final int bloodPoints;

    public Vampire(Data data) {
        super(data);
        Random rand = new Random();
        age = rand.nextInt(1000)+1;
        bloodPoints = 0;
        setAbility(new Discipline(rand.nextInt(3)+1,rand.nextInt(3)+1));
        ArrayList<Modifier> weaknessArrayList = new ArrayList<>();
        weaknessArrayList.add(new Modifier("Luz solar", rand.nextInt(5)+1));
        setFortitudeArrayList(weaknessArrayList);
    }

    /**
     * Gets int age
     * @return int age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets int bloodPoints
     * @return int bloodPoints
     */
    public int getBloodPoints() {
        return this.bloodPoints;
    }

}
