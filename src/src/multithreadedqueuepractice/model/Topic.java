package multithreadedqueuepractice.model;
import lombok.Getter;

import java.util.*;

@Getter
public class Topic {

    private String topicName;
    private String topicId;
    private List<Message> messages;
    private List<TopicSubscriber> subscribers;

    public Topic(String topicName, String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.messages = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    synchronized void addMessage(Message message){
        messages.add(message);
    }

    void addSubscriber(TopicSubscriber subscriber){
        subscribers.add(subscriber);
    }



}
