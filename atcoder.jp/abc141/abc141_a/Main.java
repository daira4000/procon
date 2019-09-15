import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String s = in.next();
            String ans = "";
            switch (s) {
                case "Sunny":
                    ans = "Cloudy";
                    break;
                case "Cloudy":
                    ans = "Rainy";
                    break;
                case "Rainy":
                    ans = "Sunny";
                    break;
            }
            out.println(ans);
        }

    }
}

