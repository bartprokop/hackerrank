/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourglassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int sum = Integer.MIN_VALUE;
        for (int i=1; i<arr.length-1; i++)
            for (int j=1; j<arr.length-1; j++) {
                int s = sum(arr, i, j);
                if (sum<s) sum = s;
            }
        return sum;
    }

    private static int sum(int[][] arr, int i, int j) {
        int s = 0;
        s += arr[i][j];
        s += arr[i-1][j-1];
        s += arr[i-1][j];
        s += arr[i-1][j+1];
        s += arr[i+1][j-1];
        s += arr[i+1][j];
        s += arr[i+1][j+1];
        return s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
