import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.AbstractQueue;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractCollection;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
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
            int M = in.nextInt();

            List<D.Item> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                D.Item item = new D.Item();
                item.A = in.nextInt();
                item.B = in.nextInt();
                list.add(item);
            }
            list.sort(Comparator.comparingInt(a -> a.A));

            long sum = 0;
            PriorityQueue<D.Item> que = new PriorityQueue<>((a, b) -> Integer.compare(b.B, a.B));
            for (int i = 1; i <= M; i++) {
                while (!list.isEmpty()) {
                    if (list.get(0).A > i) {
                        break;
                    }
                    que.add(list.remove(0));
                }
                if (!que.isEmpty()) {
                    D.Item item = que.remove();
                    sum += item.B;
                }
            }
            out.println(sum);
        }

        static class Item {
            int A;
            int B;

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

