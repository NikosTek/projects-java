/*
 Project 04
 Αναπτύξτε ένα παιχνίδι Τρίλιζα, όπου δύο παίκτες παίζουν Χ και Ο (ή 1 και 2 αν θέλετε
 να υλοποιήσετε με πίνακα ακεραίων και όχι με πίνακα char) και κερδίζει ο παίκτης
 που έχει συμπληρώσει τρία ίδια σύμβολα ή αριθμούς σε οποιαδήποτε διάσταση του
 πίνακα, οριζόντια, κάθετα ή διαγώνια.
 Η main() μπορεί να ελέγχει τη ροή του παιχνιδιού, όπως ποιος παίκτης παίζει κάθε
 φορά (εναλλαγή μεταξύ των δύο παικτών), να διαβάζει από το stdin το σύμβολο που
 δίνει ο κάθε παίκτης και να εμφανίζει με γραφικό τρόπο την τρίλιζα μετά από κάθε
 κίνηση κάθε παίκτη.
 Ενώ, μπορείτε να δημιουργήσετε και μία μέθοδο που να ελέγχει (μετά από κάθε
 κίνηση) αν ο παίκτης που έκανε την κίνηση έκανε τρίλιζα.
 Το πρόγραμμα θα πρέπει να λαμβάνει υπόψη την περίπτωση ισοπαλίας όπως και να
 μην επιτρέπει ένας παίκτης να παίξει σε θέση που είναι ήδη κατειλημμένη.
 */


package askiseisjava;
import java.util.Scanner;

public class askisi4 {
    private static final char EMPTY = '-';
    private static final char X = 'X';
    private static final char O = 'O';
    private static char[][] board = new char[3][3];

    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    private static void initializeBoard(){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = EMPTY;
            }
        }
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = X;
        int moves = 0;
        boolean gameWinner = false;

        while (moves < 9 && !gameWinner) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter row and column: (0-2)");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                moves++;
                gameWinner = Win (currentPlayer);
                if (!gameWinner) {
                    currentPlayer = (currentPlayer == X) ? O : X;
                }
            } else {
                    System.out.println("Invalid move. Try again.");
            }
        }

        if (gameWinner) {
            System.out.println("Player " + currentPlayer + " Wins");
        } else {
            System.out.println("It's a tie!");
        }
        scanner.close();
    }

    private static void printBoard () {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


        private static boolean isValidMove ( int row, int col){
            return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY;
        }

        private static boolean Win ( char player){
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
                if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
            }
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
            return false;
        }
    }

