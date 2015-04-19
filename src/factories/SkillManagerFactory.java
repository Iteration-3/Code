package factories;

import model.skillmanager.SkillManager;
import model.skillmanager.SmasherSkillManager;
import model.skillmanager.SneakSkillManager;
import model.skillmanager.SummonerSkillManager;
import utilities.structuredmap.StructuredMap;

public class SkillManagerFactory {

	public static SkillManager createSkillManager(StructuredMap structuredMap) {
		switch (structuredMap.getString("type")) {
		case "smasher":
			return new SmasherSkillManager(structuredMap);
		case "summoner":
			return new SummonerSkillManager(structuredMap);
		case "sneak":
			return new SneakSkillManager(structuredMap);
		default:
			throw new IllegalArgumentException("Fuck you");
		}
	}
}
