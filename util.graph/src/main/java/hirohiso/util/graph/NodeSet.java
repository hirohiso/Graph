package hirohiso.util.graph;

public class NodeSet extends ElementSet{

    @Override
    boolean chackEnableClass(Element e) {
        if (e instanceof Node) {
            return true;
        } else {
            return false;
        }
    }


}
