package mytharena.gui;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
    private String titleText = "titleText";
    /**
     * String descriptionText
     */
    private String descriptionText = "descriptionText";
    /**
     * String optionAText
     */
    private String optionAText = "optionAText";
    /**
     * String optionBText
     */
    private String optionBText = "optionBText";
    /**
     * String optionCText
     */
    private String optionCText = "optionCText";
    /**
     * String optionDText
     */
    private String optionDText = "optionDText";
    /**
     * String optionEText
     */
    private String optionEText = "optionEText";
    /**
     * String optionFText
     */
    private String optionFText = "optionFText";
    /**
     * String optionGText
     */
    private String optionGText = "optionGText";
    /**
     * String optionHText
     */
    private String optionHText = "optionHText";
    /**
     * String optionIText
     */
    private String optionIText = "optionIText";
    /**
     * String optionJText
     */
    private String optionJText = "optionJText";
    /**
     * String titlefieldAFormText
     */
    private String titlefieldAFormText = "titlefieldAFormText";
    /**
     * String titlefieldBFormText
     */
    private String titlefieldBFormText = "titlefieldBFormText";
    /**
     * String titlefieldCFormText
     */
    private String titlefieldCFormText = "titlefieldCFormText";
    /**
     * int lastSelectedListindex
     */
    private int lastSelectedListindex = 0;
    /**
     * JPanel messagePanel
     */
    private JPanel messagePanel;
    /**
     * JPanel formPanel
     */
    private JPanel formPanel;
    /**
     * JPanel buttonPanel
     */
    private JPanel buttonPanel;
    /**
     * JPanel listPanel
     */
    private JPanel listPanel;
    /**
     * JPanel combatPanel
     */
    private JPanel combatPanel;
    /**
     * JLabel titleMessage
     */
    private JLabel titleMessage;
    /**
     * JLabel titleForm
     */
    private JLabel titleForm;
    /**
     * JLabel titleButton
     */
    private JLabel titleButton;
    /**
     * JLabel titleList
     */
    private JLabel titleList;
    /**
     * JLabel titleCombat
     */
    private JLabel titleCombat;
    /**
     * JLabel descriptionMessage
     */
    private JLabel descriptionMessage;
    /**
     * JLabel descriptionForm
     */
    private JLabel descriptionForm;
    /**
     * JLabel descriptionButton
     */
    private JLabel descriptionButton;
    /**
     * JLabel descriptionList
     */
    private JLabel descriptionList;
    /**
     * JLabel descriptionCombat
     */
    private JLabel descriptionCombat;
    /**
     * JLabel imageMessage
     */
    private JLabel imageMessage;
    /**
     * JLabel imageForm
     */
    private JLabel imageForm;
    /**
     * JLabel imageButton
     */
    private JLabel imageButton;
    /**
     * JLabel imageList
     */
    private JLabel imageList;
    /**
     * JLabel imageCombat
     */
    private JLabel imageCombat;
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
     * JLabel optionAForm
     */
    private JLabel optionAForm;
    /**
     * JLabel optionBForm
     */
    private JLabel optionBForm;
    /**
     * JLabel optionAList
     */
    private JLabel optionAList;
    /**
     * JLabel optionBList
     */
    private JLabel optionBList;
    /**
     * JLabel optionCList
     */
    private JLabel optionCList;
    /**
     * JLabel optionDList
     */
    private JLabel optionDList;
    /**
     * JLabel optionACombat
     */
    private JLabel optionACombat;
    /**
     * JLabel optionBCombat
     */
    private JLabel optionBCombat;
    /**
     * JLabel titlefieldAForm
     */
    private JLabel titlefieldAForm;
    /**
     * JLabel titlefieldBForm
     */
    private JLabel titlefieldBForm;
    /**
     * JLabel titlefieldCForm
     */
    private JLabel titlefieldCForm;
    /**
     * JTextField fieldAForm
     */
    private JTextField fieldAForm;
    /**
     * JTextField fieldBForm
     */
    private JTextField fieldBForm;
    /**
     * JTextField fieldCForm
     */
    private JTextField fieldCForm;
    /**
     * JList listLabel
     */
    private JList<String> listLabel;
    /**
     * DefaultListModel listModel
     */
    private DefaultListModel<String> listModel;

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
        this.formPanel = new JPanel();
        this.buttonPanel = new JPanel();
        this.listPanel = new JPanel();
        this.combatPanel = new JPanel();
        this.titleMessage = new JLabel();
        this.titleForm = new JLabel();
        this.titleButton = new JLabel();
        this.titleList = new JLabel();
        this.titleCombat = new JLabel();
        this.descriptionMessage = new JLabel();
        this.descriptionForm = new JLabel();
        this.descriptionButton = new JLabel();
        this.descriptionList = new JLabel();
        this.descriptionCombat = new JLabel();
        this.imageMessage = new JLabel();
        this.imageForm = new JLabel();
        this.imageButton = new JLabel();
        this.imageList = new JLabel();
        this.imageCombat = new JLabel();
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
        this.optionAForm = new JLabel();
        this.optionBForm = new JLabel();
        this.optionAList = new JLabel();
        this.optionBList = new JLabel();
        this.optionCList = new JLabel();
        this.optionDList = new JLabel();
        this.optionACombat = new JLabel();
        this.optionBCombat = new JLabel();
        this.titlefieldAForm = new JLabel();
        this.titlefieldBForm = new JLabel();
        this.titlefieldCForm = new JLabel();
        this.fieldAForm = new JTextField();
        this.fieldBForm = new JTextField();
        this.fieldCForm = new JTextField();
        this.listLabel = new JList<>();
        this.listModel = new DefaultListModel<>();
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
        // listLabel
        this.listLabel.setModel(this.listModel);
        this.listLabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        this.listLabel.addListSelectionListener(new ListSelectionListener() {
            /**
             * valueChanged
             * @param event MouseEvent event
             */
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    MythArenaGuiScreen.this.lastSelectedListindex = event.getLastIndex();
                }
            }
        );
        JScrollPane scrollPane = new JScrollPane(this.listLabel);
        scrollPane.setBounds(403, 400, 500, 300);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.listPanel.add(scrollPane);
        // fieldAForm
        this.generateField(this.fieldAForm, 562, 490);
        // fieldBForm
        this.generateField(this.fieldBForm, 562, 560);
        // fieldCForm
        this.generateField(this.fieldCForm, 562, 630);
        // buttonPanel
        this.generatePanel(this.buttonPanel);
        // messagePanel
        this.generatePanel(this.messagePanel);
        // formPanel
        this.generatePanel(this.formPanel);
        // listPanel
        this.generatePanel(this.listPanel);
        // combatPanel
        this.generatePanel(this.combatPanel);
        // titleMessage
        this.generateText(this.titleMessage, this.messagePanel, "TitleMessage", 36, 330, 20);
        // titleForm
        this.generateText(this.titleForm, this.formPanel, "TitleForm", 36, 330, 20);
        // titleButton
        this.generateText(this.titleButton, this.buttonPanel, "TitleButton", 36, 330, 20);
        // titleList
        this.generateText(this.titleList, this.listPanel, "TitleList", 36, 330, 20);
        // titleCombat
        this.generateText(this.titleCombat, this.combatPanel, "TitleCombat", 36, 330, 20);
        // descriptionMessage
        this.generateText(this.descriptionMessage, this.messagePanel, "DescriptionMessage", 25, 330, 80);
        // descriptionForm
        this.generateText(this.descriptionForm, this.formPanel, "DescriptionForm", 25, 330, 80);
        // descriptionButton
        this.generateText(this.descriptionButton, this.buttonPanel, "DescriptionButton", 25, 330, 80);
        // descriptionList
        this.generateText(this.descriptionList, this.listPanel, "DescriptionList", 25, 330, 80);
        // descriptionCombat
        this.generateText(this.descriptionCombat, this.combatPanel, "DescriptionCombat", 25, 330, 80);
        // imageMessage
        this.generateImage(this.imageMessage, this.messagePanel, 450, -200);
        // imageForm
        this.generateImage(this.imageForm, this.formPanel, 450, -200);
        // imageButton
        this.generateImage(this.imageButton, this.buttonPanel, 450, -200);
        // imageList
        this.generateImage(this.imageList, this.listPanel, 450, -200);
        // imageCombat
        this.generateImage(this.imageCombat, this.combatPanel, 450, -200);
        // optionAButton
        this.generateOption(this.optionAButton, this.buttonPanel, "optionAButton", 'A', 350, 480);
        // optionBButton
        this.generateOption(this.optionBButton, this.buttonPanel, "optionBButton", 'B', 650, 480);
        // optionCButton
        this.generateOption(this.optionCButton, this.buttonPanel, "optionCButton", 'C', 350, 560);
        // optionDButton
        this.generateOption(this.optionDButton, this.buttonPanel, "optionDButton", 'D', 650, 560);
        // optionEButton
        this.generateOption(this.optionEButton, this.buttonPanel, "optionEButton", 'E', 350, 640);
        // optionFButton
        this.generateOption(this.optionFButton, this.buttonPanel, "optionFButton", 'F', 650, 640);
        // optionGButton
        this.generateOption(this.optionGButton, this.buttonPanel, "optionGButton", 'G', 350, 720);
        // optionHButton
        this.generateOption(this.optionHButton, this.buttonPanel, "optionHButton", 'H', 650, 720);
        // optionHButton
        this.generateOption(this.optionIButton, this.buttonPanel, "optionIButton", 'I', 350, 800);
        // optionJButton
        this.generateOption(this.optionJButton, this.buttonPanel, "optionJButton", 'J', 650, 800);
        // optionAMessage
        this.generateOption(this.optionAMessage, this.messagePanel, "optionAMessage", 'A', 350, 800);
        // optionBMessage
        this.generateOption(this.optionBMessage, this.messagePanel, "optionBMessage", 'B', 650, 800);
        // optionAForm
        this.generateOption(this.optionAForm, this.formPanel, "optionAForm", 'A', 350, 800);
        // optionBForm
        this.generateOption(this.optionBForm, this.formPanel, "optionBForm", 'B', 650, 800);
        // optionAList
        this.generateOption(this.optionAList, this.listPanel, "optionAList", 'A', 350, 720);
        // optionBList
        this.generateOption(this.optionBList, this.listPanel, "optionBList", 'B', 650, 720);
        // optionCList
        this.generateOption(this.optionCList, this.listPanel, "optionCList", 'C', 350, 800);
        // optionDList
        this.generateOption(this.optionDList, this.listPanel, "optionDList", 'D', 650, 800);
        // optionACombat
        this.generateOption(this.optionACombat, this.combatPanel, "optionACombat", 'A', 350, 800);
        // optionBCombat
        this.generateOption(this.optionBCombat, this.combatPanel, "optionBCombat", 'B', 650, 800);
        // titlefieldAForm
        this.generateTitleField(this.titlefieldAForm, "titlefieldAForm", 330, 440);
        // titlefieldBForm
        this.generateTitleField(this.titlefieldBForm, "titlefieldBForm", 330, 510);
        // titlefieldCForm
        this.generateTitleField(this.titlefieldCForm, "titlefieldCForm", 330, 580);
        this.pack();
        // default image setter
        this.setDefaultImage();
    }

    /**
     * Generates Field
     * @param fieldLabel JTextField fieldLabel
     * @param x int x
     * @param y int y
     */
    private void generateField(JTextField fieldLabel, int x, int y) {
        fieldLabel.setBounds(x, y, 165, 25);
        fieldLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        this.formPanel.add(fieldLabel);
    }

    /**
     * Generates specificPanel
     * @param specificPanel JPanel specificPanel
     */
    private void generatePanel(JPanel specificPanel) {
        specificPanel.setBackground(new Color(254, 254, 254));
        specificPanel.setMinimumSize(new Dimension(1300, 900));
        specificPanel.setLayout(new AbsoluteLayout());
        this.getContentPane().add(specificPanel, new AbsoluteConstraints(5, 5, 1300, 900));
    }

    /**
     * Generates Text
     * @param textLabel JLabel textLabel
     * @param specificPanel JPanel specificPanel
     * @param text String text
     * @param size int size
     * @param x int x
     * @param y int y
     */
    private void generateText(JLabel textLabel, JPanel specificPanel, String text, int size, int x, int y) {
        textLabel.setBackground(new Color(254, 254, 254));
        textLabel.setFont(new Font("Arial", Font.PLAIN, size));
        textLabel.setForeground(new Color(1, 1, 1));
        textLabel.setHorizontalAlignment(0);
        textLabel.setText(text);
        textLabel.setOpaque(true);
        specificPanel.add(textLabel, new AbsoluteConstraints(x, y, 630, 60));
    }

    /**
     * Generates Image
     * @param imageLabel JLabel imageLabel
     * @param specificPanel JPanel specificPanel
     * @param x int x
     * @param y int y
     */
    private void generateImage(JLabel imageLabel, JPanel specificPanel, int x, int y) {
        imageLabel.setHorizontalAlignment(0);
        imageLabel.setIconTextGap(0);
        specificPanel.add(imageLabel, new AbsoluteConstraints(x, y, 384, 978));
    }

    /**
     * Generates OptionButton
     * @param buttonLabel JLabel buttonLabel
     * @param specificPanel JPanel specificPanel
     * @param optionText String optionText
     * @param optionLetter char optionLetter
     * @param x int x
     * @param y int y
     */
    private void generateOption(JLabel buttonLabel, JPanel specificPanel, String optionText, char optionLetter, int x, int y) {
        buttonLabel.setBackground(new Color(254, 254, 254));
        buttonLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonLabel.setForeground(new Color(1, 1, 1));
        buttonLabel.setHorizontalAlignment(0);
        buttonLabel.setText(optionText);
        buttonLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        buttonLabel.setOpaque(true);
        buttonLabel.addMouseListener(new MouseAdapter() {
            /**
             * mouseClicked
             * @param event MouseEvent event
             */
            public void mouseClicked(MouseEvent event) {
                MythArenaGuiScreen.this.clickOption(optionLetter);
            }
        });
        specificPanel.add(buttonLabel, new AbsoluteConstraints(x, y, 298, 78));
    }

    /**
     * Clicks option provided
     * @param optionLetter char optionLetter
     */
    private void clickOption(char optionLetter) {
        this.mythArenaGui.insertChar(optionLetter);
    }

    /**
     * Generates TitleField
     * @param titlefieldLabel JLabel titlefieldLabel
     * @param titlefieldText String titlefieldText
     * @param x int x
     * @param y int y
     */
    private void generateTitleField(JLabel titlefieldLabel, String titlefieldText, int x, int y) {
        titlefieldLabel.setBackground(new Color(254, 254, 254));
        titlefieldLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titlefieldLabel.setForeground(new Color(1, 1, 1));
        titlefieldLabel.setHorizontalAlignment(0);
        titlefieldLabel.setText(titlefieldText);
        titlefieldLabel.setOpaque(true);
        this.formPanel.add(titlefieldLabel, new AbsoluteConstraints(x, y, 630, 60));
    }

    /**
     * Sets DefaultImage for all modes
     */
    private void setDefaultImage() {
        for (int cont = 0; cont != 5; cont++) {
            this.setImage(cont, "/resources/images/logo.png");
        }
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
     * @param imagePath String imagePath
     */
    public void setImage(int number, String imagePath) {
        JLabel imageLabel;
        switch (number) {
            case 0 -> {
                imageLabel = this.imageMessage;
            }
            case 1 -> {
                imageLabel = this.imageForm;
            }
            case 2 -> {
                imageLabel = this.imageButton;
            }
            case 3 -> {
                imageLabel = this.imageList;
            }
            case 4 -> {
                imageLabel = this.imageCombat;
            }
            default -> throw new IllegalStateException("Unexpected value: " + number);
        }
        if (imagePath == null) {
            imageLabel.setVisible(false);
        } else {
            imageLabel.setText("");
            ImageIcon image = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(imagePath)));
            int[] proportions = this.getProportions(image.getIconWidth(), image.getIconHeight(), imageLabel.getWidth(), imageLabel.getHeight());
            Image scaledImage = image.getImage().getScaledInstance(proportions[0], proportions[1], 8);
            imageLabel.setIcon(new ImageIcon(scaledImage));
            imageLabel.setVisible(true);
        }
    }

    /**
     * Sets specified field message
     * @param number int number
     * @param message String message
     */
    public void setField(int number, String message) {
        if (message == null) {
            message = "";
        } else {
            message = this.reformatMessage(message);
        }
        switch (number) {
            case 0 -> {
                this.titlefieldAFormText = message;
                this.fieldAForm.setVisible(!"".equals(message));
            }
            case 1 -> {
                this.titlefieldBFormText = message;
                this.fieldBForm.setVisible(!"".equals(message));
            }
            case 2 -> {
                this.titlefieldCFormText = message;
                this.fieldCForm.setVisible(!"".equals(message));
            }
        }
        this.refreshLater();
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
                this.optionAForm.setVisible(!"".equals(message));
                this.optionAList.setVisible(!"".equals(message));
                this.optionACombat.setVisible(!"".equals(message));
            }
            case 1 -> {
                this.optionBText = message;
                this.optionBButton.setVisible(!"".equals(message));
                this.optionBMessage.setVisible(!"".equals(message));
                this.optionBForm.setVisible(!"".equals(message));
                this.optionBList.setVisible(!"".equals(message));
                this.optionBCombat.setVisible(!"".equals(message));
            }
            case 2 -> {
                this.optionCText = message;
                this.optionCButton.setVisible(!"".equals(message));
                this.optionCList.setVisible(!"".equals(message));
            }
            case 3 -> {
                this.optionDText = message;
                this.optionDButton.setVisible(!"".equals(message));
                this.optionDList.setVisible(!"".equals(message));
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
     * Sets ArrayList String list
     * @param list ArrayList String list
     */
    public void setList(ArrayList<String> list) {
        this.listModel.removeAllElements();
        this.listModel.addAll(list);
    }

    /**
     * Gets specified field text
     * @param number int number
     * @return String fieldText
     */
    public String getFieldText(int number) {
        switch (number) {
            case 0 -> {
                return this.fieldAForm.getText();
            }
            case 1 -> {
                return this.fieldBForm.getText();
            }
            case 2 -> {
                return this.fieldCForm.getText();
            }
        }
        return null;
    }

    /**
     * Clear specified field text
     * @param number int number
     */
    public void clearFieldText(int number) {
        switch (number) {
            case 0 -> {
                this.fieldAForm.setText(null);
            }
            case 1 -> {
                this.fieldBForm.setText(null);
            }
            case 2 -> {
                this.fieldCForm.setText(null);
            }
        }
    }

    /**
     * Gets last selected list index
     * @return int index
     */
    public int getLastSelectedListIndex() {
        return this.lastSelectedListindex;
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
            MythArenaGuiScreen.this.titleForm.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.titleButton.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.titleList.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.titleCombat.setText(MythArenaGuiScreen.this.titleText);
            MythArenaGuiScreen.this.descriptionMessage.setText(MythArenaGuiScreen.this.descriptionText);
            MythArenaGuiScreen.this.descriptionForm.setText(MythArenaGuiScreen.this.descriptionText);
            MythArenaGuiScreen.this.descriptionButton.setText(MythArenaGuiScreen.this.descriptionText);
            MythArenaGuiScreen.this.descriptionList.setText(MythArenaGuiScreen.this.descriptionText);
            MythArenaGuiScreen.this.descriptionCombat.setText(MythArenaGuiScreen.this.descriptionText);
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
            MythArenaGuiScreen.this.optionAForm.setText(MythArenaGuiScreen.this.optionAText);
            MythArenaGuiScreen.this.optionBForm.setText(MythArenaGuiScreen.this.optionBText);
            MythArenaGuiScreen.this.optionAList.setText(MythArenaGuiScreen.this.optionAText);
            MythArenaGuiScreen.this.optionBList.setText(MythArenaGuiScreen.this.optionBText);
            MythArenaGuiScreen.this.optionCList.setText(MythArenaGuiScreen.this.optionCText);
            MythArenaGuiScreen.this.optionDList.setText(MythArenaGuiScreen.this.optionDText);
            MythArenaGuiScreen.this.optionACombat.setText(MythArenaGuiScreen.this.optionAText);
            MythArenaGuiScreen.this.optionBCombat.setText(MythArenaGuiScreen.this.optionBText);
            MythArenaGuiScreen.this.titlefieldAForm.setText(MythArenaGuiScreen.this.titlefieldAFormText);
            MythArenaGuiScreen.this.titlefieldBForm.setText(MythArenaGuiScreen.this.titlefieldBFormText);
            MythArenaGuiScreen.this.titlefieldCForm.setText(MythArenaGuiScreen.this.titlefieldCFormText);
        });
    }

    /**
     * Key pressed
     * @param event KeyEvent event
     */
    private void formKeyPressed(KeyEvent event) {
        if (event.getKeyCode() == 116) {
            this.titleMessage.setText(this.titleText);
            this.titleForm.setText(this.titleText);
            this.titleButton.setText(this.titleText);
            this.titleList.setText(this.titleText);
            this.titleCombat.setText(this.titleText);
            this.descriptionMessage.setText(this.descriptionText);
            this.descriptionForm.setText(this.descriptionText);
            this.descriptionButton.setText(this.descriptionText);
            this.descriptionList.setText(this.descriptionText);
            this.descriptionCombat.setText(this.descriptionText);
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
            this.optionAForm.setText(this.optionAText);
            this.optionBForm.setText(this.optionBText);
            this.optionAList.setText(this.optionAText);
            this.optionBList.setText(this.optionBText);
            this.optionCList.setText(this.optionCText);
            this.optionDList.setText(this.optionDText);
            this.optionACombat.setText(this.optionAText);
            this.optionBCombat.setText(this.optionBText);
            this.titlefieldAForm.setText(this.titlefieldAFormText);
            this.titlefieldBForm.setText(this.titlefieldBFormText);
            this.titlefieldCForm.setText(this.titlefieldCFormText);
        }
    }

    /**
     * Shows JPanel messagePanel
     */
    public void showMessagePanel() {
        this.messagePanel.setVisible(true);
        this.formPanel.setVisible(false);
        this.buttonPanel.setVisible(false);
        this.listPanel.setVisible(false);
        this.combatPanel.setVisible(false);
    }

    /**
     * Shows JPanel formPanel
     */
    public void showFormPanel() {
        this.messagePanel.setVisible(false);
        this.formPanel.setVisible(true);
        this.buttonPanel.setVisible(false);
        this.listPanel.setVisible(false);
        this.combatPanel.setVisible(false);
    }

    /**
     * Shows JPanel buttonPanel
     */
    public void showButtonPanel() {
        this.messagePanel.setVisible(false);
        this.formPanel.setVisible(false);
        this.buttonPanel.setVisible(true);
        this.listPanel.setVisible(false);
        this.combatPanel.setVisible(false);
    }

    /**
     * Shows JPanel listPanel
     */
    public void showListPanel() {
        this.messagePanel.setVisible(false);
        this.formPanel.setVisible(false);
        this.buttonPanel.setVisible(false);
        this.listPanel.setVisible(true);
        this.combatPanel.setVisible(false);
    }

    /**
     * Shows JPanel combatPanel
     */
    public void showCombatPanel() {
        this.messagePanel.setVisible(false);
        this.formPanel.setVisible(false);
        this.buttonPanel.setVisible(false);
        this.listPanel.setVisible(false);
        this.combatPanel.setVisible(true);
    }

}
