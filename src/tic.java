import java.util.*;

public class tic {

        static String[] bräde;
        static String turr;

        static String checkWinner()
        {
            for (int a = 0; a < 8; a++) {
                String line = null;

                switch (a) {
                    case 0:
                        line = bräde[0] + bräde[1] + bräde[2];
                        break;
                    case 1:
                        line = bräde[3] + bräde[4] + bräde[5];
                        break;
                    case 2:
                        line = bräde[6] + bräde[7] + bräde[8];
                        break;
                    case 3:
                        line = bräde[0] + bräde[3] + bräde[6];
                        break;
                    case 4:
                        line = bräde[1] + bräde[4] + bräde[7];
                        break;
                    case 5:
                        line = bräde[2] + bräde[5] + bräde[8];
                        break;
                    case 6:
                        line = bräde[0] + bräde[4] + bräde[8];
                        break;
                    case 7:
                        line = bräde[2] + bräde[4] + bräde[6];
                        break;
                }
                if (line.equals("XXX")) {
                    return "X";
                }

                else if (line.equals("YYY")) {
                    return "Y";
                }
            }

            for (int a = 0; a < 9; a++) {
                if (Arrays.asList(bräde).contains(
                        String.valueOf(a + 1))) {
                    break;
                }
                else if (a == 8) {
                    return "draw";
                }
            }
            
            System.out.println(
                    turr + " din tur skriv nummer så skrivs "
                            + turr + " in:");
            return null;
        }


        static void printBoard()
        {
            System.out.println("|---|---|---|");
            System.out.println("| " + bräde[0] + " | "
                    + bräde[1] + " | " + bräde[2]
                    + " |");
            System.out.println("|-----------|");
            System.out.println("| " + bräde[3] + " | "
                    + bräde[4] + " | " + bräde[5]
                    + " |");
            System.out.println("|-----------|");
            System.out.println("| " + bräde[6] + " | "
                    + bräde[7] + " | " + bräde[8]
                    + " |");
            System.out.println("|---|---|---|");
        }

        public static void main(String[] args)
        {
            Scanner in = new Scanner(System.in);
            bräde = new String[9];
            turr = "X";
            String winner = null;

            for (int a = 0; a < 9; a++) {
                bräde[a] = String.valueOf(a + 1);
            }

            System.out.println("Välkommen till 3x3 Tic Tac Toe.");
            printBoard();

            System.out.println(
                    "X kommer börja spelet. skriv in ett nummer som finns i tabelen nedan för att sätta X :");

            while (winner == null) {
                int numInput;
                try {

                    numInput = in.nextInt();
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println(
                                "Finns inte på tabbelen har du syn fel? Försök igen:");
                        continue;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println(
                            "Finns inte på tabbelen har du syn fel? Försök igen:");
                    continue;
                }

                if (bräde[numInput - 1].equals(
                        String.valueOf(numInput))) {
                    bräde[numInput - 1] = turr;

                    if (turr.equals("X")) {
                        turr = "Y";
                    }
                    else {
                        turr = "X";
                    }

                    printBoard();
                    winner = checkWinner();
                }
                else {
                    System.out.println(
                            "Upptagen ju smarto använd ögon:");
                }
            }

            if (winner.equalsIgnoreCase("draw")) {
                System.out.println(
                        "Det är oavgjort ni båda suger KEKW");
            }


            else {
                System.out.println(
                        "Grattis! " + winner
                                + " Du van coolt din vän suger lol.");
            }
        }
}