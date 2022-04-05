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
     * Data data
     */
    private final Data data;

    /**
     * Command abstract class builder
     * @param arena Arena arena
     * @param data Data data
     */
    public Command(Arena arena, Data data) {
        this.arena = arena;
        this.data = data;
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
        return this.arena;
    }

    /**
     * Gets Data data
     * @return Data data
     */
    public Data getData() {
        return this.data;
    }

}
