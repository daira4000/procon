import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		long count = S.chars().filter(c -> c == '0').count();
		System.out.println(Math.min(count, S.length() - count) * 2);
	}

}
