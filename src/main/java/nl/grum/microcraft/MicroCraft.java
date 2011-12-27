package nl.grum.microcraft;

public class MicroCraft {
    public static void main(String...args) {
        final Server server = new Server(new EventDispatch());
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                server.stop();
            }
        });
    }
}
