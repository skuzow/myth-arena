package mytharena.commands;

import mytharena.Arena;
import mytharena.Command;
import mytharena.Data;

import java.io.Serializable;

/**
 * Combat class extends Command implements Serializable
 */
public class Combat extends Command implements Serializable {

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
