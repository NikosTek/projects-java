package askiseisjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class askisi3 {
    public static void main(String[] args) {

        int[][] charFrequency = new int[128][2];
        for (int i = 0; i < 128; i++) {
            charFrequency[i][0] = i; // Αποθήκευση του χαρακτήρα (ως ακέραιος κωδικός ASCII)
            charFrequency[i][1] = 0; // Αρχικοποίηση μετρητή συχνότητας
        }


        try (BufferedReader reader = new BufferedReader(new FileReader("xaraktires.txt"))) {
            int c;
            while ((c = reader.read()) != -1) {
                char character = (char) c;
                // Αγνόηση whitespaces
                if (!Character.isWhitespace(character) && character < 128) {
                    charFrequency[character][1]++;
                }
            }
        } catch (IOException e) {
            System.err.println("Σφάλμα κατά την ανάγνωση του αρχείου: " + e.getMessage());
        }


    }
}
