import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int[] V = in.nextIntArray(N);

            Map<Integer, Integer> mapa = new HashMap<>();
            Map<Integer, Integer> mapb = new HashMap<>();
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    mapa.put(V[i], mapa.getOrDefault(V[i], 0) + 1);
                } else {
                    mapb.put(V[i], mapb.getOrDefault(V[i], 0) + 1);
                }
            }
            if (mapa.size() == 1 && mapb.size() == 1 && mapa.keySet().containsAll(mapb.keySet())) {
                out.println(N / 2);
                return;
            }
            List<int[]> lista = new ArrayList<>();
            List<int[]> listb = new ArrayList<>();
            mapa.forEach((key, value) -> lista.add(new int[]{key, value}));
            mapb.forEach((key, value) -> listb.add(new int[]{key, value}));
            lista.sort((o1, o2) -> Integer.compare(o2[1], o1[1]));
            listb.sort((o1, o2) -> Integer.compare(o2[1], o1[1]));
            int ia = 0, ib = 0;
            if (lista.get(0)[0] == listb.get(0)[0]) {
                if (lista.size() == 1) {
                    ib++;
                } else if (listb.size() == 1) {
                    ia++;
                } else {
                    if (lista.get(0)[1] > listb.get(0)[1]) {
                        ib++;
                    } else if (lista.get(0)[1] < listb.get(0)[1]) {
                        ia++;
                    } else if (lista.get(1)[1] > listb.get(1)[1]) {
                        ia++;
                    } else {
                        ib++;
                    }
                }
            }
            out.println(N - lista.get(ia)[1] - listb.get(ib)[1]);
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

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

    }
}

