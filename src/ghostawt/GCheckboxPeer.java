package ghostawt;

import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.peer.CheckboxPeer;

public class GCheckboxPeer extends GComponentPeer implements CheckboxPeer {
    GCheckboxPeer(Component target) {
        super(target);

	Logger.log("GCheckboxPeer", target);
    }

    @Override
    public void setState(boolean state) {
	Logger.log("GCheckboxPeer.setState", state);
    }

    @Override
    public void setCheckboxGroup(CheckboxGroup g) {
	Logger.log("GCheckboxPeer.setCheckboxGroup", g);
    }

    @Override
    public void setLabel(String label) {
	Logger.log("GCheckboxPeer.setLabel", label);
    }
}
