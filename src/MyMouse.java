import com.codeforall.online.simplegraphics.mouse.Mouse;
import com.codeforall.online.simplegraphics.mouse.MouseEvent;
import com.codeforall.online.simplegraphics.mouse.MouseEventType;
import com.codeforall.online.simplegraphics.mouse.MouseHandler;

public class MyMouse implements MouseHandler {
    private Mouse mouse;
    private Card card;


    public MyMouse(Card card) {
        this.card = card;
        init();
    }

    public void init(){
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();

        if (card.contains((int) mouseX, (int) mouseY)) {
                card.board.handleClick(card);
        }
    }

    public void revealCard() {
        card.setRevealed(true);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

}
