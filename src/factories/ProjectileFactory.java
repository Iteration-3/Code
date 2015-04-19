package factories;

import model.projectile.Projectile;
import model.projectile.conical.ConicalProjectile;
import model.projectile.conical.IntimidateConeProjectile;
import model.projectile.conical.LightConeProjectile;
import model.projectile.linear.CripplingProjectile;
import model.projectile.linear.FireProjectile;
import model.projectile.linear.ShadowBlastProjectile;
import model.projectile.linear.SilenceProjectile;
import model.projectile.linear.ThrowingKnife;
import utilities.structuredmap.StructuredMap;

public class ProjectileFactory {

	public static Projectile createProjectile(StructuredMap structuredMap) {
		switch (structuredMap.getString("type")) {
		case "projectile":
			return new Projectile(structuredMap);
		case "conical":
			return new ConicalProjectile(structuredMap);
		case "intimidateConeProjectile" :
			return new IntimidateConeProjectile(structuredMap);
		case "lightConeProjectile" :
			return new LightConeProjectile(structuredMap);
		case "cripplingProjectile" :
			return new CripplingProjectile(structuredMap);
		case "fireProjectile" : 
			return new FireProjectile(structuredMap);
		case "shadowBlastProjectile" :
			return new ShadowBlastProjectile(structuredMap);
		case "silenceProjectile" :
			return new SilenceProjectile(structuredMap);
		case "throwingKnife" :
			return new ThrowingKnife(structuredMap);
		default:
			throw new IllegalArgumentException("Fuck you");
		}
	}

}
