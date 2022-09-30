package multi_threaded_queue.handler;

import multi_threaded_queue.model.Message;
import multi_threaded_queue.model.Topic;
import multi_threaded_queue.model.TopicSubscriber;

public class SubscriberWorker implements Runnable{

    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker( final Topic topic,  final TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }


    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int curOffset = topicSubscriber.getOffset().get();
                while (curOffset >= topic.getMessages().size()) {
                    try {
                        topicSubscriber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message message = topic.getMessages().get(curOffset);
                topicSubscriber.getSubscriber().consume(message);

                // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
                // consuming we need to increase only if it was previous one.
                topicSubscriber.getOffset().compareAndSet(curOffset, curOffset + 1);
            } while (true);
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notifyAll();
        }
    }
}
