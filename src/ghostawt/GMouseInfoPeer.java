package ghostawt;

import java.awt.Point;
import java.awt.Window;
import java.awt.peer.MouseInfoPeer;

public class GMouseInfoPeer implements MouseInfoPeer {
    @Override
    public int fillPointWithCoords(Point point) {
	Logger.log("GMouseInfoPeer.fillPoiintWithCoords", point);
        return 0;
    }

    @Override
    public boolean isWindowUnderMouse(Window w) {
	Logger.log("GMouseInfoPeer.isWindowUnderMouse", w);
        return false;
    }
}
