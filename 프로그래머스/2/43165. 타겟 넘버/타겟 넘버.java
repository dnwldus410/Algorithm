import java.util.*;
class Solution {
    static int result;
    static int sum;
    static boolean[] visited;
  static int[] number;
    public int solution(int[] numbers, int target) {
         for(int i=0;i<numbers.length;i++){
          sum+=numbers[i];
      }
        number=numbers;
        visited=new boolean[numbers.length];
      
        for(int i=1;i<=number.length;i++){
             dfs(0,target,0,i,0);
        }
         
      
        return result;
    }
    public static void dfs(int num,int target,int depth, int end,int start){
        if(depth==end){
       
            if(sum+(num*2)==target){
                result++;
            }
            return;
        }
        for(int i=start;i<number.length;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(num-number[i],target,depth+1,end,i);
                visited[i]=false;
            }
        }
    }
    
 
}