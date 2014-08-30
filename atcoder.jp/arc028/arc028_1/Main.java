import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] arg) throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        String[] params = line.split(" ");
        int N = Integer.parseInt(params[0]);
        int A = Integer.parseInt(params[1]);
        int B = Integer.parseInt(params[2]);
        int tmp = N % (A+B);
        if (tmp != 0 && tmp <= A) {
            System.out.println("Ant");
        } else {
            System.out.println("Bug");
        }
    }
}
