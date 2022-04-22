package mytharena.command;

import mytharena.Arena;
import mytharena.data.Data;
import mytharena.gui.MythArenaGui;

/**
 * AdminMenu class extends Command
 */
public class AdminMenu extends Command {

    /**
     * AdminMenu class constructor extends Command
     * @param arena Arena arena
     * @param data Data data
     * @param mythArenaGui MythArenaGui mythArenaGui
     */
    public AdminMenu(Arena arena, Data data, MythArenaGui mythArenaGui) {
        super(arena, data, mythArenaGui);
    }

    /**
     * Executes respective command
     */
    @Override
    public void execute() {
        while (super.getArena().getActiveUser() != null) {
            super.getMythArenaGui().setButtonMode();
            super.getMythArenaGui().setTitle("Welcome to Myth Arena " + super.getArena().getActiveUser().getUsername());
            super.getMythArenaGui().setDescription("Admin Panel");
            super.getMythArenaGui().setOption(0, "Manage admins");
            super.getMythArenaGui().setOption(1, "Manage users");
            super.getMythArenaGui().setOption(2, "Manage characters");
            super.getMythArenaGui().setOption(3, "Validate combats");
            super.getMythArenaGui().setOption(4, null);
            super.getMythArenaGui().setOption(5, null);
            super.getMythArenaGui().setOption(6, null);
            super.getMythArenaGui().setOption(7, null);
            super.getMythArenaGui().setOption(8, "Log out");
            super.getMythArenaGui().setOption(9, null);
            switch (super.getMythArenaGui().waitEvent(30)) {
                // manage admins
                case 'A' -> {

                }
                // manage users
                case 'B' -> {

                }
                // manage characters
                case 'C' -> {

                }
                // validate combats
                case 'D' -> {

                }
                // log out
                case 'I' -> super.getArena().setActiveUser(null);
            }
        }
    }

}
