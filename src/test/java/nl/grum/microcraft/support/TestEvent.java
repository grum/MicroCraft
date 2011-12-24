package nl.grum.microcraft.support;

import nl.grum.microcraft.Event;

public class TestEvent implements Event<TestListener> {

    private final String string;

    public TestEvent(String string) {
        this.string = string;
    }

    public void notify(TestListener listener) {
        listener.onTest(getString());
    }

    public String getString() {
        return string;
    }
}
