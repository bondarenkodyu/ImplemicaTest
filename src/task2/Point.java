package task2;

/**
 * Created by Lil Wayne on 15.06.15.
 */
public class Point implements Cloneable {

    // finish of path
    public City finish;
    // cost of path
    public int weight;

    public Point(City target, int weight)
    {
        this.finish = target;
        this.weight = weight;
    }
}
