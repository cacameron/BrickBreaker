package BrickerBreaker;

public class Score {

    private int score;

    // Start the score at 0
    public Score() {
        score = 0;
    }

    // Add 10 points
    public void addPoints() {
        score += 10;
    }

    // Get the current score
    public int getScore() {
        return score;
    }
}

