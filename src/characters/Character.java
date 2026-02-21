package characters;

import fri.shapesge.Obrazok;

public abstract class Character {
    private String entityDirectory;
    private final String entityName;
    private Obrazok miniLook, realLook;
    private String alivePath, deadPath, markedPath;
    private int x, y;
    private int angle = 0;
    private boolean isAlive, isMarked;
    public Character(String entityName, String directory, int x, int y) {
        this.entityName = entityName;
        this.setEntityDirectory(directory);
        this.setLooksPaths();

        this.x = x;
        this.y = y;

        miniLook = new Obrazok(alivePath, this.x, this.y);
        miniLook.zobraz();

        isAlive = true;
        isMarked = false;
    }
    private void setLooksPaths() {
        this.setRealLook();
        this.setAlivePath();
        this.setDeadPath();
        this.setMarkedPath();
    }
    public abstract void setRealLook();
    public void setRealLook(String path) {
        this.realLook = new Obrazok(path, 1000, 0);
    }
    private void setAlivePath() {
        alivePath = entityDirectory + "\\alive.png";
    }
    private void setDeadPath() {
        deadPath = entityDirectory + "\\dead.png";
    }
    private void setMarkedPath() {
        markedPath = entityDirectory + "\\marked.png";
    }
    private void setEntityDirectory(String directory) {
        this.entityDirectory = directory + entityName;
    }
    public void kill() {
        if (isAlive) {
            isAlive = false;
            isMarked = false;
            miniLook.zmenObrazok(deadPath);
        } else {
            isAlive = true;
            isMarked = false;
            miniLook.zmenObrazok(alivePath);
        }
    }
    public void mark() {
        try{
            if(isAlive) {
                if(!isMarked) {
                    isMarked = true;
                    miniLook.zmenObrazok(markedPath);
                    realLook.zobraz();
                } else {
                    isMarked = false;
                    miniLook.zmenObrazok(alivePath);
                    realLook.skry();
                }
            }
        } catch(NullPointerException ex) {
            System.out.println(ex.getMessage());
            if(isAlive) {
                if(!isMarked) {
                    isMarked = true;
                    miniLook.zmenObrazok(markedPath);
                } else {
                    isMarked = false;
                    miniLook.zmenObrazok(alivePath);
                }
            }
        }
    }
    public void moveCharacter(int x, int y) {
        int moveX = x - (x % 50);
        int moveY = y - (y % 50);
        this.x = moveX;
        this.y = moveY;
        miniLook.zmenPolohu(this.x, this.y);
        this.mark();
    }
    public boolean containsCoords(int x, int y) {
        return x >= this.x && x <= this.x + 50 && y >= this.y && y <= this.y + 50;
    }
    public boolean getAlive() {
        return isAlive;
    }
    public boolean getMarked() {
        return isMarked;
    }
    public String getEntityDirectory() { return entityDirectory; }
    public String getEntityName() { return entityName; }
    public void rotateCharacter() {
        angle += 90;
        miniLook.zmenUhol(angle);
    }
    public void redraw() {
        miniLook.skry();
        miniLook.zobraz();
    }
    public void hideCharacter() {
        mark();
        if(miniLook != null) {
            miniLook.skry();
            miniLook = null;
        }
        if(realLook != null) {
            realLook.skry();
            realLook = null;
        }
    }
}
