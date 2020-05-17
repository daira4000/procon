import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractCollection;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
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
            int N = in.Int();
            int M = in.Int();
            List<D.Node> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new D.Node(i));
            }
            list.get(0).cost = 0;
            Map<Integer, List<Integer>> edge = new HashMap<>();
            for (int i = 0; i < N; i++) {
                edge.put(i, new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                int A = in.Int() - 1;
                int B = in.Int() - 1;
                edge.get(A).add(B);
                edge.get(B).add(A);
            }
            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
            for (int i = 0; i < edge.get(0).size(); i++) {
                int t = edge.get(0).get(i);
                que.add(new int[]{0, t, 1});
            }
            while (!que.isEmpty()) {
                int[] q = que.poll();
                D.Node to = list.get(q[1]);
                if (to.cost <= q[2]) {
                    continue;
                }
                to.cost = q[2];
                to.from = q[0];
                List<Integer> e = edge.get(q[1]);
                for (int i = 0; i < e.size(); i++) {
                    que.add(new int[]{q[1], e.get(i), q[2] + 1});
                }
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).cost == 1 << 30) {
                    out.println("No");
                    return;
                }
            }
            out.println("Yes");
            for (int i = 1; i < list.size(); i++) {
                out.println(list.get(i).from + 1);
            }
        }

        static class Node {
            int no;
            int from = -1;
            int cost = 1 << 30;

            Node(int _no) {
                no = _no;
            }

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
                    return null;
                }
            }
            return st.nextToken();
        }

        public int Int() {
            return Integer.parseInt(next());
        }

    }
}

