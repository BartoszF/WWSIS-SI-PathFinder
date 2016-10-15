package pl.bartoszf.solutions;

import pl.bartoszf.Graph;
import pl.bartoszf.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Kebab on 15.10.2016.
 */
public class AlwaysNearest implements Solution
{
    long start=0,stop=0;
    @Override
    public void resolve(Graph g)
    {
        LinkedList<Node> visited = new LinkedList<Node>();
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
                if (min < 0 || ac < min) {
                    min = ac;
                    minNode = x;
                }
            }

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

        stop = System.nanoTime();

        for(Node x : visited)
        {
            System.out.println(x.toString());
        }
        //System.out.println(previous.toString());
    }

    @Override
    public String getName() {
        return "Always Nearest Town";
    }

    @Override
    public long getTime() {
        return stop-start;
    }
}
