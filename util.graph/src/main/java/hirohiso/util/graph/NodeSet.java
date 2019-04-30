package hirohiso.util.graph;

import java.util.ArrayList;

public class NodeSet {
    private ArrayList<Node> nodeList = new ArrayList<Node>();

    public void add(Node node) {
        nodeList.add(node);
    }

    public boolean has(Node node) {
        boolean result = this.nodeList.contains(node);
        return result;
    }

}
