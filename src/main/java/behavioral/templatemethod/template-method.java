package behavioral.templatemethod;

abstract class Game {

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    protected int currentPlayer;
    protected final int numberOfPlayers;

    protected abstract int getWinningPlayer();
    protected abstract void takeTurn();
    protected abstract  void start();
    protected abstract boolean haveWinner();

    public void run() {
        start();
        while(!haveWinner())
            takeTurn();
        System.out.println("Player " + getWinningPlayer() + " wins");
    }

}

class Chess extends Game {

    private int maxTurns = 10;
    private int turn = 1;

    public Chess() {
        super(2);
    }

    @Override
    protected int getWinningPlayer() {
        return 0;
    }

    @Override
    protected void takeTurn() {
        System.out.println("Turn " + (turn++) + " taken by player " + currentPlayer);
        currentPlayer = (currentPlayer + 1) % numberOfPlayers;
    }

    @Override
    protected void start() {
        System.out.println("Starting a game of chess.");
    }

    @Override
    protected boolean haveWinner() {
        return turn == maxTurns;
    }
}

class TemplateMethodDemo {

    public static void main(String[] args) {
        Game game = new Chess();
        game.run();
    }
}