import javax.swing.JOptionPane;

public class ChoosingOptionCustomize{
    public static void main (String[] args){
        String[] options = {"I do", "I don't"};
        int choice = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?","Custom Choice",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[0]);   // mặc định chọn "I do"

        if (choice == 0) {
            JOptionPane.showMessageDialog(null, "You chose: I do");
        } else if (choice == 1) {
            JOptionPane.showMessageDialog(null, "You chose: I don't");
        } else {
            JOptionPane.showMessageDialog(null, "Dialog closed (X)");
        }

    }
}