import java.util.*;

class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int s : scoville) {
            minHeap.add(s);
        }
        while (minHeap.peek() < K) {
            if (minHeap.size() == 1) return -1;
            int i = minHeap.poll();
            int j = minHeap.poll();
            if (i == 0 && j == 0) return -1;
            int z = i + (j*2);
            minHeap.add(z);
            answer += 1;
        }
        return answer;
    }
}
