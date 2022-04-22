package mytharena.gui;

import java.util.ArrayList;
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
            this.mythArenaGuiScreen.setVisible(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets title
     * @param title String title
     */
    public void setTitle(String title) {
        this.mythArenaGuiScreen.setTitleMessage(title);
    }

    /**
     * Sets description
     * @param description String description
     */
    public void setDescription(String description) {
        this.mythArenaGuiScreen.setDescriptionMessage(description);
    }

    /**
     * Sets image
     * @param number int number
     * @param imagePath String imagePath
     */
    public void setImage(int number, String imagePath) {
        if (number <= 6 && number >= 0) {
            this.mythArenaGuiScreen.setImage(number, imagePath);
        } else {
            throw new RuntimeException("Mode number " + number + " out of range");
        }
    }

    /**
     * Sets specified field message
     * @param number int number
     * @param message String message
     */
    public void setField(int number, String message) {
        if (number <= 2 && number >= 0) {
            this.mythArenaGuiScreen.setField(number, message);
        } else {
            throw new RuntimeException("Field number " + number + " ( " + message + " ) out of range");
        }
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
            throw new RuntimeException("Option number " + number + " ( " + message + " ) out of range");
        }
    }

    /**
     * Sets ArrayList String list
     * @param list ArrayList String list
     */
    public void setList(ArrayList<String> list) {
        this.mythArenaGuiScreen.setList(list);
    }

    /**
     * Sets specified combat info
     * @param number int number
     * @param message String message
     */
    public void setCombatInfo(int number, String message) {
        if (number <= 2 && number >= 0) {
            this.mythArenaGuiScreen.setCombatInfo(number, message);
        } else {
            throw new RuntimeException("CombatInfo number " + number + " ( " + message + " ) out of range");
        }
    }

    /**
     * Gets specified field text
     * @param number int number
     * @return String fieldText
     */
    public String getFieldText(int number) {
        if (number <= 2 && number >= 0) {
            return this.mythArenaGuiScreen.getFieldText(number);
        } else {
            throw new RuntimeException("Field Text number " + number + " out of range");
        }
    }

    /**
     * Clear specified field text
     * @param number int number
     */
    public void clearFieldText(int number) {
        if (number <= 2 && number >= 0) {
            this.mythArenaGuiScreen.clearFieldText(number);
        } else {
            throw new RuntimeException("Field Text number " + number + " out of range");
        }
    }

    /**
     * Gets last selected list index
     * @return int index
     */
    public int getLastSelectedListIndex() {
        return this.mythArenaGuiScreen.getLastSelectedListIndex();
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
     * Sets FormMode
     */
    public void setFormMode() {
        this.mythArenaGuiScreen.showFormPanel();
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

    /**
     * Sets CombatMode
     */
    public void setCombatMode() {
        this.mythArenaGuiScreen.showCombatPanel();
    }

}
