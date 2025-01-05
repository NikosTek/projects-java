package askiseisjava;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class askisi1 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(new File("C:/Users/nickt/arithmoi.txt"));
             PrintStream ps = new PrintStream("C:/Users/nickt/project1.txt", StandardCharsets.UTF_8)) {

            final int eksada = 6;
            int[] inputNumbers = new int[49];
            int pivot = 0;
            int num;
            int window;
            int[] eksades = new int[eksada];

            while ((num = in.nextInt()) != -1 && pivot <= 48) {
                inputNumbers[pivot++] = num;
            }

            int[] numbers = Arrays.copyOfRange(inputNumbers, 0, pivot);
            Arrays.sort(numbers);

            window = pivot - eksada;
            for (int i = 0; i <= window; i++) {
                for (int j = i + 1; j <= window + 1; j++) {
                    for (int k = j + 1; k <= window + 2; k++) {
                        for (int l = k + 1; l <= window + 3; l++) {
                            for (int m = l + 1; m <= window + 4; m++) {
                                for (int n = m + 1; n <= window + 5; n++) {
                                    eksades[0] = numbers[i];
                                    eksades[1] = numbers[j];
                                    eksades[2] = numbers[k];
                                    eksades[3] = numbers[l];
                                    eksades[4] = numbers[m];
                                    eksades[5] = numbers[n];

                                    if (!zigoi(eksades, 4) && !peritoi(eksades, 4) && !idiadekada(eksades, 3) && !idioiligontes(eksades, 3) && !sinexomenoi(eksades)) {
                                        ps.printf("%d %d %d %d %d %d\n", eksades[0], eksades[1], eksades[2], eksades[3], eksades[4], eksades[5]);
                                    }
                                }
                            }
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean zigoi(int[] arr, int thres) {
        long evenCounter = 0;

        evenCounter = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .count();
        return evenCounter >= thres;
    }

    public static boolean peritoi(int[] arr, int thres) {
        long oddCounter = 0;

        oddCounter = Arrays.stream(arr)
                .filter(n -> n % 2 != 0)
                .count();
        return oddCounter >= thres;
    }


    public static boolean idiadekada(int[] arr, int thres) {
        int[] dekades = new int[5];

        for (int n : arr) {
            dekades[n / 10]++;
        }

        return Arrays.stream(dekades).anyMatch(d -> d >= thres);

    }

    public static boolean sinexomenoi(int[] arr) {
        int consCounter = 0;

        for (int i = 0; i <= 3; i++) {
            if (arr[i] == arr[i + 1] - 1 && arr[i] == arr[i + 2] - 2) {
                consCounter++;
                break;
            }
        }

        return consCounter >= 2;

    }


    public static boolean idioiligontes(int[] arr, int thres) {
        int[] ligontes = new int[10];

        for (int n : arr) {
            ligontes[n % 10]++;
        }

        return Arrays.stream(ligontes).anyMatch(l -> l >= thres);

    }
}

