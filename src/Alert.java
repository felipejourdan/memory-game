import com.codeforall.online.simplegraphics.graphics.Text;

import javax.swing.*;

public class Alert {
    String message;
    int xAlert;
    int yAlert;
    Text text;

    public Alert(int xAlert, int yAlert) {
        this.xAlert = xAlert;
        this.yAlert = yAlert;
    }

    public void showAlert(String message) {;
        this.text = new Text(xAlert, yAlert, message);
        text.draw();

        Timer timer = new Timer(500, e -> {
           text.delete();
        });
        timer.setRepeats(false);
        timer.start();
    }
}
