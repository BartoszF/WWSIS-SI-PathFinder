package pl.bartoszf.solutions;

import pl.bartoszf.Graph;
import pl.bartoszf.Node;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Kebab on 15.10.2016.
 */

public class AlwaysAverage extends Solution
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
            /*for (Node x : previous.getConnections()) {
                if (x.equals(previous)) continue;

                double ac = previous.dist(x);
                if (!x.getVisited() && (min < 0 || ac < min)) {
                    min = ac;
                    minNode = x;
                }
            }*/

            Map<Double,Node> nodes = new TreeMap<>();
            for(Node x: previous.getConnections())
            {
                if(!x.getVisited())
                    nodes.put(x.dist(previous),x);
            }

            Set<Double> s = nodes.keySet();
            Double[] arr = new Double[s.size()];
            s.toArray(arr);
            Double i = arr[s.size()/2];
            minNode = nodes.get(i);

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
