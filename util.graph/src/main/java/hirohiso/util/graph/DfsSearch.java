package hirohiso.util.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hirohiso.util.graph.structure.MappingSet;
import hirohiso.util.graph.structure.node.Node;

public class DfsSearch {
    MappingSet mapping;
    Deque<Node> queue;
    Set<Node> visitedNode;
    public DfsSearch(MappingSet map){
        this.mapping = map;
    }
    /**
     * 深さ優先探索をおこなう
     * @param 探索開始ノード
     * @param 探索対象ノード
     * @return
     */
    public boolean searchDfs(Node start, Node target) {
        //スタック
        this.queue = new ArrayDeque<Node>();
        //訪問済みノード格納用
        this.visitedNode = new HashSet<Node>();

        this.visitedNode.add(start);
        this.queue.addLast(start);

        // スタックから要素nを取得する
        Node n = null;

        while ((n = this.queue.peekLast()) != null) {
            // 要素nがtargetの場合
            if (n.equals(target)) {
                // 検索対象あり
                return true;
            }

            // 要素nがtargetではない場合
            // 要素nから未訪問の隣接ノードmを取得する
            Node m = getUnvisitedNode(n);

            if (m != null) {
                //未訪問の隣接ノードがある場合
                // 要素mを訪問済みにし
                this.visitedNode.add(m);
                // 要素mをスタックに追加する
                this.queue.addLast(m);
            } else {
                // 未訪問の隣接ノードが存在しない場合
                // 要素nをスタックから取り除く
                this.queue.pollLast();
            }
        }

        // 要素nが取得できなかった場合
        return false;
    }

    //未訪問の隣接ノードを一つ返却する
    private Node getUnvisitedNode(Node n){
        List<Node> list = this.mapping.getAdjacentNodeList(n);
        for (Node i : list) {
            if (this.visitedNode.contains(i)) {
                continue;
            } else {
                return i;
            }
        }
        //未訪問ノードがない場合はnullを返す
        return null;
    }

}
