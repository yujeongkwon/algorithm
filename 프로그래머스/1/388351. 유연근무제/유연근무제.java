class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<timelogs.length; i++) {
            int day = startday;
            int hope_m = schedules[i]%100+10;
            int hope_h = schedules[i]/100 + hope_m/60;
            hope_m %= 60;
            
            boolean isLate = false;
            for(int j=0; j<7; j++) {
                int today_h = timelogs[i][j]/100;
                int today_m = timelogs[i][j]%100;
                
                if(day != 6 && day!=7){
                    if(today_h>hope_h || (today_h== hope_h && today_m > hope_m)){
                        isLate = true;
                        break;
                    }
                }
                day = day%7 +1;
            }
                
            if(!isLate)  answer++;
        }
        
        return answer;
    }
}