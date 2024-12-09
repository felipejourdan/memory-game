import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.graphics.Text;

public class InfoBar {
    int attempt;
    Text showAttempt;
    int scorePoints;
    Text showScorePoints;
    Score scoreTable = new Score();


    public InfoBar(int xMenu, int yMenu, int margin, int cardSize, int cols, int rows) {
        attempt = 0;
        showAttempt = new Text(xMenu + margin, yMenu + (margin * 2), "Attempts: " + attempt);
        showAttempt.draw();
        scorePoints = 1000;
        showScorePoints = new Text(xMenu + margin, yMenu + (margin * 4), "Your score is: " + scorePoints);
        showScorePoints.draw();
        new Rectangle(xMenu, yMenu, (cardSize * cols + (margin * rows)),100).draw();
    }

    public void resetInfobar(){
        showAttempt.delete();
        showScorePoints.delete();
    }
}
