import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
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
            int M = in.nextInt();
            int[] L = new int[M];
            int[] R = new int[M];
            for (int i = 0; i < M; i++) {
                L[i] = in.nextInt();
                R[i] = in.nextInt();
            }
            int Lmax = Arrays.stream(L).max().getAsInt();
            int Rmin = Arrays.stream(R).min().getAsInt();
            int ans = Rmin - Lmax + 1;
            out.println(ans < 0 ? 0 : ans);
        }

    }
}

