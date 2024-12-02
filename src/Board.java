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

    public Board(int cols, int rows, int cardSize) {
        this.cols = cols;
        this.rows = rows;
        initBoard(cardSize);
    }

    public void initBoard(int cardSize) {

        //Lista de Ids para as cartas
        ArrayList<String> cardIdList = new ArrayList<>();
        //Map<String, String> idToImageMap = new HashMap<>();

        for(int i = 1; i <= (cols * rows) / 2; i++){
//            String image = Card.getNextImage(); // obtem a proxima imagem
//            String cardId = "card" + i;

            cardIdList.add("card" + i);
            cardIdList.add("card" + i);

            //idToImageMap.put(cardId, image);
        }

        // "embalaralha ordem das cartas"
        Collections.shuffle(cardIdList);

        int index = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int x = col * (cardSize + 10);
                int y = row * (cardSize + 10);

                String cardId = cardIdList.get(index);
                //String image = idToImageMap.get(cardId);

                cards.add(new Card(x,y,cardSize,cardId));
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

}

