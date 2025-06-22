import java.util.Scanner;

public class Q04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = -1, sum = 0, index = 0;

        while (num != 0) {
            System.out.println("Digite o " + (index + 1) + "° número (ou \"0\" para finalizar):");

            num += scan.nextInt();
            sum += num;
            index++;
        }

        System.out.println("O resultado da soma dos " + (index + 1) + " números digitados é: " + sum);
    }
}