package herneProstredie;

import postavy.Postava;
import postavy.other.Elf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZoznamPostav {
    private ArrayList<Postava> zoznam;
    public ZoznamPostav() {
        zoznam = new ArrayList<>();
        zoznam.add(new Elf());
    }
    public void pridajPostavu(Postava pridavana) {
        zoznam.add(pridavana);
    }
    public void uberPostavu(Postava uberana) {
        zoznam.remove(uberana);
    }
    public List<Postava> getZoznamPostav() {
        return Collections.unmodifiableList(zoznam);
    }
    public void prekresli() {
        for(Postava postava : zoznam) {
            postava.prekresli();
        }
    }
}
