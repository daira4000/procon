import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Main {
	public static void main(String[] args) throws IOException {
		Main a = new Main();

		if (true) {
			a.execute();
		} else {
			System.out.println(a.solver("9", "131142143".toCharArray()));
			System.out.println(a.solver("20", "12341234123412341234".toCharArray()));
			System.out.println(a.solver("4", "1111".toCharArray()));
		}
	}

	public void execute() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String N = reader.readLine();
		String cs = reader.readLine();
		System.out.println(solver(N, cs.toCharArray()));
	}

	public String solver(String N, char[] cs) {
		int[] counts = new int[] { 0, 0, 0, 0 };
		for (int i = 0; i < Integer.valueOf(N); i++) {
			counts[cs[i] - '0' - 1]++;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			max = Math.max(max, counts[i]);
			min = Math.min(min, counts[i]);
		}
		return String.valueOf(max) + " " + String.valueOf(min);
	}

}
