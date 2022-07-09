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
import mytharena.data.character.factory.minion.demon.Demon;
import mytharena.data.character.factory.minion.demon.DemonFactory;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.market.Offer;
import mytharena.data.user.Player;
import mytharena.gui.MythArenaGui;
import org.junit.Test;

import java.util.ArrayList;

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
        PlayerMenu playerMenu = new PlayerMenu(arena, data, mythArenaGui);
        Player player1 = new Player("gledrian","gledrian",data, "gledrian");
        VampireFactory vampireFactory = new VampireFactory(new Data());
        Character vampire = vampireFactory.createCharacter();
        player1.setCharacter(vampire);

        Player player2 = new Player("alejandro", "alejandro",data, "alejandro");
        WerewolfFactory werewolfFactory = new WerewolfFactory(new Data());
        Character werewolf = werewolfFactory.createCharacter();
        player2.setCharacter(werewolf);

        ArrayList<ArrayList<Marketable>> itemList = new ArrayList<>((ArrayList<? extends Marketable>) player1.getCharacter().getInventory().getWeaponArrayList());
        Offer offer = new Offer(player1,20,itemList);
        playerMenu.transferItems(offer, player2);
    }

    @Test
    public void testDisplayMinionPack() {

    }

    @Test
    public void testCheckCompatability() {

    }
}
