package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;

/**
 * AdminMenu class extends Command
 */
public class AdminMenu extends Command {

    /**
     * AdminMenu class builder extends Command
     * @param arena Arena arena
     * @param data Data data
     */
    public AdminMenu(Arena arena, Data data) {
        super(arena, data);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {

    }

}
