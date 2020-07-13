import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
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
        K solver = new K();
        solver.solve(1, in, out);
        out.close();
    }

    static class K {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int Q = in.Int();

            Map<Integer, K.Node> desks = new HashMap<>();
            Map<Integer, K.Node> deskst = new HashMap<>();
            List<K.Node> nodes = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                K.Node node = new K.Node(i);
                desks.put(i, node);
                deskst.put(i, node);
                nodes.add(node);
            }

            for (int q = 0; q < Q; q++) {
                int f = in.Int() - 1;
                int t = in.Int() - 1;
                int x = in.Int() - 1;

                K.Node node = nodes.get(x);
                K.Node tail;
                if (node.left == null) {
                    // 先頭
                    desks.put(f, null);
                    tail = deskst.get(f);
                    deskst.put(f, null);
                } else {
                    // 先頭以外
                    tail = deskst.get(f);
                    deskst.put(f, node.left);
                    node.left.right = null;
                    node.left = null;
                }
                if (desks.get(t) == null) {
                    // 机が空
                    desks.put(t, node);
                    deskst.put(t, tail);
                } else {
//                Node n = desks.get(t);
//                while (n.right != null) {
//                    n = n.right;
//                }
//                n.right = node;
//                node.left = n;
                    K.Node n = deskst.get(t);
                    n.right = node;
                    node.left = n;
                    deskst.put(t, tail);
                }
            }

            int[] ans = new int[N];
            for (Map.Entry<Integer, K.Node> e : desks.entrySet()) {
                int desk = e.getKey() + 1;
                K.Node n = e.getValue();
                while (n != null) {
                    ans[n.no] = desk;
                    n = n.right;
                }
            }
            for (int i = 0; i < N; i++) {
                out.println(ans[i]);
            }
        }

        static class Node {
            K.Node left;
            K.Node right;
            int no;

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

