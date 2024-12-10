import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class GameSound {
Clip musicMenu;
Clip click;

    public void menuMusicOn(){
        File music = new File("resources/sounds/sample-file-3.wav");
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
        File sound = new File("resources/sounds/cardClick.wav");

        try{
            click = AudioSystem.getClip();
            click.open(AudioSystem.getAudioInputStream(sound));
            click.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cheatSound() {
        File cheatSound = new File("resources/sounds/cheatSound.wav");

        try{
            Clip cheatSoundInit = AudioSystem.getClip();
            cheatSoundInit.open(AudioSystem.getAudioInputStream(cheatSound));
            cheatSoundInit.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void victorySound() {
        File sound = new File("resources/sounds/victorySound.wav");

        try{
            Clip victorySound = AudioSystem.getClip();
            victorySound.open(AudioSystem.getAudioInputStream(sound));
            victorySound.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void easyModeActivatedSound() {
        File sound = new File("resources/sounds/easyMode.wav");
        menuMusicOff();
        try{
            Clip easyModeSound = AudioSystem.getClip();
            easyModeSound.open(AudioSystem.getAudioInputStream(sound));
            easyModeSound.start();
        } catch (Exception e){
            e.printStackTrace();
        }
        Timer timer = new Timer(1000, f -> {
        menuMusicOn();
        });
        timer.setRepeats(false);
        timer.start();
    }
}