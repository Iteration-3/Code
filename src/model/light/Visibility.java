package model.light;

public class Visibility {
	
	private int value;
	
	public Visibility() {
		setValue(0);
	}
	
	public Visibility(int value) {
		this.setValue(value);
	}
	
	public void setMax(LightSource lightSource) {
		this.value = Math.max(value, lightSource.getVisibility().getValue());
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
