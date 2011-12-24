package nl.grum.microcraft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ServerTest {
    private Server subject;

    @Before
    public void setup() {
        subject = new Server();
    }

    @Test
    public void queueStartsEmtpy() {
        assertFalse(subject.peekEvent());
        assertNull(subject.pollEvent());
    }

    @Test
    public void addEventToQueue() {
        Event e = new Event();

        subject.queueEvent(e);
        assertTrue(subject.peekEvent());
    }

    @Test
    public void removeEventFromQueue() {
        Event e1 = new Event();
        subject.queueEvent(e1);

        Event e2 = subject.pollEvent();
        assertFalse(subject.peekEvent());
        assertEquals(e1, e2);
    }

}
