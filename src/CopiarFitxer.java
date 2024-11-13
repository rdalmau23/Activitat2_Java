import java.io.*;
import java.util.Scanner;

public class CopiarFitxer {

    public static void main(String[] args) {
        copiarFitxers();
    }

    public static void copiarFitxers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix la ruta del primer fitxer: ");
        String fitxer1 = scanner.nextLine();
        System.out.print("Introdueix la ruta del segon fitxer: ");
        String fitxer2 = scanner.nextLine();
        System.out.print("Introdueix la ruta de destinació (només carpeta): ");
        String rutaDestinacio = scanner.nextLine();
        copiarFitxersEnUn(fitxer1, fitxer2, rutaDestinacio);
    }

    private static void copiarFitxersEnUn(String fitxer1, String fitxer2, String rutaDestinacio) {
        File arxiu1 = new File(fitxer1);
        File arxiu2 = new File(fitxer2);

        if (arxiu1.exists() && arxiu2.exists()) {
            String nomNou = rutaDestinacio + File.separator + arxiu1.getName().split("\\.")[0] + "_"
                    + arxiu2.getName().split("\\.")[0] + ".txt";

            File fitxerDestinacio = new File(nomNou);
            if (fitxerDestinacio.exists()) {
                System.out.print("El fitxer ja existeix. Vols sobreescriure'l (sí/no)? ");
                Scanner scanner = new Scanner(System.in);
                String resposta = scanner.nextLine();
                if ("sí".equalsIgnoreCase(resposta)) {
                    copiar(fitxer1, fitxerDestinacio);
                    copiar(fitxer2, fitxerDestinacio);
                }
            } else {
                copiar(fitxer1, fitxerDestinacio);
                copiar(fitxer2, fitxerDestinacio);
            }
        } else {
            System.out.println("Un dels fitxers no existeix.");
        }
    }

    private static void copiar(String origen, File destinacio) {
        try (BufferedReader br = new BufferedReader(new FileReader(origen));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destinacio, true))) {

            String linia;
            while ((linia = br.readLine()) != null) {
                bw.write(linia);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al copiar els fitxers: " + e.getMessage());
        }
    }
}
