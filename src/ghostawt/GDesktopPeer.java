package ghostawt;

import java.awt.Desktop.Action;
import java.awt.peer.DesktopPeer;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class GDesktopPeer implements DesktopPeer {
    @Override
    public boolean isSupported(Action action) {
	Logger.log("GDesktopPeer.isSupported", action);
        return false;
    }

    @Override
    public void open(File file) throws IOException {
	Logger.log("GDesktopPeer.open", file);
    }

    @Override
    public void edit(File file) throws IOException {
	Logger.log("GDesktopPeer.edit", file);
    }

    @Override
    public void print(File file) throws IOException {
	Logger.log("GDesktopPeer.print", file);
    }

    @Override
    public void mail(URI mailtoURL) throws IOException {
	Logger.log("GDesktopPeer.mail", mailtoURL);
    }

    @Override
    public void browse(URI url) throws IOException {
	Logger.log("GDesktopPeer.browse", url);
    }
}
