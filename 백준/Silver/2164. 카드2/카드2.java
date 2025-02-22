import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>(); 
		for(int i=1;i<=N;i++) {
			queue.add(i);		}

		
			while(queue.size()!=1) {
				queue.remove();
				
				queue.add(queue.element());
				queue.remove();
			
			}
	
		
		System.out.println(queue.element());
		

	}
	

}
