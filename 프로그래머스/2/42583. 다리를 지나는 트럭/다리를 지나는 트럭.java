import java.util.*;
class Solution {
   	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < bridge_length; i++) {
			queue.add(0);
		}

		int x = 0;
		int check = 0; // truck배열 값;
		int weight_check = 0;// 들어오는 트럭의 값 weight를 넘으면 안됨
		while (!queue.isEmpty()) {
			
			x = queue.poll();
			answer++;

			weight_check -= x;
			if (check < truck_weights.length) {
				if (weight_check + truck_weights[check] <= weight) {
					weight_check += truck_weights[check];

					queue.add(truck_weights[check]);
					check++;

				} else {
					

					queue.add(0);
				}
			}

		}

		return answer;
	}
}