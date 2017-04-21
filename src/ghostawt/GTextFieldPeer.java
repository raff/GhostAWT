package ghostawt;

import java.awt.Dimension;
import java.awt.TextComponent;
import java.awt.im.InputMethodRequests;
import java.awt.peer.TextFieldPeer;

public class GTextFieldPeer extends GTextComponentPeer implements TextFieldPeer {
    public GTextFieldPeer(TextComponent target) {
        super(target);

	Logger.log("GTextFieldPeer", target);
    }

    @Override
    public InputMethodRequests getInputMethodRequests() {
	Logger.log("GTextFieldPeer.getInputMethodRequests");
        return null;
    }

    @Override
    public void setEchoChar(char echoChar) {
	Logger.log("GTextFieldPeer.setEchoChar", echoChar);
    }

    @Override
    public Dimension getPreferredSize(int columns) {
	Logger.log("GTextFieldPeer.getPreferredSize", columns);
        return null;
    }

    @Override
    public Dimension getMinimumSize(int columns) {
	Logger.log("GTextFieldPeer.getMinimumSize", columns);
        return null;
    }
}
