package hust.soict.globalict.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        
        
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Thời gian dùng String (toán tử +): " + (System.currentTimeMillis() - start) + " ms");

        
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