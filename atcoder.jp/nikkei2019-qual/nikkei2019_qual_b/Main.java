import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int N = in.nextInt();
		String A = in.next();
		String B = in.next();
		String C = in.next();

		int change = 0;
		for (int i = 0;i < N; i++) {
			char ac = A.charAt(i);
			char bc = B.charAt(i);
			char cc = C.charAt(i);
			HashSet<Character> set = new HashSet<Character>(Arrays.asList(ac, bc, cc));
			change += set.size() - 1;
		}
		System.out.println(change);
	}
}
