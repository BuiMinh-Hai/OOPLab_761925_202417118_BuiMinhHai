package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "OtherProjects/test.txt"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            
            // Dùng StringBuilder để nối chuỗi -> Không sinh ra rác, cực nhanh
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }
            
            endTime = System.currentTimeMillis();
            System.out.println("Thời gian đọc file tối ưu (NoGarbage): " + (endTime - startTime) + " ms");
            
        } catch (IOException e) {
            System.out.println("Không tìm thấy file! Hãy tạo file test.txt trong thư mục gốc.");
            e.printStackTrace();
        }
    }
}
