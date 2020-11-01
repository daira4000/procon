import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
            String S = in.next();
            out.println(calc(S) ? "Yes" : "No");
        }

        private boolean calc(String s) {
            if (s.length() == 1) {
                return s.equals("8");
            } else if (s.length() == 2) {
                int n = Integer.parseInt(s);
                int a = n / 10;
                int b = n % 10;
                return (n % 8 == 0) || ((b * 10 + a) % 8 == 0);
            } else {
                int[] cnts = new int[10];
                for (char c : s.toCharArray()) {
                    cnts[c - '0']++;
                }
                return check(cnts);
            }
        }

        private boolean check(int[] cnts) {
            for (int i = 1; i < 10; i++) {
                if (cnts[i] == 0) continue;
                cnts[i]--;
                for (int j = 1; j < 10; j++) {
                    if (cnts[j] == 0) continue;
                    cnts[j]--;
                    for (int k = 1; k < 10; k++) {
                        if (cnts[k] == 0) continue;
                        int n = i * 100 + j * 10 + k;
                        if (n % 8 == 0) return true;
                    }
                    cnts[j]++;
                }
                cnts[i]++;
            }
            return false;
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

    }
}

