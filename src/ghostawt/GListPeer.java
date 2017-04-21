package ghostawt;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.peer.ListPeer;

public class GListPeer extends GComponentPeer implements ListPeer {
    public GListPeer(Component target) {
        super(target);

	Logger.log("GListPeer", target);
    }

    @Override
    public int[] getSelectedIndexes() {
	Logger.log("GListPeer.getSelectedIndexes");
        return null;
    }

    @Override
    public void add(String item, int index) {
	Logger.log("GListPeer.add", item, index);
    }

    @Override
    public void delItems(int start, int end) {
	Logger.log("GListPeer.delItems", start, end);
    }

    @Override
    public void removeAll() {
	Logger.log("GListPeer.removeAll");
    }

    @Override
    public void select(int index) {
	Logger.log("GListPeer.select", index);
    }

    @Override
    public void deselect(int index) {
	Logger.log("GListPeer.deselect", index);
    }

    @Override
    public void makeVisible(int index) {
	Logger.log("GListPeer.makeVisible", index);
    }

    @Override
    public void setMultipleMode(boolean m) {
	Logger.log("GListPeer.setMultipleMode", m);
    }

    @Override
    public Dimension getPreferredSize(int rows) {
	Logger.log("GListPeer.getPreferredSize", rows);
        return null;
    }

    @Override
    public Dimension getMinimumSize(int v) {
	Logger.log("GListPeer.getMinimumSize", v);
        return null;
    }
}
