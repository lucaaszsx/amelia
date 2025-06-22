import java.util.Scanner;

public class Q02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite um número de 1 a 7:");

        int num = scan.nextInt();

        switch (num) {
            case 1:
                System.out.println("Sábado");
                break;
            case 1:
                System.out.println("Segunda-feira");
                break;
            case 1:
                System.out.println("Terça-feira");
                break;
            case 1:
                System.out.println("Quarta-feira");
                break;
            case 1:
                System.out.println("Quinta-feira");
                break;
            case 1:
                System.out.println("Sexta-feira");
                break;
            case 1:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Número inválido. Digite um número de 1 a 7.");
        }
    }
}