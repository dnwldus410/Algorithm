import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>(); //동일값 안되고
        ArrayList<Integer> list = new ArrayList<>();  //접두어 길이
         Arrays.sort(phone_book);
        String startnum=phone_book[0].substring(0,1);
        list.add(phone_book[0].length());  //0값 길이 ex)119
        set.add(phone_book[0]);             //0값 넣기 119
       
        int length=0;
        for(int i=1;i<phone_book.length;i++){
          
            if(!answer){
                break;
            }
            set.add(phone_book[i]);
             if(!phone_book[i].substring(0,1).equals(startnum)){
                startnum=phone_book[i].substring(0,1);
                list.clear();
            }
            
            if(!list.contains(phone_book[i].length())){   //다음꺼 4가 없으면
                      list.add(phone_book[i].length());    //3,4 
                } 
           
        
            for(int j=0;j<list.size();j++){  //지금 size() = 2
                      
                length=list.get(j);
            
                if(phone_book[i].length()>length){
                     if(set.contains(phone_book[i].substring(0,length))){
                        answer=false;
                         break;
                }               
            }           
           }                
        }
        return answer;
    }
}