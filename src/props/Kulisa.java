package props;

import fri.shapesge.Obrazok;

public class Kulisa {
    private final int x, y, velkost;
    private Obrazok kulisa;
    public Kulisa(int x, int y, int velkost, String pathFile) {
        this.x = x;
        this.y = y;
        this.velkost = velkost;
        String wholePath = "res\\pics\\kulisa\\" + pathFile + ".png";
        kulisa = new Obrazok(wholePath, this.x, this.y);
        kulisa.zobraz();
    }
    public boolean obsahujeSuradnice(int x, int y) {
        return x >= this.x && x <= this.x + this.velkost && y >= this.y && y <= this.y + this.velkost;
    }
    public void skryKulisu() {
        if(kulisa != null) {
            kulisa.skry();
            kulisa = null;
        }
    }
    public void prekresli() {
        kulisa.skry();
        kulisa.zobraz();
    }
    public void skontroluj() {
        if((x + velkost) > 1001) {
            skryKulisu();
        }
    }
}
