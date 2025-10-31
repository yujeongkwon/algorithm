class Solution {
    
    class Time {
        public int m;
        public int s;
        
        public Time(int m, int s) {
            this.m = m;
            this.s = s;
        }
        
        public Time(String time) {
            m = Integer.parseInt(time.substring(0,2));
            s = Integer.parseInt(time.substring(3));
        }
        
        public int getSeconds() {
            return m*60 + s;
        }
        
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        Time len = new Time(video_len);
        Time cur = new Time(pos);
        Time start = new Time(op_start);
        Time end = new Time(op_end);
        int cur_t = cur.getSeconds();
        int len_t = len.getSeconds();
        int start_t = start.getSeconds();
        int end_t = end.getSeconds();
        
        for(String com : commands) {
            if(start_t<= cur_t && cur_t<= end_t) {
                cur_t=end_t;
            }   
            
            if(com.equals("next")) {
                if(cur_t+10 <= len_t) {
                    cur_t = cur_t+10;
                }
                else{
                    cur_t = len_t;
                }
            }
            else if(com.equals("prev")) {
                if(cur_t-10 >= 0) {
                    cur_t = cur_t-10;
                }
                else{
                    cur_t = 0;
                }
            }
            
        }
        
        if(start_t<= cur_t && cur_t<= end_t) {
                cur_t=end_t;
            }  
        
        StringBuilder st = new StringBuilder();
        st.append(String.format("%02d",cur_t/60)).append(":").append(String.format("%02d",cur_t%60));
        
        return st.toString();
    }
}