import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pd = new PriorityQueue<>();
        
        for(int i=0;i<scoville.length;i++){
            pd.add(scoville[i]);
        }
        while(pd.peek()<K){
            if(pd.size()<2){
                return -1;
            }
            int a=pd.poll();
            int b=pd.poll();
            pd.add(a+b*2);
            answer++;
        }
        return answer;
    }
}