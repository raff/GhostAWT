package ghostawt;

import java.awt.Button;
import java.awt.peer.ButtonPeer;

public class GButtonPeer extends GComponentPeer implements ButtonPeer {
    public GButtonPeer(Button target) {
        super(target);
	
	Logger.log("GButtonPeer", target);
    }

    @Override
    public void setLabel(String label) {
	Logger.log("GButton.setLabel", label);
    }
}
