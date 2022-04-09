package mytharena.data.user;

import mytharena.data.Data;

import java.io.Serializable;

/**
 * User abstract class implements Serializable
 */
public abstract class User implements Serializable {

    /**
     * String username
     */
    private final String username;

    /**
     * String password
     */
    private final String password;

    /**
     * int registerNumber
     */
    private final int registerNumber;

    /**
     * User abstract class builder
     * @param username String username
     * @param password String password
     * @param data Data data
     */
    public User(String username, String password, Data data) {
        this.username = username;
        this.password = password;
        this.registerNumber = data.getUserArrayList().size() + 1;
    }

    /**
     * Gets String username
     * @return String username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Gets String password
     * @return String password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Gets int registerNumber
     * @return int registerNumber
     */
    public int getRegisterNumber() {
        return this.registerNumber;
    }

}
