package hirohiso.util.graph.structure.node;

import hirohiso.util.graph.structure.Element;
import hirohiso.util.graph.structure.ElementSet;

public class NodeSet extends ElementSet{

    @Override
    public boolean chackEnableClass(Element e) {
        if (e instanceof Node) {
            return true;
        } else {
            return false;
        }
    }


}
