package pl.bartoszf.solutions;

import pl.bartoszf.Graph;
import pl.bartoszf.Node;

import java.util.List;

/**
 * Created by Kebab on 15.10.2016.
 */
public interface Solution
{
    void resolve(Graph g);
    String getName();
    long getTime();
    double getDist();
    List<Node> getVisited();

    void printVisited();
}

@interface aSolution {}


