package model.projectile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import model.projectile.linear.FireProjectile;

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
		projectiles.add(ret);
		return ret;
	}
	
	public void enqueueProjectile(Projectile projectile) {
		projectileQueue.add(projectile);
		System.out.println(projectile instanceof FireProjectile);
	}
	
	private void removeProjectile(Projectile projectile) {
		projectiles.remove(projectile);
	}
	
	public void update(double deltaTime) {
		ArrayList<Projectile> toRemove = new ArrayList<Projectile>();
		for (Projectile projectile : projectiles) {
			projectile.advance();
			if (projectile.hasExpired()) {
				toRemove.add(projectile);
			}
		}
		for (Projectile rem : toRemove) 
			removeProjectile(rem);
	}
	
	public void clear() {
		projectiles = new ArrayList<Projectile>();
		projectileQueue = new LinkedList<Projectile>();
	}
}
