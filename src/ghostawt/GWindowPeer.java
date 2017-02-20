package ghostawt;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.peer.WindowPeer;

public class GWindowPeer extends GPanelPeer implements WindowPeer {
    public GWindowPeer(Component target) {
        super(target);
	Logger.log("GWindowPeer", target);
    }

    @Override
    public void toFront() {
	Logger.log("GWindowPeer toFront");
    }

    @Override
    public void toBack() {
	Logger.log("GWindowPeer toBack");
    }

    @Override
    public void updateAlwaysOnTopState() {
	Logger.log("GWindowPeer updateAlwaysOnTopState");
    }

    @Override
    public void updateFocusableWindowState() {
	Logger.log("GWindowPeer updateFocusableWindowState");
    }

    @Override
    public void setModalBlocked(Dialog blocker, boolean blocked) {
	Logger.log("GWindow setModalBlocker", blocker, blocked);
    }

    @Override
    public void updateMinimumSize() {
	Logger.log("GWindow updateMinimumSize");
    }

    @Override
    public void updateIconImages() {
	Logger.log("GWindow updateIconImages");
    }

    @Override
    public void setOpacity(float opacity) {
	Logger.log("GWindow setOpacity", opacity);
    }

    @Override
    public void setOpaque(boolean isOpaque) {
	Logger.log("GWindow setOpaque", isOpaque);
    }

    @Override
    public void updateWindow() {
	Logger.log("GWindow updateWindow");
    }

    @Override
    public void repositionSecurityWarning() {
	Logger.log("GWindow repositionSecurityWarning");
    }
}
