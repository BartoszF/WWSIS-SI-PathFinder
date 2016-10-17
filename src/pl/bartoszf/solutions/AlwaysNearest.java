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
public class AlwaysNearest extends Solution
{

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
}
