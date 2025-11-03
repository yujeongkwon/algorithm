class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int[] p = {0,m,0,0};
        boolean isFirst = true;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(wallpaper[i].charAt(j)=='#') {
                    if(isFirst) {
                        p[0]=i;
                        isFirst = false;
                    }
                    p[1]=Math.min(j,p[1]);
                    p[2]=i+1;
                    p[3]=Math.max(j+1,p[3]);
                }
            }
        }
        
        return p;
    }
}