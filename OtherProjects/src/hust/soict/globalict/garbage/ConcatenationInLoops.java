package hust.soict.globalict.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        
        // ----------------------------------------------------
        // CÁCH 1: Nối chuỗi bằng toán tử "+" (Rất chậm và tốn bộ nhớ)
        // ----------------------------------------------------
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Thời gian dùng String (toán tử +): " + (System.currentTimeMillis() - start) + " ms");

        // ----------------------------------------------------
        // CÁCH 2: Nối chuỗi bằng StringBuilder (Rất nhanh)
        // ----------------------------------------------------
        r = new Random(123); // Reset lại Random
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("Thời gian dùng StringBuilder: " + (System.currentTimeMillis() - start) + " ms");
    }
}