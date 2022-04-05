package mytharena;

/**
 * Command abstract class
 */
public abstract class Command {

    /**
     * Arena arena
     */
    private final Arena arena;

    /**
     * Command abstract class builder
     * @param arena Arena arena
     */
    public Command(Arena arena) {
        this.arena = arena;
    }

    /**
     * Executes respective command
     */
    public abstract void execute();

    /**
     * Gets Arena arena
     * @return Arena arena
     */
    public Arena getArena() {
        return arena;
    }

}
