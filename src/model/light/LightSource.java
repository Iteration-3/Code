package model.light;

import model.area.Area;

public class LightSource {
	private Area area;
	private Visibility visibility;
	
	public LightSource(Area area, Visibility visibility) {
		setArea(area);
		setVisibility(visibility);
	}
	
	public void changeVisibility(int change) {
		getVisibility().changeValue(change);
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

}
