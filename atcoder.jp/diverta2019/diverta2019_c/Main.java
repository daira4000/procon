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
            int N = in.nextInt();
            String[] s = new String[N];

            int count = 0;
            int countA = 0;
            int countB = 0;
            int countBoth = 0;

            for (int i = 0; i < N; i++) {
                s[i] = in.next();
                if (s[i].startsWith("B") && s[i].endsWith("A")) {
                    countBoth++;
                } else if (s[i].startsWith("B")) {
                    countB++;
                } else if (s[i].endsWith("A")) {
                    countA++;
                }
                int len = s[i].length();
                for (int j = 0; j < len - 1; j++) {
                    if (s[i].charAt(j) == 'A' && s[i].charAt(j + 1) == 'B') {
                        count++;
                    }
                }
            }

            int minAB = Math.min(countA, countB);
            countA -= minAB;
            countB -= minAB;
            count += minAB;

            if (countBoth > 0) {
                if (minAB > 0 || countA > 0 || countB > 0) {
                    count += countBoth;
                } else {
                    count += countBoth - 1;
                }
            }
            out.println(count);
        }

    }
}

