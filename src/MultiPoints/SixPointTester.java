package MultiPoints;
import java.util.Scanner;

/**
 * This Java program calculates the shortest distance between a set of points entered by the user.
 *
 * author: Dylan Long
 * date: 2/14/23
 * class: ITEC 2150, section 05
 * assignment: Lab 2.14
 *
 * The program ask the user to enter coords for 6 points in the enterPoints() method and can calculate the shortest
 * distance between 2 points in the computeShortestDistance() method.
 */

public class SixPointTester {

    //scanner object
    public static Scanner scanner = new Scanner(System.in);

    //method asks the user to enter coords to create 6 point.
    public static NamedPoint[] enterPoints() {

        //array containing 6 indexes
        NamedPoint[] points = new NamedPoint[6];
        System.out.println("Enter 6 points of x and y coords: ");

        //used to assign names to the points and iterates by each char in the loop below
        String abc = "abcdef";

        for (int i = 0; i < points.length; i++) {
            System.out.print("Enter x coord for Point " + abc.charAt(i) + ": ");
            double x = scanner.nextDouble();
            System.out.print("Enter y coord for Point " + abc.charAt(i) + ": ");
            double y = scanner.nextDouble();

            points[i] = new NamedPoint(x, y, abc.charAt(i) + "");

            System.out.println(points[i]);
        }

        return points;
    }

    public static void computeShortestDistance(NamedPoint[] points) {

        //shortestDistance is assigned to the biggest value for a double to handle edge cases
        double shortestDistance = Double.MAX_VALUE;
        String abc = "abcdef";

        NamedPoint p1 = null;
        NamedPoint p2 = null;


        for (int i = 0; i < points.length; i++) {

            for(int j = i + 1; j < points.length; j++) {
                double dist = Point.distance(points[i], points[j]);

                if (dist < shortestDistance) {
                    shortestDistance = dist;

                    //the new shorted Point distances will be converted --> NamedPoint object
                    p1 = new NamedPoint(points[i].getX(), points[i].getY(), abc.charAt(i)+"");
                    p2 = new NamedPoint(points[j].getX(), points[j].getY(), abc.charAt(j)+"");
                }
            }
        }

        //able to print out toString for NamedPoint objects
        System.out.printf("The shortest distance of two points are: \n   %s   %s and their " +
                "distance is %.2f", p1, p2, shortestDistance);
    }


    public static void main(String[] args) {

        computeShortestDistance(enterPoints());
    }

}
