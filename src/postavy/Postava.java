package postavy;

import fri.shapesge.BlokTextu;
import fri.shapesge.Obrazok;

public abstract class Postava {
    private String entitaDirectory;
    private final String entitaName;
    private Obrazok miniPodoba, skutocnaPodoba;
    private String alivePath, deadPath, markedPath;
    private int x, y;
    private int uhol = 0;
    private boolean jeZiva, jeOznacena;
    public Postava(String entitaName, String directory, int x, int y) {
        this.entitaName = entitaName;
        this.setEntitaDirectory(directory);
        this.setPodobyPaths();

        this.x = x;
        this.y = y;

        miniPodoba = new Obrazok(alivePath, this.x, this.y);
        miniPodoba.zobraz();

        jeZiva = true;
        jeOznacena = false;
    }
    private void setPodobyPaths() {
        this.setSkutocnaPodoba();
        this.setAlivePath();
        this.setDeadPath();
        this.setMarkedPath();
    }
    public abstract void setSkutocnaPodoba();
    public void setRealPodoba(String path) {
        this.skutocnaPodoba = new Obrazok(path, 1000, 0);
    }
    private void setAlivePath() {
        alivePath = entitaDirectory + "\\zivy.png";
    }
    private void setDeadPath() {
        deadPath = entitaDirectory + "\\mrtvy.png";
    }
    private void setMarkedPath() {
        markedPath = entitaDirectory + "\\oznaceny.png";
    }
    private void setEntitaDirectory(String directory) {
        this.entitaDirectory = directory + entitaName;
    }
    public void kill() {
        if (jeZiva) {
            jeZiva = false;
            jeOznacena = false;
            miniPodoba.zmenObrazok(deadPath);
        } else {
            jeZiva = true;
            jeOznacena = false;
            miniPodoba.zmenObrazok(alivePath);
        }
    }
    public void mark() {
        try{
            if(jeZiva) {
                if(!jeOznacena) {
                    jeOznacena = true;
                    miniPodoba.zmenObrazok(markedPath);
                    skutocnaPodoba.zobraz();
                } else {
                    jeOznacena = false;
                    miniPodoba.zmenObrazok(alivePath);
                    skutocnaPodoba.skry();
                }
            }
        } catch(NullPointerException ex) {
            System.out.println(ex.getMessage());
            if(jeZiva) {
                if(!jeOznacena) {
                    jeOznacena = true;
                    miniPodoba.zmenObrazok(markedPath);
                } else {
                    jeOznacena = false;
                    miniPodoba.zmenObrazok(alivePath);
                }
            }
        }
    }
    public void presunPostavu(int x, int y) {
        int posunX = x - (x % 50);
        int posunY = y - (y % 50);
        this.x = posunX;
        this.y = posunY;
        miniPodoba.zmenPolohu(this.x, this.y);
        this.mark();
    }
    public boolean obsahujeSuradnice(int x, int y) {
        return x >= this.x && x <= this.x + 50 && y >= this.y && y <= this.y + 50;
    }
    public boolean getZiva() {
        return jeZiva;
    }
    public boolean getOznacena() {
        return jeOznacena;
    }
    public String getEntitaDirectory() { return entitaDirectory; }
    public String getEntitaName() { return entitaName; }
    public void otocPostavu() {
        uhol += 90;
        miniPodoba.zmenUhol(uhol);
    }
    public void prekresli() {
        miniPodoba.skry();
        miniPodoba.zobraz();
    }
    public void skryPostavu() {
        mark();
        if(miniPodoba != null) {
            miniPodoba.skry();
            miniPodoba = null;
        }
        if(skutocnaPodoba != null) {
            skutocnaPodoba.skry();
            skutocnaPodoba = null;
        }
    }
}
