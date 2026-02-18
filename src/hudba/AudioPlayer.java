package hudba;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AudioPlayer {
    private static final List<Clip> activeClips = new ArrayList<>();

    // POZOR!! Audio súbory musia byť .wav
    public static void playAudio(String name) {
        if(!activeClips.isEmpty()) {
            stopAudio();
        }
        String pathDone = "res\\audio\\" + name + ".wav";
        try {
            File audioFile = new File(pathDone);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            activeClips.add(clip);
            clip.start();
        } catch (Exception e) {
            stopAudio();
        }
    }
    public static void stopAudio() {
        for(Clip c : activeClips) {
           if(c.isActive()) {
               c.stop();
               activeClips.remove(c);
               break;
           }
        }
    }
}
