package mytharena.commands;

import mytharena.Arena;
import mytharena.Command;
import mytharena.Data;

public class Start extends Command {

    /**
     * Command abstract class builder
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
