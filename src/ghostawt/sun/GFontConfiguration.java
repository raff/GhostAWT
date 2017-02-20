package ghostawt.sun;

import java.nio.charset.Charset;
import java.util.HashMap;

import sun.awt.FontConfiguration;
import sun.font.SunFontManager;

public class GFontConfiguration extends FontConfiguration {
    public GFontConfiguration(SunFontManager fm) {
        super(fm);

	Logger.log("GFontConfiguration", fm);
    }

    public GFontConfiguration(SunFontManager fm, boolean preferLocaleFonts, boolean preferPropFonts) {
        super(fm, preferLocaleFonts, preferPropFonts);
	Logger.log("GFontConfiguration", fm, preferLocaleFonts, preferPropFonts);
    }

    @Override
    protected Charset getDefaultFontCharset(String fontName) {
	Logger.log("GFontConfiguration getDefaultFontCharset", fontName);
        return Charset.forName("UTF-8");
    }

    @Override
    protected String getEncoding(String awtFontName, String characterSubsetname) {
	Logger.log("GFontConfiguration getEncoding", awtFontName, characterSubsetname);
        return "default";
    }

    @Override
    protected String getFaceNameFromComponentFontName(String arg0) {
	Logger.log("GFontConfiguration getFaceNameFromComponentFontName", arg0);
        return null;
    }

    @Override
    public String getFallbackFamilyName(String fontName, String defaultFallback) {
	Logger.log("GFontConfiguration getFallbackFamilyName", fontName, defaultFallback);
        return defaultFallback;
    }

    @Override
    protected String getFileNameFromComponentFontName(String componentFontName) {
	Logger.log("GFontConfiguration getFilaneNameFromComponentFontName", componentFontName);
        return getFileNameFromPlatformName(componentFontName);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initReorderMap() {
        reorderMap = new HashMap<String, String>();
    }
}
