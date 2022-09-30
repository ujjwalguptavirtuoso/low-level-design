package multithreadedqueuepractice.model;

public interface ISubscriber {
    String getId();
    void consume();
}
