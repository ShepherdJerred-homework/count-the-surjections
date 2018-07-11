// Surjections
// Jerred Shepherd

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Surjections {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("surjections.in");
        File outputFile = new File("surjections.out");

        Scanner scanner = new Scanner(inputFile);
        PrintWriter printWriter = new PrintWriter(outputFile);
        int m;
        int n;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitLine = line.split(" ");


            m = Integer.valueOf(splitLine[0]);
            n = Integer.valueOf(splitLine[1]);

            if (m == 0 && n == 0) {
                break;
            }

            int count = -1;

            if (n == 1) {
                count = 1;
            } else if (m < n) {
                count = 0;
            } else if (m == n) {
                // count = m!
            } else {
                // lots of math
            }

            String output = String.format("S(%s,%s) = %s", m, n, count);
            System.out.println(output);
            printWriter.println(output);
        }

        printWriter.close();
    }
}
