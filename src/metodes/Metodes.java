package metodes;

import java.io.*;
import java.util.Scanner;

public class Metodes {

    public static void escriureText() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el camí de l'arxiu: ");
        String cami = scanner.nextLine();
        System.out.print("Introdueix el text per afegir a l'arxiu: ");
        String text = scanner.nextLine();
        String textManipulat = manipularText(text);
        System.out.println("Text modificat: " + textManipulat);
        escriureEnArxiu(cami, text);
        llegirArxiuEnMajuscules(cami);
    }

    private static String manipularText(String text) {
        StringBuilder textManipulat = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                textManipulat.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                textManipulat.append(Character.toUpperCase(c));
            } else {
                textManipulat.append(c);
            }
        }
        return textManipulat.toString();
    }

    private static void escriureEnArxiu(String cami, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cami))) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Error al escriure l'arxiu: " + e.getMessage());
        }
    }

    private static void llegirArxiuEnMajuscules(String cami) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cami))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                System.out.println(linia.toUpperCase());
            }
        } catch (IOException e) {
            System.out.println("Error al llegir l'arxiu: " + e.getMessage());
        }
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
