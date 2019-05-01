package hirohiso.util.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MappingSet {
    private ArrayList<Mapping> mappingList = new ArrayList<Mapping>();
    private HashMap<Node, List<Edge>> egdeMap = new HashMap<Node, List<Edge>>();
    private HashMap<Node, List<Node>> nodeMap = new HashMap<Node, List<Node>>();


    public void add(Mapping func) {
        this.mappingList.add(func);
        this.setEdgeList(func.getNode1(), func.getEdge());
        this.setAdjacentNode(func.getNode1(), func.getNode2());
    }
    private void setEdgeList(Node n1,Edge e){
        List<Edge> list = this.egdeMap.get(n1);
        if (list == null) {
            list = new ArrayList<Edge>();
            this.egdeMap.put(n1, list);
        }
        list.add(e);
    }

    private void setAdjacentNode(Node n1,Node n2){
        List<Node> list = this.nodeMap.get(n1);
        if (list == null) {
            list = new ArrayList<Node>();
            this.nodeMap.put(n1, list);
        }
        list.add(n2);
    }

    /**
     * 指定されたノードから直接参照できる辺を返却する。
     * @param node1
     * @return
     */
    public List<Edge> getEdgeList(Node node1) {
        List<Edge> result = this.egdeMap.get(node1);
        if(result == null){
            result = new ArrayList<Edge>();
        }
        return result;
    }

    /**
     * 指定されたノードから直接参照できるノードを返却する。
     * @param node1
     * @return
     */
    public List<Node> getAdjacentNodeList(Node node1) {
        List<Node> result = this.nodeMap.get(node1);
        if(result == null){
            result = new ArrayList<Node>();
        }
        return result;
    }

}
