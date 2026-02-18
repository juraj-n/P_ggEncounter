package herneProstredie;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WallpaperReader {
    public static final String[] wallpaperOptions = getPozadieNames();
    private static String[] getPozadieNames() {
        List<String> fileNames = new ArrayList<>();
        File picsFolder = new File("res\\pics\\pozadie");
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
