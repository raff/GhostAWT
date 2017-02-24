package ghostawt;

import java.awt.*;
import java.awt.Dialog.*;
import java.awt.datatransfer.Clipboard;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.InvalidDnDOperationException;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.event.ActionEvent;
import java.awt.font.TextAttribute;
import java.awt.im.InputMethodHighlight;
import java.awt.im.spi.InputMethodDescriptor;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.peer.*;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import java.security.AccessController;
import java.security.PrivilegedAction;

import sun.awt.SunToolkit;
import sun.awt.AWTAutoShutdown;
import sun.misc.ThreadGroupUtils;

/**
 * This is an AWT toolkit implementation which allows to run JDownloader without any graphical user interface. It does not throw a
 * {@link HeadlessException} like other headless implementations, it allows creation of all AWT components but does not actually do any
 * visuals.
 */
public class GhostToolkit extends SunToolkit implements sun.awt.KeyboardFocusManagerPeerProvider, Runnable {
    private static final sun.misc.SoftCache imgCache = new sun.misc.SoftCache();

    private GClipboard clipboard;
    private boolean    inited;

    private Button ttarget;

    public GhostToolkit() {
        /*
        AWTAutoShutdown.notifyToolkitThreadBusy();

        // Find a root TG and attach Appkit thread to it
        ThreadGroup rootTG = AccessController.doPrivileged(new PrivilegedAction<ThreadGroup>() {
                    @Override
                    public ThreadGroup run() {
                        return ThreadGroupUtils.getRootThreadGroup();
                    }
                });

        Thread toolkitThread = new Thread(rootTG, this, "AWT-GhostAWT");
        toolkitThread.setDaemon(true);
        toolkitThread.start();

        try {
            synchronized(this) {
                while(!inited) {
                    wait();
                }
            }
        } catch (InterruptedException x) {
            // swallow the exception
        }
	*/
    }

    @Override
    public boolean isDesktopSupported() {
	Logger.log("GhostToolkit isDesktopSupported");
	return false;
    }

    @Override
    public boolean isTraySupported() {
	Logger.log("GhostToolkit isTraySupported");
	return false;
    }

    @Override
    protected int getScreenWidth() {
	Logger.log("GhostToolkit getScreenWidth");
	return 1024;
    }

    @Override
    protected int getScreenHeight() {
	Logger.log("GhostToolkit getScreenHeight");
	return 768;
    }

    @Override
    public void grab(Window w) {
	Logger.log("GhostToolkit grab", w);

	/*
        if (w.getPeer() != null) {
            ((GWindowPeer)w.getPeer()).grab();
        }
	*/
    }

    @Override
    public void ungrab(Window w) {
	Logger.log("GhostToolkit ungrab", w);

	/*
        if (w.getPeer() != null) {
           ((GWindowPeer)w.getPeer()).ungrab();
        }
	*/
    }

    @Override
    protected boolean syncNativeQueue(long timeout) {
	Logger.log("GhostToolkit syncNativeQueue", timeout);

	try {
		Thread.sleep(timeout);
	} catch (InterruptedException e) {
		Logger.log("GhostToolkit syncNativeQueue interrupted");
        }

	return false;
    }

    @Override
    public RobotPeer createRobot(Robot target, GraphicsDevice screen) throws AWTException {
	return new GRobotPeer();
    }


    @Override
    public DesktopPeer createDesktopPeer(Desktop target) throws HeadlessException {
        return new GDesktopPeer();
    }

    @Override
    public SystemTrayPeer createSystemTray(SystemTray target) throws HeadlessException {
	Logger.log("GhostToolkit createSystemTray", target);
	throw new HeadlessException();
    }

    @Override
    public TrayIconPeer createTrayIcon(TrayIcon target) throws HeadlessException {
	Logger.log("GhostToolkit createTrayIcon", target);
	throw new HeadlessException();
    }

    @Override
    public ButtonPeer createButton(Button target) throws HeadlessException {
	ttarget = target;
        return new GButtonPeer(target);
    }

    @Override
    public TextFieldPeer createTextField(TextField target) {
        return new GTextFieldPeer(target);
    }

    @Override
    public LabelPeer createLabel(Label target) throws HeadlessException {
        return new GLabelPeer(target);
    }

    @Override
    public ListPeer createList(List target) throws HeadlessException {
        return new GListPeer(target);
    }

    @Override
    public CheckboxPeer createCheckbox(Checkbox target) throws HeadlessException {
        return new GCheckboxPeer(target);
    }

    @Override
    public ScrollbarPeer createScrollbar(Scrollbar target) throws HeadlessException {
        return new GScrollbarPeer(target);
    }

    @Override
    public ScrollPanePeer createScrollPane(ScrollPane target) throws HeadlessException {
        return new GScrollPanePeer(target);
    }

    @Override
    public TextAreaPeer createTextArea(TextArea target) throws HeadlessException {
        return new GTextAreaPeer(target);
    }

    @Override
    public ChoicePeer createChoice(Choice target) throws HeadlessException {
        return new GChoicePeer(target);
    }

    @Override
    public FramePeer createFrame(Frame target) throws HeadlessException {
        return new GFramePeer(target);
    }

    @Override
    public CanvasPeer createCanvas(Canvas target) {
        return new GCanvasPeer(target);
    }

    @Override
    public PanelPeer createPanel(Panel target) {
        return new GPanelPeer(target);
    }

    @Override
    public WindowPeer createWindow(Window target) throws HeadlessException {
        return new GWindowPeer(target);
    }

    @Override
    public DialogPeer createDialog(Dialog target) throws HeadlessException {
        return new GDialogPeer(target);
    }

    @Override
    public MenuBarPeer createMenuBar(MenuBar target) throws HeadlessException {
        return new GMenuBarPeer(target);
    }

    @Override
    public MenuPeer createMenu(Menu target) throws HeadlessException {
        return new GMenuPeer(target);
    }

    @Override
    public PopupMenuPeer createPopupMenu(PopupMenu target) throws HeadlessException {
        return new GPopupMenuPeer(target);
    }

    @Override
    public MenuItemPeer createMenuItem(MenuItem target) throws HeadlessException {
        return new GMenuItemPeer(target);
    }

    @Override
    public FileDialogPeer createFileDialog(FileDialog target) throws HeadlessException {
        return new GFileDialogPeer(target);
    }

    @Override
    public CheckboxMenuItemPeer createCheckboxMenuItem(CheckboxMenuItem target) throws HeadlessException {
        return new GCheckboxMenuItemPeer(target);
    }

    @Override
    public FontPeer getFontPeer(String name, int style) {
	Logger.log("GhostToolkit getFontPeer", name, style);
        return null;
    }

    @Override
    public int getScreenResolution() throws HeadlessException {
	Logger.log("GhostToolkit getScreenResolution");
        return 96;
    }

    @Override
    public ColorModel getColorModel() throws HeadlessException {
	Logger.log("GhostToolkit getColorModel");
        return ColorModel.getRGBdefault();
    }

    @Override
    public String[] getFontList() {
	Logger.log("GhostToolkit getFontList");
        String[] hardwiredFontList = { Font.DIALOG, Font.SANS_SERIF, Font.SERIF, Font.MONOSPACED, Font.DIALOG_INPUT };
        return hardwiredFontList;
    }

    @Override
    public FontMetrics getFontMetrics(Font font) {
	Logger.log("GhostToolkit getFontMetrics", font);
        return sun.font.FontDesignMetrics.getMetrics(font);
    }

    @Override
    public void sync() {
	Logger.log("GhostToolkit sync");
        // Nothing to do here.
    }

    @Override
    public Image getImage(String filename) {
	Logger.log("GhostToolkit getImage", filename);
        return getImageFromHash(this, filename);
    }

    @Override
    public Image getImage(URL url) {
	Logger.log("GhostToolkit getImage", url);
        return getImageFromHash(this, url);
    }

    private static Image getImageFromHash(Toolkit tk, String filename) {
        synchronized (imgCache) {
            Image img = (Image) imgCache.get(filename);
            if (img == null) {
                try {
                    img = tk.createImage(new sun.awt.image.FileImageSource(filename));
                    imgCache.put(filename, img);
                } catch (Exception e) {
		    Logger.log("getImageFromHash", e);
                }
            }
            return img;
        }
    }

    private static Image getImageFromHash(Toolkit tk, URL url) {
        synchronized (imgCache) {
            Image img = (Image) imgCache.get(url);
            if (img == null) {
                try {
                    img = tk.createImage(new sun.awt.image.URLImageSource(url));
                    imgCache.put(url, img);
                } catch (Exception e) {
		    Logger.log("getImageFromHash", e);
                }
            }
            return img;
        }
    }

    @Override
    public Image createImage(String filename) {
        return createImage(new sun.awt.image.FileImageSource(filename));
    }

    @Override
    public Image createImage(URL url) {
        return createImage(new sun.awt.image.URLImageSource(url));
    }

    @Override
    public boolean prepareImage(Image img, int w, int h, ImageObserver o) {
        if (w == 0 || h == 0) { return true; }

        if (!(img instanceof sun.awt.image.ToolkitImage)) { return true; }

        sun.awt.image.ToolkitImage tkimg = (sun.awt.image.ToolkitImage) img;
        if (tkimg.hasError()) {
            if (o != null) {
                o.imageUpdate(img, ImageObserver.ERROR | ImageObserver.ABORT, -1, -1, -1, -1);
            }
            return false;
        }
        return tkimg.getImageRep().prepare(o);
    }

    @Override
    public int checkImage(Image img, int w, int h, ImageObserver o) {
        if (!(img instanceof sun.awt.image.ToolkitImage)) { return ImageObserver.ALLBITS; }

        sun.awt.image.ToolkitImage tkimg = (sun.awt.image.ToolkitImage) img;
        int repbits;
        if (w == 0 || h == 0) {
            repbits = ImageObserver.ALLBITS;
        } else {
            repbits = tkimg.getImageRep().check(o);
        }
        return tkimg.check(o) | repbits;
    }

    @Override
    public Image createImage(ImageProducer producer) {
        return new sun.awt.image.ToolkitImage(producer);
    }

    @Override
    public Image createImage(byte[] data, int offset, int length) {
        return createImage(new sun.awt.image.ByteArrayImageSource(data, offset, length));
    }

    @Override
    public PrintJob getPrintJob(Frame frame, String jobtitle, Properties props) {
        return null;
    }

    @Override
    public void beep() {
        System.out.write(0x07);
    }

    @Override
    public Clipboard getSystemClipboard() throws HeadlessException {
        synchronized (this) {
            if (clipboard == null) {
                clipboard = new GClipboard();
            }
        }
        return clipboard;
    }

    @Override
    protected EventQueue getSystemEventQueueImpl() {
        return getSystemEventQueueImplPP();
    }

    static EventQueue getSystemEventQueueImplPP() {
        return getSystemEventQueueImplPP(sun.awt.AppContext.getAppContext());
    }

    public static EventQueue getSystemEventQueueImplPP(sun.awt.AppContext appContext) {
        EventQueue theEventQueue = (EventQueue) appContext.get(sun.awt.AppContext.EVENT_QUEUE_KEY);
        return theEventQueue;
    }

    @Override
    public DragSourceContextPeer createDragSourceContextPeer(DragGestureEvent dge) throws InvalidDnDOperationException {
        // throwing this exception is ok, it just indicates that
        // drag and drop is not supported
        throw new InvalidDnDOperationException("Headless environment");
    }

    @Override
    public boolean isModalityTypeSupported(ModalityType modalityType) {
	Logger.log("GhostToolkit isModalityTypeSupported", modalityType);
        return true;
    }

    @Override
    public boolean isModalExclusionTypeSupported(ModalExclusionType modalExclusionType) {
	Logger.log("GhostToolkit isModalExclusionTypeSupported", modalExclusionType);
        return false;
    }

    public Map<TextAttribute, ?> mapInputMethodHighlight(InputMethodHighlight highlight) throws HeadlessException {
        return GInputMethod.mapInputMethodHighlight(highlight);
    }

    @Override
    public InputMethodDescriptor getInputMethodAdapterDescriptor()
        throws AWTException
    {
        return (InputMethodDescriptor)null;
    }

    @Override
    public java.awt.peer.KeyboardFocusManagerPeer getKeyboardFocusManagerPeer() {
        return new GKeyboardFocusManagerPeer();
    }

    @Override
    protected MouseInfoPeer getMouseInfoPeer() {
        return new GMouseInfoPeer();
    }

    //
    // this thread executes the headless script and generates the appropriate events
    //
    public void run() {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            @Override
            public Void run() {
                Thread.currentThread().setContextClassLoader(null);
                return null;
            }
        });
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY + 1);

        synchronized(this) {
            inited = true;
            notifyAll();
        }

	try {
		while (true) {
			Thread.sleep(5000);
			Logger.log("GhostAWT Thread...");
/*
			if (ttarget != null) {
				long when = System.currentTimeMillis();
				int modifiers = 0;

                		GhostToolkit.postEvent(GhostToolkit.targetToAppContext(ttarget),
						new ActionEvent(ttarget, ActionEvent.ACTION_PERFORMED,
                                          	((Button)ttarget).getActionCommand(),
                                          	when, modifiers));

			}
*/
		}
        } catch (InterruptedException x) {
		Logger.log("GhostAWT Thread interrupted!");
	}
    }
}
