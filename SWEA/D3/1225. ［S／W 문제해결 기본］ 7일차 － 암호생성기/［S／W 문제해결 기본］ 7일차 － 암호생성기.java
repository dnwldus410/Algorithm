import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
static Queue<Integer> queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test = 0; test < 10; test++) {
			int T = Integer.parseInt(br.readLine());
			int minNum = Integer.MAX_VALUE;
			int[] pass = new int[8];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				pass[i] = Integer.parseInt(st.nextToken());
				minNum = Math.min(minNum, pass[i]);
			}
			minNum = minNum / 15;
			for (int i = 0; i < 8; i++) {
				pass[i] = pass[i] - 15 * (minNum - 1);

			}
			queue = new LinkedList();
			for (int i = 0; i < 8; i++) {
				queue.add(pass[i]);

			}
			passWord();
			System.out.printf("#%d ",T);
			while(!queue.isEmpty()) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
			
		}
	}
	public static void passWord() {
		int cycle=0;
		int x=Integer.MAX_VALUE;
		while(x>0) {
			cycle++;
			if(cycle==6) {
				cycle=1;
			}
			x=queue.poll()-cycle;
			
			if(x<=0) {
				x=0;
			}
			queue.add(x);
		}
	}

}
