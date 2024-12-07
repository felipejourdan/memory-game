public class Main {
    public static void main(String[] args) {

        PlayMusic playMusic = new PlayMusic();
        playMusic.makeSound();
        Game game = new Game(4, 3, 100);
        game.start();

    }
}