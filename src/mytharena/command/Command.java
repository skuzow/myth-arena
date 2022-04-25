package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.gui.MythArenaGui;

/**
 * Command abstract class
 */
public abstract class Command {

    /**
     * Arena arena
     */
    private final Arena arena;
    /**
     * Data data
     */
    private final Data data;
    /**
     * MythArenaGui mythArenaGui
     */
    private final MythArenaGui mythArenaGui;

    /**
     * Command abstract class constructor
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public Command(Arena arena, Data data, MythArenaGui mythArenaGui) {
        this.arena = arena;
        this.data = data;
        this.mythArenaGui = mythArenaGui;
    }

    /**
     * Executes respective command
     */
    public abstract void execute();

    /**
     * Gets Arena arena
     * @return Arena arena
     */
    public Arena getArena() {
        return this.arena;
    }

    /**
     * Gets Data data
     * @return Data data
     */
    public Data getData() {
        return this.data;
    }

    /**
     * Gets MythArenaGui getMythArenaGui
     * @return MythArenaGui getMythArenaGui
     */
    public MythArenaGui getMythArenaGui() {
        return this.mythArenaGui;
    }

}
