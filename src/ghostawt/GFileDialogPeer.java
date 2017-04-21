package ghostawt;

import java.awt.FileDialog;
import java.awt.Window;
import java.awt.peer.FileDialogPeer;
import java.io.FilenameFilter;
import java.util.List;

public class GFileDialogPeer extends GWindowPeer implements FileDialogPeer {
    public GFileDialogPeer(FileDialog target) {
        super(target);

	Logger.log("GFileDialogPeer", target);
    }

    @Override
    public void blockWindows(List<Window> windows) {
	Logger.log("GFileDialogPeer.blockWindows", windows);
    }

    @Override
    public void setFile(String file) {
	Logger.log("GFileDialogPeer.setFile", file);
    }

    @Override
    public void setDirectory(String dir) {
	Logger.log("GFileDialogPeer.setDirectory", dir);
    }

    @Override
    public void setFilenameFilter(FilenameFilter filter) {
	Logger.log("GFileDialogPeer.setFilenameFilter", filter);
    }

    @Override
    public void setTitle(String title) {
	Logger.log("GFileDialogPeer.setTitle", title);
    }

    @Override
    public void setResizable(boolean resizeable) {
	Logger.log("GFileDialogPeer.setResizeable", resizeable);
    }
}
