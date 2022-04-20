package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.character.factory.Controller;
import mytharena.data.character.factory.ability.Ability;
import mytharena.data.character.factory.ability.AbilityAbstractFactory;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.MinionAbstractFactory;
import mytharena.data.user.Player;
import mytharena.gui.MythArenaGui;

import java.util.ArrayList;

/**
 * PlayerMenu class extends Command
 */
public class PlayerMenu extends Command {

    /**
     * Player player
     */
    private Player player;
    /**
     * boolean hasLoggedOut
     */
    private boolean userLoggedOut = false;
    /**
     * PlayerMenu class constructor extends Command
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public PlayerMenu(Arena arena, Data data, MythArenaGui mythArenaGui) {
        super(arena, data, mythArenaGui);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {
        player = (Player) super.getArena().getActiveUser();
        while (!userLoggedOut) {
            super.getMythArenaGui().setButtonMode();
            super.getMythArenaGui().setTitle("Welcome to Myth Arena " + player.getUsername());
            super.getMythArenaGui().setOption(0, "Check gold");
            super.getMythArenaGui().setOption(1, "Challenge user");
            super.getMythArenaGui().setOption(2, "Create character");
            super.getMythArenaGui().setOption(3, "Delete character");
            super.getMythArenaGui().setOption(4, "Select equipment");
            super.getMythArenaGui().setOption(5, "View notifications");
            super.getMythArenaGui().setOption(6, "View ranking");
            super.getMythArenaGui().setOption(7, "Log out");

            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> getGold();
                case 'H' -> logout();
            }
        }
    }

    public void getGold() {
        super.getMythArenaGui().setDescription(Integer.toString(player.getCharacter().getGold()) + " gold");
    }

    public void logout() {
        userLoggedOut = true;
    }

    public void deleteCharacter() {
        // Player should confirm deletion of character
        player.setCharacter(null);
    }
}
