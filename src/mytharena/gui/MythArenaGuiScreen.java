package mytharena.gui;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

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
     * JLabel titleMessage
     */
    private JLabel titleMessage;
    /**
     * JLabel titleLogin
     */
    private JLabel titleLogin;
    /**
     * JLabel titleRegister
     */
    private JLabel titleRegister;
    /**
     * JLabel titleButton
     */
    private JLabel titleButton;
    /**
     * JLabel titleList
     */
    private JLabel titleList;
    /**
     * JLabel descriptionMessage
     */
    private JLabel descriptionMessage;
    /**
     * JLabel descriptionLogin
     */
    private JLabel descriptionLogin;
    /**
     * JLabel descriptionRegister
     */
    private JLabel descriptionRegister;
    /**
     * JLabel descriptionButton
     */
    private JLabel descriptionButton;
    /**
     * JLabel descriptionList
     */
    private JLabel descriptionList;
    /**
     * JLabel imageMessage
     */
    private JLabel imageMessage;
    /**
     * JLabel imageLogin
     */
    private JLabel imageLogin;
    /**
     * JLabel imageRegister
     */
    private JLabel imageRegister;
    /**
     * JLabel imageButton
     */
    private JLabel imageButton;
    /**
     * JLabel imageList
     */
    private JLabel imageList;
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
        this.titleMessage = new JLabel();
        this.titleLogin = new JLabel();
        this.titleRegister = new JLabel();
        this.titleButton = new JLabel();
        this.titleList = new JLabel();
        this.descriptionMessage = new JLabel();
        this.descriptionLogin = new JLabel();
        this.descriptionRegister = new JLabel();
        this.descriptionButton = new JLabel();
        this.descriptionList = new JLabel();
        this.imageMessage = new JLabel();
        this.imageLogin = new JLabel();
        this.imageRegister = new JLabel();
        this.imageButton = new JLabel();
        this.imageList = new JLabel();
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
        ImageIcon logo = new ImageIcon(Objects.requireNonNull(super.getClass().getResource("/resources/images/logo.png")));
        this.setIconImage(logo.getImage());
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
        this.getContentPane().add(this.buttonPanel, new AbsoluteConstraints(5, 5, 1300, 900));
        // messagePanel
        this.messagePanel.setBackground(new Color(254, 254, 254));
        this.messagePanel.setMinimumSize(new Dimension(1300, 900));
        this.messagePanel.setLayout(new AbsoluteLayout());
        this.getContentPane().add(this.messagePanel, new AbsoluteConstraints(5, 5, 1300, 900));
        // loginPanel
        this.loginPanel.setBackground(new Color(254, 254, 254));
        this.loginPanel.setMinimumSize(new Dimension(1300, 900));
        this.loginPanel.setLayout(new AbsoluteLayout());
        this.getContentPane().add(this.loginPanel, new AbsoluteConstraints(5, 5, 1300, 900));
        // registerPanel
        this.registerPanel.setBackground(new Color(254, 254, 254));
        this.registerPanel.setMinimumSize(new Dimension(1300, 900));
        this.registerPanel.setLayout(new AbsoluteLayout());
        this.getContentPane().add(this.registerPanel, new AbsoluteConstraints(5, 5, 1300, 900));
        // listPanel
        this.listPanel.setBackground(new Color(254, 254, 254));
        this.listPanel.setMinimumSize(new Dimension(1300, 900));
        this.listPanel.setLayout(new AbsoluteLayout());
        this.getContentPane().add(this.listPanel, new AbsoluteConstraints(5, 5, 1300, 900));
        // titleMessage
        this.titleMessage.setBackground(new Color(254, 254, 254));
        this.titleMessage.setFont(new Font("Arial", Font.PLAIN, 36));
        this.titleMessage.setForeground(new Color(1, 1, 1));
        this.titleMessage.setHorizontalAlignment(0);
        this.titleMessage.setText("TitleMessage");
        this.titleMessage.setOpaque(true);
        this.messagePanel.add(this.titleMessage, new AbsoluteConstraints(330, 20, 630, 60));
        // titleLogin
        this.titleLogin.setBackground(new Color(254, 254, 254));
        this.titleLogin.setFont(new Font("Arial", Font.PLAIN, 36));
        this.titleLogin.setForeground(new Color(1, 1, 1));
        this.titleLogin.setHorizontalAlignment(0);
        this.titleLogin.setText("TitleLogin");
        this.titleLogin.setOpaque(true);
        this.loginPanel.add(this.titleLogin, new AbsoluteConstraints(330, 20, 630, 60));
        // titleRegister
        this.titleRegister.setBackground(new Color(254, 254, 254));
        this.titleRegister.setFont(new Font("Arial", Font.PLAIN, 36));
        this.titleRegister.setForeground(new Color(1, 1, 1));
        this.titleRegister.setHorizontalAlignment(0);
        this.titleRegister.setText("TitleRegister");
        this.titleRegister.setOpaque(true);
        this.registerPanel.add(this.titleRegister, new AbsoluteConstraints(330, 20, 630, 60));
        // titleButton
        this.titleButton.setBackground(new Color(254, 254, 254));
        this.titleButton.setFont(new Font("Arial", Font.PLAIN, 36));
        this.titleButton.setForeground(new Color(1, 1, 1));
        this.titleButton.setHorizontalAlignment(0);
        this.titleButton.setText("TitleButton");
        this.titleButton.setOpaque(true);
        this.buttonPanel.add(this.titleButton, new AbsoluteConstraints(330, 20, 630, 60));
        // titleList
        this.titleList.setBackground(new Color(254, 254, 254));
        this.titleList.setFont(new Font("Arial", Font.PLAIN, 36));
        this.titleList.setForeground(new Color(1, 1, 1));
        this.titleList.setHorizontalAlignment(0);
        this.titleList.setText("TitleList");
        this.titleList.setOpaque(true);
        this.listPanel.add(this.titleList, new AbsoluteConstraints(330, 20, 630, 60));
        // descriptionMessage
        this.descriptionMessage.setBackground(new Color(254, 254, 254));
        this.descriptionMessage.setFont(new Font("Arial", Font.PLAIN, 25));
        this.descriptionMessage.setForeground(new Color(1, 1, 1));
        this.descriptionMessage.setHorizontalAlignment(0);
        this.descriptionMessage.setText("DescriptionMessage");
        this.descriptionMessage.setOpaque(true);
        this.messagePanel.add(this.descriptionMessage, new AbsoluteConstraints(330, 80, 630, 60));
        // descriptionLogin
        this.descriptionLogin.setBackground(new Color(254, 254, 254));
        this.descriptionLogin.setFont(new Font("Arial", Font.PLAIN, 25));
        this.descriptionLogin.setForeground(new Color(1, 1, 1));
        this.descriptionLogin.setHorizontalAlignment(0);
        this.descriptionLogin.setText("DescriptionLogin");
        this.descriptionLogin.setOpaque(true);
        this.loginPanel.add(this.descriptionLogin, new AbsoluteConstraints(330, 80, 630, 60));
        // descriptionRegister
        this.descriptionRegister.setBackground(new Color(254, 254, 254));
        this.descriptionRegister.setFont(new Font("Arial", Font.PLAIN, 25));
        this.descriptionRegister.setForeground(new Color(1, 1, 1));
        this.descriptionRegister.setHorizontalAlignment(0);
        this.descriptionRegister.setText("DescriptionRegister");
        this.descriptionRegister.setOpaque(true);
        this.registerPanel.add(this.descriptionRegister, new AbsoluteConstraints(330, 80, 630, 60));
        // descriptionButton
        this.descriptionButton.setBackground(new Color(254, 254, 254));
        this.descriptionButton.setFont(new Font("Arial", Font.PLAIN, 25));
        this.descriptionButton.setForeground(new Color(1, 1, 1));
        this.descriptionButton.setHorizontalAlignment(0);
        this.descriptionButton.setText("DescriptionButton");
        this.descriptionButton.setOpaque(true);
        this.buttonPanel.add(this.descriptionButton, new AbsoluteConstraints(330, 80, 630, 60));
        // descriptionList
        this.descriptionList.setBackground(new Color(254, 254, 254));
        this.descriptionList.setFont(new Font("Arial", Font.PLAIN, 25));
        this.descriptionList.setForeground(new Color(1, 1, 1));
        this.descriptionList.setHorizontalAlignment(0);
        this.descriptionList.setText("DescriptionList");
        this.descriptionList.setOpaque(true);
        this.listPanel.add(this.descriptionList, new AbsoluteConstraints(330, 80, 630, 60));
        // imageMessage
        this.imageMessage.setHorizontalAlignment(0);
        this.imageMessage.setIconTextGap(0);
        this.messagePanel.add(this.imageMessage, new AbsoluteConstraints(450, -200, 384, 978));
        // imageLogin
        this.imageLogin.setHorizontalAlignment(0);
        this.imageLogin.setIconTextGap(0);
        this.loginPanel.add(this.imageLogin, new AbsoluteConstraints(450, -200, 384, 978));
        // imageRegister
        this.imageRegister.setHorizontalAlignment(0);
        this.imageRegister.setIconTextGap(0);
        this.registerPanel.add(this.imageRegister, new AbsoluteConstraints(450, -200, 384, 978));
        // imageButton
        this.imageButton.setHorizontalAlignment(0);
        this.imageButton.setIconTextGap(0);
        this.buttonPanel.add(this.imageButton, new AbsoluteConstraints(450, -200, 384, 978));
        // imageList
        this.imageList.setHorizontalAlignment(0);
        this.imageList.setIconTextGap(0);
        this.listPanel.add(this.imageList, new AbsoluteConstraints(450, -200, 384, 978));
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
        this.buttonPanel.add(this.optionAButton, new AbsoluteConstraints(350, 480, 298, 78));
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
        this.buttonPanel.add(this.optionBButton, new AbsoluteConstraints(650, 480, 298, 78));
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
        this.buttonPanel.add(this.optionCButton, new AbsoluteConstraints(350, 560, 298, 78));
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
        this.buttonPanel.add(this.optionDButton, new AbsoluteConstraints(650, 560, 298, 78));
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
        this.buttonPanel.add(this.optionEButton, new AbsoluteConstraints(350, 640, 298, 78));
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
        this.buttonPanel.add(this.optionFButton, new AbsoluteConstraints(650, 640, 298, 78));
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
        this.buttonPanel.add(this.optionGButton, new AbsoluteConstraints(350, 720, 298, 78));
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
        this.buttonPanel.add(this.optionHButton, new AbsoluteConstraints(650, 720, 298, 78));
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
        this.buttonPanel.add(this.optionIButton, new AbsoluteConstraints(350, 800, 298, 78));
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
        this.buttonPanel.add(this.optionJButton, new AbsoluteConstraints(650, 800, 298, 78));
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
        this.messagePanel.add(this.optionAMessage, new AbsoluteConstraints(350, 800, 298, 78));
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
        this.messagePanel.add(this.optionBMessage, new AbsoluteConstraints(650, 800, 298, 78));
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
        this.loginPanel.add(this.optionALogin, new AbsoluteConstraints(350, 800, 298, 78));
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
        this.loginPanel.add(this.optionBLogin, new AbsoluteConstraints(650, 800, 298, 78));
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
        this.registerPanel.add(this.optionARegister, new AbsoluteConstraints(350, 800, 298, 78));
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
        this.registerPanel.add(this.optionBRegister, new AbsoluteConstraints(650, 800, 298, 78));
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
        this.listPanel.add(this.optionAList, new AbsoluteConstraints(350, 800, 298, 78));
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
        this.listPanel.add(this.optionBList, new AbsoluteConstraints(650, 800, 298, 78));
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
     * @param number int number
     * @param image ImageIcon image
     */
    public void setImage(int number, ImageIcon image) {
        switch (number) {
            case 0 -> {
                if (image == null) {
                    this.imageMessage.setVisible(false);
                } else {
                    this.imageMessage.setText("");
                    int[] proportions = this.getProportions(image.getIconWidth(), image.getIconHeight(), this.imageMessage.getWidth(), this.imageMessage.getHeight());
                    Image scaledImage = image.getImage().getScaledInstance(proportions[0], proportions[1], 8);
                    this.imageMessage.setIcon(new ImageIcon(scaledImage));
                    this.imageMessage.setVisible(true);
                }
            }
            case 1 -> {
                if (image == null) {
                    this.imageLogin.setVisible(false);
                } else {
                    this.imageLogin.setText("");
                    int[] proportions = this.getProportions(image.getIconWidth(), image.getIconHeight(), this.imageLogin.getWidth(), this.imageLogin.getHeight());
                    Image scaledImage = image.getImage().getScaledInstance(proportions[0], proportions[1], 8);
                    this.imageLogin.setIcon(new ImageIcon(scaledImage));
                    this.imageLogin.setVisible(true);
                }
            }
            case 2 -> {
                if (image == null) {
                    this.imageRegister.setVisible(false);
                } else {
                    this.imageRegister.setText("");
                    int[] proportions = this.getProportions(image.getIconWidth(), image.getIconHeight(), this.imageRegister.getWidth(), this.imageRegister.getHeight());
                    Image scaledImage = image.getImage().getScaledInstance(proportions[0], proportions[1], 8);
                    this.imageRegister.setIcon(new ImageIcon(scaledImage));
                    this.imageRegister.setVisible(true);
                }
            }
            case 3 -> {
                if (image == null) {
                    this.imageButton.setVisible(false);
                } else {
                    this.imageButton.setText("");
                    int[] proportions = this.getProportions(image.getIconWidth(), image.getIconHeight(), this.imageButton.getWidth(), this.imageButton.getHeight());
                    Image scaledImage = image.getImage().getScaledInstance(proportions[0], proportions[1], 8);
                    this.imageButton.setIcon(new ImageIcon(scaledImage));
                    this.imageButton.setVisible(true);
                }
            }
            case 4 -> {
                if (image == null) {
                    this.imageList.setVisible(false);
                } else {
                    this.imageList.setText("");
                    int[] proportions = this.getProportions(image.getIconWidth(), image.getIconHeight(), this.imageList.getWidth(), this.imageList.getHeight());
                    Image scaledImage = image.getImage().getScaledInstance(proportions[0], proportions[1], 8);
                    this.imageList.setIcon(new ImageIcon(scaledImage));
                    this.imageList.setVisible(true);
                }
            }
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
            MythArenaGuiScreen.this.titleMessage.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.titleLogin.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.titleRegister.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.titleButton.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.titleList.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.descriptionMessage.setText(MythArenaGuiScreen.this.descriptionText);
            MythArenaGuiScreen.this.descriptionLogin.setText(MythArenaGuiScreen.this.descriptionText);
            MythArenaGuiScreen.this.descriptionRegister.setText(MythArenaGuiScreen.this.descriptionText);
            MythArenaGuiScreen.this.descriptionButton.setText(MythArenaGuiScreen.this.descriptionText);
            MythArenaGuiScreen.this.descriptionList.setText(MythArenaGuiScreen.this.descriptionText);
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
            this.titleMessage.setText(this.titleText);
            this.titleLogin.setText(this.titleText);
            this.titleRegister.setText(this.titleText);
            this.titleButton.setText(this.titleText);
            this.titleList.setText(this.titleText);
            this.descriptionMessage.setText(this.descriptionText);
            this.descriptionLogin.setText(this.descriptionText);
            this.descriptionRegister.setText(this.descriptionText);
            this.descriptionButton.setText(this.descriptionText);
            this.descriptionList.setText(this.descriptionText);
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
