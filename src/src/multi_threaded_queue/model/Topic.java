package multi_threaded_queue.model;
import java.util.ArrayList;
import java.util.List;

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

  /**  public synchronized addMessage(Message message){
        messages.add(message);
    } **/

    public void addSubscriber(TopicSubscriber topicSubsriber){
        subscribers.add(topicSubsriber);
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<TopicSubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<TopicSubscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
