import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();

            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                map.put(i, new HashSet<>());
            }
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    map.get(j).add(i);
                    map.get(i).add(j);
                }
            }
            if ((N & 1) == 0) {
                map.get(1).remove(N);
                map.get(N).remove(1);
            }
            int max = map.get(N).stream().mapToInt(n -> n).sum();
            for (int i = 1; i <= N; i++) {
                int sum = map.get(i).stream().mapToInt(n -> n).sum();
                int d = sum - max;
                if (d > 0) {
                    map.get(i).remove(d);
                    map.get(d).remove(i);
                }
            }

//        for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
//            System.err.println(e.getKey() + ":" + e.getValue().stream().mapToInt(n -> n).sum());
//        }
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
                int l = e.getKey();
                for (int r : e.getValue()) {
                    list.add(new int[]{l, r});
                    map.get(r).remove(l);
                }
            }
            out.println(list.size());
            list.forEach(ans -> out.println(ans[0] + " " + ans[1]));
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

