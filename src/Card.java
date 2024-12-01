import com.codeforall.online.simplegraphics.graphics.Color;
import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.pictures.Picture;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Card {

    private String frontImage;
    private String backImage;
    boolean isRevealed = false;
    boolean isMatched = false;
    private Rectangle rectangle;
    private String id;

    // Lista estatica para armazenar imagens
    private static List<String> pairedImages;
    private static int currentImageIndex = 0;


    // bloco estatico para iniciar imagens
    static{
        String[] imageIndex = new String[19];
        for(int i = 0; i < imageIndex.length; i++){
            imageIndex[i] = "resources/" + i + ".png";
        }
        // associa 1 imagem para cada par de ID
        pairedImages = new ArrayList<>();
        for(String image : imageIndex){
            pairedImages.add(image);
            pairedImages.add(image);
        }

        //embaralha par de imagens
        Collections.shuffle(pairedImages);
    }

    public static String getNextImage(){
        if(currentImageIndex < pairedImages.size()){
            return pairedImages.get(currentImageIndex++);
        }else{
            throw new IllegalStateException("All images has been used");
        }
    }

    public Card(int x, int y, int size, String id, String backImage) {
        this.rectangle = new Rectangle(x,y,size,size);
        this.id = id;
        this.backImage = backImage;

        Picture picture = new Picture(x, y, this.backImage);
        picture.draw();
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