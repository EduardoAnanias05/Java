import java.util.Scanner;

public class exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[4];
        double soma = 0;
        boolean bonus = true;

        for (int i = 0; i < 4; i++) {
            System.out.print("Digite a nota da disciplina " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            soma += notas[i];
            if (notas[i] <= 9) {
                bonus = false;
            }
        }

        double media = soma / 4;
        
        // Aplica o bônus de 10% se todas as notas forem acima de 9
        if (bonus) {
            media *= 1.1;
        }

        System.out.printf("Média final: %.2f\n", media);

        if (media >= 7) {
            System.out.println("Status: Aprovado");
        } else if (media >= 5) {
            System.out.println("Status: Recuperação");
        } else {
            System.out.println("Status: Reprovado");
        }

        scanner.close();
    }
}
