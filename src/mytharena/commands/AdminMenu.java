package mytharena.commands;

import mytharena.Arena;
import mytharena.Command;
import mytharena.Data;

/**
 * AdminMenu class extends Command
 */
public class AdminMenu extends Command {

    /**
     * AdminMenu abstract class builder
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
