import java.io.*;
import java.util.Scanner;

public class EscriureFitxer {

    public static void main(String[] args) {
        escriureFitxer();
    }

    public static void escriureFitxer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el camí de l'arxiu per escriure-hi: ");
        String cami = scanner.nextLine();
        System.out.print("Introdueix el número de línies a escriure: ");
        int numLinies = Integer.parseInt(scanner.nextLine());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cami))) {
            for (int i = 0; i < numLinies; i++) {
                System.out.print("Introdueix la línia " + (i + 1) + ": ");
                String linia = scanner.nextLine();
                writer.write(linia);
                writer.newLine();
            }
            System.out.println("L'arxiu ha estat creat correctament.");
        } catch (IOException e) {
            System.out.println("Error al escriure l'arxiu: " + e.getMessage());
        }
    }
}
