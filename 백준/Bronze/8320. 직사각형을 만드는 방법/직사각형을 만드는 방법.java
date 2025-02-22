import java.util.Scanner;

public class Main {

	public static int countDivisors(int num) {
		int result = 0;
		int prime = (int) Math.sqrt(num);

		for (int i = 1; i <= prime; i++) {
			if (i * (num/i) == num) {
		
				result++;
			}

		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result=0;
		
		  for (int i = 1; i < N + 1; i++) 
		  {

				  result+=countDivisors(i);

			
		  
		  }
		 
		
		System.out.println(result);
		sc.close();

	}

}
