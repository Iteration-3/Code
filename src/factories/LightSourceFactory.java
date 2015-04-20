package factories;

import model.light.LightSource;
import model.light.MovingStaticLightSource;
import utilities.structuredmap.StructuredMap;

public class LightSourceFactory {

	public static LightSource createLightSource(StructuredMap temp) {
		switch (temp.getString("type")) {
		case "movingLight":
			return new MovingStaticLightSource(temp);
		case "lightSource":
			return new LightSource(temp);
		default:
			throw new IllegalArgumentException("Bad light sources");
		}

	}

}
