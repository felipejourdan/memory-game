import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class GameSound {
Clip clip;

    public void menuMusicOn(){
        File music = new File("sample-file-3.wav");
            try{
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(music));
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    public void menuMusicOff() {
        clip.stop();
    }
}