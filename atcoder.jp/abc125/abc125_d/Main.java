import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.stream.LongStream;
import java.util.Scanner;
import java.util.OptionalInt;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int[] A = new int[N];
            int nega = 0;
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
                nega += A[i] < 0 ? 1 : 0;
                A[i] = Math.abs(A[i]);
            }
            int min = 0;
            if (nega % 2 == 1) {
                min = Arrays.stream(A).min().getAsInt();
            }
            long sum = Arrays.stream(A).asLongStream().sum();
            out.println(sum - (min * 2));
        }

    }
}

