package hirohiso.util.graph;

public class CostEdge extends Edge{
    private int cost = 0;

    public int getCost() {
        return cost;
    }

    public CostEdge(int i) {
        this.cost = i;
    }


}
