package multithreadedqueuepractice;

import multithreadedqueuepractice.handlers.TopicHandler;
import java.util.*;
import multithreadedqueuepractice.model.*;

public class Queue {

    Map<String, TopicHandler> topicHandlerMap;

    Topic createTopic(String topicName){
        String topicId = UUID.randomUUID().toString();
        Topic topic = new Topic(topicName, topicId);
        TopicHandler topicHandler = new TopicHandler(topic);
        topicHandlerMap.put(topicId, topicHandler);
        return topic;
    }

    void subscribe(Topic topic, ISubscriber subscriber){
        topic.getSubscribers().add(new TopicSubscriber(subscriber));
    }

    void publish(Topic topic, Message message){
        topic.getMessages().add(message);
        topicHandlerMap.get(topic.getTopicId()).publish();
    }
}
