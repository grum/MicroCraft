package nl.grum.microcraft;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class EventTest {

    private Event subject;

    @Before
    public void setup() {
        subject = new Event();
    }

    @Test
    public void stupidTest() {
        assertThat(subject, notNullValue());
    }
}
