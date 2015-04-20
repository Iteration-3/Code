package model.entity;

public interface EntiyVisitorable {
	
	public void accept(NPC entity);
	
	public void accept(Avatar avatar);
}
