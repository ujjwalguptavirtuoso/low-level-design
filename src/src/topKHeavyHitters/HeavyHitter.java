package topKHeavyHitters;
import java.util.*;
public class HeavyHitter {

    private String identifier;
    private int frequency;

    public HeavyHitter(String identifier, int frequency) {
        this.identifier = identifier;
        this.frequency = frequency;
    }

    public List<HeavyHitter> topK(String [] events, int k){ // O(nlogK)
        Map<String, Integer> frequencyTable = new HashMap<>();
        for(String event : events){
            frequencyTable.put(event, frequencyTable.getOrDefault(event, 0) + 1);
        }

        PriorityQueue<HeavyHitter> pq = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);
        for(String event : frequencyTable.keySet()){
            pq.offer(new HeavyHitter(event, frequencyTable.get(event)));
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<HeavyHitter> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
}
