package hirohiso.util.graph;

public class EdgeSet  extends ElementSet{

    @Override
    boolean chackEnableClass(Element e) {
        if (e instanceof Edge) {
            return true;
        } else {
            return false;
        }
    }
}
