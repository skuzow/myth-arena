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
     * MythArenaGui class constructor
     */
    public MythArenaGui() {
        try {
            this.mythArenaGuiScreen = new MythArenaGuiScreen(this);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets MessageMode
     */
    public void setMessageMode() {
        this.mythArenaGuiScreen.showMessagePanel();
    }

    /**
     * Sets LoginMode
     */
    public void setLoginMode() {
        this.mythArenaGuiScreen.showLoginPanel();
    }

    /**
     * Sets RegisterMode
     */
    public void setRegisterMode() {
        this.mythArenaGuiScreen.showRegisterPanel();
    }

    /**
     * Sets ButtonMode
     */
    public void setButtonMode() {
        this.mythArenaGuiScreen.showButtonPanel();
    }

    /**
     * Sets ListMode
     */
    public void setListMode() {
        this.mythArenaGuiScreen.showListPanel();
    }

}
