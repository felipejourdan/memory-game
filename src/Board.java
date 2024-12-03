import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.mouse.Mouse;
import com.codeforall.online.simplegraphics.pictures.Picture;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board {

    /*public static final int PADDING = 10;*/
    /*private int cellSize = 15;*/
    private int cols; // coluna
    private int rows; // linha
    private ArrayList<Card> cards = new ArrayList<>();
    protected Card firstCard = null;
    protected Card secondCard = null;

    public Board(int cols, int rows, int cardSize) {
        this.cols = cols;
        this.rows = rows;
        initBoard(cardSize);
    }

    public void initBoard(int cardSize) {

        ArrayList<Integer> cardIdList = new ArrayList<>();
        //Map<String, String> idToImageMap = new HashMap<>();

        for(int i = 1; i <= (cols * rows) / 2; i++){
//            String image = Card.getNextImage(); // obtem a proxima imagem
//            String cardId = "card" + i;

            cardIdList.add(i);
            cardIdList.add(i);

            //idToImageMap.put(cardId, image);
        }

        Collections.shuffle(cardIdList);

        int index = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int x = col * (cardSize + 10);
                int y = row * (cardSize + 10);

                int cardId = cardIdList.get(index);
                //String image = idToImageMap.get(cardId);
                cards.add(new Card(x,y,cardSize, cardId, this));
                index++;
            }
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
        for (Card card : cards) {
            if (!card.isMatched) {
                return false;
            }
        }
        return true;
    }

    }



