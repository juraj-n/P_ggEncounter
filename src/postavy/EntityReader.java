package postavy;

import java.io.File;
import java.util.*;

public class EntityReader {
    public static final String[] entityNames = EntityReader.getEntityNames();
    public static int[] pocitadlo = new int[entityNames.length];
    private static String[] getEntityNames() {
        List<String> fileNames = new ArrayList<>();
        File appereancesFolder = new File("res\\pics\\entita");
        if (appereancesFolder.exists() && appereancesFolder.isDirectory()) {
            String[] directories = appereancesFolder.list((current, name) -> new File(current, name).isDirectory());
            if (directories != null) {
                Collections.addAll(fileNames, directories);
            }
        }
        return fileNames.toArray(new String[0]);
    }
    public static void pridajPocitadlo(int index) {
        pocitadlo[index] += 1;
    }
}
