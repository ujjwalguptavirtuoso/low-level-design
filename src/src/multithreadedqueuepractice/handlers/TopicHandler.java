package multithreadedqueuepractice.handlers;
import lombok.Getter;
import multithreadedqueuepractice.model.*;
import java.util.*;

@Getter
public class TopicHandler {

    private Topic topic;
    private Map<String, SubscriberWorker> subscriberWorkerMap;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberWorkerMap = new HashMap<>();
    }

    public void publish(){
        for(TopicSubscriber subscriber : topic.getSubscribers()){
            //startSubWorker;
        }
    }

    public void startSubscriberWorker(TopicSubscriber topicSubscriber){
        String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!subscriberWorkerMap.containsKey(subscriberId)) {
             SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkerMap.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }
    }
}
