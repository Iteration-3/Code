package controller.commands;

import model.entity.Entity;

public enum Unequip {

	HELMET (new Unequiper(){
		public void unequip(Entity entity) {
			entity.unequipHelmet();
		}
	}),
	LEGGINGS (new Unequiper(){
		public void unequip(Entity entity) {
			entity.unequipLeggings();
		}
	}),
	GLOVES (new Unequiper(){
		public void unequip(Entity entity) {
			entity.unequipGloves();
		}
	}),
	BOOTS (new Unequiper(){
		public void unequip(Entity entity) {
			entity.unequipBoots();
		}
	}),
	CHESTPIECE (new Unequiper(){
		public void unequip(Entity entity) {
			entity.unequipChestPiece();
		}
	}),
	PROJECTILE (new Unequiper(){
		public void unequip(Entity entity) {
			entity.unequipProjectile();
		}
	}),
	WEAPON (new Unequiper(){
		public void unequip(Entity entity) {
			entity.unequipWeapon();
		}
	}),
	SHIELD (new Unequiper(){
		public void unequip(Entity entity) {
			entity.unequipShield();
		}
	});

	
	private Unequiper command; 	
	Unequip(Unequiper command){
		this.command = command;
	}
	
	public void unequip(Entity entity){
		this.command.unequip(entity);
	}

}
