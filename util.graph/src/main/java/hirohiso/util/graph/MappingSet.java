package hirohiso.util.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MappingSet {
    protected ArrayList<Mapping> mappingList = new ArrayList<Mapping>();
    protected HashMap<Node, List<Edge>> egdeMap = new HashMap<Node, List<Edge>>();
    protected HashMap<Node, List<Node>> nodeMap = new HashMap<Node, List<Node>>();
    protected HashMap<Element, List<Node>> edgenodeMap = new HashMap<Element, List<Node>>();


    public void add(Mapping func) {
        this.mappingList.add(func);
        this.setEdgeList(func.getNode1(), func.getEdge());
        this.setAdjacentNode(func.getNode1(), func.getNode2());
        this.setEdgeNode(func.getEdge(),func.getNode1(), func.getNode2());
    }

    protected void setEdgeNode(Edge edge, Node node1, Node node2) {
        List<Node> list = this.edgenodeMap.get(edge);
        if (list == null) {
            list = new ArrayList<Node>();
            this.edgenodeMap.put((Element)edge, list);
        }
        list.add(node1);
        list.add(node2);
    }
    protected void setEdgeList(Node n1,Edge e){
        List<Edge> list = this.egdeMap.get(n1);
        if (list == null) {
            list = new ArrayList<Edge>();
            this.egdeMap.put(n1, list);
        }
        list.add(e);
    }

    protected void setAdjacentNode(Node n1,Node n2){
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

    /**
     * 指定された辺が接続しているノードを返却する。
     * @param e
     * @return
     */
    public List<Node> getNodeList(Element e) {
        List<Node> result = this.edgenodeMap.get(e);
        if(result == null){
            result = new ArrayList<Node>();
        }
        return result;
    }


}
