package herneProstredie;

import props.Kulisa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZoznamProps {
    private ArrayList<Kulisa> zoznam;
    public ZoznamProps() {
        zoznam = new ArrayList<>();
    }
    public void pridajKulisu(Kulisa pridavana) {
        zoznam.add(pridavana);
    }
    public void uberKulisu(Kulisa uberana) {
        zoznam.remove(uberana);
    }
    public List<Kulisa> getZoznamProps() {
        return Collections.unmodifiableList(zoznam);
    }
    public void prekresli() {
        for(Kulisa kulisa : zoznam) {
            kulisa.prekresli();
        }
    }
}
