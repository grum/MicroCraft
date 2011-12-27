package nl.grum.microcraft;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class EventDispatch {
    @SuppressWarnings("rawtypes")
    private final Map<Class, Set> map = Maps.newHashMap();

    public <L> void register(Class<? extends Event<L>> eventClass, L listener) {
        Validate.notNull(eventClass, "eventClass must be set");
        Validate.notNull(listener, "listener must be set");
        Collection<L> listeners = listenersOf(eventClass);
        synchronized (listeners) {
            listeners.add(listener);
        }
    }

    public <L> void unregister(Class<? extends Event<L>> eventClass, L listener) {
        Validate.notNull(eventClass, "eventClass must be set");
        Validate.notNull(listener, "listener must be set");
        Collection<L> listeners = listenersOf(eventClass);
        synchronized (listeners) {
            listeners.remove(listener);
        }
    }

    protected <L> Collection<L> listenersOf(Class<? extends Event<L>> eventClass) {
        synchronized (map) {
            @SuppressWarnings("unchecked")
            Set<L> set = map.get(eventClass);
            if (set == null) {
                set = Sets.newHashSet();
                map.put(eventClass, set);
            }

            return set;
        }
    }

    public <L> void notify(final Event<L> event) {
        @SuppressWarnings("unchecked")
        Class<Event<L>> eventClass = (Class<Event<L>>) event.getClass();

        for (L listener : listenersOf(eventClass)) {
            event.notify(listener);
        }
    }
}
