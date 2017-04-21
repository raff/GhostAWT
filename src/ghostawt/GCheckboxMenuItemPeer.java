package ghostawt;

import java.awt.CheckboxMenuItem;
import java.awt.peer.CheckboxMenuItemPeer;

public class GCheckboxMenuItemPeer extends GMenuItemPeer implements CheckboxMenuItemPeer {
    public GCheckboxMenuItemPeer(CheckboxMenuItem target) {
        super(target);

	Logger.log("GCheckboxMenuItemPeer", target);
    }

    @Override
    public void setState(boolean t) {
	Logger.log("GCheckboxMenuItemPeer.setState", t);
    }
}
