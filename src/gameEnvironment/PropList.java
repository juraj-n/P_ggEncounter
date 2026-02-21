package gameEnvironment;

import props.Prop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PropList {
    private ArrayList<Prop> propList;
    public PropList() {
        propList = new ArrayList<>();
    }
    public void addProp(Prop added) {
        propList.add(added);
    }
    public void removeProp(Prop removed) {
        propList.remove(removed);
    }
    public List<Prop> getPropList() {
        return Collections.unmodifiableList(propList);
    }
    public void redraw() {
        for(Prop prop : propList) {
            prop.redraw();
        }
    }
}
