package BrickerBreaker;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel {

    JButton restartButton;

    public GameOverPanel() {

        setLayout(null);

        // Restart button
        restartButton = new JButton("Restart");

        restartButton.setBounds(325, 350, 150, 50);

        add(restartButton);

        // Restart game when button is clicked
        restartButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                BrickerBreaker.startGame();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        // Game Over
        g.setColor(Color.WHITE);

        g.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        50
                )
        );

        g.drawString(
                "GAME OVER",
                270,
                250
        );

        // Restart question
        g.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        25
                )
        );

        g.drawString(
                "Would you like to play again?",
                235,
                300
        );
    }
}

