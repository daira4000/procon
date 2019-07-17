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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }

            int min = Arrays.stream(a).min().getAsInt();
            int max = Arrays.stream(a).max().getAsInt();
            long cost = Long.MAX_VALUE;
            for (int i = min; i <= max; i++) {
                final int y = i;
                long temp = Arrays.stream(a).mapToLong(x -> (long) Math.pow(x - y, 2)).sum();
                cost = Math.min(cost, temp);
            }
            out.println(cost);
        }

    }
}

