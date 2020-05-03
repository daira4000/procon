import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Deque;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayDeque;
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
        F solver = new F();
        solver.solve(1, in, out);
        out.close();
    }

    static class F {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int[] ABC = in.Int(3);
            List<String> sl = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                sl.add(in.next());
            }
            ArrayDeque<Character> ans = new ArrayDeque<>();
            boolean f = check(ABC, sl, 0, ans);
            if (!f) {
                out.println("No");
                return;
            }
            out.println("Yes");
            ans.forEach(c -> out.println((char) c));
        }

        boolean check(int[] ABC, List<String> sl, int d, Deque<Character> ans) {
            if (ABC[0] < 0 || ABC[1] < 0 || ABC[2] < 0) return false;
            if (ans.size() >= sl.size()) return true;
            String s = sl.get(d);
            int l = s.charAt(0) - 'A';
            int r = s.charAt(1) - 'A';
            ABC[l]--;
            ABC[r]++;
            ans.add((char) (r + 'A'));
            boolean f = check(ABC, sl, d + 1, ans);
            if (!f) {
                ans.removeLast();
                ans.add((char) (l + 'A'));
                ABC[l]++;
                ABC[r]--;
                ABC[l]++;
                ABC[r]--;
                f = check(ABC, sl, d + 1, ans);
                if (!f) {
                    ans.removeLast();
                    ABC[l]--;
                    ABC[r]++;
                    return false;
                }
            }
            return true;
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

