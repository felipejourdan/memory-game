import com.codeforall.online.simplegraphics.graphics.Color;
import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.mouse.Mouse;
import com.codeforall.online.simplegraphics.mouse.MouseEvent;
import com.codeforall.online.simplegraphics.mouse.MouseHandler;
import com.codeforall.online.simplegraphics.pictures.Picture;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Card {

    private String frontImage;
    private String backImage = "resources/back.png";
    boolean isRevealed = false;
    boolean isMatched = false;
    private int id;
    protected Picture picture;
    private MyMouse mouse;
    Board board;

//    // Lista estatica para armazenar imagens
//    private static List<String> pairedImages;
//    private static int currentImageIndex = 0;


//    // bloco estatico para iniciar imagens
//    static{
//        String[] imageIndex = new String[19];
//        for(int i = 0; i < imageIndex.length; i++){
//            imageIndex[i] = "resources/" + i + ".png";
//        }
//        // associa 1 imagem para cada par de ID
//        pairedImages = new ArrayList<>();
//        for(String image : imageIndex){
//            pairedImages.add(image);
//            pairedImages.add(image);
//        }
//
//        //embaralha par de imagens
//        Collections.shuffle(pairedImages);
//    }
//
//    public static String getNextImage(){
//        if(currentImageIndex < pairedImages.size()){
//            return pairedImages.get(currentImageIndex++);
//        }else{
//            throw new IllegalStateException("All images has been used");
//        }
//    }

    public Card(int x, int y, int size, int id, Board board) {
        this.id = id;
        this.backImage = backImage;
        this.board = board;

        this.picture = new Picture(x, y, this.backImage);
        picture.draw();
        mouse = new MyMouse(this);
        this.frontImage = "resources/" + id + ".png";
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

}