import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

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
            int[][] AB = new int[N][2];
            for (int i = 0; i < N; i++) {
                AB[i] = new int[]{in.nextInt(), in.nextInt()};
            }
            Arrays.sort(AB, Comparator.comparingInt(a -> a[1]));

            long time = 0;
            for (int i = 0; i < N; i++) {
                time += AB[i][0];
                if (time > AB[i][1]) {
                    out.println("No");
                    return;
                }
            }
            out.println("Yes");
        }

    }
}

