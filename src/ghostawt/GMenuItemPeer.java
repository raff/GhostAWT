package ghostawt;

import java.awt.Font;
import java.awt.MenuItem;
import java.awt.peer.MenuItemPeer;

public class GMenuItemPeer extends GObjectPeer implements MenuItemPeer {
    protected GMenuItemPeer(Object target) {
        super(target);

	Logger.log("GMenuItemPeer", target);
    }

    public GMenuItemPeer(MenuItem target) {
        super(target);

	Logger.log("GMenuItemPeer", target);
    }

    @Override
    public void dispose() {
	Logger.log("GMenuItemPeer.dispose");
    }

    @Override
    public void setFont(Font f) {
	Logger.log("GMenuItemPeer.setFont", f);
    }

    @Override
    public void setLabel(String label) {
	Logger.log("GMenuItemPeer.setLabel", label);
    }

    @Override
    public void setEnabled(boolean e) {
	Logger.log("GMenuItemPeer.setEnabled", e);
    }
}
