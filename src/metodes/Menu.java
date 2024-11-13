package metodes;

import java.util.Scanner;

public class Menu {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Escriure text i manipular");
            System.out.println("2. Copiar contingut de dos fitxers en un altre");
            System.out.println("3. Comptar paraules fins a la línia 'fi'");
            System.out.println("4. Màquina d'escriure (crear fitxer amb línies de text)");
            System.out.println("5. Generar histograma de notes");
            System.out.println("0. Sortir");

            System.out.print("Introdueix una opció: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    Metodes.escriureText();
                    break;
                case 2:
                    Metodes.copiarFitxers();
                    break;
                case 3:
                    Metodes.comptarParaules();
                    break;
                case 4:
                    Metodes.escriureFitxer();
                    break;
                case 5:
                    Metodes.generarHistograma();
                    break;
                case 0:
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
                    break;
            }
        }
    }
}
