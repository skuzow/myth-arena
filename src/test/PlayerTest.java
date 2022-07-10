package test;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.character.ability.Discipline;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.vampire.Vampire;
import mytharena.data.character.factory.character.vampire.VampireFactory;
import mytharena.data.character.factory.character.werewolf.WerewolfFactory;
import mytharena.data.character.factory.minion.demon.Demon;
import mytharena.data.character.factory.minion.demon.DemonFactory;
import mytharena.data.user.Player;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class PlayerTest {

    @Test
    public void testCreateCharacter() {
        Arena arena = new Arena();
        arena.start(false);
        Data data = arena.getData();

        VampireFactory vampireFactory = new VampireFactory(data);
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
        Player player = new Player("gledrian", "gledrian", new Data(), "gledrian");
        assertEquals(0, player.getNotificationArrayList().size());
        player.notifyPlayer();
        player.notifyPlayer();
        player.notifyPlayer();
        assertEquals(3, player.getNotificationArrayList().size());
    }

}
