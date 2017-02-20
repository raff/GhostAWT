package ghostawt.image;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.image.ColorModel;

public class GGraphicsDevice extends GraphicsDevice {
    private String idString;
    private GGraphicsConfiguration defaultConfiguration;
    private ColorModel colorModel;
    
    
    public GGraphicsDevice() {
	Logger.log("GGraphicsDevice");
        idString = "Display0";
    }
    
    @Override
    public int getType() {
	Logger.log("GGraphicsDevice getType");
        return TYPE_RASTER_SCREEN;
    }

    @Override
    public String getIDstring() {
	Logger.log("GGraphicsDevice getIDString");
        return idString;
    }

    @Override
    public GraphicsConfiguration[] getConfigurations() {
	Logger.log("GGraphicsDevice getConfigurations");
        return new GraphicsConfiguration[]{getDefaultConfiguration()};
    }

    @Override
    public GraphicsConfiguration getDefaultConfiguration() {
	Logger.log("GGraphicsDevice getDefaultConfiguration");
        if(defaultConfiguration == null) {
            defaultConfiguration = new GGraphicsConfiguration(this);
        }
        return defaultConfiguration;
    }

    public ColorModel getColorModel() {
	Logger.log("GGraphicsDevice getColorModel");
        if (colorModel == null)  {
            colorModel = ColorModel.getRGBdefault();
        }
        return colorModel;
    }

}
