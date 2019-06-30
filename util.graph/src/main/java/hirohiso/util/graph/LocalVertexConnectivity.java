package hirohiso.util.graph;

import java.util.HashMap;
import java.util.List;

import hirohiso.util.graph.structure.Element;
import hirohiso.util.graph.structure.Graph;
import hirohiso.util.graph.structure.Mapping;
import hirohiso.util.graph.structure.MappingSet;
import hirohiso.util.graph.structure.edge.AbstractEdge;
import hirohiso.util.graph.structure.edge.CostEdge;
import hirohiso.util.graph.structure.edge.Edge;
import hirohiso.util.graph.structure.edge.EdgeSet;
import hirohiso.util.graph.structure.node.Node;
import hirohiso.util.graph.structure.node.NodeSet;

public class LocalVertexConnectivity {
    private Graph originalGraph;;

    public LocalVertexConnectivity(Graph graph) {
        this.originalGraph = graph;
    }

    //コストなし無向グラフを辺にコストを1持つ有向グラフに変換する
    public Graph transferDirectedGraph() {
        List<Element> orignalNode = this.originalGraph.getNodeset().getElementList();
        List<Element> orignalEdge = this.originalGraph.getEdgeset().getElementList();
        MappingSet originalMapping = this.originalGraph.getMappingset();

        NodeSet targetNodeSet = new NodeSet();
        EdgeSet targetEdgeSet = new EdgeSet();
        MappingSet targetMappingSet = new MappingSet();
        //変換前と変換後のノードの紐付け用
        HashMap<Element, Node> NodeIn = new HashMap<Element, Node>();
        HashMap<Element, Node> NodeOut = new HashMap<Element, Node>();

        //Vnをもとに、Vn_inとVn_outを作成
        //E → Vn_in×Vn_out となるコスト1の辺を作成する
        for(Element node :orignalNode){
            //Vn_in
            Node in = new Node();
            //Vn_out
            Node out = new Node();
            targetNodeSet.add(in);
            targetNodeSet.add(out);
            AbstractEdge edge1 = new CostEdge(1);
            targetEdgeSet.add(edge1);
            Mapping map = new Mapping((AbstractEdge) edge1, in, out);
            targetMappingSet.add(map);

            //次の処理のために、Vn→Vn_inとVn_outの紐付けを格納しておく
            NodeIn.put(node, in);
            NodeOut.put(node, out);
        }

        //E(E→Vn×Vm)をもとに
        //E1 → Vn_out Vm_inとなるコスト1の辺を作成する
        //E2 → Vm_out Vn_inとなるコスト1の辺を作成する
        for(Element edge :orignalEdge){
            AbstractEdge edge1 = new CostEdge(1);
            AbstractEdge edge2 = new CostEdge(1);
            targetEdgeSet.add(edge1);
            targetEdgeSet.add(edge2);

            List<Node> nodelist =  originalMapping.getNodeList((Edge)edge);
            Node Vn = nodelist.get(0);
            Node Vm = nodelist.get(1);

            //前処理で格納しておいた紐付けからin、outを取得する
            Node vn_in = NodeIn.get(Vn);
            Node vn_out = NodeOut.get(Vn);
            Node vm_in = NodeIn.get(Vm);
            Node vm_out = NodeOut.get(Vm);

            Mapping map1 = new Mapping((AbstractEdge) edge1, vn_out, vm_in);
            Mapping map2 = new Mapping((AbstractEdge) edge2, vm_out, vn_in);
            targetMappingSet.add(map1);
            targetMappingSet.add(map2);
        }
        Graph graph = new Graph(targetNodeSet, targetEdgeSet, targetMappingSet);
        return graph;
    }

}
