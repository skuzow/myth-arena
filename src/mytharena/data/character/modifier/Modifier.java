package mytharena.data.character.modifier;

import java.io.Serializable;

/**
 * Modifier class implements Serializable
 */
public class Modifier implements Serializable {

    /**
     * String name
     */
    private final String name;

    /**
     * int sensibility
     */
    private final int sensibility;

    /**
     * Modifier class constructor
     * @param name String name
     * @param sensibility int sensibility
     */
    public Modifier(String name, int sensibility) {
        this.name = name;
        this.sensibility = sensibility;
    }

    /**
     * Gets String name
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets int sensibility
     * @return int sensibility
     */
    public int getSensibility() {
        return this.sensibility;
    }

}
