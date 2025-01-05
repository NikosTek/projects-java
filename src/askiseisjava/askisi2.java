package askiseisjava;

public class askisi2 {


    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maximumSumSubarray(arr);
        System.out.println("Το μέγιστο άθροισμα είναι: " + max);
    }


    public static int maximumSumSubarray(int[] arr) {

        int localMaximum = arr[0];
        int globalMaximum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            localMaximum = Math.max(localMaximum + arr[i],arr[i]);
            globalMaximum = Math.max(globalMaximum, localMaximum);
        }

        return globalMaximum;
    }
}

//Κάθε επανάληψη εκτελεί έναν σταθερό αριθμό πράξεων. Επομένως, η χρονική πολυπλοκότητα είναι 𝑂(n).