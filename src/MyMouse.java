import com.codeforall.online.simplegraphics.mouse.Mouse;
import com.codeforall.online.simplegraphics.mouse.MouseEvent;
import com.codeforall.online.simplegraphics.mouse.MouseEventType;
import com.codeforall.online.simplegraphics.mouse.MouseHandler;

public class MyMouse implements MouseHandler {

    // representa o mouse
    private Mouse mouse;
    private Card card;

    public void init(){
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(mouseEvent.getY() >= card.getTop() && mouseEvent.getY() <= card.getBottom() && mouseEvent.getX() >= card.getLeft() && mouseEvent.getX() <= card.getRight());

        System.out.println("mouse was clicked");
    }

    public void setCard(Card card){
        this.card = card;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

}
