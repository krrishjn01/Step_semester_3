package string.class_problems;

import java.util.Random;
import java.util.Scanner;

public class CollegeCodingArcade {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int n = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            playerMoves[i] = sc.next();

            computerMoves[i] = moves[random.nextInt(3)];

            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer Move: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);
            System.out.println();
        }

        System.out.println("Round | Player Move | Computer Move | Result");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "     | " +
                    playerMoves[i] + "       | " +
                    computerMoves[i] + "        | " +
                    results[i]);
        }

        double winPercentage = (wins * 100.0) / n;

        System.out.println("\nFinal Summary");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win % = " + winPercentage);

        sc.close();
    }
}