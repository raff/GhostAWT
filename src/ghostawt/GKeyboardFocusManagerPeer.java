package ghostawt;

import java.awt.Component;
import java.awt.Window;

import sun.awt.KeyboardFocusManagerPeerImpl;

public class GKeyboardFocusManagerPeer extends KeyboardFocusManagerPeerImpl {
    @Override
    public void setCurrentFocusedWindow(Window win) {
        // Not used on Windows
	Logger.log("GKeyboardFocusManagerPeer.setCurrentFocusedWindow", win);
        throw new RuntimeException("not implemented");
    }

    @Override
    public Window getCurrentFocusedWindow() {
	Logger.log("GKeyboardFocusManagerPeer.getCurrentFocusedWindow");
        return null;
    }

    @Override
    public void setCurrentFocusOwner(Component comp) {
	Logger.log("GKeyboardFocusManagerPeer.setCurrentFocusOwner", comp);
    }

    @Override
    public Component getCurrentFocusOwner() {
	Logger.log("GKeyboardFocusManagerPeer.getCurrentFocusOwner");
        return null;
    }
}
