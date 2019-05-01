package hirohiso.util.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BsdSearch {
    MappingSet mapping;
    Deque<Node> queue;
    Set<Node> visitedNode;
    HashMap<Node, Node> hashMap;


    public BsdSearch(MappingSet map){
        this.mapping = map;
    }
    /**
     * 現在のグラフにおいて幅優先探索を行う
     * @param start 開始ノード
     * @param target 探索ノード
     * @return true 探索ノードを見つけた場合
     */
    public boolean searchBSD(Node start, Node target) {
        this.queue = new ArrayDeque<Node>();
        this.visitedNode = new HashSet<Node>();
        //探索経路保持用（あるノードに対する遷移元ノードを保持しておく）
        this.hashMap= new HashMap<Node, Node>();

        //開始ノードを探索済みにする
        this.visitedNode.add(start);
        //開始点をキューに蓄える
        this.queue.addLast(start);
        Node n;//探索点
        //キューから要素を取り出す
        while ((n = this.queue.pollFirst()) != null) {
            // 探索ノードの場合はtrueを返す
            if (n.equals(target)) {
                getRootPath(n);
                return true;
            }

            // 探索ノードでない場合,隣接するノードを取得する
            setSearchNode(n);
        }
        return false;
    }

    //ノードnから未訪問の隣接ノードを探索対象に追加する
    private void setSearchNode(Node current) {
        List<Node> list = this.mapping.getAdjacentNodeList(current);
        for (Node node : list) {

            if (this.visitedNode.contains(node)) {
                continue;
            }
            // 未探索のノードは、探索済みにしてすべてキューに追加する
            this.visitedNode.add(node);
            //親ノードを保持する
            this.hashMap.put(node, current);
            //キューに追加
            this.queue.addLast(node);
        }
    }


    //指定したノードから開始ノードまでのルートを求める
    private void getRootPath(Node n) {
        Node now = n;
        Node prev;
        //探索経路を求める
        while((prev = this.hashMap.get(now))!= null){
            System.out.println(prev);
            now = prev;
        }
    }
}
