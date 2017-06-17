import java.io.Serializable;

public class PubKey implements Serializable{
	
	private static final long serialVersionUID = 2243398784413631870L;
	
	private String pub_key;
	private String ipAddress;
		
	public PubKey(String pubKey, String ipAddress) {
		this.pubKey = pubKey;
		this.ipAddress = ipAddress;
	}

	public String getPubKey() {
		return pubKey;
	}

	public String getIpAddress() {
		return ipAddress;
	}
	
}
