package ghostawt;

import java.awt.Component;
import java.awt.peer.LabelPeer;

public class GLabelPeer extends GComponentPeer implements LabelPeer {
    public GLabelPeer(Component target) {
        super(target);
	Logger.log("GLabelPeer", target);
    }

    @Override
    public void setText(String label) {
	Logger.log("GLabelPeer.setText", label);
    }

    @Override
    public void setAlignment(int alignment) {
	Logger.log("GLabelPeer.setAlignment", alignment);
    }
}
