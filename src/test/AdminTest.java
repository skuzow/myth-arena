package test;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.character.Marketable;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.werewolf.WerewolfFactory;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.market.Offer;
import mytharena.data.user.Player;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class AdminTest {

    @Test
    public void testValidateOffer() {
        Arena arena = new Arena();
        arena.start(false);
        Data data = arena.getData();

        Player player = new Player("alejandro", "alejandro", data, "alejandro");
        WerewolfFactory werewolfFactory = new WerewolfFactory(data);
        Character werewolf = werewolfFactory.createCharacter();
        player.setCharacter(werewolf);

        ArrayList<Equipment> weapons = player.getCharacter().getInventory().getWeaponArrayList();
        ArrayList<Marketable> weaponPack = new ArrayList<>(weapons);
        ArrayList<Equipment> weaponList = new ArrayList<>();

        ArrayList<Marketable> armorPack = new ArrayList<>();
        ArrayList<Marketable> minionPack = new ArrayList<>();

        ArrayList<Equipment> armorList = new ArrayList<>();
        ArrayList<Minion> minionList = new ArrayList<>();

        assertEquals(3, player.getCharacter().getInventory().getWeaponArrayList().size());
        Offer offer = arena.createMarketOffer(player, 20,
                armorPack, weaponPack, minionPack, armorList, weaponList, minionList);
        assertNull(offer.getBuyer());

        arena.transferMarketOfferItems(offer, player);

        assertFalse(data.getPendingMarketOffers().contains(offer));
        assertEquals(player.getCharacter().getInventory().getWeaponArrayList().size(), 3);
    }

}
