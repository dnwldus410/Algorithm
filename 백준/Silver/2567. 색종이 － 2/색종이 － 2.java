import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] area = new boolean[100][100];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int a = x; a < x + 10; a++) {
				for (int b = y; b < y + 10; b++) {

					area[a][b] = true;
				}
			}
		}
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int count = 0;

		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				if (area[x][y]) {
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || !area[nx][ny]) {

							count++;

						}
					}
				}

			}

		}

		System.out.println(count);

	}

}
