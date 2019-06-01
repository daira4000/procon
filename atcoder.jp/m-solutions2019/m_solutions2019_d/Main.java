import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.LongStream;
import java.util.Collection;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedList;

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

            Map<Integer, List<Integer>> line = new HashMap<>();
            int[] count = new int[N + 1];
            for (int i = 0; i < N - 1; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                if (!line.containsKey(a)) {
                    line.put(a, new ArrayList<>());
                }
                line.get(a).add(b);
                if (!line.containsKey(b)) {
                    line.put(b, new ArrayList<>());
                }
                line.get(b).add(a);

                count[a]++;
                count[b]++;
            }

            int[] c = new int[N];
            for (int i = 0; i < N; i++) {
                c[i] = in.nextInt();
            }
            Arrays.sort(c);

            int start = 0;
            int max = 0;
            for (int i = 1; i <= N; i++) {
                if (max < count[i]) {
                    max = count[i];
                    start = i;
                }
            }

            int[] values = new int[N + 1];
            int ci = c.length - 1;
            Deque<Integer> que = new LinkedList<>();
            que.add(start);
            while (!que.isEmpty()) {
                int node = que.removeFirst();
                if (values[node] != 0) {
                    continue;
                }
                values[node] = c[ci--];

                for (int n : line.get(node)) {
                    que.add(n);
                }
            }

            Map<Integer, Integer> ansMap = new HashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : line.entrySet()) {
                int a = entry.getKey();
                for (int b : entry.getValue()) {
                    if (ansMap.containsKey(a + b * 100000) || ansMap.containsKey(b + a * 100000)) {
                        continue;
                    }
                    ansMap.put(a + b * 100000, Math.min(values[a], values[b]));
                }
            }

            out.println(ansMap.values().stream().mapToLong(n -> n).sum());
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                sb.append(values[i]).append(' ');
            }
            out.println(sb.toString().trim());
        }

    }
}

