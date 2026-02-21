package gameEnvironment;

import fri.shapesge.Obrazok;
import audio.AudioPlayer;
import audio.AudioReader;
import characters.Deletable;
import characters.EntityReader;
import characters.Character;
import characters.entity.Entity;
import props.PropReader;
import props.Prop;
import javax.swing.JOptionPane;

public class GameBoard {
    private Obrazok background;
    private final CharacterList characterList;
    private final PropList propList;
    public GameBoard() {
        background = new Obrazok("res\\pics\\background\\Default.png", 0, 0);
        background.zobraz();

        characterList = new CharacterList();
        propList = new PropList();
    }
    @SuppressWarnings("unused")
    public void mark(int x, int y) {
        for (Character character : characterList.getCharacterList()) {
            if(character.containsCoords(x, y)) {
                character.mark();
                break;
            }
        }
    }
    @SuppressWarnings("unused")
    public void kill(int x, int y) {
        for (Character character : characterList.getCharacterList()) {
            if(character.containsCoords(x, y)) {
                character.kill();
                break;
            }
        }
    }
    @SuppressWarnings("unused")
    public void rotate() {
        for(Character character : characterList.getCharacterList()) {
            if(character.getMarked()) {
                character.rotateCharacter();
                break;
            }
        }
    }
    @SuppressWarnings("unused")
    public void delete() {
        for(Character character : characterList.getCharacterList()) {
            if(character.getMarked() && (character instanceof Deletable)) {
                ((Deletable) character).delete();
                characterList.removeCharacter(character);
                break;
            }
        }
    }
    @SuppressWarnings("unused")
    public void move(int x, int y) {
        for (Character character : characterList.getCharacterList()) {
            if(!character.containsCoords(x, y) && character.getMarked() && character.getAlive()) {
                character.moveCharacter(x, y);
                break;
            }
        }
    }
    @SuppressWarnings("unused")
    public void changeBoard(int x, int y) {
        if(x >= 1000 && x <= 1100 && y >= 400 && y <= 500) {
            // String[] options = {"Zaklad", "Loď", "Tráva", "Mesto", "Dom"};
            int option = JOptionPane.showOptionDialog(null, "What background do you want?", null,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, BackgroundReader.backgroundOptions, BackgroundReader.backgroundOptions[0]);
            if(option != JOptionPane.CLOSED_OPTION) {
                if(background != null) {
                    background.skry();
                    background = null;
                }
                background = new Obrazok("res\\pics\\background\\" + BackgroundReader.backgroundOptions[option] + ".png", 0, 0);
                background.zobraz();
                characterList.redraw();
                propList.redraw();
            }
        }
    }
    @SuppressWarnings("unused")
    public void addEnemy(int x, int y) {
        if(x >= 1100 && x <= 1200 && y >= 400 && y <= 500) {
            // String[] options = {"Zombie", "Skeleton", "Pirat", "Entita"};
            String[] options = EntityReader.entityNames;
            int option = JOptionPane.showOptionDialog(null,"What enemy do you want to add?", null,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (option != JOptionPane.CLOSED_OPTION) {
                characterList.addCharacter(new Entity(options[option]));
            }
        }
    }
    @SuppressWarnings("unused")
    public void addProp(int x, int y) {
        for (Character character : characterList.getCharacterList()) {
            if (character.containsCoords(x, y)) {
                return;
            }
        }
        for (Prop prop : propList.getPropList()) {
            if (prop.containsCoords(x, y)) {
                prop.hideProp();
                propList.removeProp(prop);
                return;
            }
        }
        if(x <= 1000) {
            int surX = x - (x % 50);
            int surY = y - (y % 50);
            int option = JOptionPane.showOptionDialog(null,"Which prop do you want to add?", null,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, PropReader.propOptions, PropReader.propOptions[0]);
            if(option != JOptionPane.CLOSED_OPTION) {
                String[] pomParts = PropReader.propOptions[option].split("-");
                propList.addProp(new Prop(surX, surY, Integer.parseInt(pomParts[1]), PropReader.propOptions[option]));
            }
        }
    }
    @SuppressWarnings("unused")
    public void playAudio(int x, int y) {
        if (x >= 1000 && x <= 1100 && y >= 500 && y <= 600) {
            try{
                int option = JOptionPane.showOptionDialog(null, "Which audio to play?", null,
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, AudioReader.audioOptions, AudioReader.audioOptions[0]);
                AudioPlayer.playAudio(AudioReader.audioOptions[option]);
            }catch(Exception e) {
                System.out.println(e.getMessage());
                AudioPlayer.stopAudio();
            }
        }
    }
}