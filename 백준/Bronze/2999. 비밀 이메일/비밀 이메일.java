import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int R = check(word.length());
		int C = word.length() / R;
		int order = 0;
		char[][] arrayW = new char[R][C];
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {

				arrayW[i][j] = word.charAt(order);
				order++;

			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				System.out.print(arrayW[i][j]);

			}
		}

	}

	public static int check(int num) {
		int a = (int) Math.sqrt(num);
		int result = 0;
		for (int i = 1; i <= a; i++) {
			if (num % i == 0) {
				result = Math.max(result, i);
			}

		}
		return result;
	}

}
