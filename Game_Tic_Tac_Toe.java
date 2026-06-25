// package TIC_TAC_TOE;

import java.util.Random;
import java.util.Scanner;

public class Game_Tic_Tac_Toe {

    public static boolean winning(String[][] tic_tac_toe, String symbol) {
        for (int i = 0; i < 3; i++) {
            if (tic_tac_toe[i][0].equals(symbol) && tic_tac_toe[i][1].equals(symbol)
                    && tic_tac_toe[i][2].equals(symbol)) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tic_tac_toe[0][i].equals(symbol) && tic_tac_toe[1][i].equals(symbol)
                    && tic_tac_toe[2][i].equals(symbol)) {
                return true;
            }
        }
        if (tic_tac_toe[0][0].equals(symbol) && tic_tac_toe[1][1].equals(symbol) && tic_tac_toe[2][2].equals(symbol)) {
            return true;
        }
        if (tic_tac_toe[0][2].equals(symbol) &&
                tic_tac_toe[1][1].equals(symbol) &&
                tic_tac_toe[2][0].equals(symbol)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int moves = 0;

        System.out.println("-----------TIC-TAC-TOE GAME---------------------");
        System.out.println();

        System.out.print("Enter user choice:");
        String user = sc.next();
        String comp;

        if (user.equalsIgnoreCase("X")) {
            comp = "O";
        } else if (user.equalsIgnoreCase("O")) {
            comp = "X";
        } else {
            System.out.println("Enter valid character");
            return;
        }

        char choice;
        do {
            int rows = 3;
            int cols = 3;
            String[][] tic_tac_toe = {
                    { "1", "2", "3" },
                    { "4", "5", "6" },
                    { "7", "8", "9" }
            };

            System.out.println();
            System.out.println("-----TIC-TAC-TOE Board---------");
            System.out.println();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (j < 2) {
                        System.out.print(tic_tac_toe[i][j] + " | ");
                    } else {
                        System.out.print(tic_tac_toe[i][j]);
                    }

                }
                System.out.println();
                System.out.println(("---------"));
            }

            while (true) {
                System.out.print("Enter the position (USER): ");
                int pos_user = sc.nextInt();
                int pos_comp = rand.nextInt(9) + 1;

                if (pos_user < 1 || pos_user > 9) {
                    System.out.println("Invalid Position!");
                    continue;
                }

                int rowUser = (pos_user - 1) / 3;
                int colUser = (pos_user - 1) % 3;

                if (tic_tac_toe[rowUser][colUser].equalsIgnoreCase("X") ||
                    tic_tac_toe[rowUser][colUser].equalsIgnoreCase("O")) {
                    System.out.println("Position already occupied!");
                    continue;
                }
                tic_tac_toe[rowUser][colUser] = user;
                moves++;

                System.out.println();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (j < 2) {
                            System.out.print(tic_tac_toe[i][j] + " | ");
                        } else if (j == 2) {
                            System.out.print(tic_tac_toe[i][j]);
                        }

                    }
                    System.out.println();
                    System.out.println(("---------"));
                }

                int rowComp = (pos_comp - 1) / 3;
                int colComp = (pos_comp - 1) % 3;

                while (tic_tac_toe[rowComp][colComp].equalsIgnoreCase("X") ||
                      tic_tac_toe[rowComp][colComp].equalsIgnoreCase("O")) {
                    pos_comp = rand.nextInt(9) + 1;

                    rowComp = (pos_comp - 1) / 3;
                    colComp = (pos_comp - 1) % 3;
                }

                System.out.println();
                System.out.println("Computer selected position: " + pos_comp);
                tic_tac_toe[rowComp][colComp] = comp;
                moves++;

                System.out.println();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (j < 2) {
                            System.out.print(tic_tac_toe[i][j] + " | ");
                        } else if (j == 2) {
                            System.out.print(tic_tac_toe[i][j]);
                        }

                    }
                    System.out.println();
                    System.out.println(("---------"));
                }
                if (winning(tic_tac_toe, user)) {
                    System.out.println("USER WINS!!");
                    break;
                }
                if (winning(tic_tac_toe, comp)) {
                    System.out.println("COMPUTER WINS!!");
                    break;
                }
                if (moves == 9) {
                    System.out.println("MATCH DRAW!!");
                    break;
                }
            }
            System.out.print("Play Again? (Y/N): ");
            choice = sc.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');
        System.out.println("Thanks for playing!");
    }
}