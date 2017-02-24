package ghostawt;

import java.awt.Component;

public abstract class GhostCallback {
    // called on ComponentPeer.handleEvent for a WINDOW_OPENED event
    public void windowOpened(Component c) {};

    public static GhostCallback instance = null;

    static {
        String value = System.getProperty("ghostawt.callback");
        if (value != null) {
            try {
                Class c = Class.forName(value);
                instance = c.asSubclass(GhostCallback.class).newInstance();
            } catch(ClassNotFoundException e) {
                System.err.printf("no class for ghostawt.callback=%s", value);
            } catch(ClassCastException e) {
                System.err.printf("cannot cast %s to ghostawt.GhostCallback", value);
            }
        }
    }
}
