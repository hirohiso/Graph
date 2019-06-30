package hirohiso.util.graph.structure.edge;

public class CostEdge extends AbstractEdge{
    private int cost = 0;

    public int getCost() {
        return cost;
    }

    public CostEdge(int i) {
        this.cost = i;
    }

    @Override
    public AbstractEdge clone() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }


}
