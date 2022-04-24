package mytharena.data.notification;

import java.io.Serializable;

/**
 * Notification abstract class implements Serializable
 */
public abstract class Notification implements Serializable {

    /**
     * String title
     */
    private final String title;
    /**
     * String body
     */
    private final String body;

    /**
     * Notification abstract class constructor
     * @param title String title
     * @param body String body
     */
    public Notification(String title, String body) {
        this.title = title;
        this.body = body;
    }

    /**
     * Gets String title
     * @return String title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets String body
     * @return String body
     */
    public String getBody() {
        return this.body;
    }

}
