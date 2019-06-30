package hirohiso.util.graph.structure.edge;

import hirohiso.util.graph.structure.Element;
import hirohiso.util.graph.structure.ElementSet;

public class EdgeSet  extends ElementSet{

    @Override
    public boolean chackEnableClass(Element e) {
        if (e instanceof Edge) {
            return true;
        } else {
            return false;
        }
    }
}
