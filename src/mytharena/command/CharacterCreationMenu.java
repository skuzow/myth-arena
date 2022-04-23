package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.character.factory.character.CharacterFactory;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.hunter.HunterFactory;
import mytharena.data.character.factory.character.vampire.VampireFactory;
import mytharena.data.character.factory.character.werewolf.WerewolfFactory;
import mytharena.data.user.Player;
import mytharena.gui.MythArenaGui;

import java.util.Random;

/**
 * CharacterCreationMenu class
 */
public class CharacterCreationMenu extends Command{

    private Player player;
    private Character character;
    /**
     * CharacterCreationMenu Constructor extends Command
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public CharacterCreationMenu(Arena arena, Data data, MythArenaGui mythArenaGui) {
        super(arena,data,mythArenaGui);
        player = (Player) super.getArena().getActiveUser();
    }

    /**
     * Executes CharacterCreationMenu
     */
    @Override
    public void execute() {


        CharacterFactory characterFactory = new CharacterFactory();

        switch (super.getMythArenaGui().waitEvent(30)) {
            case 'A' -> {
                String name = super.getMythArenaGui().getFieldText(0);
                character = characterFactory.createCharacter(new HunterFactory(name));
            }
            case 'B' -> {
                String name = super.getMythArenaGui().getFieldText(0);
                character = characterFactory.createCharacter(new VampireFactory(name));
            }
            case 'C' -> {
                String name = super.getMythArenaGui().getFieldText(0);
                character = characterFactory.createCharacter(new WerewolfFactory(name));
            }
        }

        // Randomly gets 3 armor and 3 weapons
        while (character.getInventory().getWeaponArrayList().size() < 3) {
            Random rand = new Random();
            character.getInventory().getArmorArrayList().add(super.getData().getArmorPool().get(rand.nextInt(super.getData().getArmorPool().size())));
            character.getInventory().getWeaponArrayList().add(super.getData().getWeaponPool().get(rand.nextInt(super.getData().getWeaponPool().size())));
        }
        // By default, the first weapon/armor in inventory will be equipped
        character.setArmor(character.getInventory().getArmorArrayList().get(0));
        character.getEquippedWeaponArrayList().add(character.getInventory().getArmorArrayList().get(0));

        player.setCharacter(character);
    }




}
