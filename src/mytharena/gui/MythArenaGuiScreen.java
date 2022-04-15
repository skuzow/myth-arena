package mytharena.gui;

import javax.swing.*;
import java.awt.*;

/**
 * MythArenaGuiScreen class extends JFrame
 */
public class MythArenaGuiScreen extends JFrame {

    /**
     * MythArenaGui mythArenaGui
     */
    private final MythArenaGui mythArenaGui;
    /**
     * String titleText
     */
    private String titleText;
    /**
     * String descriptionText
     */
    private String descriptionText;
    /**
     * String optionAButtonText
     */
    private String optionAButtonText;
    /**
     * String optionBButtonText
     */
    private String optionBButtonText;
    /**
     * String optionCButtonText
     */
    private String optionCButtonText;
    /**
     * String optionDButtonText
     */
    private String optionDButtonText;
    /**
     * String optionEButtonText
     */
    private String optionEButtonText;
    /**
     * String optionFButtonText
     */
    private String optionFButtonText;
    /**
     * String optionGButtonText
     */
    private String optionGButtonText;
    /**
     * String optionHButtonText
     */
    private String optionHButtonText;
    /**
     * String optionIButtonText
     */
    private String optionIButtonText;
    /**
     * String optionJButtonText
     */
    private String optionJButtonText;
    /**
     * String optionAMessageText
     */
    private String optionAMessageText;
    /**
     * String optionBMessageText
     */
    private String optionBMessageText;
    /**
     * String optionALoginText
     */
    private String optionALoginText;
    /**
     * String optionBLoginText
     */
    private String optionBLoginText;
    /**
     * String optionARegisterText
     */
    private String optionARegisterText;
    /**
     * String optionBRegisterText
     */
    private String optionBRegisterText;
    /**
     * String optionAListText
     */
    private String optionAListText;
    /**
     * String optionBListText
     */
    private String optionBListText;
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
     * JLabel titleLabel
     */
    private JLabel titleLabel;
    /**
     * JLabel descriptionLabel
     */
    private JLabel descriptionLabel;
    /**
     * JLabel imageLabel
     */
    private JLabel imageLabel;
    /**
     * JLabel optionAButton
     */
    private JLabel optionAButton;
    /**
     * JLabel optionBButton
     */
    private JLabel optionBButton;
    /**
     * JLabel optionCButton
     */
    private JLabel optionCButton;
    /**
     * JLabel optionDButton
     */
    private JLabel optionDButton;
    /**
     * JLabel optionEButton
     */
    private JLabel optionEButton;
    /**
     * JLabel optionFButton
     */
    private JLabel optionFButton;
    /**
     * JLabel optionGButton
     */
    private JLabel optionGButton;
    /**
     * JLabel optionHButton
     */
    private JLabel optionHButton;
    /**
     * JLabel optionIButton
     */
    private JLabel optionIButton;
    /**
     * JLabel optionJButton
     */
    private JLabel optionJButton;
    /**
     * JLabel optionAMessage
     */
    private JLabel optionAMessage;
    /**
     * JLabel optionBMessage
     */
    private JLabel optionBMessage;
    /**
     * JLabel optionALogin
     */
    private JLabel optionALogin;
    /**
     * JLabel optionBLogin
     */
    private JLabel optionBLogin;
    /**
     * JLabel optionARegister
     */
    private JLabel optionARegister;
    /**
     * JLabel optionBRegister
     */
    private JLabel optionBRegister;
    /**
     * JLabel optionAList
     */
    private JLabel optionAList;
    /**
     * JLabel optionBList
     */
    private JLabel optionBList;

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
        this.titleLabel = new JLabel();
        this.descriptionLabel = new JLabel();
        this.imageLabel = new JLabel();
        this.optionAButton = new JLabel();
        this.optionBButton = new JLabel();
        this.optionCButton = new JLabel();
        this.optionDButton = new JLabel();
        this.optionEButton = new JLabel();
        this.optionFButton = new JLabel();
        this.optionGButton = new JLabel();
        this.optionHButton = new JLabel();
        this.optionIButton = new JLabel();
        this.optionJButton = new JLabel();
        this.optionAMessage = new JLabel();
        this.optionBMessage = new JLabel();
        this.optionALogin = new JLabel();
        this.optionBLogin = new JLabel();
        this.optionARegister = new JLabel();
        this.optionBRegister = new JLabel();
        this.optionAList = new JLabel();
        this.optionBList = new JLabel();
    }

    /**
     * Sets TitleMessage
     * @param title String title
     */
    public void setTitleMessage(String title) {
        this.titleText = this.reformatMessage(title);
        this.refreshLater();
    }

    /**
     * Sets DescriptionMessage
     * @param description String description
     */
    public void setDescriptionMessage(String description) {
        this.descriptionText = this.reformatMessage(description);
        this.refreshLater();
    }

    /**
     * Sets Image,
     * @param image ImageIcon image
     */
    public void setImage(ImageIcon image) {
        if (image == null) {
            this.imageLabel.setVisible(false);
        } else {
            this.imageLabel.setText("");
            int[] proportions = this.getProportions(image.getIconWidth(), image.getIconHeight(), this.imageLabel.getWidth(), this.imageLabel.getHeight());
            Image scaledImage = image.getImage().getScaledInstance(proportions[0], proportions[1], 8);
            this.imageLabel.setIcon(new ImageIcon(scaledImage));
            this.imageLabel.setVisible(true);
        }
    }

    /**
     * Reformats String message
     * @param message String message
     * @return String message
     */
    private String reformatMessage(String message) {
        message = message.replaceAll("<img", "");
        message = message.replaceAll("<href", "");
        message = message.replaceAll("<[A-Za-z0-9]+>", "");
        message = message.replaceAll("\n", "<br>");
        message = "<html>" + message + "</html>";
        return message;
    }

    /**
     * Refresh components later
     */
    private void refreshLater() {
        SwingUtilities.invokeLater(() -> {
            MythArenaGuiScreen.this.titleLabel.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.descriptionLabel.setText(MythArenaGuiScreen.this.descriptionText);
            MythArenaGuiScreen.this.optionAButton.setText(MythArenaGuiScreen.this.optionAButtonText);
            MythArenaGuiScreen.this.optionBButton.setText(MythArenaGuiScreen.this.optionBButtonText);
            MythArenaGuiScreen.this.optionCButton.setText(MythArenaGuiScreen.this.optionCButtonText);
            MythArenaGuiScreen.this.optionDButton.setText(MythArenaGuiScreen.this.optionDButtonText);
            MythArenaGuiScreen.this.optionEButton.setText(MythArenaGuiScreen.this.optionEButtonText);
            MythArenaGuiScreen.this.optionFButton.setText(MythArenaGuiScreen.this.optionFButtonText);
            MythArenaGuiScreen.this.optionGButton.setText(MythArenaGuiScreen.this.optionGButtonText);
            MythArenaGuiScreen.this.optionHButton.setText(MythArenaGuiScreen.this.optionHButtonText);
            MythArenaGuiScreen.this.optionIButton.setText(MythArenaGuiScreen.this.optionIButtonText);
            MythArenaGuiScreen.this.optionJButton.setText(MythArenaGuiScreen.this.optionJButtonText);
            MythArenaGuiScreen.this.optionAMessage.setText(MythArenaGuiScreen.this.optionAMessageText);
            MythArenaGuiScreen.this.optionBMessage.setText(MythArenaGuiScreen.this.optionBMessageText);
            MythArenaGuiScreen.this.optionALogin.setText(MythArenaGuiScreen.this.optionALoginText);
            MythArenaGuiScreen.this.optionBLogin.setText(MythArenaGuiScreen.this.optionBLoginText);
            MythArenaGuiScreen.this.optionARegister.setText(MythArenaGuiScreen.this.optionARegisterText);
            MythArenaGuiScreen.this.optionBRegister.setText(MythArenaGuiScreen.this.optionBRegisterText);
            MythArenaGuiScreen.this.optionAList.setText(MythArenaGuiScreen.this.optionAListText);
            MythArenaGuiScreen.this.optionBList.setText(MythArenaGuiScreen.this.optionBListText);
        });
    }

    /**
     * Gets proper proportions for images
     * @param originalWidth int originalWidth
     * @param originalHeight int originalHeight
     * @param destinationWidth int destinationWidth
     * @param destinationHeight int destinationHeight
     * @return int[] proportions
     */
    private int[] getProportions(int originalWidth, int originalHeight, int destinationWidth, int destinationHeight) {
        int[] proportions = new int[2];
        int height = originalHeight * destinationWidth / originalWidth;
        if (height <= destinationHeight) {
            proportions[0] = destinationWidth;
            proportions[1] = height;
        } else {
            proportions[0] = originalWidth * destinationHeight / originalHeight;
            proportions[1] = destinationHeight;
        }
        return proportions;
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
