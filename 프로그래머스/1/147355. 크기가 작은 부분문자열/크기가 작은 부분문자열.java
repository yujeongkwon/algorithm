// class Solution {
//     public int solution(String t, String p) {
//         int answer = 0;
//         int tLen =t.length();
//         int pLen =p.length();
//         long pInt = Integer.parseInt(p);
//         for(int i=0; i+pLen<=tLen; i++){
//             if(Long.parseLong(t.substring(i,i+pLen)) <= pInt){
//                 answer++;
//             }
//         }
//         return answer;
//     }
// }

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLen = t.length();
        int pLen = p.length();

        long pVal = Long.parseLong(p); // int 대신 long
        for (int i = 0; i + pLen <= tLen; i++) {
            long subVal = Long.parseLong(t.substring(i, i + pLen));
            if (subVal <= pVal) answer++;
        }
        return answer;
    }
}
