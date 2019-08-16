import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int T = in.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            int cnt = 0;
            int min = A[0];
            int diff = 0;
            for (int i = 1; i < N; i++) {
                if (A[i] < min) {
                    min = A[i];
                } else {
                    if (A[i] - min > diff) {
                        diff = A[i] - min;
                        cnt = 1;
                    } else if (A[i] - min == diff) {
                        cnt++;
                    }
                }
            }
            out.println(cnt);
        }

    }
}

