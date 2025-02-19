package askiseisjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class askisi3 {
    public static void main(String[] args) {
        String filePath = "C:/Users/nickt/Desktop/input.txt";
        File file = new File(filePath);
        int[][] charTable = new int[128][2];
        for (int i = 0; i < 128; i++) {
            charTable[i][0] = i;
            charTable[i][1] = 0;
        }

        int totalCharacters = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int ch;
            while ((ch = reader.read()) != -1){
                if (!Character.isWhitespace(ch) && ch >= 0 && ch < 128) {
                    charTable[ch][1]++;
                    totalCharacters++;
                }
            }
        } catch (IOException e) {
            System.err.println("Σφάλμα κατά την ανάγνωση του αρχείου: " + e.getMessage());
            return;
        }

        List<int[]> charList = new ArrayList<>();
        for(int i = 0; i < 128; i++){
            if(charTable[i][1] > 0) {
                charList.add(charTable[i]);
            }
        }

        charList.sort(Comparator.comparingInt(p->p[0]));
        System.out.println("\nΤαξινομηση κατα χαρακτηρα.");
        for(int[] entry : charList){
            System.out.printf("%c: %d\n",(char) entry[0], entry[1]);
        }


        Map<Character, Integer> frequencyMap = new HashMap<>();
        List<Map.Entry<Character, Integer>> charListByFrequency = new ArrayList<>(frequencyMap.entrySet());

        System.out.println("\nΤαξινομηση κατα συχνοτητα.");
        charListByFrequency.sort(Comparator.comparing((Map.Entry<Character, Integer> entry) -> entry.getValue()).reversed());

        for (Map.Entry<Character, Integer> entry : charListByFrequency) {
            double percentage = (entry.getValue() * 100.0) / totalCharacters;
            System.out.printf("%c: %d (%.2f%%)\n", entry.getKey(), entry.getValue(), percentage);
        }
    }
}
