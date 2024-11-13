import java.io.*;
import java.util.Scanner;

public class ComptarParaules {

    public static void main(String[] args) {
        comptarParaules();
    }

    public static void comptarParaules() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el camí de l'arxiu per comptar paraules: ");
        String cami = scanner.nextLine();
        File fitxer = new File(cami);

        if (fitxer.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fitxer))) {
                String linia;
                int comptador = 0;

                while ((linia = reader.readLine()) != null) {
                    if ("fi".equalsIgnoreCase(linia)) {
                        break;
                    }
                    String[] paraules = linia.split("\\s+");
                    comptador += paraules.length;
                }

                System.out.println("El nombre de paraules fins a la línia 'fi' és: " + comptador);
            } catch (IOException e) {
                System.out.println("Error al llegir l'arxiu: " + e.getMessage());
            }
        } else {
            System.out.println("El fitxer no existeix.");
        }
    }
}
