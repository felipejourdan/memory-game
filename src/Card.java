import com.codeforall.online.simplegraphics.pictures.Picture;

public class Card {

    private String frontImage;
    private String backImage = "back.png";
    boolean isRevealed = false;
    boolean isMatched = false;
    private int id;
    protected Picture picture;
    Board board;
    int y;
    int x;


    public Card(int x, int y, int size, int id, Board board) {
        this.id = id;
        this.backImage = backImage;
        this.board = board;
        this.y = y;
        this.x = x;
        this.picture = new Picture(x, y, this.backImage);
        picture.draw();
        this.frontImage = id + ".png";
    }

    public String backImage(){
        return backImage;
    }

    public String getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(String frontImage) {
        this.frontImage = frontImage;
    }

    public int getId(){
        return id;
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

    public int getTop(){
        return picture.getY();
    }

    public int getBottom(){
        return picture.getY() + picture.getHeight();
    }

    public int getY() {
        return y;
    }

    public int getRight(){
        return picture.getX() + picture.getWidth();
    }

    public int getLeft(){
        return picture.getX();
    }

    public boolean canReveal() {
        return !isRevealed && !isMatched;
    }

    public void reveal() {
        setRevealed(true);
        picture.load(frontImage);
    }

    public void hide() {
        setRevealed(false);
        picture.load(backImage);
    }

    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= getLeft() && mouseX <= getRight() &&
                mouseY >= getTop() && mouseY <= getBottom() + 20;
    }

}