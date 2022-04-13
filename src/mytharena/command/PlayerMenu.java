package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;

/**
 * PlayerMenu class extends Command
 */
public class PlayerMenu extends Command {

    /**
     * PlayerMenu class constructor extends Command
     * @param arena Arena arena
     * @param data Data data
     */
    public PlayerMenu(Arena arena, Data data) {
        super(arena, data);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {

    }

}
