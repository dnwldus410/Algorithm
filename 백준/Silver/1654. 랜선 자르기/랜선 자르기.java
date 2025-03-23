import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int[] lan;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lan = new int[N];

		int maxium = 0;
	

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lan[i] = Integer.parseInt(st.nextToken());
			maxium = Math.max(maxium, lan[i]);
	

		}
		long start = 1;
		long end = maxium;
		long result = 1;

		while (start <= end) {
			long midium = (start + end) / 2;

			long count = check(midium);
			if (count < M) {

				end = midium - 1;

			} else {
 
				result = Math.max(result, midium);

				start = midium + 1;
			}
		}
		System.out.println(result);

	}

	public static long check(long mid) {
		long count = 0;

		for (int i = 0; i < N; i++) {
			count += lan[i] / mid;
		}
		return count;

	}

}
