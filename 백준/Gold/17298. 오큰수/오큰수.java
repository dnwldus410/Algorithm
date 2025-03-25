import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] area = new int[N];
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			area[i] = Integer.parseInt(st.nextToken());

		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int num = area[i];
			while (!stack.isEmpty() && num > area[stack.peek()]) {
				int p = stack.pop();
				answer[p] = num;
			}
			stack.push(i);
		}
		for (int i = 0; i < N; i++) {
			if (answer[i] == 0) {
				answer[i] = -1;
			}
			sb.append(answer[i]).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		
		System.out.println(sb);

	}

}
