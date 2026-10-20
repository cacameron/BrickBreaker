
package BrickerBreaker;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {

    public SettingsPanel() {

        setLayout(null);
        setBackground(Color.BLACK);

        // Title
        JLabel title = new JLabel("SETTINGS", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        title.setBounds(250, 30, 300, 50);
        add(title);

        // Difficulty
        JLabel difficultyLabel = new JLabel("Difficulty:");
        styleLabel(difficultyLabel, 150, 110, 150, 30);

        String[] levels = {"Easy", "Medium", "Hard"};
        JComboBox<String> difficultyBox = new JComboBox<>(levels);

        difficultyBox.setSelectedItem(GameSettings.difficulty);
        difficultyBox.setBounds(350, 110, 200, 30);
        add(difficultyBox);

        difficultyBox.addActionListener(e ->
            GameSettings.setDifficulty(
                (String) difficultyBox.getSelectedItem()
            )
        );

        // Ball speed
        JLabel ballLabel = new JLabel("Ball Speed:");
        styleLabel(ballLabel, 150, 170, 150, 30);

        JSlider ballSlider =
            new JSlider(1, 10, GameSettings.ballSpeed);

        ballSlider.setBounds(330, 165, 250, 45);
        ballSlider.setBackground(Color.BLACK);
        ballSlider.setForeground(Color.WHITE);
        ballSlider.setPaintTicks(true);
        ballSlider.setPaintLabels(true);
        add(ballSlider);

        ballSlider.addChangeListener(e ->
            GameSettings.ballSpeed = ballSlider.getValue()
        );

        // Paddle speed
        JLabel paddleLabel = new JLabel("Paddle Speed:");
        styleLabel(paddleLabel, 150, 230, 170, 30);

        JSlider paddleSlider =
            new JSlider(1, 10, GameSettings.paddleSpeed);

        paddleSlider.setBounds(330, 225, 250, 45);
        paddleSlider.setBackground(Color.BLACK);
        paddleSlider.setForeground(Color.WHITE);
        paddleSlider.setPaintTicks(true);
        paddleSlider.setPaintLabels(true);
        add(paddleSlider);

        paddleSlider.addChangeListener(e ->
            GameSettings.paddleSpeed = paddleSlider.getValue()
        );

        // Background color
        JLabel colorLabel = new JLabel("Background:");
        styleLabel(colorLabel, 150, 300, 170, 30);

        String[] colors = {"Black", "Blue", "Dark Gray", "Green"};
        JComboBox<String> colorBox = new JComboBox<>(colors);

        colorBox.setBounds(350, 300, 200, 30);
        add(colorBox);

        colorBox.addActionListener(e -> {
            String color = (String) colorBox.getSelectedItem();

            switch (color) {
                case "Blue":
                    GameSettings.bgColor = Color.BLUE;
                    break;

                case "Dark Gray":
                    GameSettings.bgColor = Color.DARK_GRAY;
                    break;

                case "Green":
                    GameSettings.bgColor = Color.GREEN;
                    break;

                default:
                    GameSettings.bgColor = Color.BLACK;
            }
        });

        // High score
        JLabel highScoreLabel = new JLabel(
            "High Score: " + GameSettings.highScore,
            SwingConstants.CENTER
        );

        highScoreLabel.setFont(
            new Font("Arial", Font.BOLD, 24)
        );
        highScoreLabel.setForeground(Color.WHITE);
        highScoreLabel.setBounds(250, 360, 300, 35);
        add(highScoreLabel);

        // Back button
        JButton backButton = new JButton("BACK");
        backButton.setBounds(325, 430, 150, 50);
        add(backButton);

        backButton.addActionListener(e ->
            BrickerBreaker.showStartScreen()
        );
    }

    // Format labels
    private void styleLabel(
            JLabel label, int x, int y, int width, int height) {

        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, width, height);
        add(label);
    }
}
