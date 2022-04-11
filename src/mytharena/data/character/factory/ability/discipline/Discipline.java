package mytharena.data.character.factory.ability.discipline;

import mytharena.data.character.factory.ability.Ability;

import java.io.Serializable;

/**
 * Discipline class extends Ability implements Serializable
 */
public class Discipline extends Ability implements Serializable {

    /**
     * int cost
     */
    private int cost;

    /**
     * Discipline class builder extends Ability
     * @param name String name
     * @param attackModifier int attackModifier
     * @param defenseModifier int defenseModifier
     */
    public Discipline(String name, int attackModifier, int defenseModifier, int cost) {
        super(name, attackModifier, defenseModifier);
        this.cost = cost;
    }

}
