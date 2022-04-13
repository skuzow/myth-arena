package mytharena.gui;

/**
 * MythArenaGui final class
 */
public final class MythArenaGui {

    /**
     * MythArenaGuiScreen mythArenaGuiScreen
     */
    private MythArenaGuiScreen mythArenaGuiScreen;

    /**
     * MythArenaGui class builder
     */
    public MythArenaGui() {
        try {
            this.mythArenaGuiScreen = new MythArenaGuiScreen();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
