package ghostawt;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.peer.MenuBarPeer;

public class GMenuBarPeer extends GMenuPeer implements MenuBarPeer {
    public GMenuBarPeer(MenuBar target) {
        super(target);

	Logger.log("GMenuBarPeer", target);
    }

    @Override
    public void addMenu(Menu m) {
	Logger.log("GMenuBarPeer.addMenu", m);
    }

    @Override
    public void delMenu(int index) {
	Logger.log("GMenuBarPeer.delMenu", index);
    }

    @Override
    public void addHelpMenu(Menu m) {
	Logger.log("GMenuBarPeer.addHelpMenu", m);
    }
}
