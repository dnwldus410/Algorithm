import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		list = new LinkedList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new LinkedList();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a); // 양방향이기때문
		}

		for (int i = 1; i < N + 1; i++) {
			list[i].sort(Comparator.naturalOrder());
		}
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();

		visited = new boolean[N + 1];
		bfs(V);
		System.out.println();

	}

	public static void dfs(int v) {
		Stack<Integer> stack = new Stack();
		stack.push(v);
		while (!stack.isEmpty()) {
			int a = stack.pop();
			if (visited[a])
				continue;
			visited[a] = true;
			System.out.print(a + " ");
			for (int next = list[a].size() - 1; next >= 0; next--) {
				int b = list[a].get(next);
				if (!visited[b]) {
					stack.push(b);
				}

			}

		}
	}

	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList();
		queue.add(v);
		visited[v]=true;
		while (!queue.isEmpty()) {
			int a = queue.poll();

			System.out.print(a + " ");
			for (int next : list[a]) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}

			}

		}
	}

}
