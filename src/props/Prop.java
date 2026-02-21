package props;

import fri.shapesge.Obrazok;

public class Prop {
    private final int x, y, size;
    private Obrazok prop;
    public Prop(int x, int y, int size, String filePath) {
        this.x = x;
        this.y = y;
        this.size = size;
        String wholePath = "res\\pics\\prop\\" + filePath + ".png";
        prop = new Obrazok(wholePath, this.x, this.y);
        prop.zobraz();
    }
    public boolean containsCoords(int x, int y) {
        return x >= this.x && x <= this.x + this.size && y >= this.y && y <= this.y + this.size;
    }
    public void hideProp() {
        if(prop != null) {
            prop.skry();
            prop = null;
        }
    }
    public void redraw() {
        prop.skry();
        prop.zobraz();
    }
    public void checkBounds() {
        if((x + size) > 1001) {
            hideProp();
        }
    }
}
