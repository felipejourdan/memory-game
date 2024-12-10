import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.keyboard.Keyboard;
import com.codeforall.online.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.online.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.online.simplegraphics.keyboard.KeyboardHandler;
import com.codeforall.online.simplegraphics.mouse.Mouse;
import com.codeforall.online.simplegraphics.mouse.MouseEvent;
import com.codeforall.online.simplegraphics.mouse.MouseEventType;
import com.codeforall.online.simplegraphics.mouse.MouseHandler;
import com.codeforall.online.simplegraphics.pictures.Picture;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Collections;


public class Board implements MouseHandler, KeyboardHandler {

    private int cols; // coluna
    private int rows; // linha
    private Card[][] cards = new Card[cols][rows];
    protected Card firstCard = null;
    protected Card secondCard = null;
    private int cardSize;
    private int margin = 10;
    private Mouse mouse;
    private Keyboard keyboard;
    private Picture menu;
    private boolean menuIsOn = false;
    int xInfoBar;
    int yInfoBar;
    Alert alert;
    InfoBar infoBar;
    Score scoreTable = new Score();
    GameSound gameSound = new GameSound();
    boolean easyMode = false;

    public Board(int cols, int rows, int cardSize) {
        this.cols = cols;
        this.rows = rows;
        this.cardSize = cardSize;
        cards = new Card[rows][cols];
        xInfoBar = margin;
        yInfoBar = (int)(rows * (cardSize + margin) + margin);
        alert = new Alert(xInfoBar + margin, yInfoBar + (margin * 7), 500);
        initMouseAndKeyboard();
        init();

    }

    public void initMouseAndKeyboard() {
        mouse = new Mouse(this);
        keyboard = new Keyboard(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

        KeyboardEvent spacePressEvent = new KeyboardEvent();
        spacePressEvent.setKey(KeyboardEvent.KEY_SPACE);
        spacePressEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spacePressEvent);

        KeyboardEvent escapePressEvent = new KeyboardEvent();
        escapePressEvent.setKey(KeyboardEvent.KEY_ESC);
        escapePressEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(escapePressEvent);




    }

    public void init(){
        menu = new Picture(10, 10, "menu.png");
        menu.draw();
        menuIsOn = true;
        gameSound.menuMusicOn();
    }

    public void startGame() {
        ArrayList<Integer> cardIdList = new ArrayList<>();

        for(int i = 1; i <= (cols * rows) / 2; i++){
            cardIdList.add(i);
            cardIdList.add(i);
        }

        Collections.shuffle(cardIdList);

        int index = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int x = (col * (cardSize + margin) + margin);
                int y = (row * (cardSize + margin) + margin);

                cards[row][col] = new Card(x, y, cardSize, cardIdList.get(index), this);
                index++;
            }
        }

        menu.delete();
        this.infoBar = new InfoBar(xInfoBar, yInfoBar, margin, cardSize, cols, rows, scoreTable, easyMode);
        gameSound.menuMusicOff();

    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public void handleClick(Card clickedCard) {
        if (secondCard == null && clickedCard.canReveal()) {
            clickedCard.reveal();

            if (firstCard == null) {
                firstCard = clickedCard;
            } else {
                secondCard = clickedCard;
                isMatch();
            }
        }
    }


    public void scoreSend(){
        String scoreString = String.valueOf(getPoints());
        scoreTable.scoreAdd(scoreString);
    }

    public int getPoints(){
        return infoBar.scorePoints;
    }

    public boolean checkVictory() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!cards[i][j].isMatched()) {
                    return false;
                }
            }
        }
        gameSound.victorySound();
        infoBar.resetInfobar();
        scoreSend();
        return true;
    }

    public void exitGame() {
        System.exit(0);
    }

    public void isMatch() {
        Timer timer = new Timer(500, e -> {
            if (firstCard.getId() == secondCard.getId()) {
                alert.showAlert("Cards match!", 500);
                firstCard.setMatched(true);
                secondCard.setMatched(true);
                infoBar.scorePoints += 50;
                /*System.out.println(scorePoints);*/
            } else {
                firstCard.picture.load(firstCard.backImage());
                secondCard.picture.load(secondCard.backImage());
                firstCard.setRevealed(false);
                secondCard.setRevealed(false);
                infoBar.scorePoints -= 65;
                /*System.out.println(scorePoints);*/
            }
            infoBar.attempt++;
            infoBar.showAttempt.setText("Attempts: " + infoBar.attempt);
            infoBar.showAttempt.draw();
            infoBar.showScorePoints.setText("Your score is: " + infoBar.scorePoints);
            infoBar.showScorePoints.draw();
            firstCard = null;
            secondCard = null;
            Timer timer2 = new Timer(500, f -> {
            if (checkVictory()) {
                alert.showAlert("You Win!", 3000);
                Timer timer3 = new Timer(3500, d -> {
                    new Board(cols, rows, cardSize);
                });
                timer3.setRepeats(false);
                timer3.start();
            } });
            timer2.setRepeats(false);
            timer2.start();
        });
        timer.setRepeats(false);
        timer.start();
        if (infoBar.scorePoints == 0){
            alert.showAlert("No more points left!! Game over!!", 500);
            Timer timer3 = new Timer(500, d -> {
                new Board(cols, rows, cardSize);
            });
            timer3.setRepeats(false);
            timer3.start();
            menuIsOn = true;
        }
    }



    @Override
        public void mouseClicked(MouseEvent mouseEvent) {
    //        System.out.println("X: " + mouseEvent.getX());
    //        System.out.println("Y: " + mouseEvent.getY());

                //easyMode
                if ((mouseEvent.getX() >= 160 && mouseEvent.getX() <= 186)
                        && (mouseEvent.getY() >= 285 && mouseEvent.getY() <= 310) ||
                        (mouseEvent.getX() >= 271 && mouseEvent.getX() <= 298)
                                && (mouseEvent.getY() >= 316 && mouseEvent.getY() <= 340)) {
                    if (!easyMode) {
                    easyMode = true;
                    gameSound.easyModeActivatedSound();
                    }
                }

                //start game
                if ((mouseEvent.getX() >= 114 && mouseEvent.getX() <= 338)
                        && (mouseEvent.getY() >= 410 && mouseEvent.getY() <= 435)) {

                    if (menuIsOn) {
                        menuIsOn = false;
                        startGame();
                    }
                }

                //cardClick
                int mouseX = (int) mouseEvent.getX();
                int mouseY = (int) mouseEvent.getY() - 20;
                int row = mouseY / (cardSize + margin);
                int col = mouseX / (cardSize + margin);
                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    Card clickedCard = cards[row][col];
                    if (clickedCard != null && clickedCard.contains(mouseX, mouseY)) {
                        handleClick(clickedCard);
                        gameSound.clickSound();
                    }
                }
        }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
            infoBar.cheatActivated();
            gameSound.cheatSound();
           if (keyboardEvent.getKey() == KeyboardEvent.KEY_ESC) {
               exitGame();
           }}

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}




