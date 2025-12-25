import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			String first;
			String second;
			String result = "DIFF";
			st = new StringTokenizer(br.readLine());
			first = st.nextToken();
			second = st.nextToken();
			if (first.length() == second.length()) {
				if (check(first, second)) {
					result = "SAME";
				}
			}

			System.out.println("#" + test + " " + result);
		}
	}

	public static boolean check(String a, String b) {
		int[] word = new int[10];
		for (int i = 0; i < a.length(); i++) {

			word[i] = count(a.charAt(i));

			if (word[i] != count(b.charAt(i))) {
				return false;
			}
		}

		return true;

	}

	public static int count(char c) {

		if(c=='A'||c=='D'||c=='O'||c=='P'||c=='Q'||c=='R') {

			return 1;
		} else if(c=='B') {
			return 2;
		}
		return 0;

	}

}
