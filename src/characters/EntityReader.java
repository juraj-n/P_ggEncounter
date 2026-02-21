package characters;

import java.io.File;
import java.util.*;

public class EntityReader {
    public static final String[] entityNames = EntityReader.getEntityNames();
    public static int[] count = new int[entityNames.length];
    private static String[] getEntityNames() {
        List<String> fileNames = new ArrayList<>();
        File appereancesFolder = new File("res\\pics\\entity");
        if (appereancesFolder.exists() && appereancesFolder.isDirectory()) {
            String[] directories = appereancesFolder.list((current, name) -> new File(current, name).isDirectory());
            if (directories != null) {
                Collections.addAll(fileNames, directories);
            }
        }
        return fileNames.toArray(new String[0]);
    }
    public static void addCount(int index) {
        count[index] += 1;
    }
}
