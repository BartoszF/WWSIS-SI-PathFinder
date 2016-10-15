package pl.bartoszf;

import java.util.List;

/**
 * Created by Kebab on 15.10.2016.
 */
public class Graph
{
    private List<Node> nodes;
    private Node starting;

    public Graph() {}

    public void addNode(Node n)
    {
        for(Node x : nodes)
        {
            n.addEdge(x);
        }
        this.nodes.add(n);
    }

    public List<Node> getNodes() {return nodes;}
    public Node getNode(int i) {return nodes.get(i);}

    public double dist(int a, int b) { return nodes.get(a).dist(nodes.get(b));}
}
