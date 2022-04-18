package mytharena.data.notification;

import java.io.Serializable;

/**
 * GeneralNotification class extends Notification implements Serializable
 */
public class GeneralNotification extends Notification implements Serializable {

    /**
     * Notification abstract class constructor
     * @param title String title
     * @param body  String body
     */
    public GeneralNotification(String title, String body) {
        super(title, body);
    }
}
