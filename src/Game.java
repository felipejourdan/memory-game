public class Game {
    private Board board;

    public Game(int cols, int rows, int cardSize) {
        this.board = new Board(cols, rows, cardSize);
    }

    public void start() {
        System.out.println("Jogo iniciado!");
    }
}