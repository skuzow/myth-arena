package mytharena.data;

import mytharena.data.character.inventory.equipment.Armor;
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.combat.Combat;
import mytharena.data.combat.PendingCombat;
import mytharena.data.market.Offer;
import mytharena.data.user.Player;
import mytharena.data.user.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Data class implements Serializable
 */
public class Data implements Serializable {

    /**
     * ArrayList User userArrayList
     */
    private final ArrayList<User> userArrayList = new ArrayList<>();
    /**
     * HashMap Player Date bannedPlayerMap
     */
    private final HashMap<Player, Date> bannedPlayerMap = new HashMap<>();
    /**
     * ArrayList Combat combatArrayList
     */
    private final ArrayList<Combat> combatArrayList = new ArrayList<>();
    /**
     * ArrayList PendingCombat pendingCombatArrayList
     */
    private final ArrayList<PendingCombat> pendingCombatArrayList = new ArrayList<>();
    /**
     * ArrayList Weapon weaponPool
     */
    private final ArrayList<Weapon> weaponPool = new ArrayList<>();
    /**
     * ArrayList Armor armorPool
     */
    private final ArrayList<Armor> armorPool = new ArrayList<>();
    /**
     * ArrayList Offer marketOffers
     */
    private final ArrayList<Offer> marketOffers = new ArrayList<>();
    /**
     * ArrayList Offer purchasedOffers
     */
    private final ArrayList<Offer> purchasedOffers = new ArrayList<>();
    /**
     * JSONObject defaultMarketSubscriptions
     */
    private JSONObject defaultMarketSubscriptions;

    /**
     * Data class constructor
     */
    public Data() {
        // init JSONObject defaultMarketSubscriptions
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("./src/resources/market/subscriptions.json")) {
            this.defaultMarketSubscriptions = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets ArrayList User userArrayList
     * @return ArrayList User userArrayList
     */
    public ArrayList<User> getUserArrayList() {
        return this.userArrayList;
    }

    /**
     * Gets HashMap Player Date bannedPlayerMap
     * @return HashMap Player Date bannedPlayerMap
     */
    public HashMap<Player, Date> getBannedPlayerMap() {
        return this.bannedPlayerMap;
    }

    /**
     * Gets ArrayList Combat combatArrayList
     * @return ArrayList Combat combatArrayList
     */
    public ArrayList<Combat> getCombatArrayList() {
        return this.combatArrayList;
    }

    /**
     * Gets ArrayList PendingCombat pendingCombatArrayList
     * @return ArrayList PendingCombat pendingCombatArrayList
     */
    public ArrayList<PendingCombat> getPendingCombatArrayList() {
        return this.pendingCombatArrayList;
    }

    /**
     * Gets ArrayList Weapon weaponPool
     * @return ArrayList Weapon weaponPool
     */
    public ArrayList<Weapon> getWeaponPool() {
        return this.weaponPool;
    }

    /**
     * Gets ArrayList Armor armorPool
     * @return ArrayList Armor armorPool
     */
    public ArrayList<Armor> getArmorPool() {
        return this.armorPool;
    }

    /**
     * Gets ArrayList Offer marketOffers
     * @return ArrayList Offer marketOffers
     */
    public ArrayList<Offer> getMarketOffers() {
        return this.marketOffers;
    }

    /**
     * Gets ArrayList Offer purchasedOffers
     * @return ArrayList Offer purchasedOffers
     */
    public ArrayList<Offer> getPurchasedOffers() {
        return this.purchasedOffers;
    }

    /**
     * Gets JSONObject defaultMarketSubscriptions
     * @return JSONObject defaultMarketSubscriptions
     */
    public JSONObject getDefaultMarketSubscriptions() {
        return this.defaultMarketSubscriptions;
    }

}
