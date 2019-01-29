import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int N = in.nextInt();
		int A = in.nextInt();
		int B = in.nextInt();
		int max = Math.min(A, B);
		int min = Math.max((A + B) - N, 0);
		System.out.println(max + " " + min);
	}
}
