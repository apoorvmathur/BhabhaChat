import java.io.Serializable;

public class PubKey implements Serializable{
	
	private static final long serialVersionUID = 2243398784413631870L;
	
	private String pub_key;
	private String ipAddress;
		
	public PubKey(String pub_key, String ipAddress) {
		this.pub_key = pub_key;
		this.ipAddress = ipAddress;
	}

	public String getPub_key() {
		return pub_key;
	}

	public String getIpAddress() {
		return ipAddress;
	}
	
}