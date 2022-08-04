package multi_threaded_queue;

import multi_threaded_queue.model.Message;

public interface ISubscriber {

    String getId();
    void consume(Message message);
}
