package pl.bartoszf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kebab on 15.10.2016.
 */
public class Node
{
    private int index;
    private Vector2 position;
    private ArrayList<Node> connections = new ArrayList<>();
    private Boolean visited=false;

    public Node(Vector2 pos, int index)
    {
        this.position = pos;
        this.index = index;
    }

    public Node(double X, double Y, int index)
    {
        this.position = new Vector2(X,Y);
        this.index = index;
    }

    public void addEdge(Node n)
    {
        connect(n);
        n.connect(this);
    }

    public void connect(Node n) { this.connections.add(n);}

    public void setVisited() {visited=true;}
    public void unsetVisited() {visited=false;}
    public boolean getVisited() {return visited;}

    public void setIndex(int index) {this.index = index;}

    public ArrayList<Node> getConnections() {return connections;}

    public Vector2 getPos() {return this.position;}
    public double dist(Node n) {return Vector2.Dist(position, n.getPos());}

    public String toString()
    {
        return "Node " + index + " " + position.toString();
    }
}
