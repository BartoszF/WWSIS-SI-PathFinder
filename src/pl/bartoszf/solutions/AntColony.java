package pl.bartoszf.solutions;

import pl.bartoszf.Graph;
import pl.bartoszf.Node;

import java.util.ArrayList;
import java.util.List;

class Ant {
    public List<Node> visited = new ArrayList<>();
    public Ant(){}
}
/**
 * Created by Użytkownik on 2016-11-16.
 */
public class AntColony extends Solution {

    public static double FER_INFLUENCE = 0.8f;
    public static double DIST_INFLUENCE = 5;
    public static double EVAP_INDEX = 0.5f;

    public void resolve(Graph g, int numAnt)
    {
        int size = g.getNodes().size();
        double[][] fer = new double[size][size];
        for(int y=0;y<size;y++) {
            for(int x=0;x<size;x++)
            {
                fer[x][y] = 1;
            }
        }

        start = System.nanoTime();

        for(int i=0;i<numAnt;i++) {
            Ant ant = new Ant();
            ant.visited.add(g.getStarting());
            if(i==numAnt-1)
            {
                visited.add(g.getStarting());
            }
            Node act = g.getStarting();

            do {
                double best = 0;
                Node bestNode = null;
                for (Node x : act.getConnections()) {
                    if(ant.visited.contains(x)) continue;
                    //double f = Math.pow(fer[act.getIndex()-1][x.getIndex()-1],FER_INFLUENCE);
                    double f = fer[act.getIndex()-1][x.getIndex()-1];
                    double d = Math.pow(1/act.dist(x),DIST_INFLUENCE);
                    double poly = f*d;
                    int toVisit = 0;
                    for(Node z: act.getConnections())
                    {
                        if(!ant.visited.contains(z))
                        {
                            toVisit++;
                        }
                    }
                    double fer_res = poly / (toVisit * poly);
                    if(fer_res > best)
                    {
                        best = fer_res;
                        bestNode = x;
                    }
                }

                double f = fer[act.getIndex()-1][bestNode.getIndex()-1];
                double sum = 0;
                if(ant.visited.size() == 1)
                {
                    sum = 0;
                }
                else {
                    for (int x = 1; i < ant.visited.size(); i++) {
                        sum += ant.visited.get(x - 1).dist(ant.visited.get(x));
                    }
                }
                fer[act.getIndex()-1][bestNode.getIndex()-1] = (1-EVAP_INDEX) * f + sum;
                fer[bestNode.getIndex()-1][act.getIndex()-1] = (1-EVAP_INDEX) * f + sum;
                ant.visited.add(bestNode);
                if(i==numAnt-1)
                {
                    visited.add(bestNode);
                }
                act = bestNode;
            }while(ant.visited.size() < size);
        }
        visited.add(g.getStarting());

        stop = System.nanoTime();
    }

    @Override
    public String getName() {
        return "Ant Colony";
    }
}
