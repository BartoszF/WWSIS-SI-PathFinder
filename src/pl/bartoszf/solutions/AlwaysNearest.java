package pl.bartoszf.solutions;

import pl.bartoszf.Graph;
import pl.bartoszf.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kebab on 15.10.2016.
 */
@aSolution
public class AlwaysNearest implements Solution
{
    long start=0,stop=0;
    LinkedList<Node> visited = new LinkedList<Node>();

    @Override
    public void resolve(Graph g)
    {
        Node previous = g.getStarting();
        Node minNode = null;
        double min = -1;

        start = System.nanoTime();
        boolean exit;
        previous.setVisited();
        visited.add(previous);

        do {
            exit = true;
            min = -1;
            for (Node x : previous.getConnections()) {
                if (x.equals(previous)) continue;

                double ac = previous.dist(x);
                if (!x.getVisited() && (min < 0 || ac < min)) {
                    min = ac;
                    minNode = x;
                }
            }

            System.out.println("Visiting "+minNode.toString());
            minNode.setVisited();
            visited.add(minNode);
            previous = minNode;

            for(Node x:g.getNodes())
            {
                if(x.getVisited() == false)
                {
                    exit = false;
                }
            }
        }while(exit==false);

        visited.add(g.getStarting());

        stop = System.nanoTime();
    }

    @Override
    public String getName() {
        return "Always Nearest Town";
    }

    @Override
    public long getTime() {
        return TimeUnit.SECONDS.convert(stop-start,TimeUnit.NANOSECONDS);
    }

    @Override
    public double getDist()
    {
        double dist = 0;
        for(int i=0;i<visited.size()-1;i++)
        {
            dist += visited.get(i).dist(visited.get(i+1));
        }

        return dist;
    }

    @Override
    public List<Node> getVisited() {
        return visited;
    }

    @Override
    public void printVisited() {
        for(Node x : visited)
        {
            System.out.println(x.toString());
        }
    }
}
