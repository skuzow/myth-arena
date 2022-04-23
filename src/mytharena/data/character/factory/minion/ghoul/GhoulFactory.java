package mytharena.data.character.factory.minion.ghoul;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

import java.util.ArrayList;

/**
 * GhoulFactory class implements MinionAbstractFactory
 */
public class GhoulFactory implements MinionAbstractFactory {

    public GhoulFactory() {

    }

    /**
     * GhoulFactory createMinion method
     * @return Ghoul
     */
    @Override
    public Minion createMinion() {
        return new Ghoul();
    }

}
