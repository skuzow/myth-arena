package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.gui.MythArenaGui;

/**
 * AdminMenu class extends Command
 */
public class AdminMenu extends Command {

    /**
     * AdminMenu abstract class builder
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public AdminMenu(Arena arena, Data data, MythArenaGui mythArenaGui) {
        super(arena, data, mythArenaGui);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {

    }

}
