package hust.soict.globalict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Integer: "));
        tfInput = new JTextField(10);
        cp.add(tfInput);
        
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false); // Ô hiển thị kết quả không được sửa
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        
        // Khác với AWT, Swing có thể tự đóng chương trình khi bấm nút X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn; 
                
                tfInput.setText(""); 
                tfOutput.setText(sum + ""); 
            } catch (NumberFormatException e) {
                // Xử lý trường hợp người dùng nhập chữ thay vì số
                JOptionPane.showMessageDialog(null, "Please enter a valid integer!");
                tfInput.setText("");
            }
        }
    }
}
