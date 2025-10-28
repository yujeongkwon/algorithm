import java.util.*;
import java.util.function.Function;
import java.util.regex.*;

class Solution {
    public int solution(int n, Function<Integer, String> submit) {
        // 1) 후보 생성: 1~9, 서로 다른 4자리 => 3024개
        List<int[]> candidates = new ArrayList<>(3024);
        for (int a = 1; a <= 9; a++)
            for (int b = 1; b <= 9; b++) if (b != a)
                for (int c = 1; c <= 9; c++) if (c != a && c != b)
                    for (int d = 1; d <= 9; d++) if (d != a && d != b && d != c)
                        candidates.add(new int[]{a,b,c,d});

        // 2) 루프
        while (true) {
            int bestIdx = -1;
            int bestWorst = Integer.MAX_VALUE;
            long bestScoreSumSq = Long.MAX_VALUE; // 타이브레이커: ∑ bucket^2 (작을수록 좋음)

            // 미리 현재 후보 인덱스 배열화(속도 미세 최적화)
            int m = candidates.size();
            // 조기 종료: 후보 1개면 바로 답
            if (m == 1) return toInt(candidates.get(0));

            for (int gi = 0; gi < m; gi++) {
                int[] guess = candidates.get(gi);

                // 버킷: S는 0..4, B는 0..(4-S) => 최대 15개 조합. 인덱스를 하나로 매핑.
                // 간단히 5x5 배열로 두고 불가능한 조합은 0으로 두자.
                int[][] buckets = new int[5][5];

                for (int ci = 0; ci < m; ci++) {
                    int[] cand = candidates.get(ci);
                    int[] sb = score(cand, guess);
                    buckets[sb[0]][sb[1]]++;
                }

                int worst = 0;
                long sumSq = 0;
                for (int s = 0; s <= 4; s++) {
                    for (int b = 0; b <= 4; b++) {
                        int cnt = buckets[s][b];
                        if (cnt == 0) continue;
                        // 불가능 조합(예: s+b>4)은 자연히 cnt=0일 것
                        worst = Math.max(worst, cnt);
                        sumSq += (long) cnt * cnt;
                    }
                }

                if (worst < bestWorst || (worst == bestWorst && sumSq < bestScoreSumSq)) {
                    bestWorst = worst;
                    bestScoreSumSq = sumSq;
                    bestIdx = gi;
                }
            }

            int[] guess = candidates.get(bestIdx);
            int g = toInt(guess);

            // 2-2) 제출 & 힌트 파싱
            String hint = submit.apply(g);      
            int sNeeded = hint.charAt(0) - '0';
            int bNeeded = hint.charAt(3) - '0';

            if (sNeeded == 4) return g;           // 정답

            // 2-3) 후보 필터링
            List<int[]> next = new ArrayList<>();
            for (int[] cand : candidates) {
                int[] sb = score(cand, guess);
                if (sb[0] == sNeeded && sb[1] == bNeeded) next.add(cand);
            }
            candidates = next;

        
        }
    }

    // 정수화
    private static int toInt(int[] d) {
        return d[0]*1000 + d[1]*100 + d[2]*10 + d[3];
    }

    // 문제 정의: 같은 자리면 STRIKE, 아니면 포함이면 BALL
    private static int[] score(int[] ans, int[] guess) {
        int s = 0, b = 0;
        // 빈도 대신 직접 비교 (자리 4개라 이게 가장 빠름)
        for (int i = 0; i < 4; i++) {
            if (ans[i] == guess[i]) s++;
            else if (ans[0]==guess[i] || ans[1]==guess[i] || ans[2]==guess[i] || ans[3]==guess[i]) b++;
        }
        return new int[]{s, b};
    }
}
