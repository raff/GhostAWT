package ghostawt;

import ghostawt.image.GhostGraphicsEnvironment;
import ghostawt.GhostCallback;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.BufferCapabilities;
import java.awt.BufferCapabilities.FlipContents;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.dnd.DropTarget;
import java.awt.dnd.peer.DropTargetPeer;
import java.awt.event.ComponentEvent;
import java.awt.event.PaintEvent;
import java.awt.event.WindowEvent;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.VolatileImage;
import java.awt.peer.ComponentPeer;
import java.awt.peer.ContainerPeer;

import sun.awt.CausedFocusEvent.Cause;
import sun.awt.image.SunVolatileImage;
import sun.awt.image.ToolkitImage;
import sun.java2d.pipe.Region;

public class GComponentPeer extends GObjectPeer implements ComponentPeer, DropTargetPeer {
    private String name;
    private Graphics graphics;

    public GComponentPeer(Component target) {
        super(target);

	Logger.log("GComponentPeer", target);
	name = target.getName();
    }

    @Override
    public void dispose() {
	Logger.log("GComponentPeer", name, "dispose");
    }

    @Override
    public void addDropTarget(DropTarget dt) {
	Logger.log("GComponentPeer", name, "addDropTarget", dt);
    }

    @Override
    public void removeDropTarget(DropTarget dt) {
	Logger.log("GComponentPeer", name, "removeDropTarget", dt);
    }

    @Override
    public boolean isObscured() {
        // false because canDetermineObscurity indicates we do not support this
	Logger.log("GComponentPeer", name, "isObscured");
        return false;
    }

    @Override
    public boolean canDetermineObscurity() {
	Logger.log("GComponentPeer", name, "canDetermineObscurity");
        return false;
    }

    @Override
    public void setVisible(boolean v) {
	Logger.log("GComponentPeer", name, "setVisible", v);
        // nothing to do
    }

    @Override
    public void setEnabled(boolean e) {
	Logger.log("GComponentPeer", name, "setEnabled", e);
        // nothing to do
    }

    @Override
    public void paint(Graphics g) {
	Logger.log("GComponentPeer", name, "paint");
    }

    @Override
    public void print(Graphics g) {
	Logger.log("GComponentPeer", name, "print");
        // nothing to do
    }

    @Override
    public void setBounds(int x, int y, int width, int height, int op) {
	Logger.log("GComponentPeer", name, "setBounds", x, y, width, height);
        // nothing to do
    }

    @Override
    public void handleEvent(AWTEvent e) {
	Logger.log("GComponentPeer", name, "handleEvent", e);

	if (e.getID() == WindowEvent.WINDOW_OPENED) {
		if (GhostCallback.instance != null) {
			Component c = ((ComponentEvent)e).getComponent();
	                Logger.log("GhostCallback.windowOpened", c);
			GhostCallback.instance.windowOpened(c);
		}
	}
    }

    @Override
    public void coalescePaintEvent(PaintEvent e) {
	Logger.log("GComponentPeer", name, "coaleshePaintEvent");
        // nothing to do
    }

    @Override
    public Point getLocationOnScreen() {
	Logger.log("GComponentPeer", name, "getLocationOnScreen");
        return new Point();
    }

    @Override
    public Dimension getPreferredSize() {
	Logger.log("GComponentPeer", name, "getPreferredSize");
        return getMinimumSize();
    }

    @Override
    public Dimension getMinimumSize() {
	Logger.log("GComponentPeer", name, "getSize");
        return ((Component) target).getSize();
    }

    @Override
    public ColorModel getColorModel() {
	Logger.log("GComponentPeer", name, "getColorModel");
        return null;
    }

    @Override
    public Toolkit getToolkit() {
	Logger.log("GComponentPeer", name, "getToolkit");
        return Toolkit.getDefaultToolkit();
    }

    @Override
    public Graphics getGraphics() {
	Logger.log("GComponentPeer", name, "getGraphics" );
	if (graphics == null) {
		GhostGraphicsEnvironment ge = (GhostGraphicsEnvironment) GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphics = ge.createGraphics(null);
	}
        return graphics;
    }

    protected void disposeImpl() {
	Logger.log("GComponentPeer", name, "disposeImpl");
    }

    @Override
    public FontMetrics getFontMetrics(Font font) {
	Logger.log("GComponentPeer", name, "getFontMetrics", font);
        return getToolkit().getFontMetrics(font);
    }

    @Override
    public synchronized void setForeground(Color c) {
	Logger.log("GComponentPeer", name, "setForeground", c);
    }

    @Override
    public synchronized void setBackground(Color c) {
	Logger.log("GComponentPeer", name, "setBackground", c);
    }

    @Override
    public synchronized void setFont(Font f) {
	Logger.log("GComponentPeer", name, "setFont", f);
    }

    @Override
    public void updateCursorImmediately() {
	Logger.log("GComponentPeer", name, "updateCursorImmediately");
    }

    @Override
    public boolean requestFocus(Component lightweightChild, boolean temporary, boolean focusedWindowChangeAllowed, long time, Cause cause) {
	Logger.log("GComponentPeer", name, "requestFocus", lightweightChild, temporary, focusedWindowChangeAllowed, cause);
        return false;
    }

    @Override
    public boolean isFocusable() {
	Logger.log("GComponentPeer", name, "isFocusable");
        return false;
    }

    @Override
    public Image createImage(ImageProducer producer) {
	Logger.log("GComponentPeer", name, "createImage", producer);
        return new ToolkitImage(producer);
    }

    @Override
    public Image createImage(int width, int height) {
	Logger.log("GComponentPeer", name, "createImage", width, height);
        return new SunVolatileImage((Component) target, width, height);
    }

    @Override
    public VolatileImage createVolatileImage(int width, int height) {
	Logger.log("GComponentPeer", name, "createVolatileImage", width, height);
        return new SunVolatileImage((Component) target, width, height);
    }

    @Override
    public boolean prepareImage(Image img, int w, int h, ImageObserver o) {
	Logger.log("GComponentPeer", name, "prepareImage", img, w, h, o);
        return getToolkit().prepareImage(img, w, h, o);
    }

    @Override
    public int checkImage(Image img, int w, int h, ImageObserver o) {
	Logger.log("GComponentPeer", name, "checkImage", img, w, h, o);
        return getToolkit().checkImage(img, w, h, o);
    }

    @Override
    public GraphicsConfiguration getGraphicsConfiguration() {
	Logger.log("GComponentPeer", name, "getGraphicsConfiguration");
        return ((Component) target).getGraphicsConfiguration();
    }

    @Override
    public boolean handlesWheelScrolling() {
	Logger.log("GComponentPeer", name, "handlesWheelScrolling");
        return false;
    }

    @Override
    public void createBuffers(int numBuffers, BufferCapabilities caps) throws AWTException {
	Logger.log("GComponentPeer", name, "createBuffers", numBuffers, caps);
    }

    @Override
    public Image getBackBuffer() {
	Logger.log("GComponentPeer", name, "getBackBuffer");
        throw new IllegalStateException("Buffers have not been created");
    }

    @Override
    public void flip(int x1, int y1, int x2, int y2, FlipContents flipAction) {
	Logger.log("GComponentPeer", name, "flip", x1, y1, x2, y2, flipAction);
    }

    @Override
    public void destroyBuffers() {
	Logger.log("GComponentPeer", name, "destroyBuffers");
    }

    @Override
    public void reparent(ContainerPeer newContainer) {
	Logger.log("GComponentPeer", name, "reparent", newContainer);
    }

    @Override
    public boolean isReparentSupported() {
	Logger.log("GComponentPeer", name, "isReparentSupported");
        return false;
    }

    @Override
    public void layout() {
	Logger.log("GComponentPeer", name, "layout");
    }

    @Override
    public void applyShape(Region shape) {
	Logger.log("GComponentPeer", name, "applyShape", shape);
    }

    @Override
    public void setZOrder(ComponentPeer above) {
	Logger.log("GComponentPeer", name, "setZOrder", above);
    }

    @Override
    public boolean updateGraphicsData(GraphicsConfiguration gc) {
	Logger.log("GComponentPeer", name, "updateGraphicsData");
        return false;
    }
}
