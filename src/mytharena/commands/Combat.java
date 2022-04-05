package mytharena.commands;

import mytharena.Arena;
import mytharena.Command;
import mytharena.Data;

/**
 * Combat class extends Command
 */
public class Combat extends Command {

    /**
     * Combat abstract class builder
     * @param arena Arena arena
     * @param data Data data
     */
    public Combat(Arena arena, Data data) {
        super(arena, data);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {

    }

}
