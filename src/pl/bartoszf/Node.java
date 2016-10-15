package pl.bartoszf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kebab on 15.10.2016.
 */
public class Node
{
    private Vector2 position;
    private ArrayList<Node> connections = new ArrayList<>();

    public Node(Vector2 pos)
    {
        this.position = pos;
    }

    public Node(double X, double Y)
    {
        this.position = new Vector2(X,Y);
    }

    public void addEdge(Node n)
    {
        connect(n);
        n.connect(this);
    }

    public void connect(Node n) { this.connections.add(n);}

    public Vector2 getPos() {return this.position;}
    public double dist(Node n) {return Vector2.Dist(position, n.getPos());}

    public String toString()
    {
        return "Node " + position.toString();
    }
}
