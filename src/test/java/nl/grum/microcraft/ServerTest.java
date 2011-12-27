package nl.grum.microcraft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import nl.grum.microcraft.support.TestEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ServerTest {
    private Server subject;

    @Mock
    private EventDispatch dispatcher;

    @Before
    public void setup() {
        subject = new Server(dispatcher);
    }

    @Test
    public void queueStartsEmtpy() {
        assertFalse(subject.peekEvent());
        assertNull(subject.pollEvent());
    }

    @Test
    public void addEventToQueue() {
        Event<?> e = new TestEvent("foo");

        subject.queueEvent(e);
        assertTrue(subject.peekEvent());
    }

    @Test
    public void removeEventFromQueue() {
        Event<?> e1 = new TestEvent("foo");
        subject.queueEvent(e1);

        Event<?> e2 = subject.pollEvent();
        assertFalse(subject.peekEvent());
        assertEquals(e1, e2);
    }

}
