import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.graphics.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class InfoBar {
    int attempt;
    Text showAttempt;
    int scorePoints;
    Text showScorePoints;
    Score scoreTable;


    public InfoBar(int xInfoBar, int yInfoBar, int margin, int cardSize, int cols, int rows, Score scoreTable) {
        attempt = 0;
        showAttempt = new Text(xInfoBar + margin, yInfoBar + (margin), "Attempts: " + attempt);
        showAttempt.draw();
        scorePoints = 1000;
        showScorePoints = new Text(xInfoBar + margin, yInfoBar + (margin * 3), "Your score is: " + scorePoints);
        showScorePoints.draw();
        this.scoreTable = scoreTable;
        new Rectangle(xInfoBar, yInfoBar, (cardSize * cols + (margin * rows)),cardSize).draw();
        new Text(xInfoBar + (cardSize * 3), yInfoBar + margin, "Best scores").draw();
        showScoreTable(xInfoBar, yInfoBar, cardSize, margin);
    }

    public void showScoreTable(int xInfoBar, int yInfoBar, int cardSize, int margin) {
        ArrayList listScores = scoreTable.getScores();
        Collections.sort(listScores, Collections.reverseOrder());

        new Text(xInfoBar + (cardSize * 3) + margin, yInfoBar + (margin * 3), "1. " + listScores.get(0)).draw();
        new Text(xInfoBar + (cardSize * 3) + margin, yInfoBar + (margin * 5), "2. " + listScores.get(1)).draw();
        new Text(xInfoBar + (cardSize * 3) + margin, yInfoBar + (margin * 7), "3. " + listScores.get(2)).draw();

    }

    public void resetInfobar(){
        showAttempt.delete();
        showScorePoints.delete();
    }
}
