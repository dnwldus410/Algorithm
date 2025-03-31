import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] area;

	static int N, sum;
	static List<core> list, result;

	static class core {
		int x;
		int y;

		public core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());

			area = new int[N][N];
			sum = 0;
			list = new ArrayList<>();
			result = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
					if (area[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
						list.add(new core(i, j));
					} else if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
						sum++;
					}

				}
			}
			dfs(0, 0, 0);
			result.sort((a, b) -> {
				if (b.x != a.x)
					return b.x - a.x;
				return a.y - b.y;
			});
			System.out.printf("#%d %d\n", test, result.get(0).y);

		}
	}

	public static void dfs(int idx, int connectCnt, int length) {
		if (idx == list.size()) {
			result.add(new core(connectCnt, length));
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (check(idx, i)) {
				int line = drawWire(list.get(idx).x, list.get(idx).y, i, area, 2);
				dfs(idx + 1, connectCnt + 1, length + line);
				drawWire(list.get(idx).x, list.get(idx).y, i, area, 0);
			}
		}
		dfs(idx + 1, connectCnt, length);
	}

	public static boolean check(int idx, int dir) {
		int x = list.get(idx).x;
		int y = list.get(idx).y;

		while (true) {
			x += dx[dir];
			y += dy[dir];

			if (x < 0 || x >= N || y < 0 || y >= N)
				break;
			if (area[x][y] != 0)
				return false;
		}
		return true;
	}

	public static int drawWire(int x, int y, int dir, int[][] map, int value) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		int length = 0;

		while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			map[nx][ny] = value; // value = 2 (선 표시)
			nx += dx[dir];
			ny += dy[dir];
			length++;
		}

		return length;
	}
}
