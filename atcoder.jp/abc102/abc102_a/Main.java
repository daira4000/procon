import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		long N = in.nextInt();
		if (N % 2 == 0) {
			System.out.println(N);
		} else {
			System.out.println(N * 2);
		}
	}
}