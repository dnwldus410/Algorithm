import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] area;
	static int white;
	static int blue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursive(0, 0, N);
		System.out.println(white);
		System.out.println(blue);

	}

	public static void recursive(int x, int y, int N) {
		if (check(x, y, N) != 0) {
			return;
		}
		recursive(x, y, N / 2);
		recursive(x + N / 2, y + N / 2, N / 2);
		recursive(x + N / 2, y, N / 2);
		recursive(x, y + N / 2, N / 2);
	}

	public static int check(int x, int y, int N) {
		int num = 0;
		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {

				if (area[i][j] == 0) {
					num++;
				}

			}
		}
		if (num == N * N) {
			white++;

			return 1;
		} else if (num == 0) {
			blue++;
			return 1;
		}
		return 0;

	}

}
