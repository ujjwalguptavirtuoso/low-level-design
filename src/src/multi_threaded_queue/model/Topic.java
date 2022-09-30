package multi_threaded_queue.model;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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

    synchronized public void addMessage(Message message){
        messages.add(message);
    }

    public void addSubscriber(TopicSubscriber topicSubsriber){
        subscribers.add(topicSubsriber);
    }

}
