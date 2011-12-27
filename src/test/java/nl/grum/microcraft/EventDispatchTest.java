package nl.grum.microcraft;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import nl.grum.microcraft.support.TestEvent;
import nl.grum.microcraft.support.TestListener;

import org.junit.Test;

public class EventDispatchTest {
    private EventDispatch subject = new EventDispatch();
    private int counter = 0;
    private String message;

    private TestListener testListener = new TestListener() {
        public void onTest(String string) {
            message = string;
            counter++;
        }
    };
    private Class<? extends Event<TestListener>> eventClass = TestEvent.class;

    @Test(expected = IllegalArgumentException.class)
    public void registerNullEventFails() {
        subject.register(null, testListener);
    }

    @Test(expected = IllegalArgumentException.class)
    public void registerNullListenerFails() {
        subject.register(TestEvent.class, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void unregisterNullEventFails() {
        subject.unregister(null, testListener);
    }

    @Test(expected = IllegalArgumentException.class)
    public void unregisterNullListenerFails() {
        subject.unregister(TestEvent.class, null);
    }

    @Test
    public void registrationAndNotificationWorks() {
        subject.register(TestEvent.class, new TestListener() {
            public void onTest(String string) {
                message = string;
                counter++;
            }
        });

        String input = "Foo";

        assertThat(counter, is(0));
        assertThat(message, nullValue());

        subject.notify(new TestEvent(input));
        assertThat(counter, is(1));
        assertThat(message, is(input));
    }

}
