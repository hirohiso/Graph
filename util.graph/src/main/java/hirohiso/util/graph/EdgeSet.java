package hirohiso.util.graph;

import java.util.ArrayList;

public class EdgeSet {
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();

    public void add(Edge edge) {
        this.edgeList.add(edge);

    }

    public boolean has(Edge edge) {
        boolean result = this.edgeList.contains(edge);
        return result;
    }

}
