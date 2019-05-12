package hirohiso.util.graph;

public class Graph {

    MappingSet mapping;
    NodeSet nodeset;
    EdgeSet edgeset;

    public Graph(NodeSet nodeset, EdgeSet edgeset, MappingSet funcset) {
        this.mapping = funcset;
        this.nodeset = nodeset;
        this.edgeset = edgeset;
    }


    /**
     * 現在のグラフにおいて幅優先探索を行う
     * @param node1 開始ノード
     * @param node2 探索ノード
     * @return true 探索ノードを見つけた場合
     */
    public boolean searchBSD(Node node1, Node node2) {
        BsdSearch bsd = new BsdSearch(this.mapping);
        boolean result = bsd.searchBSD(node1, node2);
        return result;
    }

    /**
     * 現在のグラフにおいて深さ優先探索を行う
     * @param node1 開始ノード
     * @param node2 探索ノード
     * @return true 探索ノードを見つけた場合
     */
    public boolean searchDFS(Node node1, Node node2) {
        DfsSearch dfs = new DfsSearch(this.mapping);
        boolean result = dfs.searchDfs(node1, node2);
        return result;
    }


    public NodeSet getNodeset() {
        return this.nodeset;
    }


    public EdgeSet getEdgeset() {
        return this.edgeset;
    }

    public MappingSet getMappingset() {
        return this.mapping;
    }



}
