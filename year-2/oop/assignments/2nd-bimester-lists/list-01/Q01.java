import java.util.Scanner;

public class Q01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um número: ");

        int num = scan.nextInt();

        System.out.println(num > 0 ? "Positivo" : num < 0 ? "Negativo" : "Igual a zero");
    }
}