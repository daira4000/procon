import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.AbstractCollection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.HashMap;
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
            Map<Integer, Map<Integer, Integer>> lines = new HashMap<>();

            for (int i = 0; i < N - 1; i++) {
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                long w = in.nextLong();
                if (!lines.containsKey(v1)) {
                    lines.put(v1, new HashMap<>());
                }
                if (!lines.containsKey(v2)) {
                    lines.put(v2, new HashMap<>());
                }
                lines.get(v1).put(v2, (int) (w % 2));
                lines.get(v2).put(v1, (int) (w % 2));
            }

            int[] black = new int[N + 1];
            Arrays.fill(black, -1);
            black[1] = 0;
            LinkedList<Integer> que = new LinkedList<>();
            que.add(1);
            while (!que.isEmpty()) {
                int current = que.removeFirst();
                if (!lines.containsKey(current)) {
                    continue;
                }
                for (Map.Entry<Integer, Integer> entry : lines.get(current).entrySet()) {
                    if (black[entry.getKey()] != -1) {
                        continue;
                    }
                    que.add(entry.getKey());
                    black[entry.getKey()] = (black[current] + entry.getValue()) % 2;
                }
            }
            for (int i = 1; i <= N; i++) {
                out.println(black[i]);
            }
        }

    }
}

