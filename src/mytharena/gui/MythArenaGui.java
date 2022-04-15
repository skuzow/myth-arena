package mytharena.gui;

import javax.swing.*;

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
     * Sets Title
     */
    public void setTitle(String title) {
        this.mythArenaGuiScreen.setTitleMessage(title);
    }

    /**
     * Sets Description
     */
    public void setDescription(String description) {
        this.mythArenaGuiScreen.setDescriptionMessage(description);
    }

    /**
     * Sets Image
     */
    public void setImage(ImageIcon image) {
        this.mythArenaGuiScreen.setImage(image);
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
