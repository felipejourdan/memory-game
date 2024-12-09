import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class GameSound {
Clip musicMenu;
Clip click;

    public void menuMusicOn(){
        File music = new File("resources/sample-file-3.wav");
            try{
                musicMenu = AudioSystem.getClip();
                musicMenu.open(AudioSystem.getAudioInputStream(music));
                musicMenu.start();
                musicMenu.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    public void menuMusicOff() {
        musicMenu.stop();
    }

    public void clickSound() {
        File sound = new File("resources/cardClick.wav");

        try{
            click = AudioSystem.getClip();
            click.open(AudioSystem.getAudioInputStream(sound));
            click.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void victorySound() {
        File sound = new File("resources/victorySound.wav");

        try{
            Clip victorySound = AudioSystem.getClip();
            victorySound.open(AudioSystem.getAudioInputStream(sound));
            victorySound.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}