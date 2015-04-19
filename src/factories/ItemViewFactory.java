package factories;

import utilities.structuredmap.StructuredMap;
import view.item.BasicItemView;
import view.item.ItemView;

public class ItemViewFactory {

	public static ItemView createItemView(StructuredMap map) {
		switch (map.getString("type")) {
		case "basicItem":
			return new BasicItemView(map);
		default:
			throw new IllegalArgumentException("Fuck you");
		}
	}
}
