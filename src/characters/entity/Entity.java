package characters.entity;

import characters.Deletable;
import characters.EntityReader;
import characters.Character;

import java.nio.file.Files;
import java.nio.file.Path;

public class Entity extends Character implements Deletable {

    public Entity(String entityName) {
        super(entityName, "res\\pics\\entity\\", 0, 0);
    }

    @Override
    public void setRealLook() {
        for (int i = 0; i < EntityReader.entityNames.length; i++) {
            if (EntityReader.entityNames[i].equals(getEntityName())) {
                String realPodoba = getEntityDirectory() + "\\real" + (EntityReader.count[i] + 1) + ".png";
                if (!Files.exists(Path.of(realPodoba))) {
                    EntityReader.count[i] = 0;
                    realPodoba = getEntityDirectory() + "\\real" + (EntityReader.count[i] + 1) + ".png";
                }
                setRealLook(realPodoba);
                EntityReader.addCount(i);
                break;
            }
        }
    }
    @Override
    public void delete() {
        hideCharacter();
    }
}
