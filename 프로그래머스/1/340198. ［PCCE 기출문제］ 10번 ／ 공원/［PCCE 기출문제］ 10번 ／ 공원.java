import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] dp = new int[park.length][park[0].length];
        int max = 0;
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[0].length; j++) {
                if(park[i][j].equals("-1")){
                    if(i== 0||j==0) {
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +1;
                    }
                    if(max<dp[i][j]){
                        max = dp[i][j];
                    }
                }
            }
        } 
        int answer = -1;
        for(int size : mats) {
            if(size <= max) {
                answer = Math.max(size,answer);
            }
        }
        
        return answer;
    }
    
}