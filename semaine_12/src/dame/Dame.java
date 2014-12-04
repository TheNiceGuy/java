package dame;

import dame.DameFrame;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Dame {
    public static void main(String[] args) {
        DameFrame dame = new DameFrame();

        AudioInputStream audio = null;

        try {
            String clipPath = "wav/music.wav";
            audio = AudioSystem.getAudioInputStream(new File(clipPath));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch(UnsupportedAudioFileException err) {
        } catch(IOException err) {
        } catch(LineUnavailableException err) {}

        dame.init();
        dame.createWindow();
        dame.selectPlayerMovement();
        dame.showWindow();

        try {
            audio.close();
        } catch(IOException err) {}
    }
}
