import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static int[] num;
	static HashSet<Integer> hash;
	static int N;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		hash = new HashSet<>();
		result = 0;
		num = new int[4];
		num[0] = 1;
		num[1] = 5;
		num[2] = 10;
		num[3] = 50;

		Combination(0, 0);

		System.out.println(hash.size());
	}

	public static void Combination(int depth, int start) {
		if (depth == N) {
			hash.add(result);
			return;
		}
		for (int i = start; i < 4; i++) {
			result += num[i];
			Combination(depth + 1, i);
			result -= num[i];
		}
	}

}
