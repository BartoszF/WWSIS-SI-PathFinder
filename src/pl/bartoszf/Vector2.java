package pl.bartoszf;

/**
 * Created by Kebab on 15.10.2016.
 */
public class Vector2
{
    private double X, Y;

    public Vector2(double X, double Y)
    {
        this.X = X;
        this.Y = Y;
    }

    public Vector2(double i)
    {
        this.X = this.Y = i;
    }

    public Vector2() { this.X = this.Y = 0;}

    public void setX(double X) {this.X = X;}
    public void setY(double Y) {this.Y = Y;}
    public double getX() {return X;}
    public double getY() {return Y;}

    public static double Dist(Vector2 a, Vector2 b)
    {
        return Math.sqrt(Math.pow((b.getX()-a.getX()),2) + Math.pow((b.getY()-a.getY()),2));
    }
}
