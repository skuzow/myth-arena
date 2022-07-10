package test;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.character.Marketable;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.vampire.VampireFactory;
import mytharena.data.character.factory.character.werewolf.WerewolfFactory;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.ghoul.Ghoul;
import mytharena.data.character.factory.minion.human.Human;
import mytharena.data.character.inventory.equipment.Armor;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.market.Offer;
import mytharena.data.user.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static junit.framework.TestCase.*;

public class ArenaTest {

    @Test
    public void testTransferItems() {
        Arena arena = new Arena();
        arena.start(false);
        Data data = arena.getData();

        Player player1 = new Player("gledrian", "gledrian", data, "gledrian");
        VampireFactory vampireFactory = new VampireFactory(data);
        Character vampire = vampireFactory.createCharacter();
        player1.setCharacter(vampire);

        Player player2 = new Player("alejandro", "alejandro", data, "alejandro");
        WerewolfFactory werewolfFactory = new WerewolfFactory(data);
        Character werewolf = werewolfFactory.createCharacter();
        player2.setCharacter(werewolf);

        ArrayList<Equipment> weapons = new ArrayList<>(player1.getCharacter().getInventory().getWeaponArrayList());
        ArrayList<Marketable> marketables = new ArrayList<>(weapons);
        ArrayList<ArrayList<Marketable>> itemList = new ArrayList<>();
        itemList.add(marketables);

        assertEquals(3, player2.getCharacter().getInventory().getWeaponArrayList().size());
        Offer offer = new Offer(player1,20,itemList);
        assertNull(offer.getBuyer());

        arena.transferMarketOfferItems(offer, player2);

        assertEquals(player2.getCharacter().getInventory().getWeaponArrayList().size(), 6);
        assertNotNull(offer.getBuyer());
    }

    @Test
    public void testCheckCompatability() {
        Arena arena = new Arena();
        arena.start(false);
        Data data = arena.getData();

        data.getArmorPool().add(new Armor("Cuirass", 0, 3,"Legendary"));
        data.getWeaponPool().add(new Weapon("Rapier", 3, 0, false, "Normal"));

        Player player1 = new Player("gledrian","gledrian", data, "gledrian");
        VampireFactory vampireFactory = new VampireFactory(data);
        Character vampire = vampireFactory.createCharacter();
        player1.setCharacter(vampire);

        Player player2 = new Player("alejandro", "alejandro", data, "alejandro");
        WerewolfFactory werewolfFactory = new WerewolfFactory(data);
        Character werewolf = werewolfFactory.createCharacter();
        player2.setCharacter(werewolf);

        ArrayList<Equipment> weapons = new ArrayList<>(player1.getCharacter().getInventory().getWeaponArrayList());
        ArrayList<Marketable> marketables = new ArrayList<>(weapons);
        ArrayList<ArrayList<Marketable>> itemList = new ArrayList<>();
        itemList.add(marketables);

        Offer offer = new Offer(player1,20,itemList);
        assertFalse(arena.checkCompatibility(offer,player2));
        Map typeSub = (Map) player2.getMarketSubscriptions().get("Type");
        typeSub.put("Weapon", true);
        assertTrue(arena.checkCompatibility(offer,player2));
    }

    @Test
    public void testDisplayMinionPack() {
        Arena arena = new Arena();

        ArrayList<Minion> minionArrayList = new ArrayList<>();
        ArrayList<Minion> total = new ArrayList<>();
        minionArrayList.add(new Human());
        minionArrayList.add(new Ghoul());
        minionArrayList.add(new Ghoul());
        arena.displayMinionPack(minionArrayList,total);
        assertEquals(3, total.size());
    }

}
