import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.mouse.Mouse;
import com.codeforall.online.simplegraphics.pictures.Picture;

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

        System.out.println(cardIdList);
        Collections.shuffle(cardIdList);
        System.out.println(cardIdList);

        int index = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int x = col * (cardSize + 10);
                int y = row * (cardSize + 10);

                int cardId = cardIdList.get(index);
                //String image = idToImageMap.get(cardId);
                System.out.println("carta sendo criada com: " + cardId);
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
        if (secondCard == null) {
            if (clickedCard.isMatched || clickedCard.isRevealed) {
                System.out.println("carta ja revelada");
                return;
            }

            if (firstCard == null) {
                clickedCard.setRevealed(true);
                firstCard = clickedCard;
                clickedCard.picture.load(clickedCard.getFrontImage());
            } else {
                clickedCard.setRevealed(true);
                secondCard = clickedCard;
                clickedCard.picture.load(clickedCard.getFrontImage());
                isMatch();
            }
        }

    }

    public void isMatch() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

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
        }).start();

    }

}

