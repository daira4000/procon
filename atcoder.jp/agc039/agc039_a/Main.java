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
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String S = in.next();
            long K = in.nextLong();

            int c1 = count(S);
            int c2 = count(S + S);
            int c3 = count(S + S + S);

            out.println(c1 + (c2 - c1) * (K / 2) + (c3 - c2) * (Math.max(K - 1, 0) / 2));
        }

        int count(String S) {
            char[] cs = S.toCharArray();
            int cnt = 0;
            for (int i = 0; i < cs.length - 1; i++) {
                if (cs[i] == cs[i + 1]) {
                    cs[i + 1] = '@';
                    cnt++;
                }
            }
            return cnt;
        }

    }
}

