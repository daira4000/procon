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
            int[] v = new int[N];
            for (int i = 0; i < N; i++) {
                v[i] = in.nextInt();
            }
            Arrays.sort(v);
            double ret = v[0];
            for (int i = 1; i < N; i++) {
                ret = (ret + v[i]) / 2.0;
            }
            out.println(ret);
        }

    }
}

