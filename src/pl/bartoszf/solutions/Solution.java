package pl.bartoszf.solutions;

import pl.bartoszf.Graph;
import pl.bartoszf.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kebab on 15.10.2016.
 */
public class Solution
{
    long start=0,stop=0;
    LinkedList<Node> visited = new LinkedList<Node>();
    public Solution(){}
    void resolve(Graph g){}

    public String getName(){return "Empty Solution";}

    public double getTime() {
        return (double)(stop-start)/1000000000.0;
    }

    public double getDist()
    {
        double dist = 0;
        for(int i=0;i<visited.size()-1;i++)
        {
            dist += visited.get(i).dist(visited.get(i+1));
        }

        return dist;
    }

    public List<Node> getVisited() {
        return visited;
    }

    public void printVisited() {
        for(int i=1;i<visited.size();i++)
        {
            System.out.println(visited.get(i-1).toString() + " -> " + visited.get(i).toString() + " = " + visited.get(i-1).dist(visited.get(i)));
        }
        /*for(Node x : visited)
        {
            System.out.println(x.toString());
        }*/
    }
}


