package ghostawt;

import java.awt.Component;
import java.awt.peer.ChoicePeer;

public class GChoicePeer extends GComponentPeer implements ChoicePeer {
    GChoicePeer(Component target) {
        super(target);

	Logger.log("GChoicePeer", target);
    }

    @Override
    public void add(String item, int index) {
	Logger.log("GChoicePeer.add", item, index);
    }

    @Override
    public void remove(int index) {
	Logger.log("GChoicePeer.remove", index);
    }

    @Override
    public void removeAll() {
	Logger.log("GChoicePeer.removeAll");
    }

    @Override
    public void select(int index) {
	Logger.log("GChoicePeer.select", index);
    }
}
