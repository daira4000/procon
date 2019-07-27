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
        static int MOD = (int) 1e9 + 7;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String S = in.next();
            char c = S.charAt(0);
            if (S.length() == 1) {
                if (c == '5' || c == '?') {
                    out.println(1);
                } else {
                    out.println(0);
                }
                return;
            }

            int[] xs = new int[13];
            if (c == '?') {
                for (int i = 0; i < 10; i++) {
                    xs[i] = 1;
                }
            } else {
                xs[c - '0'] = 1;
            }

            for (int i = 1; i < S.length(); i++) {
                int[] ys = new int[13];
                c = S.charAt(i);
                if (c == '?') {
                    for (int j = 0; j < 10; j++) {
                        for (int k = 0; k < 13; k++) {
                            int index = (k * 10 + j) % 13;
                            ys[index] += xs[k];
                            ys[index] %= MOD;
                        }
                    }
                } else {
                    for (int k = 0; k < 13; k++) {
                        int index = (k * 10 + (c - '0')) % 13;
                        ys[index] += xs[k];
                        ys[index] %= MOD;
                    }
                }
                xs = ys;
            }
            out.println(xs[5]);
        }

    }
}

