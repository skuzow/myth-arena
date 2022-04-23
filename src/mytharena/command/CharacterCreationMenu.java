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
import mytharena.data.user.Player;
import mytharena.gui.MythArenaGui;

import java.util.ArrayList;
import java.util.Random;

/**
 * CharacterCreationMenu class
 */
public class CharacterCreationMenu extends Command{

    private final Player player;
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
                character = characterFactory.createCharacter(new HunterFactory());
            }
            case 'B' -> {
                character = characterFactory.createCharacter(new VampireFactory());
            }
            case 'C' -> {
                character = characterFactory.createCharacter(new WerewolfFactory());
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

         double roll = Math.random();
         int minionsCount;
         if (roll < 0.1) {
            minionsCount = 3;
         }else if(roll < 0.25) {
             minionsCount = 2;
         }else if(roll < 0.45) {
             minionsCount = 1;
         }else {
             minionsCount = 0;
         }
        ArrayList<Minion> minionArrayList = new ArrayList<>();

        for (int i = 0; i < minionsCount; i++) {
               if (character instanceof Vampire) {
                    if (Math.random() < 0.5) {
                        Minion minion = new Demon();
                        minionArrayList.add(minion);
                   } else {
                        Minion minion = new Ghoul();
                        minionArrayList.add(minion);
                    }
               }else {
                   double randomMinion = Math.random();
                   if (randomMinion < 0.33) {
                       Minion minion = new Demon();
                       minionArrayList.add(minion);
                   } else if (randomMinion < 0.66) {
                       Minion minion = new Ghoul();
                       minionArrayList.add(minion);
                   }else {
                       Minion minion = new Human();
                       minionArrayList.add(minion);
                   }
               }
        }

        character.setMinionArrayList(minionArrayList);
        player.setCharacter(character);
        super.getMythArenaGui().setDescription("Character has been created");
        super.getMythArenaGui().waitEvent(3);
    }




}
