import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        out.println(Arrays.stream(in.nextLine().trim().split(" ")).map(s -> s.substring(0, 1)).collect(Collectors.joining()));
    }
}
