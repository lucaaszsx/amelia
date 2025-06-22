import java.util.Scanner;

public class Q06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        loop: while (true) {
            System.out.println("[Lista de Ações]");
            System.out.println("0. Cancelar");
            System.out.println("1. Imprimir o alfabeto");
            System.out.println("2. Imprimir os números");
            System.out.println("3. Contagem regresiva");
            
            System.out.print("Digite uma das opções:");

            switch (scan.nextInt()) {
                case 0:
                    System.out.println("O processo de seleção de opções foi cancelado.");
                    break loop;
                    break;
                case 1: {
                    System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                break; }
                case 2: {
                    System.out.println("1234567890");
                break; }
                case 3: {
                    System.out.println("Digite um número:");

                    int num = scan.nextInt();

                    for (int i = num; i > 0; i--) {
                        System.out.println(i);
                        Thread.sleep(1000);
                    } 
                break; }
                default:
                    System.out.println("A opção selecionada é inválida!");
                    break;
            }
        }
    }
}