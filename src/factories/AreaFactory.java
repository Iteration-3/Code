package factories;

import model.area.Area;
import model.area.ConicalArea;
import model.area.LinearArea;
import model.area.RadialArea;
import utilities.structuredmap.StructuredMap;

public class AreaFactory {

	public static Area createArea(StructuredMap structuredMap) {
		switch (structuredMap.getString("type")) {
		case "conical":
			return new ConicalArea(structuredMap);
		case "radial":
			return new RadialArea(structuredMap);
		case "linear":
			return new LinearArea(structuredMap);
		default:
			throw new IllegalArgumentException("Fuck you");
		}
	}

}
