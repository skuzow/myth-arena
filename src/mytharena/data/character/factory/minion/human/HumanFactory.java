package mytharena.data.character.factory.minion.human;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

/**
 * HumanFactory class implements MinionAbstractFactory
 */
public class HumanFactory implements MinionAbstractFactory {

    /**
     * HumanFactory createMinion method
     * @return new Human
     */
    @Override
    public Minion createMinion() {
        return new Human();
    }
    
}
