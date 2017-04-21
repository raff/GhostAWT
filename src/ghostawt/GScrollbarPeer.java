package ghostawt;

import java.awt.Component;
import java.awt.peer.ScrollbarPeer;

public class GScrollbarPeer extends GComponentPeer implements ScrollbarPeer {
    public GScrollbarPeer(Component target) {
        super(target);

        Logger.log("GScrollbarPeer", target);
    }

    @Override
    public void setValues(int value, int visible, int minimum, int maximum) {
        Logger.log("GScrollbarPeer.setValues", value, visible, minimum, maximum);
    }

    @Override
    public void setLineIncrement(int l) {
        Logger.log("GScrollbarPeer.setLineIncrement", l);
    }

    @Override
    public void setPageIncrement(int l) {
        Logger.log("GScrollbarPeer.setPageIncrement", l);
    }
}
