import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Collection;
import java.io.IOException;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.StringTokenizer;
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
            int H = in.nextInt();
            int W = in.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < H; i++) {
                String a = in.next();
                if (a.contains("#"))
                    list.add(a.chars().map(c -> c == '#' ? 1 : 0).boxed().collect(Collectors.toList()));
            }
            int i = 0;
            while (list.get(0).size() > i) {
                boolean f = true;
                for (List<Integer> l : list) {
                    if (l.get(i) != 0) {
                        f = false;
                    }
                }
                if (f) {
                    for (List<Integer> l : list) {
                        l.remove(i);
                    }
                } else {
                    i++;
                }
            }

            list.forEach(l -> {
                String s = l.stream()
                        .map(Object::toString)
                        .map(ss -> ss.replace('0', '.').replace('1', '#'))
                        .collect(Collectors.joining());
                out.println(s);
            });
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

