package BrickerBreaker;

import java.awt.Color;

public class GameSettings {

    // Default settings
    // Ball speed, paddle speed, background color, high score, and difficulty

    public static int ballSpeed = 5;
    public static int paddleSpeed = 5;

    public static Color bgColor = Color.BLACK;

    public static int highScore = 0;

    public static String difficulty = "Medium";

    // Apply difficulty settings
    public static void setDifficulty(String level) {

        difficulty = level;

        switch (level) {
            case "Easy":
                ballSpeed = 3;
                paddleSpeed = 7;
                break;

            case "Medium":
                ballSpeed = 5;
                paddleSpeed = 5;
                break;

            case "Hard":
                ballSpeed = 7;
                paddleSpeed = 5;
                break;
        }
    }

    // Update high score
    public static void updateHighScore(int score) {

        if (score > highScore) {
            highScore = score;
        }
    }

    // Choose a brick color that contrasts with the background
    public static Color getBrickColor() {

        if (bgColor.equals(Color.PINK)) {
            return Color.BLACK;
        } else if (bgColor.equals(Color.BLUE)) {
            return Color.YELLOW;
        } else if (bgColor.equals(Color.DARK_GRAY)) {
            return Color.CYAN;
        } else {
            return Color.PINK;
        }
    }
}

