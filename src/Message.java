import java.io.Serializable;

public class Message implements Serializable{
	
	private static final long serialVersionUID = 7076772970992921527L;
	
	private String from;
	private String fromAddress;
	private String toAddress;
	private String message;
	
	public Message(String from, String fromAddress, String toAddress, String message) {
		this.from = from;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.message = message;
	}

	public String getFrom() {
		return from;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public String getMessage() {
		return message;
	}

	public String getToAddress() {
		return toAddress;
	}
	
	public String toString() {
		return "From "+from+" at "+fromAddress+" to "+toAddress+"\nMessage: "+message;
	}

}
