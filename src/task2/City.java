package task2;



/**
 * Created by Lil Wayne on 15.06.15.
 */
public class City implements Cloneable  {

    public  String name;
    //array of adjacency
    public Point[] adjacencies;
    // max value
    public int minDistance = 200000;
    // link on previous element
    public City previous;
    // array for index neighbor and cost to neighbors
    int [][] arr;

    public City(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
