import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.OptionalInt;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            List<D.Edge> list = new ArrayList<>();
            Map<Integer, List<D.Edge>> tree = new HashMap<>();
            for (int i = 0; i < N - 1; i++) {
                D.Edge e = new D.Edge();
                e.l = in.nextInt();
                e.r = in.nextInt();
                e.c = -1;
                list.add(e);
                if (!tree.containsKey(e.l)) {
                    tree.put(e.l, new ArrayList<>());
                }
                tree.get(e.l).add(e);
                if (!tree.containsKey(e.r)) {
                    tree.put(e.r, new ArrayList<>());
                }
                tree.get(e.r).add(e);
            }

            Deque<Integer> que = new ArrayDeque<>();
            que.add(1);
            while (!que.isEmpty()) {
                int p = que.removeFirst();
                List<D.Edge> l = tree.getOrDefault(p, Collections.emptyList());
                Set<Integer> cs = l.stream().map(e -> e.c).collect(Collectors.toSet());
                int color = 1;
                for (D.Edge e : l) {
                    if (e.c == -1) {
                        while (cs.contains(color)) {
                            color++;
                        }
                        e.c = color++;
                        que.add(e.r);
                    }
                }
            }

            int colorMax = list.stream().mapToInt(e -> e.c).max().getAsInt();
            String ans = list.stream().map(e -> String.valueOf(e.c)).collect(Collectors.joining("\n"));
            out.println(colorMax);
            out.println(ans);
        }

        static class Edge {
            int l;
            int r;
            int c;

        }

    }

    static class MyScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public MyScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

