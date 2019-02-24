import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String[] ymd = in.next().split("/");
		if (ymd[0].compareTo("2019") < 0
				|| ymd[0].compareTo("2019") == 0 && ymd[1].compareTo("04") < 0
				|| ymd[0].compareTo("2019") == 0 && ymd[1].compareTo("04") == 0 && ymd[2].compareTo("30") <= 0) {
			System.out.println("Heisei");
		} else {
			System.out.println("TBD");
		}
	}
}
