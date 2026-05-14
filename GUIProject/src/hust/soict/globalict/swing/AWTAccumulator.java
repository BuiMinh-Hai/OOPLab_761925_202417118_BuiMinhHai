package hust.soict.globalict.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an Integer: "));
        tfInput = new TextField(10);
        add(tfInput);
        
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The Accumulated Sum is: "));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false); // Không cho phép người dùng sửa ô này
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);

        // Xử lý sự kiện đóng cửa sổ (bắt buộc trong AWT để có thể tắt app bằng nút X)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }

    // Lớp nội (Inner class) đóng vai trò là ActionListener cho tfInput
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}
