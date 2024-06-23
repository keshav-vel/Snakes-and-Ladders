package app.src.main.events;

public class Game implements GameEvents {
    public void endGame() {
        System.exit(1);
    }
}