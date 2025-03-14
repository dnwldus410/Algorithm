import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        int num=0;
        //가장많은장르확인
        HashMap<String,Integer> hash = new HashMap<>();
      
        for(int i=0;i<genres.length;i++){
            if(hash.containsKey(genres[i])){
                num=hash.get(genres[i])+plays[i];
                hash.put(genres[i],num);
            }
            else{
                num=plays[i];
                hash.put(genres[i],num);
            }
        }
        List<String>KeySet = new ArrayList<>(hash.keySet());
        KeySet.sort((o1,o2)-> hash.get(o2).compareTo(hash.get(o1)));
     
       List<Integer>result = new ArrayList<>();
        int genreKey=0;
       for(String key : KeySet){
            String genre=key;
           List<int []> array = new LinkedList<>();
           for(int i=0;i<genres.length;i++){
               if(genre.equals(genres[i])){
                   array.add(new int[]{i,plays[i]});
                
               }}
      
             
                   if (!array.isEmpty()) {
                   array.sort((o1,o2)->o1[1]==o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o2[1], o1[1]));
                     
                   if(array.size()>=2){
                       for(int a=0;a<2;a++){
                         result.add(array.get(a)[0]);
                       }
                      
                   }
                 else{
                   result.add(array.get(0)[0]);
                     
                 }
            
                  
                   
               }
             
        
       }
        answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
       
        return answer;
    }
}