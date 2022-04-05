package mytharena.commands;

import mytharena.Arena;
import mytharena.Command;
import mytharena.Data;

/**
 * UserMenu class extends Command
 */
public class UserMenu extends Command {

    /**
     * UserMenu abstract class builder
     * @param arena Arena arena
     * @param data Data data
     */
    public UserMenu(Arena arena, Data data) {
        super(arena, data);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {

    }

}
