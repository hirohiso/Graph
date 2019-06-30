package hirohiso.util.graph.structure;

import hirohiso.util.graph.structure.edge.Edge;
import hirohiso.util.graph.structure.node.Node;

public class Mapping {
    private Edge edge;
    private Node node1;
    private Node node2;

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public Node getNode1() {
        return node1;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public Node getNode2() {
        return node2;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public Mapping(Edge edge1, Node node1, Node node2) {
        this.edge = edge1;
        this.node1 = node1;
        this.node2 = node2;
    }

}
