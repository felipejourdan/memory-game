import com.codeforall.online.simplegraphics.graphics.Text;

public class InfoBar {
    int attempt;
    Text showAttempt;
    int scorePoints;
    Text showScorePoints;
    Score scoreTable = new Score();


    public InfoBar(int xMenu, int yMenu, int margin) {
        attempt = 0;
        showAttempt = new Text(xMenu + margin, yMenu + (margin * 2), "Attempts: " + attempt);
        showAttempt.draw();
        scorePoints = 1000;
        showScorePoints = new Text(xMenu + margin, yMenu + (margin * 4), "Your score is: " + scorePoints);
        showScorePoints.draw();
    }

    public void resetInfobar(){
        showAttempt.delete();
        showScorePoints.delete();
    }
}
