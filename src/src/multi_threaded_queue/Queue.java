package multi_threaded_queue;

import multi_threaded_queue.handler.TopicHandler;
import multi_threaded_queue.model.Message;
import multi_threaded_queue.model.Topic;
import multi_threaded_queue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {

    Map<String, TopicHandler> topicHandlers;

    public Queue(){
        this.topicHandlers = new HashMap<>();
    }

    Topic createTopic(String topicName){
        Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicHandlers.put(topic.getTopicId(), topicHandler);
        return topic;
    }

    void subscribe(ISubscriber subscriber, Topic topic){
        topic.addSubscriber(new TopicSubscriber(subscriber));
    }

   void publish(Topic topic, Message message){
        topic.getMessages().add(message);
        //Thread newThread = new Thread(() -> topicHandlers.get(topic.getTopicId()).publish());
        //newThread.start();
       Thread newThread = new Thread(() -> topicHandlers.get(topic.getTopicId()).publish());
       newThread.start();
   }

    public void resetOffset(final Topic topic,final ISubscriber subscriber, final Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            if (topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() + " offset reset to: " + newOffset);
                new Thread(() -> topicHandlers.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }
}
