import com.codeforall.online.simplegraphics.graphics.Color;
import com.codeforall.online.simplegraphics.graphics.Rectangle;
import org.w3c.dom.css.Rect;

public class Card {

    private String frontImage;
    private String backImage;
    boolean isRevealed;
    boolean isMatched;

    public Card(String frontImage, String backImage, boolean isRevealed, boolean isMatched) {

        this.frontImage = frontImage;
        this.backImage = backImage;
        this.isRevealed = isRevealed;
        this.isMatched = isMatched;
    }

    public String getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(String frontImage) {
        this.frontImage = frontImage;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage() {
        Rectangle rectangle = new Rectangle();
        rectangle.setColor(Color.GRAY);
        rectangle.fill();
        this.backImage = backImage;
    }

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