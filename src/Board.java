import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.mouse.Mouse;
import com.codeforall.online.simplegraphics.mouse.MouseEvent;
import com.codeforall.online.simplegraphics.mouse.MouseEventType;
import com.codeforall.online.simplegraphics.mouse.MouseHandler;
import com.codeforall.online.simplegraphics.pictures.Picture;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board implements MouseHandler {

    private int cols; // coluna
    private int rows; // linha
    private Card[][] cards = new Card[cols][rows];
    protected Card firstCard = null;
    protected Card secondCard = null;
    private int cardSize;
    private int margin = 10;
    private Mouse mouse;

    public Board(int cols, int rows, int cardSize) {
        this.cols = cols;
        this.rows = rows;
        this.cards = new Card[rows][cols];
        this.cardSize = cardSize;
        this.mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        initBoard(cardSize);

    }

    public void initBoard(int cardSize) {

        ArrayList<Integer> cardIdList = new ArrayList<>();

        for(int i = 1; i <= (cols * rows) / 2; i++){
            cardIdList.add(i);
            cardIdList.add(i);
        }

        Collections.shuffle(cardIdList);

        int index = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int x = col * (cardSize + margin);
                int y = row * (cardSize + margin);

                cards[row][col] = new Card(x, y, cardSize, cardIdList.get(index), this);
                index++;
            }
            System.out.println("segunda row: " + row);
        }
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
        Timer timer = new Timer(1000, e -> {
            if (firstCard.getId() == secondCard.getId()) {
                System.out.println("Par encontrado!");
                firstCard.setMatched(true);
                secondCard.setMatched(true);
            } else {
                firstCard.picture.load(firstCard.backImage());
                secondCard.picture.load(secondCard.backImage());
                firstCard.setRevealed(false);
                secondCard.setRevealed(false);
            }
            firstCard = null;
            secondCard = null;
            if (checkVictory()) {
                System.out.println("Você venceu!");
            }
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
        // Coordenadas do clique
        int mouseX = (int) mouseEvent.getX();

        int mouseY = (int) mouseEvent.getY() - 20;

        // Calcula a linha e coluna do clique

        int row = mouseY / (cardSize + margin);
        System.out.println(mouseY + " / " + cardSize + " + " + margin + " = " + row);
        int col = mouseX / (cardSize + margin);
        System.out.println(mouseX + " / " + cardSize + " + " + margin + " = " + col);



        // Verifica se a linha e coluna estão dentro dos limites do array
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            Card clickedCard = cards[row][col];
            if (clickedCard != null && clickedCard.contains(mouseX, mouseY)) {
                System.out.println(cards[row][col].getId());
                handleClick(clickedCard); // Processa a lógica do clique
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }
}



