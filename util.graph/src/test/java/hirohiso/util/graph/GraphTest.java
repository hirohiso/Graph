package hirohiso.util.graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

    @Test
    public void testNodeSetConstruct() {

        NodeSet nodeset = new NodeSet();
        Node node1 = new Node();
        Node node2 = new Node();
        nodeset.add(node1);
        nodeset.add(node2);
        //nodesetがnode1を持っているか確認
        assertTrue(nodeset.has(node1));

        Node node3 = new Node();
        //nodesetがnode3を持っていないか確認
        assertFalse(nodeset.has(node3));
        /*
        EdgeSet edgeset = new EdgeSet();
        Edge edge1 = new Edge();
        edgeset.add(edge1);

        MappingSet funcset = new MappingSet();
        Mapping func = new Mapping(edge1,node1,node2);
        funcset.add(func);

        Graph graph = new Graph(nodeset,edgeset,funcset);

        //グラフがnode1を持っているか確認
        assertTrue(graph.hasNode(node1));
        //グラフがEdgeを持っているか確認
        assertTrue(graph.hasEdge(node1));
        //グラフのNode1につながっているEdgeにedge1があるか確認
        assertEquals(edge1,graph.getEgde(node1));
        */
    }

    @Test
    public void testEdgeSetConstruct(){
        EdgeSet edgeset = new EdgeSet();
        Edge edge1 = new Edge();
        edgeset.add(edge1);
        //edgesetがnode1を持っているか確認
        assertTrue(edgeset.has(edge1));
        Edge edge2 = new Edge();
        //edgesetがedge2を持っているか確認
        assertFalse(edgeset.has(edge2));
    }

}