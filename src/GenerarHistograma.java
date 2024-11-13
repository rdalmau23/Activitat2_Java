import java.util.Scanner;

public class GenerarHistograma {

    public static void main(String[] args) {
        generarHistograma();
    }

    public static void generarHistograma() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el nombre de notes: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] notes = new int[n];
        System.out.println("Introdueix les notes (entre 0 i 10):");
        for (int i = 0; i < n; i++) {
            notes[i] = Integer.parseInt(scanner.nextLine());
        }

        int[] histograma = new int[11];
        for (int nota : notes) {
            if (nota >= 0 && nota <= 10) {
                histograma[nota]++;
            }
        }

        System.out.println("\nHistograma de notes:");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + ": " + "*".repeat(histograma[i]));
        }
    }
}
