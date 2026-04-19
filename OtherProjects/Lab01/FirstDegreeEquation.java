import java.net.http.HttpResponse.PushPromiseHandler;
import java.util.Scanner;
public class FirstDegreeEquation {
    public static void main (String[] args){
        double a, b;
        Scanner s = new Scanner(System.in);
        a = s.nextDouble();
        b = s.nextDouble();
        if (a == 0){
            if (b == 0){
                System.out.println("Infinite solutions");
            }
            else{
                System.out.println("No solution");
            }
        }
        else{
            double res = -b / a;
            System.out.println("The solution is " + res);
        }
    }
}