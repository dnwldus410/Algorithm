import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
static List<Integer>[] list;
static boolean[] visited;
static int count;
static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		 list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList();
		}
		visited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=1;i<=N;i++) {
			list[i].sort(Comparator.naturalOrder());
		}
		
		
		dfs();
		System.out.println(count);
		
	}
	public static void dfs() {
		Stack<Integer> stack = new Stack();
		for(int i=1;i<N+1;i++) {
			if(!visited[i]) {
				stack.push(i);
				
				while(!stack.isEmpty()) {
					int a=stack.pop();
					for(int next: list[a]) {
						if(!visited[next]) {
							stack.push(next);
							visited[next]=true;
						}
					}
				}
				count++;
			}
			else {
				
			}
			
		}
		
		
		
	}

}
