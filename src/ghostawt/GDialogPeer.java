package ghostawt;

import java.awt.Component;
import java.awt.Window;
import java.awt.peer.DialogPeer;
import java.util.List;

public class GDialogPeer extends GWindowPeer implements DialogPeer {
    public GDialogPeer(Component target) {
        super(target);

	Logger.log("GDialogPeer", target);
    }

    @Override
    public void setTitle(String title) {
	Logger.log("GDialogPeer.setTitle", title);
    }

    @Override
    public void setResizable(boolean resizeable) {
	Logger.log("GDialogPeer.setResizable", resizeable);
    }

    @Override
    public void blockWindows(List<Window> windows) {
	Logger.log("GDialogPeer.blockWindows", windows);
    }
}
