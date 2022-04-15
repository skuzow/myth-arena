package mytharena.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * MythArenaGuiScreen class extends JFrame
 */
public class MythArenaGuiScreen extends JFrame {

    /**
     * JPanel Main
     */
    private JPanel Main;

    /**
     * JButton loginButton
     */
    private JButton loginButton;

    /**
     * JButton registerButton
     */
    private JButton registerButton;

    /**
     * MythArenaGuiScreen class constructor
     */
    public MythArenaGuiScreen() {
        this.setContentPane(this.Main);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 700);
        ImageIcon logo = new ImageIcon(Objects.requireNonNull(super.getClass().getResource("/resources/images/logo.png")));
        this.setTitle("Myth Arena");
        this.setIconImage(logo.getImage());
        this.setVisible(true);
        this.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
