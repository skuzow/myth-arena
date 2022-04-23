package mytharena.data.character.factory.minion.ghoul;

import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;

import java.util.ArrayList;

/**
 * GhoulFactory class implements MinionAbstractFactory
 */
public class GhoulFactory implements MinionAbstractFactory {

    /**
     * String name
     */
    private final String name;

    /**
     * int health
     */
    private final int health;

    /**
     * int dependency
     */
    private final int dependency;

    /**
     * GhoulFactory constructor implements MinionAbstractFactory
     * @param name String name
     * @param health int health
     * @param dependency int dependency
     */
    public GhoulFactory(String name, int health, int dependency) {
        this.name = name;
        this.health = health;
        this.dependency = dependency;
    }

    /**
     * GhoulFactory createMinion method
     * @return Ghoul
     */
    @Override
    public Minion createMinion() {
        return new Ghoul(name, health, dependency);
    }

}
