import java.util.Scanner;
public class AddTwoMatrices {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int m, n;
        System.out.println("Nhap vao m, n");
        m = s.nextInt();
        n = s.nextInt();
        int[][] matrix1 = new int[m][n];
        int[][] matrix2 = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int tmp = s.nextInt();
                matrix1[i][j] = tmp;
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int tmp = s.nextInt();
                matrix2[i][j] = tmp;
            }
        }     

        int[][] res = new int[m][n];
        for (int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                res[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }


    }
    
}
