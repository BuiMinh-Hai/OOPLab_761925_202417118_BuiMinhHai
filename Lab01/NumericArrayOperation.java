import java.util.Scanner;
public class NumericArrayOperation {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int[] BubbleSort(int[] arr, int n){
        boolean sorted = false;
        for (int i=1; i<n; i++){
            if (sorted == false){
                sorted = true;
                for (int j=0; j<=n-i-1; j++){
                    if (arr[j+1] < arr[j]){
                        swap(arr, j, j+1);
                        sorted = false;
                    }
                }
            }
        }
        return arr;
    }

    static int Sum(int[] arr){
        int res = 0;
        for (int x: arr){
            res += x;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap vao so phan tu: ");
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }
        
        int[] bubblesort_arr = BubbleSort(arr, n);
        System.out.println("Sorted Array!");
        for (int i=0; i<n; i++){
            System.out.print(bubblesort_arr[i] + " ");
        }
        System.out.println("\n");
        int arr_sum = Sum(arr);
        int arr_avg = arr_sum / n;
        System.out.println("Sum of array elements: "+ arr_sum);
        System.out.println("Average of array elements: " + arr_avg);
    }
}
