import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String s = in.next();

		long red = s.chars().filter(c -> c == 'R').count();
		System.out.println(N < red * 2 ? "Yes" : "No");
	}
}
