package ghostawt.image;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.util.Locale;

public class GhostGraphicsEnvironment extends GraphicsEnvironment {
    private GraphicsDevice screenDevice;

    @Override
    public GraphicsDevice[] getScreenDevices() throws HeadlessException {
	Logger.log("GhostGrapicsEnvironment getScreenDevices");
        return new GraphicsDevice[] {getDefaultScreenDevice()};
    }

    @Override
    public GraphicsDevice getDefaultScreenDevice() throws HeadlessException {
	Logger.log("GhostGrapicsEnvironment getDefaultScreenDevice");
        if (screenDevice == null) {
            screenDevice = new GGraphicsDevice();
        }
        return screenDevice;
    }

    @Override
    public Graphics2D createGraphics(BufferedImage img) {
	Logger.log("GhostGrapicsEnvironment createGraphics", img);
        return new GGraphics2D(getDefaultScreenDevice().getConfigurations()[0]);
    }

    @Override
    public Font[] getAllFonts() {
	Logger.log("GhostGrapicsEnvironment getAllFonts");
        GFontManager fm = GFontManager.getInstance();
        Font[] installedFonts = fm.getAllInstalledFonts();
        return installedFonts;
    }

    @Override
    public String[] getAvailableFontFamilyNames() {
	Logger.log("GhostGrapicsEnvironment getAvailableFontFamilyName");
        return getAvailableFontFamilyNames(Locale.getDefault());
    }

    @Override
    public String[] getAvailableFontFamilyNames(Locale requestedLocale) {
	Logger.log("GhostGrapicsEnvironment getAvailableFontFamilyNames", requestedLocale);
        return GFontManager.getInstance().getInstalledFontFamilyNames(requestedLocale);
    }

    public double getXResolution() {
	Logger.log("GhostGrapicsEnvironment getXResolution");
        return 96;
    }

    public double getYResolution() {
	Logger.log("GhostGrapicsEnvironment getYResolution");
        return 96;
    }

}
