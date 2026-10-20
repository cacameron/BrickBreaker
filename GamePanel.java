package BrickerBreaker;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, Runnable {

    // Paddle
    int paddleX = 350;
    int paddleY = 520;
    int paddleWidth = 100;
    int paddleHeight = 15;

    // Ball
    int ballX = 390;
    int ballY = 480;
    int ballSize = 20;

    int ballXSpeed = 3;
    int ballYSpeed = -3;

    // Keyboard
    boolean leftPressed = false;
    boolean rightPressed = false;

    // Score
    int score = 0;

    // Brick color
    Color brickColor = Color.GREEN;

    // Bricks
    int[][] bricks = new int[4][8];

    Thread gameThread;

    public GamePanel() {

        setFocusable(true);
        addKeyListener(this);

        // Create bricks
        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 8; col++) {

                bricks[row][col] = 1;
            }
        }

        // Start game
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Background
        g.setColor(GameSettings.bgColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));

        g.drawString("Score: " + score, 20, 30);

        // Paddle
        g.setColor(Color.WHITE);

        g.fillRect(
                paddleX,
                paddleY,
                paddleWidth,
                paddleHeight
        );

        // Ball
        g.setColor(Color.WHITE);

        g.fillOval(
                ballX,
                ballY,
                ballSize,
                ballSize
        );

        // Bricks
        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 8; col++) {

                if (bricks[row][col] == 1) {

                    int brickX = col * 100;
                    int brickY = row * 30 + 50;

                  
                    // Brick color based on selected background
                    g.setColor(GameSettings.getBrickColor());
                    g.fillRect(
                            brickX + 2,
                            brickY + 2,
                            96,
                            26
                    );
                }
            }
        }
    }

    @Override
    public void run() {

        while (true) {

            // Move paddle
            if (leftPressed) {
                paddleX -= 5;
            }

            if (rightPressed) {
                paddleX += 5;
            }

            // Keep paddle inside window
            if (paddleX < 0) {
                paddleX = 0;
            }

            if (paddleX > 700) {
                paddleX = 700;
            }

            // Move ball
            ballX += ballXSpeed;
            ballY += ballYSpeed;

            // Left wall
            if (ballX <= 0) {
                ballXSpeed = -ballXSpeed;
            }

            // Right wall
            if (ballX >= 780) {
                ballXSpeed = -ballXSpeed;
            }

            // Top wall
            if (ballY <= 0) {
                ballYSpeed = -ballYSpeed;
            }

            // Paddle collision
            if (ballY + ballSize >= paddleY &&
                ballX + ballSize >= paddleX &&
                ballX <= paddleX + paddleWidth) {

                ballYSpeed = -ballYSpeed;
            }

            // Brick collision
            for (int row = 0; row < 4; row++) {

                for (int col = 0; col < 8; col++) {

                    if (bricks[row][col] == 1) {

                        int brickX = col * 100;
                        int brickY = row * 30 + 50;

                        if (ballX + ballSize >= brickX &&
                            ballX <= brickX + 100 &&
                            ballY + ballSize >= brickY &&
                            ballY <= brickY + 30) {

                            // Remove brick
                            bricks[row][col] = 0;

                            // Add 10 points
                            score += 10;

                            // Bounce ball
                            ballYSpeed = -ballYSpeed;
                        }
                    }
                }
            }

            // Ball misses the paddle
            if (ballY + ballSize >= paddleY + paddleHeight) {

                break;
            }

            // Redraw game
            repaint();

            // Game speed
            try {

                Thread.sleep(10);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

        // Show Game Over
        BrickerBreaker.showGameOver(score);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}