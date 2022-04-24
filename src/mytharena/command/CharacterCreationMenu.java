package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.character.factory.character.CharacterFactory;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.hunter.HunterFactory;
import mytharena.data.character.factory.character.vampire.Vampire;
import mytharena.data.character.factory.character.vampire.VampireFactory;
import mytharena.data.character.factory.character.werewolf.WerewolfFactory;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.demon.Demon;
import mytharena.data.character.factory.minion.ghoul.Ghoul;
import mytharena.data.character.factory.minion.human.Human;
import mytharena.data.character.inventory.Inventory;
import mytharena.data.character.inventory.equipment.Armor;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.user.Player;
import mytharena.gui.MythArenaGui;

import java.util.ArrayList;
import java.util.Random;

/**
 * CharacterCreationMenu class
 */
public class CharacterCreationMenu extends Command{

    private Character character;
    /**
     * CharacterCreationMenu Constructor extends Command
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public CharacterCreationMenu(Arena arena, Data data, MythArenaGui mythArenaGui) {
        super(arena,data,mythArenaGui);
    }

    /**
     * Executes CharacterCreationMenu
     */
    @Override
    public void execute() {
        Player player = (Player) super.getArena().getActiveUser();
        super.getMythArenaGui().setButtonMode();
        super.getMythArenaGui().setTitle("Character Creation");
        super.getMythArenaGui().setDescription("Select the type of your new character");
        super.getMythArenaGui().setOption(0,"Hunter");
        super.getMythArenaGui().setOption(1,"Vampire");
        super.getMythArenaGui().setOption(2,"Werewolf");
        super.getMythArenaGui().setOption(3,null);
        super.getMythArenaGui().setOption(4,null);
        super.getMythArenaGui().setOption(5,null);
        super.getMythArenaGui().setOption(6,null);
        super.getMythArenaGui().setOption(7,null);
        super.getMythArenaGui().setOption(8,null);
        super.getMythArenaGui().setOption(9,"Cancel");


        CharacterFactory characterFactory = new CharacterFactory();

        switch (super.getMythArenaGui().waitEvent(30)) {
            case 'A' -> {
                player.setCharacter(characterFactory.createCharacter(new HunterFactory(getData())));
            }
            case 'B' -> {
                player.setCharacter(characterFactory.createCharacter(new VampireFactory(getData())));
            }
            case 'C' -> {
                player.setCharacter(characterFactory.createCharacter(new WerewolfFactory(getData())));
            }
        }

        super.getMythArenaGui().setDescription("Character has been created");
        super.getMythArenaGui().waitEvent(1);
    }




}
