package multithreadedqueuepractice.model;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TopicSubscriber{

    private ISubscriber subscriber;
    private AtomicInteger offset;

    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }


    public AtomicInteger getOffset() {
        return offset;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }

}
