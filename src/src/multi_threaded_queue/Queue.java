package multi_threaded_queue;

import multi_threaded_queue.handler.TopicHandler;
import multi_threaded_queue.model.Message;
import multi_threaded_queue.model.Topic;
import multi_threaded_queue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {

    Map<String, TopicHandler> topicProcessors;

    public Queue(){
        this.topicProcessors = new HashMap<>();
    }

    Topic createTopic(String topicName){
        Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicProcessors.put(topic.getTopicId(), topicHandler);
        return topic;
    }

    void subscribe(ISubscriber subscriber, Topic topic){
        topic.addSubscriber(new TopicSubscriber(subscriber));
    }

   void publish(Topic topic, Message message){
        topic.getMessages().add(message);
       new Thread(() -> topicProcessors.get(topic.getTopicId()).publish()).start();
   }

    public void resetOffset(final Topic topic,final ISubscriber subscriber, final Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            if (topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() + " offset reset to: " + newOffset);
                new Thread(() -> topicProcessors.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }
}
