import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());
		int[][] position = new int[N + 1][3];

		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num;
			int p = Integer.parseInt(st.nextToken());
			position[i][0] = p;
			switch (p) {
			case 1:
				num = Integer.parseInt(st.nextToken());
				position[i][1] = 0;
				position[i][2] = num;
				break;
			case 2:
				num = Integer.parseInt(st.nextToken());
				position[i][1] = X;
				position[i][2] = num;
				break;
			case 3:
				num = Integer.parseInt(st.nextToken());
				position[i][1] = num;
				position[i][2] = 0;
				break;
			case 4:
				num = Integer.parseInt(st.nextToken());
				position[i][1] = num;
				position[i][2] = Y;
				break;

			}

		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			if ((position[N][0] == 1 && position[i][0] == 2) || (position[N][0] == 2 && position[i][0] == 1)) {
				// 북-남
				
			
					if (position[N][2] + position[i][2] > Y) {
						result += (2 * Y - (position[N][2] + position[i][2]))+X ;
					} 
					else {

						result += position[N][2] + position[i][2] + X;
					}
				
			}
			else if ((position[N][0] == 3 && position[i][0] == 4) || (position[N][0] == 4 && position[i][0] == 3)) {
				// 서-
				if (position[N][1] + position[i][1] > X) {
					result += (2 * X - (position[N][1] + position[i][1]))+Y;
				} 
				else {
					result += position[N][1] + position[i][1] + Y;
				}

			}
		
			else  {
			
				result += Math.abs(position[N][1] - position[i][1]) + Math.abs(position[N][2] - position[i][2]);
			}

		}
		System.out.println(result);

	}

}
