package mytharena.data.character.factory.minion.ghoul;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

/**
 * GhoulFactory class implements MinionAbstractFactory
 */
public class GhoulFactory implements MinionAbstractFactory {

    /**
     * GhoulFactory createMinion method
     * @return new Ghoul
     */
    @Override
    public Minion createMinion() {
        return new Ghoul();
    }

}
