package mytharena.data.character.factory.minion;

/**
 * MinionFactory class
 */
public class MinionFactory {

    /**
     * createMinion method
     * @param minionAbstractFactory MinionAbstractFactory minionAbstractFactory
     * @return new Minion
     */
    public Minion createMinion(MinionAbstractFactory minionAbstractFactory) {
        return minionAbstractFactory.createMinion();
    }

}
