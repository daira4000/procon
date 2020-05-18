import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        private static long INF = 1L << 62;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = in.Int();
            int[] a = new int[M];
            int[] b = new int[M];
            int[] c = new int[M];
            for (int i = 0; i < M; i++) {
                a[i] = in.Int() - 1;
                b[i] = in.Int() - 1;
                c[i] = in.Int();
            }
            List<D.Vertex> vertices = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                vertices.add(new D.Vertex());
            }
            List<D.Edge> edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                D.Edge e = new D.Edge();
                e.source = vertices.get(a[i]);
                e.destination = vertices.get(b[i]);
                e.weight = -c[i];
                edges.add(e);
            }

            bellmanFord(vertices, edges, vertices.get(0));
            D.Vertex vertex = vertices.get(N - 1);
            if (vertex.negative) {
                out.println("inf");
                return;
            }
            out.println(-(vertex.distance));
        }

        private static void bellmanFord(List<D.Vertex> vertices, List<D.Edge> edges, D.Vertex source) {
            for (D.Vertex v : vertices) {
                if (v.equals(source)) {
                    v.distance = 0;
                } else {
                    v.distance = INF;
                }
                v.predecessor = null;
                v.negative = false;
            }

            for (int i = 0; i < vertices.size() - 1; i++) {
                for (D.Edge uv : edges) {
                    D.Vertex u = uv.source;
                    D.Vertex v = uv.destination;
                    if (v.distance > u.distance + uv.weight) {
                        v.distance = u.distance + uv.weight;
                        v.predecessor = u;
                    }
                }
            }

            for (int i = 0; i < vertices.size(); i++) {
                for (D.Edge uv : edges) {
                    D.Vertex u = uv.source;
                    D.Vertex v = uv.destination;
                    if (v.distance > u.distance + uv.weight) {
                        v.distance = u.distance + uv.weight;
                        v.negative = true;
                    } else if (u.negative) {
                        v.negative = true;
                    }
                }
            }
        }

        private static class Vertex {
            public long distance;
            public D.Vertex predecessor;
            public boolean negative;

        }

        private static class Edge {
            public D.Vertex source;
            public D.Vertex destination;
            public long weight;

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

