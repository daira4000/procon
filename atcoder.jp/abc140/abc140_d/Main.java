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
            int K = in.nextInt();
            String S = in.next();
            char[] cs = S.toCharArray();

            int li = 0;
            int ri = cs.length - 1;
            int cnt = 0;
            while (true) {
                while (li < ri && cs[li] == cs[li + 1]) {
                    cnt++;
                    li++;
                }
                while (li < ri && cs[ri - 1] == cs[ri]) {
                    cnt++;
                    ri--;
                }
                if (li < ri) {
                    if (0 < K) {
                        if (li + 1 == ri) {
                            cnt++;
                            break;
                        }
                        cnt += 2;
                        K--;
                    }
                    li++;
                    ri--;
                } else {
                    break;
                }
            }
            out.println(cnt);
        }

    }
}

