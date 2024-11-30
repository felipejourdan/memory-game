import com.codeforall.online.simplegraphics.graphics.Color;
import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.pictures.Picture;

public class Card {

    private String frontImage;
    private String backImage;
    boolean isRevealed = false;
    boolean isMatched = false;
    private Rectangle rectangle;
    private String id;

    public Card(int x, int y, int size, String id) {
        this.rectangle = new Rectangle(x,y,size,size);
        Picture picture = new Picture(x, y, "1.png" );
        picture.draw();
/*        this.rectangle.setColor(Color.GRAY);
        this.rectangle.fill();*/
        this.id = id;
    }

    public String getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(String frontImage) {
        this.frontImage = frontImage;
    }

    public String getId(){
        return id;
    }

/*
    public String getBackImage() {
        return backImage;
    }

    public void setBackImage() {
        Rectangle rectangle = new Rectangle();
        rectangle.setColor(Color.GRAY);
        rectangle.fill();
        this.backImage = backImage;
    }
*/

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }
}