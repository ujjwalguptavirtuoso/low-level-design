package multithreadedqueuepractice.handlers;

import lombok.Getter;
import java.util.*;

import lombok.SneakyThrows;
import multithreadedqueuepractice.model.*;
@Getter
public class SubscriberWorker implements Runnable{

    private  Topic topic;
    private  TopicSubscriber topicSubscriber;

    public SubscriberWorker( Topic topic,  TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (topicSubscriber){
            while(true){
                int currOffset = topicSubscriber.getOffset().get();
                if( currOffset >= topic.getMessages().size()){
                    wait();
                }
                Message message = topic.getMessages().get(topicSubscriber.getOffset().get());
                topicSubscriber.getSubscriber().consume();
                topicSubscriber.getOffset().compareAndSet(currOffset, currOffset + 1);
            }
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notifyAll();
        }
    }
}
