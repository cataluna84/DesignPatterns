package pattern.command;

// Build all Receivers from this interface
public interface ElectronicDevice {

	public void on();

	public void off();

	public void volumeUp();

	public void volumenDown();

}