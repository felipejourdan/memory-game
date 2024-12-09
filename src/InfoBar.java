import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.graphics.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InfoBar {
    int attempt;
    Text showAttempt;
    int scorePoints;
    Text showScorePoints;
    Score scoreTable;


    public InfoBar(int xInfoBar, int yInfoBar, int margin, int cardSize, int cols, int rows, Score scoreTable, boolean easyMode) {
        attempt = 0;
        showAttempt = new Text(xInfoBar + margin, yInfoBar + (margin), "Attempts: " + attempt);
        showAttempt.draw();
        if (easyMode) {
            scorePoints = 1500;
        } else {
            scorePoints = 1000;
        }
        showScorePoints = new Text(xInfoBar + margin, yInfoBar + (margin * 3), "Your score is: " + scorePoints);
        showScorePoints.draw();
        this.scoreTable = scoreTable;
        new Rectangle(xInfoBar, yInfoBar, (cardSize * cols + (margin * rows)),cardSize).draw();
        new Text(xInfoBar + (cardSize * 3), yInfoBar + margin, "Best scores").draw();
        showScoreTable(xInfoBar, yInfoBar, cardSize, margin);

    }

    public void showScoreTable(int xInfoBar, int yInfoBar, int cardSize, int margin) {
        ArrayList<String> listScores = scoreTable.getScores();

        /// exceção a cabeça
        if(listScores == null || listScores.size() < 3){
            return;
        }

        /// Realiza a conversão de strings para inteiros, ordenando e convertendo de volta para string.

        ArrayList<Integer> stringsToIntegers = new ArrayList<>();
        for(String score : listScores){
            stringsToIntegers.add(Integer.parseInt(score));
        }

        stringsToIntegers.sort(Collections.reverseOrder());

        ArrayList<String> sortedScores = new ArrayList<>();
        for(Integer score : stringsToIntegers){
            sortedScores.add(score.toString());
        }

        new Text(xInfoBar + (cardSize * 3) + margin, yInfoBar + (margin * 3), "1. " + sortedScores.get(0)).draw();
        new Text(xInfoBar + (cardSize * 3) + margin, yInfoBar + (margin * 5), "2. " + sortedScores.get(1)).draw();
        new Text(xInfoBar + (cardSize * 3) + margin, yInfoBar + (margin * 7), "3. " + sortedScores.get(2)).draw();

    }

    public void resetInfobar(){
        showAttempt.delete();
        showScorePoints.delete();
    }

    public void cheatActivated() {
        scorePoints += 15;
        showScorePoints.setText("Your score is: " + scorePoints);
    }
}
