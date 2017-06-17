import java.io.Serializable;

public class PubKey implements Serializable{
	
	private static final long serialVersionUID = -4914863377695455060L;
	
	private String pubKey;
	private String ipAddress;
	private String name;
		
	public PubKey(String pubKey, String ipAddress, String name) {
		this.pubKey = pubKey;
		this.ipAddress = ipAddress;
		this.name = name;
	}

	public String getPubKey() {
		return pubKey;
	}

	public String getIpAddress() {
		return ipAddress;
	}
	
	public String getName() {
		return name;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public boolean equals(Object o) {
		
		if(super.equals(o)) {
			return true;
		} else {
			try {
				PubKey key = (PubKey) o;
				if(key.getPubKey().equals(getPubKey())) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
			
		}
	}
	
	public String toString() {
		return name+" at "+ipAddress+"\nPublic Key: "+pubKey;
	}
	
}
