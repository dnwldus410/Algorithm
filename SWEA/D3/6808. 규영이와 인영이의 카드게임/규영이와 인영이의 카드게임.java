import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int gyuyung_num;
	static int inyung_num;
	static int gyuyung_win;
	static int gyuyung_lose;
	static int[] gyuyung;
	static int[] inyung;
	static int[] inyung_permutation;
	static boolean[] inyung_check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			boolean[] check = new boolean[19];
			inyung_check = new boolean[9];
			inyung_permutation = new int[9];
			gyuyung = new int[9];
			inyung = new int[9];
			// 규영이는 true 인영이는 false
			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				check[num] = true;
				gyuyung[i] = num;
			}
			int inyoung_num = 0;
			for (int i = 1; i <= 18; i++) {
				if (!check[i]) {
					inyung[inyoung_num] = i;
					inyoung_num++;

				}
			}

			gyuyung_win = 0;
			gyuyung_lose = 0;

			permutation(0);

			System.out.println("#" + test + " " + gyuyung_win + " " + gyuyung_lose);
		}
	}

	public static void permutation(int depth) {
		if (depth == 9) {
			gyuyung_num = 0;
			inyung_num = 0;
			for (int i = 0; i < depth; i++) {
				if (gyuyung[i] > inyung_permutation[i]) {
					gyuyung_num += gyuyung[i] + inyung_permutation[i];
				} else {
					inyung_num += gyuyung[i] + inyung_permutation[i];
				}
			}
			if (gyuyung_num > inyung_num) {
				gyuyung_win++;
			} else if (gyuyung_num < inyung_num) {
				gyuyung_lose++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!inyung_check[i]) {
				inyung_check[i] = true;
				inyung_permutation[depth] = inyung[i];
				permutation(depth + 1);
				inyung_check[i] = false;
			}
		}
	}

}
