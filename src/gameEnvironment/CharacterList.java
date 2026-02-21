package gameEnvironment;

import characters.Character;
import characters.other.Elf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterList {
    private ArrayList<Character> characterList;
    public CharacterList() {
        characterList = new ArrayList<>();
        characterList.add(new Elf());
    }
    public void addCharacter(Character added) {
        characterList.add(added);
    }
    public void removeCharacter(Character removed) {
        characterList.remove(removed);
    }
    public List<Character> getCharacterList() {
        return Collections.unmodifiableList(characterList);
    }
    public void redraw() {
        for(Character character : characterList) {
            character.redraw();
        }
    }
}
