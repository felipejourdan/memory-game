import com.codeforall.online.simplegraphics.graphics.Canvas;
import com.codeforall.online.simplegraphics.graphics.Rectangle;



public class Grid {

    public static final int PADDING = 10;
    private int cellSize = 15;
    private int cols;
    private int rows;
    private Card[] card;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        Rectangle grid = new Rectangle(10, 10, 400, 400);

    }

    public void init() {
        Rectangle field = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
/*        Canvas.setMaxX(400);
        Canvas.setMaxY(600);*/
        field.draw();
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     *
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return PADDING + cellSize * row;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     *
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return PADDING + cellSize * column;
    }





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

