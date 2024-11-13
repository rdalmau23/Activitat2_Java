import java.io.*;
import java.util.Scanner;

public class EscriureText {

    public static void main(String[] args) {
        escriureText();
    }

    public static void escriureText() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix ruta del fitxer: ");
        String cami = scanner.nextLine();
        System.out.print("Introdueix el text: ");
        String text = scanner.nextLine();
        String textCanviat = canviarText(text);
        System.out.println("Text modificat: " + textCanviat);
        escriureEnArxiu(cami, text);
        llegirArxiuEnMajuscules(cami);
    }

    private static String canviarText(String text) {
        StringBuilder textCanviat = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                textCanviat.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                textCanviat.append(Character.toUpperCase(c));
            } else {
                textCanviat.append(c);
            }
        }
        return textCanviat.toString();
    }

    private static void escriureEnArxiu(String cami, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cami))) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Error al escriure el fitxerr: " + e.getMessage());
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
}
