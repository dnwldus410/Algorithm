import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        String a = phone_book[0];
        for(int i=1;i<phone_book.length;i++){
            if(phone_book[i].startsWith(a)){
                answer=false;
            }
            else{
                a = phone_book[i];
            }
        }
   return answer;
    }
}