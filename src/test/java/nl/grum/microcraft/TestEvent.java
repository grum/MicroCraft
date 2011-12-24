package nl.grum.microcraft;

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
