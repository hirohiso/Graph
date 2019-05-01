package hirohiso.util.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

    MappingSet mapping;

    public Graph(NodeSet nodeset, EdgeSet edgeset, MappingSet funcset) {
        this.mapping = funcset;
    }


    /**
     * 現在のグラフにおいて幅優先探索を行う
     * @param node1 開始ノード
     * @param node2 探索ノード
     * @return true 探索ノードを見つけた場合
     */
    public boolean searchBSD(Node node1, Node node2) {
        Deque<Node> queue = new ArrayDeque<Node>();
        Set<Node> searchedSet = new HashSet<Node>();
        //探索経路保持用
        HashMap<Node, Node> hashMap= new HashMap<Node, Node>();

        //開始ノードを探索済みにする
        searchedSet.add(node1);
        //開始点をキューに蓄える
        queue.push(node1);
        Node n;//探索点
        //キューから要素を取り出す
        while (queue.size() != 0) {
            n = queue.pop();
            // 探索ノードの場合はtrueを返す
            if (n.equals(node2)) {
                Node now = n;
                Node prev;
                //探索経路を求める
                while((prev = hashMap.get(now))!= null){
                    System.out.println(prev);
                    now = prev;
                }
                return true;
            }
            // 探索ノードでない場合
            List<Node> list = this.mapping.getAdjacentNodeList(n);
            for (Node node : list) {

                if (searchedSet.contains(node)) {
                    continue;
                }
                // 未探索のノードは、探索済みにしてすべてキューに追加する
                searchedSet.add(node);
                hashMap.put(node, n);
                queue.push(node);
            }
        }
        return false;
    }

}
