package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;

/**
 * Start class extends Command
 */
public class Start extends Command {

    /**
     * Start abstract class builder
     * @param arena Arena arena
     * @param data Data data
     */
    public Start(Arena arena, Data data) {
        super(arena, data);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {

    }

}
