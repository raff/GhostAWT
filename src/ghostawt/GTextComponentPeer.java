package ghostawt;

import java.awt.TextComponent;
import java.awt.peer.TextComponentPeer;

public abstract class GTextComponentPeer extends GComponentPeer implements TextComponentPeer {
    private String text;

    public GTextComponentPeer(TextComponent target) {
        super(target);

	Logger.log("GTextComponentPeer", target);
    }

    @Override
    public void setEditable(boolean editable) {
	Logger.log("GTextComponentPeer.setEditable", editable);
    }

    @Override
    public String getText() {
	Logger.log("GTextComponentPeer.getText");
        return text;
    }

    @Override
    public void setText(String l) {
	Logger.log("GTextComponentPeer.setText", l);
        text = l;
    }

    @Override
    public int getSelectionStart() {
	Logger.log("GTextComponentPeer.getSelectionStart");
        return 0;
    }

    @Override
    public int getSelectionEnd() {
	Logger.log("GTextComponentPeer.getSelectionEnd");
        return 0;
    }

    @Override
    public void select(int selStart, int selEnd) {
	Logger.log("GTextComponentPeer.select", selStart, selEnd);
    }

    @Override
    public void setCaretPosition(int pos) {
	Logger.log("GTextComponentPeer.setCaretPosition", pos);
    }

    @Override
    public int getCaretPosition() {
	Logger.log("GTextComponentPeer.getCaretPosition");
        return 0;
    }
}
