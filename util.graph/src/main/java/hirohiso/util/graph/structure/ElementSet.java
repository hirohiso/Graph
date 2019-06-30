package hirohiso.util.graph.structure;

import java.util.ArrayList;

public abstract class ElementSet {
    private ArrayList<Element> elementList = new ArrayList<Element>();
    public abstract boolean chackEnableClass(Element e);

    public void add(Element node) {
        if(!chackEnableClass(node)){
            throw new IllegalArgumentException();
        }
        elementList.add(node);
    }

    public boolean has(Element node) {
        boolean result = this.elementList.contains(node);
        return result;
    }

    public int length() {
        return elementList.size();
    }

    public ArrayList<Element> getElementList() {
        return this.elementList;
    }

}
