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
        Player player = (Player) getArena().getActiveUser();
        getMythArenaGui().setListMode();
        getMythArenaGui().setOption(0,null);
        getMythArenaGui().setOption(1,null);
        getMythArenaGui().setOption(2,"Cancel");
        getMythArenaGui().setOption(3,"Next");
        getMythArenaGui().setTitle("Select the type of your new Character");
        ArrayList<String> characterTypes = new ArrayList<>();
        characterTypes.add("Hunter");
        characterTypes.add("Vampire");
        characterTypes.add("Werewolf");
        getMythArenaGui().setList(characterTypes);

        CharacterFactory characterFactory = new CharacterFactory();

        if (getMythArenaGui().waitEvent(30) == 'D') {
            switch (getMythArenaGui().getLastSelectedListIndex()) {
                case 0 -> player.setCharacter(characterFactory.createCharacter(new HunterFactory(getData())));
                case 1 -> player.setCharacter(characterFactory.createCharacter(new VampireFactory(getData())));
                case 2 -> player.setCharacter(characterFactory.createCharacter(new WerewolfFactory(getData())));
            }
            super.getMythArenaGui().setDescription("Character has been created");
            super.getMythArenaGui().waitEvent(1);
        }

    }




}
