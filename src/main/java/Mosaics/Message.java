package Mosaics;

public class Message {
	
	private String _text;
	String text;
	public String getText() {
		return _text;
	}
	public void setText(String text) {
		_text = BidiVisual.convertVisualToLogical(text);
	}
	
	MessageSeverity severity;
	boolean acknowledgement;
	
	public Message(String text, MessageSeverity severity,boolean acknowledgement)
	{
		this._text=text;
		this.severity=severity;
		this.acknowledgement=acknowledgement;
	}
	
	public enum MessageSeverity
	{
		OK(0),
		Info(1),
		Warning(2),
		Force(3),
		Error(4),
		Abort(5);
		
		private int severity;

		MessageSeverity(int severity) {
			this.severity=severity;
		}
		
	}
}
