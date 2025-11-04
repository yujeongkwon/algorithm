import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> arr = new ArrayList<>();
        int year = Integer.parseInt(today.substring(0,4));
        int month = Integer.parseInt(today.substring(5,7));
        int day = Integer.parseInt(today.substring(8));
        int todayInt = year*10000 + month*100 + day;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(String term : terms) {
            map.put(term.charAt(0), Integer.parseInt(term.substring(2)));
        }
        
        for(int i=0; i< privacies.length; i++) {
            String privacy = privacies[i];
            int cur_year = Integer.parseInt(privacy.substring(0,4));
            int cur_month = Integer.parseInt(privacy.substring(5,7));
            int cur_day = Integer.parseInt(privacy.substring(8,10));
            
            char cur = privacy.charAt(11);
            cur_day -= 1;
            cur_month = cur_month + map.get(cur) - ((cur_day==0) ? 1 : 0);
            cur_year = cur_year + (cur_month-1)/12;
            cur_day = (cur_day==0) ? 28 : cur_day;
            cur_month = ((cur_month - 1) % 12) + 1;

            
            int curDayInt =  cur_year*10000 + cur_month*100 + cur_day;
            if(curDayInt<todayInt) {
                arr.add(i+1);
            }
        }
        
        return arr.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}