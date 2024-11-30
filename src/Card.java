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

    public void setBackImage(String backImage) {
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
