import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.LongStream;
import java.util.Collection;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
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
        int N;
        int K;
        Map<Integer, Long> memo = new HashMap<>();

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            N = in.nextInt();
            K = in.nextInt();
            List<Long> V = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                V.add(in.nextLong());
            }

            long max = calc(V, 0, 0);
            out.println(max);
        }

        private long calc(List<Long> V, int left, int right) {
            if (memo.containsKey(left + K * right)) {
                return memo.get(left + K * right);
            }
            long ans = Long.MIN_VALUE;
            if (K < left + right || V.size() < left + right) {
                return ans;
            }
            if (K >= left + right) {
                List<Long> sub = new ArrayList<>(V.subList(0, left));
                sub.addAll(V.subList(V.size() - right, V.size()));
                sub.sort(Comparator.naturalOrder());
                for (int i = 0; i < (K - left - right); i++) {
                    if (!sub.isEmpty() && sub.get(0) < 0) {
                        sub.remove(0);
                    }
                }
                ans = sub.stream().mapToLong(l -> l).sum();
            }
            ans = Math.max(ans, calc(V, left + 1, right));
            ans = Math.max(ans, calc(V, left, right + 1));
            memo.put(left + K * right, ans);
            return ans;
        }

    }
}

