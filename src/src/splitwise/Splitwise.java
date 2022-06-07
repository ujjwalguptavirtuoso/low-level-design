package splitwise;

import javafx.util.Pair;

import java.util.*;

public class Splitwise {

    Map<Integer, Integer> net_balance = new HashMap<>();
     // Pair --> {K : personId, V : netBalance }
    PriorityQueue<Pair<Integer, Integer>> postive_pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

    PriorityQueue<Pair<Integer, Integer>> negative_pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

    /**
     * gets a list of transactions
     * payer --> payee, we store payer, with +ve balance as that money will paid back to payer later
     * we store payee in met_balance map , with -ve balance as that money will be paid back by payee later(debt)
     * @param transactions
     */
    void registerTransactions(List<Transaction> transactions){
        for(int i=0; i < transactions.size(); i ++){
              Transaction tr = transactions.get(i);
              //checks whether payer is present in hashmap
              // payer code
              if(net_balance.containsKey(tr.payer)){
                  // adding into payer amount as he/she has to pay that later
                  net_balance.put(tr.payer, net_balance.get(tr.payer) + tr.amount);
              }else{
                  net_balance.put(tr.payer, tr.amount);
              }


              //payee code
            if(net_balance.containsKey(tr.payee)){
                // adding into payer amount as he/she has to pay that later
                net_balance.put(tr.payee, net_balance.get(tr.payee) - tr.amount);
            }else{
                net_balance.put(tr.payee, 0 - tr.amount);
            }
        }
    }

    /**
     * populate min heap for debtors and max heap for people who lent money
     */
    void populatePriorityQueues(){
        for(Integer personId : net_balance.keySet()){
            if(net_balance.get(personId) > 0){
                postive_pq.offer(new Pair(personId, net_balance.get(personId)));
            }
            else if(net_balance.get(personId) < 0){
                negative_pq.offer(new Pair(personId, net_balance.get(personId)));
            }
        }
    }


    /**
     *  returns the final list of simplified settlements
     * @return
     */
    List<Transaction> settleTransactions() {
        List<Transaction> settlementList = new ArrayList<>();

        while (!postive_pq.isEmpty() && !negative_pq.isEmpty()) {
            Pair positivePair = postive_pq.poll();
            Pair negativePair = negative_pq.poll();

            settlementList.add(new Transaction((int)negativePair.getKey(), (int)positivePair.getKey(),
                    Math.min(Math.abs((int)negativePair.getValue()), Math.abs((int)positivePair.getValue()))));

            // after adding in settlement list checking if still some balance left for this person ; if postive > negative
            if((int)positivePair.getValue() > Math.abs((int)negativePair.getValue())){
                postive_pq.offer(new Pair(positivePair.getKey(), (int)positivePair.getValue() - Math.abs((int)negativePair.getValue())));
            }

            // after adding in settlement list checking if still some balance left for this person ; if negative > positive
            if((int)positivePair.getValue() < Math.abs((int)negativePair.getValue())){
                negative_pq.offer(new Pair(negativePair.getKey(),  -1 * (Math.abs((int)negativePair.getValue()) - (int)positivePair.getValue())));
            }
        }
        return settlementList;
    }


}
