import java.util.Scanner;

public class Triangle {
    static void cvtTriangle(int h){
        for(int i=1; i<=h; i++){
            for (int j=1; j<= h-i; j++){
                System.out.print(" "+" ");
            }
            for (int j=1; j<= 2*i-1; j++){
                System.out.print("*" + " ");
            }
            for (int j=1; j<= h-i; j++){
                System.out.print(" "+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int h = s.nextInt();
        cvtTriangle(h);
    }
}
