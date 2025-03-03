import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int N = 9;
	static int[][] area;
	static List<int[]> list = new ArrayList();
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		area = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if (area[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}
		if (recursive(0)) {
			System.out.println(sb);
		}

	}

	public static boolean recursive(int cnt) {
		if (cnt == list.size()) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(area[i][j]).append(" ");
				}
				sb.append("\n");

			}
			return true;
		}
		int[] pos = list.get(cnt);
		int x = pos[0], y = pos[1];
		for (int num = 1; num <= 9; num++) {
			if (isValid(x, y, num)) {

				area[x][y] = num;
				if (recursive(cnt + 1)) {
					return true;
				}
				;
				area[x][y] = 0;
			}
		}
		return false;

	}

	private static boolean isValid(int x, int y, int num) {
		for (int i = 0; i < N; i++) {
			if (area[x][i] == num) {
				return false;
			}
			if (area[i][y] == num) {
				return false;
			}
		}

		int nx = x / 3 * 3;
		int ny = y / 3 * 3;
		for (int i = nx; i < nx + 3; i++) {
			for (int j = ny; j < ny + 3; j++) {
				if (area[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}

}
