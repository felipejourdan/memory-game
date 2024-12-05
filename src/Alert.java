import com.codeforall.online.simplegraphics.graphics.Text;

import javax.swing.*;

public class Alert {
    String message;
    int xAlert;
    int yAlert;
    int time;
    Text text;

    public Alert(int xAlert, int yAlert, int time) {
        this.xAlert = xAlert;
        this.yAlert = yAlert;
        this.time = time;
    }

    public void showAlert(String message, int time) {;
        this.text = new Text(xAlert, yAlert, message);
        text.draw();

        Timer timer = new Timer(time, e -> {
           text.delete();
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void showAlert(int xAlert, int yAlert, String message) {;
        this.text = new Text(xAlert, yAlert, message);
        text.draw();

        Timer timer = new Timer(500, e -> {
            text.delete();
        });
        timer.setRepeats(false);
        timer.start();
    }
}
