import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Arrays;
import java.util.AbstractCollection;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collections;
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
            int M = in.nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < M; i++) {
                int u = in.nextInt();
                map.put(u, map.getOrDefault(u, new ArrayList<>()));
                map.get(u).add(in.nextInt());
            }
            int S = in.nextInt();
            int T = in.nextInt();

            int[][] memo;
            memo = new int[N + 1][4];
            for (int i = 0; i < N + 1; i++) {
                Arrays.fill(memo[i], -1);
            }
            memo[S][0] = 0;

            LinkedList<List<Integer>> que = new LinkedList<>();
            que.add(Arrays.asList(S, 0));
            while (!que.isEmpty()) {
                List<Integer> l = que.removeFirst();
                int s = l.get(0);
                int kenkenpa = l.get(1);
                if (s == T && kenkenpa == 3) {
                    out.println(memo[s][kenkenpa] / 3);
                    return;
                }
                int temp = (kenkenpa % 3) + 1;
                for (int u : map.getOrDefault(s, Collections.emptyList())) {
                    if (memo[u][temp] > 0) {
                        continue;
                    }
                    memo[u][temp] = memo[s][kenkenpa] + 1;
                    que.add(Arrays.asList(u, temp));
                }
            }
            out.println(-1);
        }

    }
}

