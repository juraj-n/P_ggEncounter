package gameEnvironment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BackgroundReader {
    public static final String[] backgroundOptions = getBackgroundName();
    private static String[] getBackgroundName() {
        List<String> fileNames = new ArrayList<>();
        File picsFolder = new File("res\\pics\\background");
        if (picsFolder.exists() && picsFolder.isDirectory()) {
            File[] files = picsFolder.listFiles((dir, name) -> name.endsWith(".png"));
            if (files != null) {
                for (File file : files) {
                    fileNames.add(file.getName().replace(".png",""));
                }
            }
        }
        return fileNames.toArray(new String[0]);
    }
}
