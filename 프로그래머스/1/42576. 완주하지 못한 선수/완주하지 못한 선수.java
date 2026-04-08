import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int num;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<participant.length;i++){
            if(map.containsKey(participant[i])){
                num=map.get(participant[i])+1;
                map.replace(participant[i],num);
            }
            else{
                map.put(participant[i],1);
            }
                
        }
        
        for(int i=0;i<completion.length;i++){
             if(map.containsKey(completion[i])){
                num=map.get(completion[i])-1;
                map.replace(completion[i],num);
            }
        }
        for(String name : map.keySet()){
            if(map.get(name)==1){
                answer=name;
            }
        }
        return answer;
    }
}