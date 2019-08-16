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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String S = in.next();
            char c = S.charAt(0);
            int cnt = 0;
            for (int i = 1; i < S.length(); i++) {
                char s = S.charAt(i);
                if (s != c) {
                    c = s;
                    cnt++;
                }
            }
            out.println(cnt);
        }

    }
}

