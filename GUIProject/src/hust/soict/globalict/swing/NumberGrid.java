package hust.soict.globalict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        // Khởi tạo ô hiển thị Text
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // FIX: Đặt chiều cao cố định cho ô hiển thị để không bị móp
        tfDisplay.setPreferredSize(new Dimension(0, 40));
        // Tùy chọn: Làm chữ to lên cho dễ nhìn
        tfDisplay.setFont(new Font("Arial", Font.BOLD, 20));

        // Khởi tạo Panel chứa các nút bấm với GridLayout (4 hàng, 3 cột)
        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 2, 2)); // Thêm khoảng cách (gap) giữa các nút
        addButtons(panelButtons);

        // Đưa các thành phần vào Content Pane bằng BorderLayout
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        // Cài đặt thông số cho cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");

        // FIX: Tăng kích thước cửa sổ lên một chút để các nút bấm rộng rãi hơn
        setSize(250, 300);
        setLocationRelativeTo(null); // Căn giữa màn hình
        setVisible(true);
    }

    // Phương thức thêm các nút bấm vào Panel
    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();

        // Thêm các nút từ 1 đến 9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Thêm nút DEL
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Thêm nút 0
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Thêm nút C (Reset)
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    // Lớp nội xử lý sự kiện bấm nút
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();

            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                // Nếu là số: Nối thêm số vào màn hình
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                // Nút DEL: Xóa ký tự cuối cùng
                String currentText = tfDisplay.getText();
                if (currentText.length() > 0) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else {
                // Nút C: Xóa trắng màn hình
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}