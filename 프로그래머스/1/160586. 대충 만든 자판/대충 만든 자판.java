import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int INF = 99999;
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(String key : keymap) {
            int cnt = 0;
            for(char c : key.toCharArray()) {
                cnt++;
                map.put(c, Math.min(map.getOrDefault(c,INF),cnt));
            }
        }
        
        for(String target : targets) {
            int cnt = 0;
            for(char c : target.toCharArray()) {
                if(!map.containsKey(c)) {
                    cnt = -1;
                    break;
                }
                else {
                    cnt+= map.get(c);
                }
            }
            arr.add(cnt);
        }
        
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}