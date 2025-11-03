class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int n = park.length;
        int m = park[0].length();
        int[] cur = new int[2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(park[i].charAt(j)=='S'){
                    cur = new int[]{i,j};
                }
            }
        }
        
        for(String op : routes){
            char oper = op.charAt(0);
            int cnt = op.charAt(2) - '0';
            if(oper=='E' && cur[1]+cnt < m) {
                boolean isPossible = true;
                for(int i=1; i<=cnt; i++) {
                    if(park[cur[0]].charAt(cur[1]+i) == 'X') {
                        isPossible = false;
                    }
                }
                if(isPossible) {
                    cur[1] += cnt;
                }
            }
            if(oper=='N' && cur[0]-cnt >= 0) {
                boolean isPossible = true;
                for(int i=1; i<=cnt; i++) {
                    if(park[cur[0]-i].charAt(cur[1]) == 'X') {
                        isPossible = false;
                    }
                }
                if(isPossible) {
                    cur[0] -= cnt;
                }
            }
            if(oper=='S'&&cur[0]+cnt < n) {
                boolean isPossible = true;
                for(int i=1; i<=cnt; i++) {
                    if(park[cur[0]+i].charAt(cur[1]) == 'X') {
                        isPossible = false;
                    }
                }
                if(isPossible) {
                    cur[0] += cnt;
                }
            }
            if(oper=='W' && cur[1]-cnt >= 0) {
                boolean isPossible = true;
                for(int i=1; i<=cnt; i++) {
                    if(park[cur[0]].charAt(cur[1]-i) == 'X') {
                        isPossible = false;
                    }
                }
                if(isPossible) {
                    cur[1] -= cnt;
                }
            }
        }
        
        return cur;
    }
}