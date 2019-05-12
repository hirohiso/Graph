package hirohiso.util.graph;

public class LinkedMappingSet extends MappingSet {

    public void add(Mapping func) {
        this.mappingList.add(func);
        this.setEdgeList(func.getNode1(), func.getEdge());
        this.setEdgeList(func.getNode2(), func.getEdge());
        this.setAdjacentNode(func.getNode1(), func.getNode2());
        this.setAdjacentNode(func.getNode2(), func.getNode1());
        this.setEdgeNode(func.getEdge(),func.getNode1(), func.getNode2());
    }
}
