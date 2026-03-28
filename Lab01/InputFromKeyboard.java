import java.util.Scanner;
public class InputFromKeyboard {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("What 's your name?");
        String strName = s.nextLine();
        System.out.println("How old are you?");
        int age = s.nextInt();
        System.out.println("How tall are you(m) ?");
        double height = s.nextDouble();
        System.out.println("Mrs/Ms. " + strName + ", " + age + " years old. " + "Your height is " + height + " m.");

    }
}
