import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.stream.Collectors;

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

            int len = S.length();
            int[] ans = new int[len];

            int l = 0, r = 0;
            for (int i = 1; i < len; i++) {
                if (S.charAt(i - 1) == 'R' && S.charAt(i) == 'L') {
                    for (r = i; r < len; r++) {
                        if (S.charAt(r) == 'R') {
                            break;
                        }
                    }
                    r--;
                    ans[i - 1] = (i - l + 1) / 2 + (r - (i - 1)) / 2;
                    ans[i] = (i - l) / 2 + (r - (i - 1) + 1) / 2;
                    l = r + 1;
                }
            }
            String ret = Arrays.stream(ans).mapToObj(Integer::toString).collect(Collectors.joining(" "));
            out.println(ret);
        }

    }
}

