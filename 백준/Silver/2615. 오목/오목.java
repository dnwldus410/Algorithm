import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[][] array = new int[19][19];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 19; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		int[] black_count = { 1, 1, 1 ,1};
		int[] white_count = { 1, 1, 1 ,1};

		int black_check = 0;
		int white_check = 0;

		int[] dx = { 0, 1, 1 ,-1}; // 가로,세로,대각
		int[] dy = { 1, 0, 1 ,1};
		int nx = 0;
		int ny = 0;

		int result_bx = 0;
		int result_by = 0;

		int result_wx = 0;
		int result_wy = 0;
		for (int num = 0; num < 4; num++) {
			for (int i = 0; i < 19; i++) {
				for (int j = 0; j < 19; j++) {
					if (array[i][j] == 1) {
						black_count[num] = 1;
						for (int k = 1; k < 19; k++) {
							nx = i + dx[num] * k;
							ny = j + dy[num] * k;
							if (nx < 19 && nx >= 0 && ny < 19 && ny >= 0) {
								if (array[nx][ny] == 1) {
									black_count[num] += 1;

								} else {
									break;
								}
							}
						}
						if (i - dx[num] >= 0 && j - dy[num] >= 0 &&i-dx[num]<19&&j-dy[num] < 19) {

							if (array[i - dx[num]][j - dy[num]] != 1) {
								if (black_count[num] == 5) {
									result_bx = i + 1;
									result_by = j + 1;
									black_check++;
								}
							}
							
						
						}else {
							if (black_count[num] == 5) {
								result_bx = i + 1;
								result_by = j + 1;
								black_check++;
					}

					}
					}

					if (array[i][j] == 2) {
						white_count[num] = 1;
						for (int k = 1; k < 19; k++) {
							nx = i + dx[num] * k;
							ny = j + dy[num] * k;
							if (nx < 19 && nx >= 0 && ny < 19 && ny >= 0) {
								if (array[nx][ny] == 2) {
									white_count[num] += 1;

								} else {
									break;
								}
							}
						}
						if (i - dx[num] >= 0 && j - dy[num] >= 0 &&i-dx[num]<19&&j-dy[num] < 19) {
							if (array[i - dx[num]][j - dy[num]] != 2) {
								if (white_count[num] == 5) {
									result_wx = i + 1;
									result_wy = j + 1;
									white_check++;
								
								}
							}
						}
						else {
							if (white_count[num] == 5) {
								result_wx = i + 1;
								result_wy = j + 1;
								white_check++;
						}
							
					}

				}

			}

				}
			}
		
		if (black_check + white_check == 1)

		{
			if (black_check == 1) {
				System.out.println("1");
				System.out.print(result_bx + " " + result_by);
			}
			if (white_check == 1) {
				System.out.println("2");
				System.out.print(result_wx + " " + result_wy);
			}

		} else {
			System.out.println("0");
		}

	}
}