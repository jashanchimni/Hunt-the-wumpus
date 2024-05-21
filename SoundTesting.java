import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class SoundTesting {
    private static Clip clip;
    public SoundTesting(String soundFilePath){
        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } 
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    
    public static void playSound(){
        clip.start();
    }
    public static void stopSound() {
            clip.flush();
            clip.close();
    }
}
