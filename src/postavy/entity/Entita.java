package postavy.entity;

import postavy.Deletable;
import postavy.EntityReader;
import postavy.Postava;

import java.nio.file.Files;
import java.nio.file.Path;

public class Entita extends Postava implements Deletable {

    public Entita(String entitaName) {
        super(entitaName, "res\\pics\\entita\\", 0, 0);
    }

    @Override
    public void setSkutocnaPodoba() {
        for (int i = 0; i < EntityReader.entityNames.length; i++) {
            if (EntityReader.entityNames[i].equals(getEntitaName())) {
                String realPodoba = getEntitaDirectory() + "\\real" + (EntityReader.pocitadlo[i] + 1) + ".png";
                if (!Files.exists(Path.of(realPodoba))) {
                    EntityReader.pocitadlo[i] = 0;
                    realPodoba = getEntitaDirectory() + "\\real" + (EntityReader.pocitadlo[i] + 1) + ".png";
                }
                setRealPodoba(realPodoba);
                EntityReader.pridajPocitadlo(i);
                break;
            }
        }
    }
    @Override
    public void odstran() {
        skryPostavu();
    }
}
