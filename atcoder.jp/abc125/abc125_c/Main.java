import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

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
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }
            int[] L = new int[N + 1];
            int[] R = new int[N + 1];
            Arrays.fill(L, 0);
            Arrays.fill(R, 0);

            for (int i = 0; i < N; i++) {
                L[i + 1] = gcd(A[i], L[i]);
            }

            for (int i = N - 1; i >= 0; i--) {
                R[i] = gcd(A[i], R[i + 1]);
            }

            int max = 0;
            for (int i = 0; i < N; i++) {
                int temp = gcd(L[i], R[i + 1]);
                if (max < temp) {
                    max = temp;
                }
            }
            out.println(max);
        }

        int gcd(int a, int b) {

            if (a < b) {
                a ^= b;
                b ^= a;
                a ^= b;
            }

            return b > 0 ? gcd(b, a % b) : a;
        }

    }
}

