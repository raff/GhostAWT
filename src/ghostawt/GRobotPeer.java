package ghostawt;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.peer.*;

import sun.awt.AWTAccessor;
import sun.awt.SunToolkit;
import sun.awt.X11GraphicsConfig;

class GRobotPeer implements RobotPeer {

    GRobotPeer() {
	Logger.log("GRobotPeer");
    }

    public void dispose() {
	Logger.log("GRobotPeer dispose");
        // does nothing
    }

    public void mouseMove(int x, int y) {
	Logger.log("GRobotPeer mouseMove", x, y);
    }

    public void mousePress(int buttons) {
	Logger.log("GRobotPeer mousePress", buttons);
    }

    public void mouseRelease(int buttons) {
	Logger.log("GRobotPeer mouseRelease", buttons);
    }

    public void mouseWheel(int wheelAmt) {
	Logger.log("GRobotPeer mouseWheel", wheelAmt);
    }

    public void keyPress(int keycode) {
	Logger.log("GRobotPeer keyPress", keycode);
    }

    public void keyRelease(int keycode) {
	Logger.log("GRobotPeer keyRelease", keycode);
    }

    public int getRGBPixel(int x, int y) {
	Logger.log("GRobotPeer getRGBPixel", x, y);
        int pixelArray[] = new int[1];
        return pixelArray[0];
    }

    public int [] getRGBPixels(Rectangle bounds) {
	Logger.log("GRobotPeer getRGBPixels", bounds);
        int pixelArray[] = new int[bounds.width*bounds.height];
        return pixelArray;
    }
}
