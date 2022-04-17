package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.gui.MythArenaGui;

/**
 * Start class extends Command
 */
public class Start extends Command {

    /**
     * Start class constructor extends Command
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public Start(Arena arena, Data data, MythArenaGui mythArenaGui) {
        super(arena, data, mythArenaGui);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {

    }

}
