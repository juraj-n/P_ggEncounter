package props;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class PropReader {
    public static final String[] propOptions = getPropNames();
    private static String[] getPropNames() {
        List<String> fileNames = new ArrayList<>();
        File propFolder = new File("res\\pics\\kulisa");
        if (propFolder.exists() && propFolder.isDirectory()) {
            File[] files = propFolder.listFiles((dir, name) -> name.endsWith(".png"));
            if (files != null) {
                for (File file : files) {
                    //fileNames.add(file.getName().replaceAll("-\\d+\\.png$", ""));
                    fileNames.add(file.getName().replace(".png",""));
                }
            }
        }

        return fileNames.toArray(new String[0]);
    }
}
