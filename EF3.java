import java.util.Scanner;

public class EF3 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String var;
        do {
            var = keyboard.next();
            System.out.println(decode(var));
        } while (!var.equals("0"));
    }

    public static int decode(String input) {
        int len = input.length();
        int[] combinations = new int[len];
        combinations[0] = 1;
        int last = 0;
        for (int i = 1; i < len; i++) {
            if (Integer.parseInt(Character.toString(input.charAt(i - 1))) == 0 || Integer.parseInt(Character.toString(input.charAt(i))) == 0) {
                combinations[i] = combinations[last];
                if (last != i - 1) {return 0;}
            } else {
                combinations[i] = combinations[i - 1];
                if (Integer.parseInt(Character.toString(input.charAt(i - 1)) + Character.toString(input.charAt(i))) < 27) {
                    combinations[i] += combinations[last];
                    last = i - 1;
                }
            }
        }
        return combinations[len - 1];
    }

}