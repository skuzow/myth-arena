package mytharena.data.user;

import mytharena.data.Data;
import mytharena.data.character.factory.character.Character;
import mytharena.data.notification.Notification;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Player class extends User implements Serializable
 */
public class Player extends User implements Serializable {

    /**
     * String nickname
     */
    private final String nickname;
    /**
     * Character character
     */
    private Character character;
    /**
     * ArrayList Notification notificationArrayList
     */
    private final ArrayList<Notification> notificationArrayList = new ArrayList<>();

    /**
     * Player class constructor extends User
     * @param username String username
     * @param password String password
     * @param data Data data
     */
    public Player(String username, String password, Data data, String nickname) {
        super(username, password, data);
        this.nickname = nickname;
    }

    /**
     * Sets Character character
     * @param character Character character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * Gets String nickname
     * @return String nickname
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Gets Character character
     * @return Character character
     */
    public Character getCharacter() {
        return this.character;
    }

    /**
     * Gets ArrayList Notification notificationArrayList
     * @return ArrayList Notification notificationArrayList
     */
    public ArrayList<Notification> getNotificationArrayList() {
        return this.notificationArrayList;
    }

}
