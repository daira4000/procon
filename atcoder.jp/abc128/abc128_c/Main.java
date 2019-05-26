import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Arrays;
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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        int N;
        int M;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            N = in.nextInt();
            M = in.nextInt();

            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                int k = in.nextInt();
                for (int j = 0; j < k; j++) {
                    int s = in.nextInt();
                    list.get(s).add(i);
                }
            }
            int[] p = new int[M];
            for (int i = 0; i < M; i++) {
                p[i] = in.nextInt();
            }

            int[] dp = new int[1025];
            int im = (int) Math.pow(2, N);
            for (int i = 0; i < im; i++) {
                dp[i + 1] = check(i, list, p) + dp[i];
            }
            out.println(dp[im]);
        }

        private int check(int n, List<List<Integer>> list, int[] p) {
            int[] count = new int[M];
            Arrays.fill(count, 0);

            for (int i = 0; i < N; i++) {
                if ((n & (1 << i)) > 0) {
                    for (int s : list.get(i + 1)) {
                        count[s]++;
                    }
                }
            }

            boolean lamp = true;
            for (int i = 0; i < M && lamp; i++) {
                lamp = lamp && count[i] % 2 == p[i];
            }
            return lamp ? 1 : 0;
        }

    }
}

