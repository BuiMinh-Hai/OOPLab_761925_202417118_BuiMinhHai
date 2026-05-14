package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        // Trỏ đường dẫn tới một file text hoặc file thực thi có dung lượng khá lớn (khoảng vài MB)
        String filename = "OtherProjects/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            
            String outputString = "";
            // Dùng toán tử + nối chuỗi từng byte một -> Tạo ra cực kỳ nhiều rác
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            
            endTime = System.currentTimeMillis();
            System.out.println("Thời gian đọc file sinh rác (GarbageCreator): " + (endTime - startTime) + " ms");
            
        } catch (IOException e) {
            System.out.println("Không tìm thấy file! Hãy tạo file test.txt trong thư mục gốc.");
            e.printStackTrace();
        }
    }
}