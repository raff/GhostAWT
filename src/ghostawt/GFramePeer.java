package ghostawt;

import java.awt.Component;
import java.awt.MenuBar;
import java.awt.Rectangle;
import java.awt.peer.FramePeer;

public class GFramePeer extends GWindowPeer implements FramePeer {
    private int curState;

    public GFramePeer(Component target) {
        super(target);

	Logger.log("GFramePeer", target);
    }

    @Override
    public void setTitle(String title) {
	Logger.log("GFramePeer setTitle", title);
    }

    @Override
    public void setMenuBar(MenuBar mb) {
	Logger.log("GFramePeer setMenuBar", mb);
    }

    @Override
    public void setResizable(boolean resizeable) {
	Logger.log("GFramePeer setResizable", resizeable);
    }

    @Override
    public void setState(int state) {
	Logger.log("GFramePeer setState", state);
	curState = state;
    }

    @Override
    public int getState() {
	Logger.log("GFramePeer getState");
        return curState;
    }

    @Override
    public void setMaximizedBounds(Rectangle bounds) {
	Logger.log("GFramePeer setMaximimizeBounds", bounds);
    }

    @Override
    public void setBoundsPrivate(int x, int y, int width, int height) {
	Logger.log("GFramePeer setboundsPrivate", x, y, width, height);
    }

    @Override
    public Rectangle getBoundsPrivate() {
	Logger.log("GFramePeer getboundsPrivate");
        return null;
    }
}
