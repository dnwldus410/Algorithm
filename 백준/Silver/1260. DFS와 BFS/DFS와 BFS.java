import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	public static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		V = Integer.parseInt(st.nextToken()); // 시작
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);

		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();

		visited = new boolean[N + 1];
		bfs(V);
		System.out.println();

	}

	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		for (int i = 0; i < graph[start].size(); i++) {
			if (!visited[graph[start].get(i)]) {
				visited[graph[start].get(i)] = true;

				dfs(graph[start].get(i));
			}

		}

	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		System.out.print(start + " ");
		while (!queue.isEmpty()) {
			int num = queue.poll();

			for (int i = 0; i < graph[num].size(); i++) {
				if (!visited[graph[num].get(i)]) {
					visited[graph[num].get(i)] = true;
					queue.add(graph[num].get(i));
					System.out.print(graph[num].get(i) + " ");

				}

			}
		}

	}

}
