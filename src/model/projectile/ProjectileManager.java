package model.projectile;

import java.util.ArrayList;

public class ProjectileManager {
	private static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public static void addProjectile(Projectile projectile) {
		ProjectileManager.projectiles.add(projectile);
	}
	
	private static void removeProjectile(Projectile projectile) {
		projectiles.remove(projectile);
	}
	
	public static void update() {
		for (Projectile projectile : projectiles) {
			projectile.advance();
			if (projectile.hasExpired()) {
				removeProjectile(projectile);
			}
		}
	}

}
