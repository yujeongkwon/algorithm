import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);
        
        ArrayList<int[]> datas = new ArrayList<>();
        for(int i=0; i<data.length; i++) {
            if(data[i][map.get(ext)] < val_ext) {
                datas.add(data[i]);
            }
        }
        
        answer = datas.stream()
            .sorted(Comparator.comparingInt(x->x[map.get(sort_by)])).toArray(int[][]::new);
        
        
        return answer;
    }
}