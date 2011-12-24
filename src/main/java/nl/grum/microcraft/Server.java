package nl.grum.microcraft;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Server {

    private final ConcurrentLinkedQueue<Event> queue = new ConcurrentLinkedQueue<Event>();

    public void queueEvent(Event e) {
        queue.add(e);
    }

    public Event pollEvent() {
        return queue.poll();
    }

    public boolean peekEvent() {
        return queue.peek() != null;
    }
}