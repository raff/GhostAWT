package ghostawt;

public abstract class GObjectPeer {
    protected Object target;
    
    public Object getTarget() {
	Logger.log("GObjectPeer.getTarget");
        return target;
    }

    protected GObjectPeer(Object target) {
	Logger.log("GObjectPeer", target);
        this.target = target;
    }
}
