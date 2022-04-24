package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.data.character.inventory.equipment.Equipment;
import mytharena.data.combat.PendingCombat;
import mytharena.data.user.Player;
import mytharena.data.user.User;
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
    private boolean userLoggedOut;
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
        while (getArena().getActiveUser() != null) {
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
            getMythArenaGui().setOption(8,null);
            getMythArenaGui().setOption(9, null);

            switch (super.getMythArenaGui().waitEvent(30)) {
                case 'A' -> getGold();
                case 'B' -> challengeUser();
                case 'C' -> createCharacter();
                case 'D' -> deleteCharacter();
                case 'E' -> selectEquipment();
                case 'F' -> viewNotifications();
                case 'G' -> viewRanking();
                case 'H' -> getArena().setActiveUser(null);
            }
        }
    }

    public void getGold() {
        if (player.getCharacter() == null) {
            super.getMythArenaGui().setDescription("No character found");
        }else {
            getMythArenaGui().setMessageMode();
            super.getMythArenaGui().setDescription(Integer.toString(player.getCharacter().getGold()) + " gold \n Gold lost in battle: 2M \n Gold won in battle: 1M");
            getMythArenaGui().waitEvent(30);

        }
    }

    public void viewNotifications() {

    }

    public void viewRanking() {

    }

    public void deleteCharacter() {
        if (player.getCharacter() != null) {
            getMythArenaGui().setMessageMode();
            getMythArenaGui().setTitle(null);
            getMythArenaGui().setDescription("Are you sure you want to delete your character?");
            getMythArenaGui().setOption(0, "No, I love my character :)");
            getMythArenaGui().setOption(1, "Yes, I'm sure :(");
            if (getMythArenaGui().waitEvent(30) == 'B') {
                player.setCharacter(null);
                getMythArenaGui().setDescription("Character has been deleted");
            }
        }else {
            getMythArenaGui().setDescription("What character?");
        }
    }

    public void createCharacter() {
        super.getArena().getCommand("CharacterCreationMenu").execute();
    }

    public void challengeUser() {
        if (player.getCharacter() != null) {
            getMythArenaGui().setListMode();
            getMythArenaGui().setOption(0, null);
            getMythArenaGui().setOption(1, null);
            getMythArenaGui().setOption(2, "Cancel");
            getMythArenaGui().setOption(3, "Next");
            ArrayList<String> listOptions = new ArrayList<>();
            for (User user : getData().getUserArrayList()) {
                if (user instanceof Player) {
                    listOptions.add(user.getUsername());
                }
            }
            getMythArenaGui().setList(listOptions);
            if (getMythArenaGui().waitEvent(30) == 'D') {
                User challengedPlayer = getData().getUserArrayList().get(getMythArenaGui().getLastSelectedListIndex() + 1);
                if (challengedPlayer instanceof Player) {
                    if (challengedPlayer != player) {
                        PendingCombat pendingCombat = new PendingCombat(player, (Player) challengedPlayer);
                        getData().getPendingCombatArrayList().add(pendingCombat);
                        getMythArenaGui().setDescription("Your challenge request has been sent!");
                        getMythArenaGui().waitEvent(3);
                    } else {
                        getMythArenaGui().setDescription("You can't challenge yourself");
                    }
                }
            }
        }else {
            getMythArenaGui().setDescription("No character found");
        }
    }

    public void selectEquipment() {
        if (player.getCharacter() != null) {
            getMythArenaGui().setListMode();
            getMythArenaGui().setOption(0, null);
            getMythArenaGui().setOption(1, null);
            getMythArenaGui().setOption(2, "Cancel");
            getMythArenaGui().setOption(3, "Next");
            ArrayList<String> listWeapons = new ArrayList<>();
            for (Equipment weapon : player.getCharacter().getInventory().getWeaponArrayList()) {
                listWeapons.add(weapon.getName());
            }
            getMythArenaGui().setList(listWeapons);
            if (getMythArenaGui().waitEvent(30) == 'D') {
                getMythArenaGui().setListMode();
                ArrayList<String> listArmor = new ArrayList<>();
                for (Equipment armor : player.getCharacter().getInventory().getWeaponArrayList()) {
                    listArmor.add(armor.getName());
                }
                getMythArenaGui().setList(listArmor);
                getMythArenaGui().waitEvent(30);
            }
        }else {
            getMythArenaGui().setDescription("No character found");
        }

    }

}
