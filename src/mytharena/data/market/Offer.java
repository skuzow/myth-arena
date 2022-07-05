package mytharena.data.market;

import mytharena.data.character.Marketable;
import mytharena.data.user.Player;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Offer class implements Serializable
 */
public class Offer implements Serializable {

    /**
     * Player buyer
     */
    private Player buyer;
    /**
     * Player seller
     */
    private final Player seller;
    /**
     * int Price
     */
    private final int price;
    /**
     * ArrayList ArrayList Marketable itemList
     */
    private final ArrayList<ArrayList<Marketable>> itemList;

    /**
     * Offer class constructor
     * @param seller Player seller
     * @param price int Price
     * @param itemList ArrayList ArrayList Marketable itemList
     */
    public Offer(Player seller, int price, ArrayList<ArrayList<Marketable>> itemList) {
        this.seller = seller;
        this.price = price;
        this.itemList = itemList;
    }

    /**
     * Sets Player buyer
     * @param buyer Player buyer
     */
    public void setBuyer(Player buyer) {
        this.buyer = buyer;
    }

    /**
     * Gets Player buyer
     * @return Player buyer
     */
    public Player getBuyer() {
        return this.buyer;
    }

    /**
     * Gets Player seller
     * @return Player seller
     */
    public Player getSeller() {
        return this.seller;
    }

    /**
     * Gets int price
     * @return int price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Gets ArrayList ArrayList Marketable itemList
     * @return ArrayList ArrayList Marketable itemList
     */
    public ArrayList<ArrayList<Marketable>> getItemList() {
        return this.itemList;
    }

}
