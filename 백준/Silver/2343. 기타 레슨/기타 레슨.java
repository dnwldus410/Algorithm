import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int start, end, result;
	static int N, M;
	static int[] blue;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		blue = new int[N];

		int minium = 0;
		int maxium = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			blue[i] = Integer.parseInt(st.nextToken());
			minium = Math.max(blue[i], minium);
			maxium += blue[i];

		}
		start = minium;
		end = maxium;
		result = maxium;
		while (start <= end) {
			int midium = (start + end) / 2;
			int count = check(midium);

			if (count <= M) {
				result = midium;
				end = midium - 1;
			} else {
				start = midium + 1;
			}

		}

		System.out.println(result);

	}

	public static int check(int mid) {
		int count = 1;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (blue[i] > mid)
				return M + 1;
			if (sum + blue[i] > mid) {
				count++;
				sum = 0;
			}
			sum += blue[i];

		}
		return count;

	}

}
