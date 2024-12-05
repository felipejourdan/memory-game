import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.graphics.Text;
import com.codeforall.online.simplegraphics.mouse.Mouse;
import com.codeforall.online.simplegraphics.mouse.MouseEvent;
import com.codeforall.online.simplegraphics.mouse.MouseEventType;
import com.codeforall.online.simplegraphics.mouse.MouseHandler;
import com.codeforall.online.simplegraphics.pictures.Picture;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Collections;


public class Board implements MouseHandler {

    private int cols; // coluna
    private int rows; // linha
    private Card[][] cards = new Card[cols][rows];
    protected Card firstCard = null;
    protected Card secondCard = null;
    private int cardSize;
    private int margin = 10;
    private Mouse mouse;
    private Picture menu;
    private boolean menuIsOn = false;
    int xMenu;
    int yMenu;
    Alert alert;
    int attempt;
    Text showAttempt;


    public Board(int cols, int rows, int cardSize) {
        this.cols = cols;
        this.rows = rows;
        cards = new Card[rows][cols];
        this.cardSize = cardSize;
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        xMenu = margin;
        yMenu = (int)(rows * (cardSize + margin) + margin);
        alert = new Alert(xMenu + margin, yMenu, 500);
        attempt = 0;
        showAttempt = new Text(xMenu + margin, yMenu + (margin * 2), "Attempts: " + attempt);
        showAttempt.draw();


        init();
    }

    public void init(){
        menu = new Picture(10, 10, "menu.png");
        menu.draw();
        menuIsOn = true;
    }

    public void startGame(int cardSize) {

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

        new Rectangle(xMenu, yMenu, (cardSize * cols + (margin * rows)),100).draw();
        menu.delete();
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

    public void isMatch() {
        Timer timer = new Timer(500, e -> {
            if (firstCard.getId() == secondCard.getId()) {
                alert.showAlert("Par encontrado!", 500);
                firstCard.setMatched(true);
                secondCard.setMatched(true);
            } else {
                firstCard.picture.load(firstCard.backImage());
                secondCard.picture.load(secondCard.backImage());
                firstCard.setRevealed(false);
                secondCard.setRevealed(false);
            }
            attempt++;
            showAttempt.setText("Attempts: " + attempt);
            showAttempt.draw();
            firstCard = null;
            secondCard = null;
            Timer timer2 = new Timer(500, f -> {
            if (checkVictory()) {
                alert.showAlert("Você venceu!", 2000);
                Timer timer3 = new Timer(2000, d -> {
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
    }

    public boolean checkVictory() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!cards[i][j].isMatched()) {
                    return false;
                }
            }
        }
        return true;
    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (menuIsOn) {
            menuIsOn = false;
            startGame(cardSize);
        }

        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY() - 20;

        int row = mouseY / (cardSize + margin);
        int col = mouseX / (cardSize + margin);

        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            Card clickedCard = cards[row][col];
            if (clickedCard != null && clickedCard.contains(mouseX, mouseY)) {
                handleClick(clickedCard);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }
}



