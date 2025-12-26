import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack();
		boolean check = false;
		String word = br.readLine();

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == '<') {
				while (!stack.isEmpty()) {

					sb.append(stack.pop());
				}
				check = true;
			}

			if (check) {
				sb.append(word.charAt(i));
			}
			if (word.charAt(i) == '>') {

				check = false;
			}

			if (!check) {
				if (word.charAt(i) != ' ') {
					if (word.charAt(i) == '>') {
						continue;
					}
					stack.add(word.charAt(i) + "");

				} else {
					while (!stack.isEmpty()) {

						sb.append(stack.pop());
					}
					sb.append(" ");
				}
			}

		}
		while (!stack.isEmpty()) {

			sb.append(stack.pop());
		}
		System.out.println(sb);
	}

}
