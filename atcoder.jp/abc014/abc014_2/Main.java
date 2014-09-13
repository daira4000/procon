import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int X = in.nextInt();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			if (X % 2 == 1) {
				sum += a;
			}
			X /= 2;
		}
		System.out.println(sum);
	}
}
