package mytharena.data.character.factory.minion;

public class MinionFactory {

    public Minion createMinion(MinionAbstractFactory minionAbstractFactory) {
        return minionAbstractFactory.createMinion();
    }
}
