package mytharena.data.user;

import mytharena.data.Data;

import java.io.Serializable;
import java.util.Random;

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
     * String registerNumber
     */
    private final String registerNumber;

    /**
     * User abstract class constructor
     * @param username String username
     * @param password String password
     * @param data Data data
     */
    public User(String username, String password, Data data) {
        this.username = username;
        this.password = password;
        // registerNumber generator
        StringBuilder generatedNumber = new StringBuilder();
        Random rand = new Random();
        boolean unique = false;
        while (!unique) {
            // random letter between A & Z
            generatedNumber.append((char) (rand.nextInt(26) + 'A'));
            // random number between 0 & 9
            generatedNumber.append(rand.nextInt(9 + 1));
            generatedNumber.append(rand.nextInt(9 + 1));
            generatedNumber.append((char) (rand.nextInt(26) + 'A'));
            generatedNumber.append((char) (rand.nextInt(26) + 'A'));
            // checks if it's unique
            unique = true;
            for (User user : data.getUserArrayList()) {
                if (generatedNumber.toString().equals(user.getRegisterNumber())) {
                    unique = false;
                    generatedNumber = new StringBuilder();
                }
            }
        }
        this.registerNumber = generatedNumber.toString();
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
     * Gets String registerNumber
     * @return String registerNumber
     */
    public String getRegisterNumber() {
        return this.registerNumber;
    }

}
