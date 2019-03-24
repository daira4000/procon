import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String b = in.next();
		String out = "";
		switch (b) {
		case "A":
			out = "T";
			break;
		case "C":
			out = "G";
			break;
		case "G":
			out = "C";
			break;
		case "T":
			out = "A";
			break;
		default:
			break;
		}
		System.out.println(out);
	}
}
