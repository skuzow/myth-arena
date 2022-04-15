package mytharena.gui;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Myth Arena");
        this.setBackground(new Color(2, 40, 3));
        this.setResizable(false);
        this.addKeyListener(new KeyAdapter() {
            /**
             * keyPressed
             * @param event KeyEvent event
             */
            public void keyPressed(KeyEvent event) {
                MythArenaGuiScreen.this.formKeyPressed(event);
            }
        });
        this.getContentPane().setLayout(new AbsoluteLayout());
        // buttonPanel
        this.buttonPanel.setBackground(new Color(254, 254, 254));
        this.buttonPanel.setMinimumSize(new Dimension(1300, 900));
        this.buttonPanel.setLayout(new AbsoluteLayout());
        // messagePanel
        this.messagePanel.setBackground(new Color(254, 254, 254));
        this.messagePanel.setMinimumSize(new Dimension(1300, 900));
        this.messagePanel.setLayout(new AbsoluteLayout());
        // loginPanel
        this.loginPanel.setBackground(new Color(254, 254, 254));
        this.loginPanel.setMinimumSize(new Dimension(1300, 900));
        this.loginPanel.setLayout(new AbsoluteLayout());
        // registerPanel
        this.registerPanel.setBackground(new Color(254, 254, 254));
        this.registerPanel.setMinimumSize(new Dimension(1300, 900));
        this.registerPanel.setLayout(new AbsoluteLayout());
        // listPanel
        this.listPanel.setBackground(new Color(254, 254, 254));
        this.listPanel.setMinimumSize(new Dimension(1300, 900));
        this.listPanel.setLayout(new AbsoluteLayout());
        // optionAButton
        this.optionAButton.setBackground(new Color(254, 254, 254));
        this.optionAButton.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionAButton.setForeground(new Color(1, 1, 1));
        this.optionAButton.setHorizontalAlignment(0);
        this.optionAButton.setText("OptionAButton");
        this.optionAButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionAButton.setOpaque(true);
        this.optionAButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionA();
            }
        });
        this.buttonPanel.add(this.optionAButton, new AbsoluteConstraints(0, 380, 298, 78));
        // optionBButton
        this.optionBButton.setBackground(new Color(254, 254, 254));
        this.optionBButton.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionBButton.setForeground(new Color(1, 1, 1));
        this.optionBButton.setHorizontalAlignment(0);
        this.optionBButton.setText("OptionBButton");
        this.optionBButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionBButton.setOpaque(true);
        this.optionBButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionB();
            }
        });
        this.buttonPanel.add(this.optionBButton, new AbsoluteConstraints(0, 380, 298, 78));
        // optionCButton
        this.optionCButton.setBackground(new Color(254, 254, 254));
        this.optionCButton.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionCButton.setForeground(new Color(1, 1, 1));
        this.optionCButton.setHorizontalAlignment(0);
        this.optionCButton.setText("OptionCButton");
        this.optionCButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionCButton.setOpaque(true);
        this.optionCButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionC();
            }
        });
        this.buttonPanel.add(this.optionCButton, new AbsoluteConstraints(0, 380, 298, 78));
        // optionDButton
        this.optionDButton.setBackground(new Color(254, 254, 254));
        this.optionDButton.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionDButton.setForeground(new Color(1, 1, 1));
        this.optionDButton.setHorizontalAlignment(0);
        this.optionDButton.setText("OptionDButton");
        this.optionDButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionDButton.setOpaque(true);
        this.optionDButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionD();
            }
        });
        this.buttonPanel.add(this.optionDButton, new AbsoluteConstraints(0, 380, 298, 78));
        // optionEButton
        this.optionEButton.setBackground(new Color(254, 254, 254));
        this.optionEButton.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionEButton.setForeground(new Color(1, 1, 1));
        this.optionEButton.setHorizontalAlignment(0);
        this.optionEButton.setText("OptionEButton");
        this.optionEButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionEButton.setOpaque(true);
        this.optionEButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionE();
            }
        });
        this.buttonPanel.add(this.optionEButton, new AbsoluteConstraints(0, 380, 298, 78));
        // optionFButton
        this.optionFButton.setBackground(new Color(254, 254, 254));
        this.optionFButton.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionFButton.setForeground(new Color(1, 1, 1));
        this.optionFButton.setHorizontalAlignment(0);
        this.optionFButton.setText("OptionFButton");
        this.optionFButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionFButton.setOpaque(true);
        this.optionFButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionF();
            }
        });
        this.buttonPanel.add(this.optionFButton, new AbsoluteConstraints(0, 380, 298, 78));
        // optionGButton
        this.optionGButton.setBackground(new Color(254, 254, 254));
        this.optionGButton.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionGButton.setForeground(new Color(1, 1, 1));
        this.optionGButton.setHorizontalAlignment(0);
        this.optionGButton.setText("OptionGButton");
        this.optionGButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionGButton.setOpaque(true);
        this.optionGButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionG();
            }
        });
        this.buttonPanel.add(this.optionGButton, new AbsoluteConstraints(0, 380, 298, 78));
        // optionHButton
        this.optionHButton.setBackground(new Color(254, 254, 254));
        this.optionHButton.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionHButton.setForeground(new Color(1, 1, 1));
        this.optionHButton.setHorizontalAlignment(0);
        this.optionHButton.setText("OptionHButton");
        this.optionHButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionHButton.setOpaque(true);
        this.optionHButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionH();
            }
        });
        this.buttonPanel.add(this.optionHButton, new AbsoluteConstraints(0, 380, 298, 78));
        // optionHButton
        this.optionIButton.setBackground(new Color(254, 254, 254));
        this.optionIButton.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionIButton.setForeground(new Color(1, 1, 1));
        this.optionIButton.setHorizontalAlignment(0);
        this.optionIButton.setText("OptionIButton");
        this.optionIButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionIButton.setOpaque(true);
        this.optionIButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionI();
            }
        });
        this.buttonPanel.add(this.optionIButton, new AbsoluteConstraints(0, 380, 298, 78));
        // optionJButton
        this.optionJButton.setBackground(new Color(254, 254, 254));
        this.optionJButton.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionJButton.setForeground(new Color(1, 1, 1));
        this.optionJButton.setHorizontalAlignment(0);
        this.optionJButton.setText("OptionJButton");
        this.optionJButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionJButton.setOpaque(true);
        this.optionJButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionJ();
            }
        });
        this.buttonPanel.add(this.optionJButton, new AbsoluteConstraints(0, 380, 298, 78));
        // optionAMessage
        this.optionAMessage.setBackground(new Color(254, 254, 254));
        this.optionAMessage.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionAMessage.setForeground(new Color(1, 1, 1));
        this.optionAMessage.setHorizontalAlignment(0);
        this.optionAMessage.setText("optionAMessage");
        this.optionAMessage.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionAMessage.setOpaque(true);
        this.optionAMessage.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionA();
            }
        });
        this.messagePanel.add(this.optionAMessage, new AbsoluteConstraints(0, 380, 298, 78));
        // optionBMessage
        this.optionBMessage.setBackground(new Color(254, 254, 254));
        this.optionBMessage.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionBMessage.setForeground(new Color(1, 1, 1));
        this.optionBMessage.setHorizontalAlignment(0);
        this.optionBMessage.setText("optionBMessage");
        this.optionBMessage.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionBMessage.setOpaque(true);
        this.optionBMessage.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionB();
            }
        });
        this.messagePanel.add(this.optionBMessage, new AbsoluteConstraints(0, 380, 298, 78));
        // optionALogin
        this.optionALogin.setBackground(new Color(254, 254, 254));
        this.optionALogin.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionALogin.setForeground(new Color(1, 1, 1));
        this.optionALogin.setHorizontalAlignment(0);
        this.optionALogin.setText("optionALogin");
        this.optionALogin.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionALogin.setOpaque(true);
        this.optionALogin.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionA();
            }
        });
        this.loginPanel.add(this.optionALogin, new AbsoluteConstraints(0, 380, 298, 78));
        // optionBLogin
        this.optionBLogin.setBackground(new Color(254, 254, 254));
        this.optionBLogin.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionBLogin.setForeground(new Color(1, 1, 1));
        this.optionBLogin.setHorizontalAlignment(0);
        this.optionBLogin.setText("optionBLogin");
        this.optionBLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionBLogin.setOpaque(true);
        this.optionBLogin.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionB();
            }
        });
        this.loginPanel.add(this.optionBLogin, new AbsoluteConstraints(0, 380, 298, 78));
        // optionARegister
        this.optionARegister.setBackground(new Color(254, 254, 254));
        this.optionARegister.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionARegister.setForeground(new Color(1, 1, 1));
        this.optionARegister.setHorizontalAlignment(0);
        this.optionARegister.setText("optionARegister");
        this.optionARegister.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionARegister.setOpaque(true);
        this.optionARegister.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionA();
            }
        });
        this.registerPanel.add(this.optionARegister, new AbsoluteConstraints(0, 380, 298, 78));
        // optionBRegister
        this.optionBRegister.setBackground(new Color(254, 254, 254));
        this.optionBRegister.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionBRegister.setForeground(new Color(1, 1, 1));
        this.optionBRegister.setHorizontalAlignment(0);
        this.optionBRegister.setText("optionBRegister");
        this.optionBRegister.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionBRegister.setOpaque(true);
        this.optionBRegister.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionB();
            }
        });
        this.registerPanel.add(this.optionBRegister, new AbsoluteConstraints(0, 380, 298, 78));
        // optionAList
        this.optionAList.setBackground(new Color(254, 254, 254));
        this.optionAList.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionAList.setForeground(new Color(1, 1, 1));
        this.optionAList.setHorizontalAlignment(0);
        this.optionAList.setText("optionAList");
        this.optionAList.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionAList.setOpaque(true);
        this.optionAList.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionA();
            }
        });
        this.listPanel.add(this.optionAList, new AbsoluteConstraints(0, 380, 298, 78));
        // optionBList
        this.optionBList.setBackground(new Color(254, 254, 254));
        this.optionBList.setFont(new Font("Arial", Font.PLAIN, 18));
        this.optionBList.setForeground(new Color(1, 1, 1));
        this.optionBList.setHorizontalAlignment(0);
        this.optionBList.setText("optionBList");
        this.optionBList.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.optionBList.setOpaque(true);
        this.optionBList.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOptionB();
            }
        });
        this.listPanel.add(this.optionBList, new AbsoluteConstraints(0, 380, 298, 78));
        this.pack();
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
     * Sets Image
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
