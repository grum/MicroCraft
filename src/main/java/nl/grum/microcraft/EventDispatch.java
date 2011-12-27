package nl.grum.microcraft;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class EventDispatch {
    @SuppressWarnings("rawtypes")
    private final Map<Class, List> map = Maps.newHashMap();

    public <L> void register(Class<? extends Event<L>> eventClass, L listener) {
        List<L> listeners = listenersOf(eventClass);
        synchronized (listeners) {
            listeners.add(listener);
        }
    }

    public <L> void unregister(Class<? extends Event<L>> eventClass, L listener) {
        List<L> listeners = listenersOf(eventClass);
        synchronized (listeners) {
            listeners.remove(listener);
        }
    }

    private <L> List<L> listenersOf(Class<? extends Event<L>> eventClass) {
        synchronized (map) {
            @SuppressWarnings("unchecked")
            List<L> list = map.get(eventClass);
            if (list == null) {
                list = Lists.newArrayList();
                map.put(eventClass, list);
            }

            return list;
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
