package nl.grum.microcraft;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import nl.grum.microcraft.support.TestEvent;
import nl.grum.microcraft.support.TestListener;

import org.junit.Test;

public class EventDispatchTest {
    private EventDispatch subject = new EventDispatch();
    private int counter = 0;
    private String message;

    @Test
    public void test() {
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
