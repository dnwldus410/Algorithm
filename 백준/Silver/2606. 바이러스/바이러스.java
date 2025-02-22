import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
static boolean[] visited;
static List<Integer>[] list;
static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		visited = new boolean[N+1];
		
		dfs(1);
		
		System.out.println(result-1);
	}
	public static void dfs(int V) {
		Stack<Integer> stack = new Stack();
		stack.push(V);
		while(!stack.isEmpty()) {
			
			int num=stack.pop();
			if(visited[num])continue;
			
			visited[num]=true;
			result++;
			
			for(int next : list[num]) {
				if(!visited[next]) {
					stack.push(next);
					
				}
				
			}
			
		}
		
	}

}
