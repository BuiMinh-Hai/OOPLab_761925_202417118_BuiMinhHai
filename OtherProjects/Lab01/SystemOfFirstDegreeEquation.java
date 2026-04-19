import java.util.Scanner;
public class SystemOfFirstDegreeEquation {
    public static void main (String[] args){
        double a11, a12, a21, a22;
        double b1, b2;
        Scanner s = new Scanner(System.in);
        a11 = s.nextDouble();
        a12 = s.nextDouble();
        a21 = s.nextDouble();
        a22 = s.nextDouble();
        b1 = s.nextDouble();
        b2 = s.nextDouble();

        double d = a11*a22 - a12*a21;
        if (d == 0){
            System.out.println("No solution");
            return;
        }
        double d1 = b1*a22 - a12*b2;
        double d2 = a11*b2 - a21*b1;
        double x1 = d1/d;
        double x2 = d2/d;
        System.out.println("First Solution: " + x1 + "\n" + "Second Solution: " + x2 + "\n" );
        System.exit(0);

    }
}