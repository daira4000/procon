import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            long K = in.nextLong();
            Long[] A = new Long[N];
            Long[] F = new Long[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextLong();
            }
            for (int i = 0; i < N; i++) {
                F[i] = in.nextLong();
            }
            Arrays.sort(A, Comparator.naturalOrder());
            Arrays.sort(F, Comparator.reverseOrder());

            long min = -1;
            long max = (long) 1e13;
            while (min + 1 < max) {
                long mid = (max + min) / 2;
                long cost = 0;
                for (int i = 0; i < N; i++) {
                    long temp = mid / F[i];
                    if (A[i] >= temp) {
                        cost += A[i] - temp;
                    }
                    if (K < cost) {
                        break;
                    }
                }
                if (cost <= K) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
            out.println(max);
        }

    }
}

