package mytharena.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
     * String optionAText
     */
    private String optionAText;
    /**
     * String optionBText
     */
    private String optionBText;
    /**
     * String optionCText
     */
    private String optionCText;
    /**
     * String optionDText
     */
    private String optionDText;
    /**
     * String optionEText
     */
    private String optionEText;
    /**
     * String optionFText
     */
    private String optionFText;
    /**
     * String optionGText
     */
    private String optionGText;
    /**
     * String optionHText
     */
    private String optionHText;
    /**
     * String optionIText
     */
    private String optionIText;
    /**
     * String optionJText
     */
    private String optionJText;
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
        this.addKeyListener(new KeyAdapter() {
            /**
             * keyPressed
             * @param event KeyEvent event
             */
            public void keyPressed(KeyEvent event) {
                MythArenaGuiScreen.this.formKeyPressed(event);
            }
        });
        this.optionAButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionA();
            }
        });
        this.optionBButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionB();
            }
        });
        this.optionCButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionC();
            }
        });
        this.optionDButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionD();
            }
        });
        this.optionEButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionE();
            }
        });
        this.optionFButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionF();
            }
        });
        this.optionGButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionG();
            }
        });
        this.optionHButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionH();
            }
        });
        this.optionIButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionI();
            }
        });
        this.optionJButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionJ();
            }
        });
        this.optionAMessage.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionA();
            }
        });
        this.optionBMessage.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionB();
            }
        });
        this.optionALogin.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionA();
            }
        });
        this.optionBLogin.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionB();
            }
        });
        this.optionARegister.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionA();
            }
        });
        this.optionBRegister.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionB();
            }
        });
        this.optionAList.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionA();
            }
        });
        this.optionBList.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionB();
            }
        });
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
     * Sets specified option message
     * @param number int number
     * @param message String message
     */
    public void setOption(int number, String message) {
        if (message == null) {
            message = "";
        } else {
            message = this.reformatMessage(message);
        }
        switch (number) {
            case 0 -> {
                this.optionAText = message;
                this.optionAButton.setVisible(!"".equals(message));
                this.optionAMessage.setVisible(!"".equals(message));
                this.optionALogin.setVisible(!"".equals(message));
                this.optionARegister.setVisible(!"".equals(message));
                this.optionAList.setVisible(!"".equals(message));
            }
            case 1 -> {
                this.optionBText = message;
                this.optionBButton.setVisible(!"".equals(message));
                this.optionBMessage.setVisible(!"".equals(message));
                this.optionBLogin.setVisible(!"".equals(message));
                this.optionBRegister.setVisible(!"".equals(message));
                this.optionBList.setVisible(!"".equals(message));
            }
            case 2 -> {
                this.optionCText = message;
                this.optionCButton.setVisible(!"".equals(message));
            }
            case 3 -> {
                this.optionDText = message;
                this.optionDButton.setVisible(!"".equals(message));
            }
            case 4 -> {
                this.optionEText = message;
                this.optionEButton.setVisible(!"".equals(message));
            }
            case 5 -> {
                this.optionFText = message;
                this.optionFButton.setVisible(!"".equals(message));
            }
            case 6 -> {
                this.optionGText = message;
                this.optionGButton.setVisible(!"".equals(message));
            }
            case 7 -> {
                this.optionHText = message;
                this.optionHButton.setVisible(!"".equals(message));
            }
            case 8 -> {
                this.optionIText = message;
                this.optionIButton.setVisible(!"".equals(message));
            }
            case 9 -> {
                this.optionJText = message;
                this.optionJButton.setVisible(!"".equals(message));
            }
        }
        this.refreshLater();
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
     * Refresh components later
     */
    private void refreshLater() {
        SwingUtilities.invokeLater(() -> {
            MythArenaGuiScreen.this.titleLabel.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.descriptionLabel.setText(MythArenaGuiScreen.this.descriptionText);
            MythArenaGuiScreen.this.optionAButton.setText(MythArenaGuiScreen.this.optionAText);
            MythArenaGuiScreen.this.optionBButton.setText(MythArenaGuiScreen.this.optionBText);
            MythArenaGuiScreen.this.optionCButton.setText(MythArenaGuiScreen.this.optionCText);
            MythArenaGuiScreen.this.optionDButton.setText(MythArenaGuiScreen.this.optionDText);
            MythArenaGuiScreen.this.optionEButton.setText(MythArenaGuiScreen.this.optionEText);
            MythArenaGuiScreen.this.optionFButton.setText(MythArenaGuiScreen.this.optionFText);
            MythArenaGuiScreen.this.optionGButton.setText(MythArenaGuiScreen.this.optionGText);
            MythArenaGuiScreen.this.optionHButton.setText(MythArenaGuiScreen.this.optionHText);
            MythArenaGuiScreen.this.optionIButton.setText(MythArenaGuiScreen.this.optionIText);
            MythArenaGuiScreen.this.optionJButton.setText(MythArenaGuiScreen.this.optionJText);
            MythArenaGuiScreen.this.optionAMessage.setText(MythArenaGuiScreen.this.optionAText);
            MythArenaGuiScreen.this.optionBMessage.setText(MythArenaGuiScreen.this.optionBText);
            MythArenaGuiScreen.this.optionALogin.setText(MythArenaGuiScreen.this.optionAText);
            MythArenaGuiScreen.this.optionBLogin.setText(MythArenaGuiScreen.this.optionBText);
            MythArenaGuiScreen.this.optionARegister.setText(MythArenaGuiScreen.this.optionAText);
            MythArenaGuiScreen.this.optionBRegister.setText(MythArenaGuiScreen.this.optionBText);
            MythArenaGuiScreen.this.optionAList.setText(MythArenaGuiScreen.this.optionAText);
            MythArenaGuiScreen.this.optionBList.setText(MythArenaGuiScreen.this.optionBText);
        });
    }

    /**
     * Key pressed
     * @param event KeyEvent event
     */
    private void formKeyPressed(KeyEvent event) {
        if (event.getKeyCode() == 116) {
            this.titleLabel.setText(this.titleText);
            this.descriptionLabel.setText(this.descriptionText);
            this.optionAButton.setText(this.optionAText);
            this.optionBButton.setText(this.optionBText);
            this.optionCButton.setText(this.optionCText);
            this.optionDButton.setText(this.optionDText);
            this.optionEButton.setText(this.optionEText);
            this.optionFButton.setText(this.optionFText);
            this.optionGButton.setText(this.optionGText);
            this.optionHButton.setText(this.optionHText);
            this.optionIButton.setText(this.optionIText);
            this.optionJButton.setText(this.optionJText);
            this.optionAMessage.setText(this.optionAText);
            this.optionBMessage.setText(this.optionBText);
            this.optionALogin.setText(this.optionAText);
            this.optionBLogin.setText(this.optionBText);
            this.optionARegister.setText(this.optionAText);
            this.optionBRegister.setText(this.optionBText);
            this.optionAList.setText(this.optionAText);
            this.optionBList.setText(this.optionBText);
        }
    }

    /**
     * Clicks OptionA
     */
    private void clickOptionA() {
        this.mythArenaGui.insertChar('A');
    }

    /**
     * Clicks OptionB
     */
    private void clickOptionB() {
        this.mythArenaGui.insertChar('B');
    }

    /**
     * Clicks OptionC
     */
    private void clickOptionC() {
        this.mythArenaGui.insertChar('C');
    }

    /**
     * Clicks OptionD
     */
    private void clickOptionD() {
        this.mythArenaGui.insertChar('D');
    }

    /**
     * Clicks OptionE
     */
    private void clickOptionE() {
        this.mythArenaGui.insertChar('E');
    }

    /**
     * Clicks OptionF
     */
    private void clickOptionF() {
        this.mythArenaGui.insertChar('F');
    }

    /**
     * Clicks OptionG
     */
    private void clickOptionG() {
        this.mythArenaGui.insertChar('G');
    }
    /**
     * Clicks OptionH
     */
    private void clickOptionH() {
        this.mythArenaGui.insertChar('H');
    }

    /**
     * Clicks OptionI
     */
    private void clickOptionI() {
        this.mythArenaGui.insertChar('I');
    }

    /**
     * Clicks OptionJ
     */
    private void clickOptionJ() {
        this.mythArenaGui.insertChar('J');
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
