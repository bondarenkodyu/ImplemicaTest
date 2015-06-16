package task2;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.*;


public class Solution {

    // the method for compute  path
    public static void computePaths(City city)

    {
        // cost of starts of path
        city.minDistance = 0;
        LinkedList<City> linkedList = new LinkedList<City>();
        linkedList.add((city));
        while (!linkedList.isEmpty()) {
            City tmp = linkedList.poll();
            for (Point p : tmp.adjacencies)
            {
                City v = p.finish;
                int weight = p.weight;
                int distanceThroughU = tmp.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    linkedList.remove(v);
                    v.minDistance = distanceThroughU ;
                    v.previous = tmp;
                    linkedList.add(v);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("the number of tests");
        int S = Integer.parseInt(reader.readLine()); // the number of tests
        if (S>10)
        {
            while (true) // check
            {
                System.out.println("the number of tests can't be more then 10");
                S = Integer.parseInt(reader.readLine());
                if (S<=10) break;
            }
        }
        for (int testCount = 0; testCount<S; testCount++)
        {
            System.out.println("the number of cities"); // the number of cities
            int N = Integer.parseInt(reader.readLine());
            if (N > 10000)
            {
                while (true) // check
                {
                    System.out.println("the number of cities can't be more then 10000");
                    N = Integer.parseInt(reader.readLine());
                    if (N <= 10000) break;
                }
            }
            ArrayList<City> cities = new ArrayList<>();
            for (int i = 0; i < N; i++)
            {
                System.out.println("the name of city");
                String name = reader.readLine();
                cities.add(new City(name)); // the name of city
                System.out.println("number neighbors");
                int countNeighbors = Integer.parseInt(reader.readLine()); // number neighbors
                cities.get(i).arr = new int[countNeighbors][2];
                for (int j = 0; j < countNeighbors; j++)
                {
                    System.out.println("index neighbor");
                    int a = Integer.parseInt(reader.readLine()) - 1; // index neighbor
                    System.out.println("cost to the city");
                    int b = Integer.parseInt(reader.readLine()); // cost to the city
                    cities.get(i).arr[j][0] = a;
                    cities.get(i).arr[j][1] = b;
                }
            }
            System.out.println("the number of paths to find ");
            int numberPath = Integer.parseInt(reader.readLine()); // the number of paths to find
            if (numberPath > 100) // check
            {
                while (true)
                {
                    System.out.println("the number of paths can't be more then 100");
                    numberPath = Integer.parseInt(reader.readLine());
                    if (numberPath <= 100) break;
                }
            }
            for (int i = 0; i < N; i++)
            {
                int size = cities.get(i).arr.length;
                cities.get(i).adjacencies = new Point[size];
                int e = 0;
                for (int j = 0; j < size; j++)
                {
                    int key = cities.get(i).arr[j][0]; // index neighbor
                    int value = cities.get(i).arr[j][1]; // cost to the city
                    cities.get(i).adjacencies[e] = new Point(cities.get(key), value); // initialization array of adjacency
                    e++;
                }
            }
            ArrayList<String> listName = new ArrayList<>(); // list of cities name
            for (int i = 0; i < cities.size(); i++)
            {
                listName.add(cities.get(i).name);
            }
            for (int a = 0; a < numberPath; a++)
            {
                for (int i = 0; i < N; i++)
                {
                    int size = cities.get(i).arr.length;
                    cities.get(i).adjacencies = new Point[size];
                    int e = 0;
                    for (int j = 0; j < size; j++)
                    {
                        int key = cities.get(i).arr[j][0]; // index neighbor
                        int value = cities.get(i).arr[j][1]; // cost to the city
                        cities.get(i).adjacencies[e] = new Point(cities.get(key), value); // initialization array of adjacency
                        e++;
                    }
                }

                System.out.println("from city ");
                // name of first city
                String city1Name = reader.readLine();
                System.out.println("to city ");
                // name of second city
                String city2Name = reader.readLine();
                int index1 = listName.indexOf(city1Name);
                int index2 = listName.indexOf(city2Name);
                System.out.println("cost is ");
                computePaths(cities.get(index1));
                System.out.println(cities.get(index2).minDistance);
            }
            System.out.println();
        }
        reader.close();
    }
}
