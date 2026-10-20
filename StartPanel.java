
package BrickerBreaker;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel {

    JButton startButton;
    JButton settingsButton;

    public StartPanel() {

        setLayout(null);

        // Start button
        startButton = new JButton("START");
        startButton.setBounds(325, 350, 150, 50);
        add(startButton);

        // Start game when button is clicked
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                BrickerBreaker.startGame();
            }
        });

        // Settings button
        settingsButton = new JButton("SETTINGS");
        settingsButton.setBounds(325, 420, 150, 50);
        add(settingsButton);

        // Open Settings screen when button is clicked
        settingsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                BrickerBreaker.showSettings();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Background
        g.setColor(GameSettings.bgColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Title
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 50));

        g.drawString("BRICK BREAKER", 220, 250);

        // Instructions
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("Use the arrow keys to move", 250, 300);
    }
}
