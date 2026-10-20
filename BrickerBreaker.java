package BrickerBreaker;

import javax.swing.JFrame;

public class BrickerBreaker {

    static JFrame window;

    public static void main(String[] args) {

        window = new JFrame("Brick Breaker");

        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // Show start screen
        showStartScreen();

        window.setVisible(true);
    }

    // Show Start screen
    public static void showStartScreen() {

        StartPanel start = new StartPanel();

        window.getContentPane().removeAll();
        window.add(start);

        window.revalidate();
        window.repaint();
    }

    // Start a new game
    public static void startGame() {

        GamePanel game = new GamePanel();

        window.getContentPane().removeAll();
        window.add(game);

        window.revalidate();
        window.repaint();

        game.requestFocusInWindow();
    }

    // Show Game Over screen
    public static void showGameOver(int score) {

        GameOverPanel gameOver = new GameOverPanel(score);

        window.getContentPane().removeAll();
        window.add(gameOver);

        window.revalidate();
        window.repaint();
    }
}
