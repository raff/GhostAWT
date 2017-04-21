package ghostawt;

import java.awt.MenuItem;
import java.awt.peer.MenuPeer;

public class GMenuPeer extends GMenuItemPeer implements MenuPeer {
    protected GMenuPeer(Object target) {
        super(target);

	Logger.log("GMenuPeer", target);
    }
    
    public GMenuPeer(MenuItem target) {
        super(target);

	Logger.log("GMenuPeer", target);
    }

    @Override
    public void addSeparator() {
	Logger.log("GMenuPeer.addSeparator");
    }

    @Override
    public void addItem(MenuItem item) {
	Logger.log("GMenuPeer.addItem", item);
    }

    @Override
    public void delItem(int index) {
	Logger.log("GMenuPeer.delItem", index);
    }
}
