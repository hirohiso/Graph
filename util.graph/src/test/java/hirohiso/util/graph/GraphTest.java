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

    @Test(expected = IllegalArgumentException.class)
    public void testSetEdgeIntoNodeSet() {
        NodeSet nodeset = new NodeSet();
        Node node1 = new Node();
        Node node2 = new Node();
        Edge edge1 = new Edge();
        nodeset.add(node1);
        nodeset.add(node2);
        nodeset.add(edge1);// ここでエラーにしたい
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

        // 登録されていないノードのアクセス
        list = funcset.getEdgeList(node3);
        assertFalse(list.contains(edge1));

        List<Node> list2 = funcset.getAdjacentNodeList(node1);
        assertTrue(list2.contains(node2));
        assertFalse(list2.contains(node3));

        list2 = funcset.getAdjacentNodeList(node2);
        assertFalse(list2.contains(node1));

        //Edgeから接続しているノードを取得する
        list2 = funcset.getNodeList(edge1);
        assertEquals(2,list2.size());
        assertTrue(list2.contains(node1));
        assertTrue(list2.contains(node2));
        assertFalse(list2.contains(node4));

    }

    @Test
    public void testBSD() {
        NodeSet nodeset = new NodeSet();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node99 = new Node();
        nodeset.add(node1);
        nodeset.add(node2);
        nodeset.add(node3);
        nodeset.add(node4);
        nodeset.add(node5);
        nodeset.add(node6);

        EdgeSet edgeset = new EdgeSet();
        Edge edge1 = new Edge();
        Edge edge2 = new Edge();
        Edge edge3 = new Edge();
        Edge edge4 = new Edge();
        Edge edge5 = new Edge();
        Edge edge6 = new Edge();
        Edge edge7 = new Edge();
        Edge edge8 = new Edge();
        Edge edge9 = new Edge();
        edgeset.add(edge1);
        edgeset.add(edge2);
        edgeset.add(edge3);
        edgeset.add(edge4);
        edgeset.add(edge5);
        edgeset.add(edge6);
        edgeset.add(edge7);
        edgeset.add(edge8);
        edgeset.add(edge9);

        MappingSet funcset = new MappingSet();
        Mapping func1 = new Mapping(edge1, node1, node2);
        Mapping func2 = new Mapping(edge2, node2, node3);
        Mapping func3 = new Mapping(edge3, node2, node4);
        Mapping func4 = new Mapping(edge4, node2, node5);
        Mapping func5 = new Mapping(edge5, node1, node5);
        Mapping func6 = new Mapping(edge6, node5, node6);
        Mapping func7 = new Mapping(edge7, node5, node4);
        Mapping func8 = new Mapping(edge8, node4, node3);
        Mapping func9 = new Mapping(edge9, node4, node1);

        funcset.add(func1);
        funcset.add(func2);
        funcset.add(func3);
        funcset.add(func4);
        funcset.add(func5);
        funcset.add(func6);
        funcset.add(func7);
        funcset.add(func8);
        funcset.add(func9);

        Graph graph = new Graph(nodeset, edgeset, funcset);
        // 指定したノードを開始点として、次に指定したノードが存在するかを幅優先探索する
        assertTrue(graph.searchBSD(node1, node2));
        assertFalse(graph.searchBSD(node1, node99));
        assertTrue(graph.searchBSD(node1, node6));
        assertTrue(graph.searchBSD(node2, node6));
        assertFalse(graph.searchBSD(node6, node1));
        assertTrue(graph.searchBSD(node5, node4));
        assertTrue(graph.searchBSD(node5, node2));
        assertFalse(graph.searchBSD(node2, node99));

    }

    @Test
    public void testDFS() {
        NodeSet nodeset = new NodeSet();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node99 = new Node();
        nodeset.add(node1);
        nodeset.add(node2);
        nodeset.add(node3);
        nodeset.add(node4);
        nodeset.add(node5);
        nodeset.add(node6);

        EdgeSet edgeset = new EdgeSet();
        Edge edge1 = new Edge();
        Edge edge2 = new Edge();
        Edge edge3 = new Edge();
        Edge edge4 = new Edge();
        Edge edge5 = new Edge();
        Edge edge6 = new Edge();
        Edge edge7 = new Edge();
        Edge edge8 = new Edge();
        Edge edge9 = new Edge();
        edgeset.add(edge1);
        edgeset.add(edge2);
        edgeset.add(edge3);
        edgeset.add(edge4);
        edgeset.add(edge5);
        edgeset.add(edge6);
        edgeset.add(edge7);
        edgeset.add(edge8);
        edgeset.add(edge9);

        MappingSet funcset = new MappingSet();
        Mapping func1 = new Mapping(edge1, node1, node2);
        Mapping func2 = new Mapping(edge2, node2, node3);
        Mapping func3 = new Mapping(edge3, node2, node4);
        Mapping func4 = new Mapping(edge4, node2, node5);
        Mapping func5 = new Mapping(edge5, node1, node5);
        Mapping func6 = new Mapping(edge6, node5, node6);
        Mapping func7 = new Mapping(edge7, node5, node4);
        Mapping func8 = new Mapping(edge8, node4, node3);
        Mapping func9 = new Mapping(edge9, node4, node1);

        funcset.add(func1);
        funcset.add(func2);
        funcset.add(func3);
        funcset.add(func4);
        funcset.add(func5);
        funcset.add(func6);
        funcset.add(func7);
        funcset.add(func8);
        funcset.add(func9);

        Graph graph = new Graph(nodeset, edgeset, funcset);
        // 指定したノードを開始点として、次に指定したノードが存在するかを幅優先探索する
        assertTrue(graph.searchDFS(node1, node2));
        assertFalse(graph.searchDFS(node1, node99));
        assertTrue(graph.searchDFS(node1, node6));
        assertTrue(graph.searchDFS(node2, node6));
        assertFalse(graph.searchDFS(node6, node1));
        assertTrue(graph.searchDFS(node5, node4));
        assertTrue(graph.searchDFS(node5, node2));
        assertFalse(graph.searchDFS(node2, node99));

    }

    @Test
    public void testEdgeCost() {
        CostEdge edge1 = new CostEdge(3);
        assertEquals(3, edge1.getCost());
    }
    @Test
    public void testLinkedMappingConstruct() {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        Edge edge1 = new Edge();
        Edge edge2 = new Edge();
        Edge edge3 = new Edge();

        MappingSet funcset = new LinkedMappingSet();
        Mapping func = new Mapping(edge1, node1, node2);
        Mapping func2 = new Mapping(edge3, node1, node4);
        funcset.add(func);
        funcset.add(func2);

        List<Edge> list3 = funcset.getEdgeList(node2);
        assertTrue(list3.contains(edge1));
        List<Node> list4 = funcset.getAdjacentNodeList(node4);
        assertTrue(list4.contains(node1));

    }

    @Test
    public void testLinkedGraphBSD() {
        NodeSet nodeset = new NodeSet();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node99 = new Node();
        nodeset.add(node1);
        nodeset.add(node2);
        nodeset.add(node3);
        nodeset.add(node4);
        nodeset.add(node5);
        nodeset.add(node6);

        EdgeSet edgeset = new EdgeSet();
        Edge edge1 = new Edge();
        Edge edge2 = new Edge();
        Edge edge3 = new Edge();
        Edge edge4 = new Edge();
        Edge edge5 = new Edge();
        Edge edge6 = new Edge();
        Edge edge7 = new Edge();
        Edge edge8 = new Edge();
        Edge edge9 = new Edge();
        edgeset.add(edge1);
        edgeset.add(edge2);
        edgeset.add(edge3);
        edgeset.add(edge4);
        edgeset.add(edge5);
        edgeset.add(edge6);
        edgeset.add(edge7);
        edgeset.add(edge8);
        edgeset.add(edge9);

        MappingSet funcset = new LinkedMappingSet();
        Mapping func1 = new Mapping(edge1, node1, node2);
        Mapping func2 = new Mapping(edge2, node2, node3);
        Mapping func3 = new Mapping(edge3, node2, node4);
        Mapping func4 = new Mapping(edge4, node2, node5);
        Mapping func5 = new Mapping(edge5, node1, node5);
        Mapping func6 = new Mapping(edge6, node5, node6);
        Mapping func7 = new Mapping(edge7, node5, node4);
        Mapping func8 = new Mapping(edge8, node4, node3);
        Mapping func9 = new Mapping(edge9, node4, node1);

        funcset.add(func1);
        funcset.add(func2);
        funcset.add(func3);
        funcset.add(func4);
        funcset.add(func5);
        funcset.add(func6);
        funcset.add(func7);
        funcset.add(func8);
        funcset.add(func9);

        Graph graph = new Graph(nodeset, edgeset, funcset);
        // 指定したノードを開始点として、次に指定したノードが存在するかを幅優先探索する
        assertTrue(graph.searchBSD(node1, node2));
        assertFalse(graph.searchBSD(node1, node99));
        assertTrue(graph.searchBSD(node6, node1));
    }
    @Test
    public void testGraphMethod() {
        Graph graph = getTestDataForLvc();

        ElementSet directedNodeSet = graph.getNodeset();
        ElementSet directedEdgeSet = graph.getEdgeset();
        assertEquals(4, directedNodeSet.length());
        assertEquals(3, directedEdgeSet.length());
    }
    @Test
    public void testConvertDirectedGraph() {
        Graph graph = getTestDataForLvc();

        LocalVertexConnectivity lvc = new  LocalVertexConnectivity(graph);

        Graph directedGraph = lvc.transferDirectedGraph();
        ElementSet directedNodeSet = directedGraph.getNodeset();
        ElementSet directedEdgeSet = directedGraph.getEdgeset();
        assertEquals(8, directedNodeSet.length());
        assertEquals(10, directedEdgeSet.length());
    }

    @Test
    public void testGraphMapping() {
        Graph graph = getTestDataForLvc();
        List<Element> orignalEdge = graph.getEdgeset().getElementList();
        MappingSet originalMapping = graph.getMappingset();

        for(Element edge :orignalEdge){
            List<Node> nodelist =  originalMapping.getNodeList(edge);
            assertEquals(2,nodelist.size());
        }

    }


    @Test
    public void getMappingGarphTest(){
        NodeSet nodeset = new NodeSet();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        nodeset.add(node1);
        nodeset.add(node2);
        nodeset.add(node3);
        nodeset.add(node4);


        EdgeSet edgeset = new EdgeSet();
        Edge edge1 = new Edge();
        Edge edge2 = new Edge();
        Edge edge3 = new Edge();

        edgeset.add(edge1);
        edgeset.add(edge2);
        edgeset.add(edge3);

        MappingSet funcset = new LinkedMappingSet();
        Mapping func1 = new Mapping(edge1, node1, node2);
        Mapping func2 = new Mapping(edge2, node2, node3);
        Mapping func3 = new Mapping(edge3, node2, node4);


        funcset.add(func1);
        funcset.add(func2);
        funcset.add(func3);

        Graph graph = new Graph(nodeset, edgeset, funcset);
        List<Element> orignalEdge = graph.getEdgeset().getElementList();
        MappingSet originalMapping = graph.getMappingset();

        List<Node> nodelistTemp =  funcset.getNodeList(edge1);
        assertEquals(2,nodelistTemp.size());
        List<Node> nodelist =  originalMapping.getNodeList(edge1);
        assertEquals(2,nodelist.size());
    }

    private Graph getTestDataForLvc(){
        NodeSet nodeset = new NodeSet();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        nodeset.add(node1);
        nodeset.add(node2);
        nodeset.add(node3);
        nodeset.add(node4);


        EdgeSet edgeset = new EdgeSet();
        Edge edge1 = new Edge();
        Edge edge2 = new Edge();
        Edge edge3 = new Edge();

        edgeset.add(edge1);
        edgeset.add(edge2);
        edgeset.add(edge3);

        MappingSet funcset = new LinkedMappingSet();
        Mapping func1 = new Mapping(edge1, node1, node2);
        Mapping func2 = new Mapping(edge2, node2, node3);
        Mapping func3 = new Mapping(edge3, node2, node4);


        funcset.add(func1);
        funcset.add(func2);
        funcset.add(func3);

        Graph graph = new Graph(nodeset, edgeset, funcset);
        return graph;
    }
}
