import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    /*public static final int PADDING = 10;*/
    /*private int cellSize = 15;*/
    private int cols; // coluna
    private int rows; // linha
    private ArrayList<Card> cards = new ArrayList<>();

    public Board(int cols, int rows, int cardSize){
        this.cols = cols;
        this.rows = rows;
        /*Rectangle board = new Rectangle(10, 10, 400, 400);*/
        initBoard(cardSize);
    }

    public void initBoard(int cardSize) {

        ArrayList<String> cardId = new ArrayList<>();

        for(int i = 1; i <= (cols*rows) / 2;i++){
            cardId.add("card" + i);
            cardId.add("card" + i);
        }

        Collections.shuffle(cardId); // "embalaralha ordem das cartas"

        int index = 0;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int x = col * (cardSize + 10);
                int y = row * (cardSize + 10);

               cards.add(new Card(x, y, cardSize, cardId.get(index)));
                 System.out.println(cards.get(index).getId());
                 index++;
            }
        }
    }

/*    public int getCellSize() {
        return cellSize;
    }*/

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }


/*
    public int rowToY(int row) {
        return PADDING + cellSize * row;
    }

    public int columnToX(int column) {
        return PADDING + cellSize * column;
    }

*/




/*    public void initGrid() {
        card = new Card[9];
        int i;
        for (i = 0; i < card.length; i++) {
            card[i].getBackImage();
*//*            for(int j = 0; j < card.length; j++){

            }*//*

        }
        return ;
    }

 *//*   Rectangle grid = new Rectangle(10, 10 , 400, 400);
        grid.draw();

    Rectangle card1 = new Rectangle(20, 40, 70, 50);
        card1.setColor(Color.GRAY);
        card1.fill();*/
}

