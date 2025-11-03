import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        LinkedList<Integer> paint = new LinkedList<>();
        for(int s:section) paint.offer(s);
        
        int end = paint.pollLast();
        answer++;
        while(!paint.isEmpty() && paint.getLast() > end-m){
            paint.pollLast();
        }
        while(!paint.isEmpty()) {
            int cur = paint.poll();
            answer++;
            while(!paint.isEmpty() && paint.getFirst() < cur+m){
                paint.poll();
            }
        }
        
        return answer;
    }
}