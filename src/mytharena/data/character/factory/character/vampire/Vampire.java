package mytharena.data.character.factory.character.vampire;

import mytharena.data.Data;
import mytharena.data.character.ability.Discipline;
import mytharena.data.character.factory.character.Character;
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
    private int age;
  
    /**
     * int bloodPoints
     */
    private int bloodPoints;

    /**
     * Hunter class constructor extends Character
     * @param data Data data
     */
    public Vampire(Data data) {
        super(data);
        Random rand = new Random();
        this.age = rand.nextInt(1000)+1;
        this.bloodPoints = 0;
        super.setAbility(new Discipline(rand.nextInt(3) + 1, rand.nextInt(3) + 1));
        ArrayList<Modifier> weaknessArrayList = new ArrayList<>();
        weaknessArrayList.add(new Modifier("Luz solar", rand.nextInt(5) + 1));
        super.setFortitudeArrayList(weaknessArrayList);
    }

    /**
     * Sets int age
     * @param age int age
     * @return boolean inside bounds
     */
    public boolean setAge(int age) {
        if (age > 0) {
            this.age = age;
            return true;
        }
        return false;
    }

    /**
     * Sets int bloodPoints
     * @param bloodPoints int bloodPoints
     * @return boolean inside bounds
     */
    public boolean setBloodPoints(int bloodPoints) {
        if (bloodPoints <= 10 && bloodPoints >= 0) {
            this.bloodPoints = bloodPoints;
            return true;
        }
        return false;
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
