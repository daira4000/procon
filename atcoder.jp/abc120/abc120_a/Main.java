import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		System.out.println(Math.min(C, B / A));
	}
}
