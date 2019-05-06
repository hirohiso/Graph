package hirohiso.util.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DfsSearch {
    MappingSet mapping;
    Deque<Node> queue;
    Set<Node> visitedNode;
    public DfsSearch(MappingSet map){
        this.mapping = map;
    }
    public boolean searchDfs(Node node1, Node node2) {
        this.queue = new ArrayDeque<Node>();
        this.visitedNode = new HashSet<Node>();

        this.visitedNode.add(node1);
        this.queue.addLast(node1);

        // スタックから要素nを取得する
        Node n = null;

        while ((n = this.queue.peekLast()) != null) {
            // 要素nがtargetの場合
            if (n.equals(node2)) {
                // 検索対象あり
                return true;
            }

            // 要素nがtargetではない場合

            // 要素nから未訪問の隣接ノードmを取得する
            Node m = null;
            List<Node> list = this.mapping.getAdjacentNodeList(n);
            for (Node i : list) {
                if (this.visitedNode.contains(i)) {
                    continue;
                } else {
                    m = i;
                    break;
                }
            }
            if (m != null) {
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
}
