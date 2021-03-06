package nl.grum.microcraft;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Server {

    private final ConcurrentLinkedQueue<Event<?>> queue = new ConcurrentLinkedQueue<Event<?>>();
    private final EventDispatch dispatcher;

    public Server(EventDispatch dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void queueEvent(Event<?> e) {
        queue.add(e);
    }

    public Event<?> pollEvent() {
        return queue.poll();
    }

    public boolean peekEvent() {
        return queue.peek() != null;
    }

    public void start() {
        System.err.println("Starting server");
    }

    public void stop() {
        System.err.println("Stopping server");
    }
}