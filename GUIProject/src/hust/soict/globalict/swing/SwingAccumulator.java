package hust.soict.globalict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0; // Biến tích lũy tổng, khởi tạo bằng 0

    // Constructor để thiết lập các thành phần GUI và bộ xử lý sự kiện
    public SwingAccumulator() {
        // Trong Swing, chúng ta thêm các thành phần vào Content Pane của JFrame
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        // Hàng 1
        cp.add(new JLabel("Enter an Integer: "));
        tfInput = new JTextField(10);
        cp.add(tfInput);

        // Thêm bộ lắng nghe sự kiện khi nhấn Enter
        tfInput.addActionListener(new TFInputListener());

        // Hàng 2
        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false); // Ô hiển thị kết quả không được sửa
        cp.add(tfOutput);

        // Thiết lập các thuộc tính cho JFrame
        setTitle("Swing Accumulator");
        setSize(350, 120);

        // Khác với AWT, Swing có thể tự đóng chương trình khi bấm nút X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Căn giữa cửa sổ trên màn hình (tùy chọn thêm để đẹp hơn)
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    // Lớp nội xử lý sự kiện khi người dùng nhấn Enter tại ô nhập liệu
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                // Lấy giá trị nhập vào, chuyển thành số nguyên
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn; // Cộng dồn vào tổng

                tfInput.setText(""); // Xóa trắng ô nhập
                tfOutput.setText(sum + ""); // Hiển thị tổng mới
            } catch (NumberFormatException e) {
                // Xử lý trường hợp người dùng nhập chữ thay vì số
                JOptionPane.showMessageDialog(null, "Please enter a valid integer!");
                tfInput.setText("");
            }
        }
    }
}