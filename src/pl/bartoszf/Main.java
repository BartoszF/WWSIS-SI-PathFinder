package pl.bartoszf;

import pl.bartoszf.solutions.AlwaysNearest;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj ilosc miast: ");
        int num = in.nextInt();
        System.out.println("Podaj odpowiednio "+num+" wspolrzednych X Y");

        int x=0,y=0;
        Graph g = new Graph();

        for(int i=1;i<=num;i++)
        {
            System.out.print(i+ ": ");
            x = in.nextInt();
            y = in.nextInt();

            g.addNode(new Node(x,y,i));
        }

        System.out.print("Podaj numer miasta startowego: ");

        g.setStarting(in.nextInt()-1);

        AlwaysNearest sol1 = new AlwaysNearest();
        sol1.resolve(g);

        System.out.println("Kolejność : " );
        sol1.printVisited();

        System.out.println("Droga : " + sol1.getDist());

        System.out.println("Czas wykonania : " + sol1.getTime() + " sek.");
    }
}
