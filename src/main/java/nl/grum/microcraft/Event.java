package nl.grum.microcraft;

public interface Event<L extends Listener>  {
    void notify(final L listener);
}
