package pl.bartoszf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kebab on 15.10.2016.
 */
public class Graph
{
    private ArrayList<Node> nodes = new ArrayList<>();
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

    public ArrayList<Node> getNodes() {return nodes;}
    public Node getNode(int i) {return nodes.get(i);}

    public void setStarting(int i) {starting = nodes.get(i);}
    public Node getStarting() {return starting;}

    public void resetVisited() {
        for(Node x: nodes)
        {
            x.unsetVisited();
        }
    }

    public double dist(int a, int b) { return nodes.get(a).dist(nodes.get(b));}

    public String toString()
    {
        int i=1;
        String val = "";
        for(Node x: nodes)
        {
            val += i++ +": "+x.toString() + "\n";
        }

        return val;
    }
}
