
import java.util.Scanner;

public class Q03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = new String[10];

        for (int i = 0; i < names.length; i++) {
            System.out.print("Digite o " + (i + 1) + "° nome: ");
            names[i] = scan.nextLine();
        }

        for (int i = 0; i < names.length; i++) System.out.println(names[i]);
    }
}