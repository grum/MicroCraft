package nl.grum.microcraft;

public interface Event<L>  {
    void notify(final L listener);
}
