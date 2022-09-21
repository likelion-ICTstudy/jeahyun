import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 완주자의 이름, 완주자 이름이 배열에 포함된 횟수를 저장하는 자료구조
        Map<String, Integer> comp = new HashMap<>();

        // 모든 완주자를 for문으로 돌면서 키값에는 이름을 넣고, value에 +1씩 증가시킴
        for (String c : completion) {
            comp.put(c, comp.getOrDefault(c, 0) + 1);
        }

        // 참가자 배열의 길이는 항상 완주자 배열의 길이보다 1만큼 크다.
        // 즉, 참가자 배열을 for문으로 돌면서 1씩 HashMap의 value를 줄인다면 언젠가는 -1이 될 것이다.
        // -1을 만드는 참가자가 바로 완주하지 못한 사람이다.
        // 또는 애초에 완주자 배열에 없어서 HashMap에도 포함되지 못한 참가자가 바로 완주하지 못한 사람이다.
        for (String p : participant) {
            if (comp.get(p) == null) {
                answer = p;
                break;
            } else if (comp.get(p) == 0) {
                answer = p;
                break;
            } else {
                comp.put(p, comp.get(p) - 1);
            }
        }

        return answer;
    }
}