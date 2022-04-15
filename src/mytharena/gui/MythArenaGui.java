package mytharena.gui;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * MythArenaGui final class
 */
public final class MythArenaGui {

    /**
     * MythArenaGuiScreen mythArenaGuiScreen
     */
    private MythArenaGuiScreen mythArenaGuiScreen;
    /**
     * Queue Character buffer
     */
    private Queue<Character> buffer = new LinkedList();

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
     * Sets specified option message
     * @param number int number
     * @param message String message
     */
    public void setOption(int number, String message) {
        if (number <= 9 && number >= 0) {
            this.mythArenaGuiScreen.setOption(number, message);
        } else {
            throw new RuntimeException("Option number " + number + " ( " + message + " ) " + "out of range");
        }
    }

    /**
     * Waits until input event, if int seconds pass it passes
     * @param seconds int seconds
     * @return string option, or '\u0000' if time passes
     */
    public synchronized char waitEvent(int seconds) {
        if (this.buffer.size() > 0) {
            return this.buffer.poll();
        } else {
            try {
                this.wait(seconds * 1000L);
            } catch (InterruptedException ignored) {
            }
            return this.buffer.size() > 0 ? this.buffer.poll() : '\u0000';
        }
    }

    /**
     * Inserts char into Queue Character buffer
     * @param c char c
     */
    synchronized void insertChar(char c) {
        this.buffer.add(c);
        this.notify();
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
