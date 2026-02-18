package hudba;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AudioReader {
    public static final String[] audioOptions = getAudioFileNames();
    public static String[] getAudioFileNames() {
        List<String> fileNames = new ArrayList<>();
        File audioFolder = new File("res\\audio");
        if (audioFolder.exists() && audioFolder.isDirectory()) {
            File[] files = audioFolder.listFiles((dir, name) -> name.endsWith(".wav"));
            if (files != null) {
                for (File file : files) {
                    fileNames.add(file.getName().replace(".wav",""));
                }
            }
            // Pridana moznost "Zrus" - vypina prehravanie Clipov v pripade zlovenia
            fileNames.add("Zrus");
        }
        return fileNames.toArray(new String[0]);
    }
}
