package nl.grum.microcraft;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class EventTest {

    private static final String STRING = "foo";
    private TestEvent subject;

    @Before
    public void setup() {
        subject = new TestEvent(STRING);
    }

    @Test
    public void eventHasStringData() {
        assertNotNull(subject.getString());
        assertThat(subject.getString(), is(STRING));
    }
}
