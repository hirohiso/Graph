package hirohiso.util.graph;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GraphTest {

    @Test
    public void testNodeSetConstruct() {

        NodeSet nodeset = new NodeSet();
        Node node1 = new Node();
        Node node2 = new Node();
        nodeset.add(node1);
        nodeset.add(node2);
        // nodesetがnode1を持っているか確認
        assertTrue(nodeset.has(node1));

        Node node3 = new Node();
        // nodesetがnode3を持っていないか確認
        assertFalse(nodeset.has(node3));
        /*
         * EdgeSet edgeset = new EdgeSet(); Edge edge1 = new Edge();
         * edgeset.add(edge1);
         *
         * MappingSet funcset = new MappingSet(); Mapping func = new
         * Mapping(edge1,node1,node2); funcset.add(func);
         *
         * Graph graph = new Graph(nodeset,edgeset,funcset);
         *
         * //グラフがnode1を持っているか確認 assertTrue(graph.hasNode(node1));
         * //グラフがEdgeを持っているか確認 assertTrue(graph.hasEdge(node1));
         * //グラフのNode1につながっているEdgeにedge1があるか確認
         * assertEquals(edge1,graph.getEgde(node1));
         */
    }

    @Test
    public void testEdgeSetConstruct() {
        EdgeSet edgeset = new EdgeSet();
        Edge edge1 = new Edge();
        edgeset.add(edge1);
        // edgesetがnode1を持っているか確認
        assertTrue(edgeset.has(edge1));
        Edge edge2 = new Edge();
        // edgesetがedge2を持っているか確認
        assertFalse(edgeset.has(edge2));
    }

    @Test
    public void testMappingConstruct() {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        Edge edge1 = new Edge();
        Edge edge2 = new Edge();
        Edge edge3 = new Edge();

        MappingSet funcset = new MappingSet();
        Mapping func = new Mapping(edge1, node1, node2);
        Mapping func2 = new Mapping(edge3, node1, node4);
        funcset.add(func);
        funcset.add(func2);

        List<Edge> list = funcset.getEdgeList(node1);
        assertTrue(list.contains(edge1));
        assertFalse(list.contains(edge2));

        //登録されていないノードのアクセス
        list = funcset.getEdgeList(node3);
        assertFalse(list.contains(edge1));

        List<Node> list2 = funcset.getAdjacentNodeList(node1);
        assertTrue(list2.contains(node2));
        assertFalse(list2.contains(node3));

        list2 = funcset.getAdjacentNodeList(node2);
        assertFalse(list2.contains(node1));

    }

}
