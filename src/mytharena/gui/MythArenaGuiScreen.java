package mytharena.gui;

import javax.swing.*;

/**
 * MythArenaGuiScreen class extends JFrame
 */
public class MythArenaGuiScreen extends JFrame {

    /**
     * MythArenaGui mythArenaGui
     */
    private final MythArenaGui mythArenaGui;
    /**
     * JPanel messagePanel
     */
    private JPanel messagePanel;
    /**
     * JPanel loginPanel
     */
    private JPanel loginPanel;
    /**
     * JPanel registerPanel
     */
    private JPanel registerPanel;
    /**
     * JPanel buttonPanel
     */
    private JPanel buttonPanel;
    /**
     * JPanel listPanel
     */
    private JPanel listPanel;

    /**
     * MythArenaGuiScreen class constructor
     */
    public MythArenaGuiScreen(MythArenaGui mythArenaGui) {
        this.initComponents();
        this.mythArenaGui = mythArenaGui;
        this.showMessagePanel();
    }

    /**
     * Inits MythArenaGuiScreen components
     */
    private void initComponents() {
        this.messagePanel = new JPanel();
        this.loginPanel = new JPanel();
        this.registerPanel = new JPanel();
        this.buttonPanel = new JPanel();
        this.listPanel = new JPanel();
    }

    /**
     * Shows JPanel messagePanel
     */
    public void showMessagePanel() {
        this.messagePanel.setVisible(true);
        this.loginPanel.setVisible(false);
        this.registerPanel.setVisible(false);
        this.buttonPanel.setVisible(false);
        this.listPanel.setVisible(false);
    }

    /**
     * Shows JPanel loginPanel
     */
    public void showLoginPanel() {
        this.messagePanel.setVisible(false);
        this.loginPanel.setVisible(true);
        this.registerPanel.setVisible(false);
        this.buttonPanel.setVisible(false);
        this.listPanel.setVisible(false);
    }

    /**
     * Shows JPanel registerPanel
     */
    public void showRegisterPanel() {
        this.messagePanel.setVisible(false);
        this.loginPanel.setVisible(false);
        this.registerPanel.setVisible(true);
        this.buttonPanel.setVisible(false);
        this.listPanel.setVisible(false);
    }

    /**
     * Shows JPanel buttonPanel
     */
    public void showButtonPanel() {
        this.messagePanel.setVisible(false);
        this.loginPanel.setVisible(false);
        this.registerPanel.setVisible(false);
        this.buttonPanel.setVisible(true);
        this.listPanel.setVisible(false);
    }

    /**
     * Shows JPanel listPanel
     */
    public void showListPanel() {
        this.messagePanel.setVisible(false);
        this.loginPanel.setVisible(false);
        this.registerPanel.setVisible(false);
        this.buttonPanel.setVisible(false);
        this.listPanel.setVisible(true);
    }

}
