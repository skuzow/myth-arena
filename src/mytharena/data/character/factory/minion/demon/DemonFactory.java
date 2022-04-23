package mytharena.data.character.factory.minion.demon;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

import java.util.ArrayList;

/**
 * DemonFactory class implements MinionAbstractFactory
 */
public class DemonFactory implements MinionAbstractFactory {

    private ArrayList<Minion> minionArrayList;

    public DemonFactory() {

    }

    /**
     * DemonFactory createMinion method
     * @return new Demon
     */
    @Override
    public Minion createMinion() {
        return new Demon();
    }

}
