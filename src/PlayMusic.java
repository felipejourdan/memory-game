import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class PlayMusic {
    public void makeSound(){
        File music = new File("sample-file-3.wav");


        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(music));
            clip.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    }

