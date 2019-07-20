import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

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
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            List<Integer> colors = new ArrayList<>();
            colors.add(A[0]);
            for (int i = 1; i < N; i++) {
                int low = 0, hi = colors.size() - 1;
                for (int j = 0; j < 1000 && low < hi; j++) {
                    int mid = low + (hi - low) / 2;
                    int v = colors.get(mid);
                    if (v >= A[i]) {
                        low = mid + 1;
                    } else if (v < A[i]) {
                        hi = mid;
                    }
                }
                if (colors.get(low) < A[i]) {
                    colors.remove(low);
                    colors.add(low, A[i]);
                } else {
                    colors.add(A[i]);
                }
            }
            out.println(colors.size());
        }

    }
}

