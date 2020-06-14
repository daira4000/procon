import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.io.IOException;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.io.BufferedReader;
import java.util.LinkedList;
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
            int N = in.Int();
            int[] A = in.Int(N);

            LinkedList<Integer> al = IntStream.of(A).boxed().sorted(Comparator.naturalOrder()).collect(Collectors.toCollection(LinkedList::new));
            List<Integer> ans = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int v : al) {
                map.put(v, map.getOrDefault(v, 0) + 1);
            }
            if (map.containsKey(1)) {
                out.println(map.get(1) > 1 ? 0 : 1);
                return;
            }
            boolean[] b = new boolean[al.stream().max(Comparator.naturalOrder()).orElse(0) + 1];
            Arrays.fill(b, true);
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                int i = e.getKey();
                if (b[i]) {
                    for (int j = i * 2; j < b.length; j += i) {
                        b[j] = false;
                    }
                }
            }
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() == 1 && b[e.getKey()]) {
                    ans.add(e.getKey());
                }
            }

            out.println(ans.size());
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

        public int[] Int(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Int();
            }
            return a;
        }

    }
}

