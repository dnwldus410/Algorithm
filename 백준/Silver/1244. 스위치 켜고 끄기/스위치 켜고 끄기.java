import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[] sw = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		int P = Integer.parseInt(br.readLine());
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			if (gen == 1) {
				int num = Integer.parseInt(st.nextToken());
				ManChange(sw, num);
			} else if (gen == 2) {
				int num = Integer.parseInt(st.nextToken());

				WomanChange(sw, num - 1);
			}
		}
		for (int i = 0; i < N; i++) {
            System.out.print(sw[i] + " ");
            if ((i + 1) % 20 == 0) { // 20개씩 출력 후 줄바꿈
                System.out.println();
            }
        }
		
	}

	public static void ManChange(int[] sw, int num) {
		for (int i = num - 1; i < N; i += num) {
			if (sw[i] == 0) {
				sw[i] = 1;
			} else if (sw[i] == 1) {
				sw[i] = 0;
			}
		}

	}

	public static void WomanChange(int[] sw, int num) {
		int dx = 1;
		int dy = -1;
		if (num - 1 >= 0 && num + 1 < N) {
			if (sw[num - 1] == sw[num + 1]) {
				for (int i = 1; num + i * dy >= 0 && num + i * dx < N; i++) {
					if (sw[num + i * dy] == sw[num + i * dx]) {
						if (sw[num + i * dy] == 0) {
							sw[num + i * dy] = 1;
						} else if (sw[num + i * dy] == 1) {
							sw[num + i * dy] = 0;
						}
						if (sw[num + i * dx] == 0) {
							sw[num + i * dx] = 1;
						} else if (sw[num + i * dx] == 1) {
							sw[num + i * dx] = 0;
						}
					}
					else {
						break;
					}
				}

			}
		

		}
		if (sw[num] == 0) {
			sw[num] = 1;
		} else if (sw[num] == 1) {
			sw[num] = 0;
		}
	}

}
