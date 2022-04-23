package mytharena.data.character.factory.minion.human;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

import java.util.ArrayList;

/**
 * HumanFactory class implements MinionAbstractFactory
 */
public class HumanFactory implements MinionAbstractFactory {

    /**
     * String name
     */
    private final String name;

    /**
     * int health
     */
    private final int health;

    /**
     * String loyalty
     */
    private final String loyalty;

    /**
     * HumanFactory constructor implements MinionAbstracFactory
     * @param name String name
     * @param health int health
     * @param loyalty String loyal
     */
    public HumanFactory(String name, int health, String loyalty) {
        this.name = name;
        this.health = health;
        this.loyalty = loyalty;
    }

    /**
     * HumanFactory createMinion method
     * @return Human
     */
    @Override
    public Minion createMinion() {
        return new Human(name, health, loyalty);
    }
    
}
