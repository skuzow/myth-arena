package mytharena.data.user;

import mytharena.data.Data;

import java.io.Serializable;

/**
 * Admin class extends User implements Serializable
 */
public class Admin extends User implements Serializable {

    /**
     * Admin abstract class builder
     * @param username String username
     * @param password String password
     * @param data Data data
     */
    public Admin(String username, String password, Data data) {
        super(username, password, data);
    }
    
}
