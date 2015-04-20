package model.projectile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProjectileManager {
	
	private static ProjectileManager _projectileManager = new ProjectileManager();
	private Queue<Projectile> projectileQueue = new LinkedList<Projectile>();
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public static ProjectileManager getSingleton() {
		return _projectileManager;
	}
	
	public boolean isQueueEmpty() {
		return projectileQueue.isEmpty();
	}
	
	public Projectile dequeueProjectile() {
		Projectile ret = projectileQueue.poll();
		if (!projectiles.contains(ret))
			projectiles.add(ret);
		return ret;
	}
	
	public void enqueueProjectile(Projectile projectile) {
		projectileQueue.add(projectile);
	}
	
	private void removeProjectile(Projectile projectile) {
		projectiles.remove(projectile);
	}
	
	public void update(double deltaTime) {
		ArrayList<Projectile> toRemove = new ArrayList<Projectile>();
		for (Projectile projectile : projectiles) {
			projectile.advance();
			if (projectile.hasExpired() && !toRemove.contains(projectile)) {
				toRemove.add(projectile);
			}
		}
		for (Projectile rem : toRemove)  {
			removeProjectile(rem);
			rem.dispose();
		}
	}
	
	public void clear() {
		projectiles = new ArrayList<Projectile>();
		projectileQueue = new LinkedList<Projectile>();
	}
}
