import javax.swing.JOptionPane;
import java.math.*;
import java.text.ListFormat.Style;
public class SecondDegreeEquation {

    public static void main(String[] args){
        String strA, strB, strC;
        strA = JOptionPane.showInputDialog(null, "Please input the value of A: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strB = JOptionPane.showInputDialog(null, "Please input the value of B: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strC = JOptionPane.showInputDialog(null, "Please input the value of C: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        String strNotifications;
        strNotifications = "Second Degree Equation: " + strA + ".x^2" + "+" + strB + "x" + "+" + strC;
        JOptionPane.showMessageDialog(null, strNotifications, "Second Degree Equation with one variable", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double c = Double.parseDouble(strC);
        if (a == 0){
            if (b == 0){
                if (c == 0){
                    JOptionPane.showMessageDialog(null, "Infinite Solutions","Results", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else{
                    JOptionPane.showMessageDialog(null, "No solutions", "Results", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            else{
                double res = -c/b;
                JOptionPane.showMessageDialog(null, "The solution is "+ res, "Results", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        else{
            double delta = Math.pow(b,2) - 4*a*c;
            if (delta < 0){
                JOptionPane.showMessageDialog(null, "No solution", "Results", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            else if(delta == 0){
                double res = -b/(2*a);
                JOptionPane.showMessageDialog(null, "The solution is " + res , "Results", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            else{
                double res1 = (-b + Math.sqrt(delta)) / (2*a);
                double res2 = (-b - Math.sqrt(delta)) / (2*a);
                JOptionPane.showMessageDialog(null, "First Solution: " + res1 + "\n"+ "Second Solution: " + res2 + "\n", "Results", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }
}
