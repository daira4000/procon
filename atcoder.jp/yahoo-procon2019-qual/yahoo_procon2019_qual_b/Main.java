import java.util.Arrays;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] count = new int[4];
		for (int i = 0; i < 6; i++) {
			int n = in.nextInt();
			count[n-1]++;
		}
		boolean yes = Arrays.stream(count).filter(n -> n >= 3).count() == 0;
		System.out.println(yes ? "YES" : "NO");
	}
}
