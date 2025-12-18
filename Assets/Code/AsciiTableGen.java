public class AsciiTableGen {
    // prints a multi-column markdown ASCII table of ASCII characters 32-126
    public static void main(String[] args) {
        String[] rows = new String[35];
        // First 2 rows: header and separator
        rows[0] = "| Dec | Hex | Char |     | Dec | Hex | Char |     | Dec | Hex | Char |     | Dec | Hex | Char |";
        rows[1] = "|-----|-----|------|-----|-----|-----|------|-----|-----|-----|------|-----|-----|-----|------|";

        // Adding specials to first column
        for (int i = 32; i <= 47; i++) {
            char character = (char) i;
            String row = String.format("| **%2d** | %3s |  %c   |", i, Integer.toHexString(i).toUpperCase(), character);
            rows[i-32+2] = row;
        }
        // Adding extra specials to first column
        for (int i = 58; i <= 64; i++) {
            char character = (char) i;
            String row = String.format("| **%2d** | %3s |  %c   |", i, Integer.toHexString(i).toUpperCase(), character);
            rows[i-42+2] = row;
        }
        // Adding even more specials to first column
        for (int i = 91; i <= 96; i++) {
            char character = (char) i;
            String row = String.format("| **%2d** | %3s |  %c   |", i, Integer.toHexString(i).toUpperCase(), character);
            rows[i-68+2] = row;
        }
        // Adding last specials to first column
        for (int i = 123; i <= 126; i++) {
            char character = (char) i;
            String row = String.format("| **%2d** | %3s |  %c   |", i, Integer.toHexString(i).toUpperCase(), character);
            rows[i-94+2] = row;
        }
        // Adding numbers to second column
        for (int i = 48; i <= 57; i++) {
            char character = (char) i;
            String row = String.format("     | **%2d** | %3s |  %c   |", i, Integer.toHexString(i).toUpperCase(), character);
            rows[i-48+2] += row;
        }
        // Adding 15 empty lines to second column for alignment
        for (int i = 58; i <= 73; i++) {
            rows[i-48+2] += "     |        |     |      |";
        }

        // Adding upercase to third column
        for (int i = 65; i <= 90; i++) {
            char character = (char) i;
            String row = String.format("     | **%2d** | %3s |  %c   |", i, Integer.toHexString(i).toUpperCase(), character);
            rows[i-65+2] += row;
        }
        // Adding lowercase to fourth column
        for (int i = 97; i <= 122; i++) {
            char character = (char) i;
            String row = String.format("     | **%2d** | %3s |  %c   |", i, Integer.toHexString(i).toUpperCase(), character);
            rows[i-97+2] += row;
        }

        printTable(rows);

    }

    public static void printTable(String[] rows) {
        for (String row : rows) {
            System.out.println(row);
        }
    }
}