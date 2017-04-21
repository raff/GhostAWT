package ghostawt;

import java.awt.Component;
import java.awt.Insets;
import java.awt.peer.PanelPeer;

public class GPanelPeer extends GCanvasPeer implements PanelPeer {
    public GPanelPeer(Component target) {
        super(target);

	Logger.log("GPanelPeer", target);
    }

    @Override
    public Insets getInsets() {
	Logger.log("GPanelPeer.getInsets");
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public void beginValidate() {
	Logger.log("GPanelPeer.beginValidate");
    }

    @Override
    public void endValidate() {
	Logger.log("GPanelPeer.endValidate");
    }

    @Override
    public void beginLayout() {
	Logger.log("GPanelPeer.beginLayout");
    }

    @Override
    public void endLayout() {
	Logger.log("GPanelPeer.endLayout");
    }
}
