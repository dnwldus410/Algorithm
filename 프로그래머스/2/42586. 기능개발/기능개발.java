import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};      
        List<Integer> list = new ArrayList<>();
        int count=1 ;
        int day=0;
        if(speeds[0]==1){
            day=(100-progresses[0])/speeds[0];
        }
        else{
             day=(100-progresses[0])/speeds[0]+1;
        }      
            for(int i=0;i<progresses.length-1;i++){  
                int num=progresses[i+1];
                if((num+=speeds[i+1]*day)>=100){
                    count++;       
                   
                }
                else{
                    
                     list.add(count);
                    count=0;
                    if(speeds[i+1]==1){
            day=(100-progresses[i+1])/speeds[i+1];
                       
        }
        else{
             day=(100-progresses[i+1])/speeds[i+1]+1;
        }      
                   
                
                    count++;
                    
                   
                }
            }
       
        list.add(count);
        answer=new int[list.size()];
    for(int i=0;i<list.size();i++){
        answer[i]=list.get(i);
    }
        return answer;
    }
    
}