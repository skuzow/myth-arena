package mytharena.data.character.factory.minion.human;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

import java.util.ArrayList;

/**
 * HumanFactory class implements MinionAbstractFactory
 */
public class HumanFactory implements MinionAbstractFactory {

    public HumanFactory() {

    }

    /**
     * HumanFactory createMinion method
     * @return Human
     */
    @Override
    public Minion createMinion() {
        return new Human();
    }
    
}
