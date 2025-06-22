import java.util.Scanner;

public class Q03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite um número para imprimir a tabuada:");

        int num = scan.nextInt();

        for (int i = 1; i <= 10; i++) System.out.println(num + "x" + i + " = " + (num * i));
    }
}