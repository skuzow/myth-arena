package mytharena.data.user;

import mytharena.data.Data;
import mytharena.data.character.factory.character.Character;
import mytharena.data.notification.Notification;
import org.json.simple.JSONObject;

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
     * boolean combatNotification subscriber
     */
    private boolean subscriber;
    /**
     * int goldWonInBattle
     */
    private int goldWonInBattle;
    /**
     * int goldLostInBattle
     */
    private int goldLostInBattle;
    /**
     * Character character
     */
    private Character character;
    /**
     * ArrayList Notification notificationArrayList
     */
    private final ArrayList<Notification> notificationArrayList = new ArrayList<>();
    /**
     * JSONObject marketSubscriptions
     */
    private final JSONObject marketSubscriptions;

    /**
     * Player class constructor extends User
     * @param username String username
     * @param password String password
     * @param data Data data
     */
    public Player(String username, String password, Data data, String nickname) {
        super(username, password, data);
        this.nickname = nickname;
        this.goldLostInBattle = 0;
        this.goldWonInBattle = 0;
        // marketSubscriptions init with default values
        this.marketSubscriptions = data.getDefaultMarketSubscriptions();
    }

    /**
     * Sets Character character
     * @param character Character character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * Sets boolean subscriber
     * @param subscriber boolean subscriber
     */
    public void setSubscriber(boolean subscriber) {
        this.subscriber = subscriber;
    }

    /**
     * Sets int goldWonInBattle
     * @param goldWonInBattle int goldWonInBattle
     */
    public void setGoldWonInBattle(int goldWonInBattle) {
        this.goldWonInBattle = goldWonInBattle;
    }

    /**
     * Sets int goldLostInBattle
     * @param goldLostInBattle int goldLostInBattle
     */
    public void setGoldLostInBattle(int goldLostInBattle) {
        this.goldLostInBattle = goldLostInBattle;
    }

    /**
     * Gets boolean subscriber
     * @return boolean subscriber
     */
    public boolean isSubscriber() {
        return this.subscriber;
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
     * Gets int goldWonInBattle
     * @return int goldWonInBattle
     */
    public int getGoldWonInBattle() {
        return this.goldWonInBattle;
    }

    /**
     * Gets int goldLostInBattle
     * @return int goldLostInBattle
     */
    public int getGoldLostInBattle() {
        return this.goldLostInBattle;
    }

    /**
     * Gets ArrayList Notification notificationArrayList
     * @return ArrayList Notification notificationArrayList
     */
    public ArrayList<Notification> getNotificationArrayList() {
        return this.notificationArrayList;
    }

    /**
     * Gets JSONObject marketSubscriptions
     * @return JSONObject marketSubscriptions
     */
    public JSONObject getMarketSubscriptions(String subscription) {
        return this.marketSubscriptions;
    }

}
