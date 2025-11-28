/**
 * multTableGen.java
 *
 * Simple command-line multiplication table generator.
 *
 * Usage:
 *   java multTableGen            -> prints 10x10 table (default)
 *   java multTableGen N          -> prints NxN table (N must be positive)
 *   java multTableGen ROWS COLS  -> prints ROWS x COLS table (both positive)
 *
 * Examples:
 *   java multTableGen 5
 *   java multTableGen 3 7
 */
public class multTableGen {

    public static void main(String[] args) {
        int rows = 35;
        int cols = 14;

        if (args.length == 1) {
            try {
                rows = cols = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                printUsageAndExit("Invalid number: " + args[0]);
            }
        } else if (args.length == 2) {
            try {
                rows = Integer.parseInt(args[0]);
                cols = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                printUsageAndExit("Invalid numbers: " + args[0] + " " + args[1]);
            }
        } else if (args.length > 2) {
            printUsageAndExit("Too many arguments.");
        }

        if (rows <= 0 || cols <= 0) {
            printUsageAndExit("Rows and columns must be positive integers.");
        }

        printMultiplicationTable(rows, cols);
    }

    private static void printUsageAndExit(String message) {
        System.err.println("Error: " + message);
        System.err.println("Usage: java multTableGen [ROWS] [COLS]");
        System.err.println("  No args -> 10x10 table. One arg -> NxN. Two args -> ROWS x COLS.");
        System.exit(1);
    }

    private static void printMultiplicationTable(int rows, int cols) {
        //Header
        System.out.print("\\hline \n$\\times$ & ");
        System.out.print(1);
        for (int i = 2; i<=cols; i++) {
            System.out.print(" & " + i);
        }
        System.out.println(" \\\\");

        //Rows
        for (int i = 1; i<=rows; i++) {
            //Columsn
            System.out.print(i);
            for (int j = 1; j<=cols; j++) {
                System.out.print(" & " + i*j);
            }
            System.out.println(" \\\\ \n\\hline");
        }
    }
}