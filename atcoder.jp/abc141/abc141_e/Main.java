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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            String S = in.next();

            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 1 + max; j * 2 - 1 < N - i; j++) {
                    int last = i + j;
                    String t = S.substring(i, last);
                    if (S.indexOf(t, last) >= 0) {
                        max = Math.max(max, t.length());
                    } else {
                        break;
                    }
                }
            }
            out.println(max);
        }

    }
}

