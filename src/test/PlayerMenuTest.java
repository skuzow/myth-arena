package test;

import mytharena.data.Data;
import mytharena.data.character.ability.Discipline;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.vampire.Vampire;
import mytharena.data.character.factory.character.vampire.VampireFactory;
import mytharena.data.user.Player;
import org.junit.Test;

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
    }

    @Test
    public void testDeleteCharacter() {
        Player player = new Player("gled","gled",new Data(),"gled");
        VampireFactory vampireFactory = new VampireFactory(new Data());
        Character vampire = vampireFactory.createCharacter();
        player.setCharacter(vampire);
        assertNotNull(player.getCharacter());
        player.setCharacter(null);
        assertNull(player.getCharacter());
    }

}
