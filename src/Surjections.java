// surjections
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

            long count = solve(m, n);

            String output = String.format("S(%s,%s) = %s", m, n, count);
            System.out.println(output);
            printWriter.println(output);
        }

        printWriter.close();
    }

    private static long solve(long m, long n) {
        if (n == 1) {
            return 1;
        } else if (m < n) {
            return 0;
        } else if (m == n) {
            return factorial(m);
        } else {
            return exponent(n, m) - sum(m, n);
        }
    }

    private static long sum(long m, long n) {
        long sum = 0;
        for (int i = 1; i <= n - 1; i++) {
            sum += combination(n, i) * solve(m, i);
        }
        return sum;
    }

    private static long combination(long n, long i) {
        if (i == 0 || n == 0 || i == n) {
            return 1;
        } else {
            return combination(n - 1, i - 1) + combination(n - 1, i);
        }
    }

    private static long exponent(long number, long power) {
        if (power == 0) {
            return 1;
        } else {
            long exponent = 1;
            for (int i = 1; i < power + 1; i++) {
                exponent *= number;
            }
            return exponent;
        }
    }

    private static long factorial(long l) {
        long factorial = 1;
        for (int i = 1; i < l + 1; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
