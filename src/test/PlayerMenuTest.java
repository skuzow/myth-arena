package test;

import mytharena.Arena;
import mytharena.command.PlayerMenu;
import mytharena.data.Data;
import mytharena.data.character.Marketable;
import mytharena.data.character.ability.Discipline;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.vampire.Vampire;
import mytharena.data.character.factory.character.vampire.VampireFactory;
import mytharena.data.character.factory.character.werewolf.WerewolfFactory;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.demon.Demon;
import mytharena.data.character.factory.minion.demon.DemonFactory;
import mytharena.data.character.factory.minion.ghoul.Ghoul;
import mytharena.data.character.factory.minion.human.Human;
import mytharena.data.character.inventory.equipment.Armor;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.market.Offer;
import mytharena.data.user.Player;
import mytharena.gui.MythArenaGui;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static junit.framework.TestCase.*;

public class PlayerMenuTest {

    @Test
    public void testCreateCharacter() {
        VampireFactory vampireFactory = new VampireFactory(new Data());
        Character vampire = vampireFactory.createCharacter();
        assertTrue(vampire instanceof Vampire);
        assertTrue(vampire.getAbility() instanceof Discipline);
        assertEquals(vampire.getWeaknessArrayList().get(0).getName(), "Luz solar");
        assertEquals(((Vampire) vampire).getBloodPoints(), 0);
        assertEquals(3, vampire.getInventory().getWeaponArrayList().size());
        assertEquals(3, vampire.getInventory().getArmorArrayList().size());
        assertNotNull(vampire.getEquippedWeaponArrayList());
        assertNotNull(vampire.getArmor());
    }

    @Test
    public void testGetGold() {
        WerewolfFactory werewolfFactory = new WerewolfFactory(new Data());
        Character werewolf = werewolfFactory.createCharacter();
        assertEquals(100, werewolf.getGold());
    }

    @Test
    public void testCreateMinion() {
        DemonFactory demonFactory = new DemonFactory();
        Demon demon = (Demon) demonFactory.createMinion();
        assertTrue(demon.getHealth() < 4);
        assertTrue(demon.getMinionArrayList().size() < 4);
    }

    @Test
    public void testNotifyPlayer() {
        Player player = new Player("gledrian","gledrian",new Data(),"gledrian");
        assertEquals(0,player.getNotificationArrayList().size());
        player.notifyPlayer();
        player.notifyPlayer();
        player.notifyPlayer();
        assertEquals(3, player.getNotificationArrayList().size());
    }

    @Test
    public void testTransferItems() {
        Arena arena = new Arena();
        Data data = new Data();
        MythArenaGui mythArenaGui = new MythArenaGui();

        data.getArmorPool().add(new Armor("Platemail", 0, 2,"Normal"));
        data.getWeaponPool().add(new Weapon("Rapier", 3, 0, false, "Normal"));

        PlayerMenu playerMenu = new PlayerMenu(arena, data, mythArenaGui);
        Player player1 = new Player("gledrian","gledrian",data, "gledrian");
        VampireFactory vampireFactory = new VampireFactory(data);
        Character vampire = vampireFactory.createCharacter();
        player1.setCharacter(vampire);

        Player player2 = new Player("alejandro", "alejandro",data, "alejandro");
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

        assertEquals(player2.getCharacter().getInventory().getWeaponArrayList().size(),6);
        assertNotNull(offer.getBuyer());
    }

    @Test
    public void testDisplayMinionPack() {
        Arena arena = new Arena();
        Data data = new Data();
        MythArenaGui mythArenaGui = new MythArenaGui();
        PlayerMenu playerMenu = new PlayerMenu(arena,data,mythArenaGui);

        ArrayList<Minion> minionArrayList = new ArrayList<>();
        ArrayList<Minion> total = new ArrayList<>();
        minionArrayList.add(new Human());
        minionArrayList.add(new Ghoul());
        minionArrayList.add(new Ghoul());
        playerMenu.displayMinionPack(minionArrayList,total);
        assertEquals(3, total.size());
    }

    @Test
    public void testCheckCompatability() {
        Arena arena = new Arena();
        Data data = new Data();
        MythArenaGui mythArenaGui = new MythArenaGui();
        PlayerMenu playerMenu = new PlayerMenu(arena, data, mythArenaGui);

        data.getArmorPool().add(new Armor("Cuirass", 0, 3,"Legendary"));
        data.getWeaponPool().add(new Weapon("Rapier", 3, 0, false, "Normal"));

        Player player1 = new Player("gledrian","gledrian",data, "gledrian");
        VampireFactory vampireFactory = new VampireFactory(data);
        Character vampire = vampireFactory.createCharacter();
        player1.setCharacter(vampire);

        Player player2 = new Player("alejandro", "alejandro",data, "alejandro");
        WerewolfFactory werewolfFactory = new WerewolfFactory(data);
        Character werewolf = werewolfFactory.createCharacter();
        player2.setCharacter(werewolf);

        ArrayList<Equipment> weapons = new ArrayList<>(player1.getCharacter().getInventory().getWeaponArrayList());
        ArrayList<Marketable> marketables = new ArrayList<>(weapons);
        ArrayList<ArrayList<Marketable>> itemList = new ArrayList<>();
        itemList.add(marketables);

        Offer offer = new Offer(player1,20,itemList);
        assertFalse(playerMenu.checkCompatibility(offer,player2));
        Map typeSub = (Map) player2.getMarketSubscriptions().get("Type");
        typeSub.put("Weapon", true);
        assertTrue(playerMenu.checkCompatibility(offer,player2));
    }

}
