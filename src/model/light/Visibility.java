package model.light;

public class Visibility {
	private int value;
	
	public Visibility() {
		setValue(0);
	}
	
	public Visibility(int value) {
		this.setValue(value);
	}
	
	/**
	 * @param lightSource LightSource to set visibility to
	 * Only changes the value when the light source is brighter
	 * then what is currently there.
	 */
	public void setValue(LightSource lightSource) {
		this.value = Math.max(value, lightSource.getVisibility().getValue());
	}
	
	public void changeValue(int change) {
		this.value += change;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
