package model.item;
/**
 * NOTHING IN HERE IS IMPLEMENTED
 */
class EquipmentManager {
	private Helmet helmet;
	private ChestPiece chestPiece;
	private Leggings leggings;
	private Boots boots;
	private Gloves gloves;
	private Shield shield;
	private Weapon weapon;
	
    public Helmet equipHelmet(Helmet helmet){
    	Helmet conflict = unequipHelmet();
    	this.helmet = helmet;
    	return conflict;
    }

    public ChestPiece equipChestPiece(ChestPiece chestpiece){
    	ChestPiece conflict = unequipChestPiece();
    	this.chestPiece = chestpiece;
    	return conflict;
    }

    public Leggings equipLeggings(Leggings leggings){
    	Leggings conflict = unequipLeggings();
    	this.leggings = leggings;
    	return conflict;
    }

    public Boots equipBoots(Boots boots){
    	Boots conflict = unequipBoots();
    	this.boots = boots;
    	return conflict;
    }

    public Gloves equipGloves(Gloves gloves){
    	Gloves conflict = unequipGloves();
    	this.gloves = gloves;
    	return conflict;
    }

    public Shield equipShield(Shield shield){
    	Shield conflict = unequipShield();
    	this.shield = shield;
    	return conflict;
    }

    public Weapon equipWeapon(Weapon weapon){
    	Weapon conflict = unequipWeapon();
    	this.weapon = weapon;
    	return conflict;
    }

    public Helmet unequipHelmet() {
    	Helmet helmet = this.helmet;
    	this.helmet = null;
    	return helmet;
    }

    public ChestPiece unequipChestPiece() {
    	ChestPiece chestPiece = this.chestPiece;
    	this.chestPiece = null;
    	return chestPiece;
    }

    public Leggings unequipLeggings() {
    	Leggings leggings = this.leggings;
    	this.leggings = null;
    	return leggings;
    }

    public Boots unequipBoots() {
    	Boots boots = this.boots;
    	this.boots = null;
    	return boots;
    }
    
    public Gloves unequipGloves() {
    	Gloves gloves = this.gloves;
    	this.gloves = null;
    	return gloves;
    }
    
    public Shield unequipShield() {
    	Shield shield = this.shield;
    	this.shield = null;
    	return shield;
    }
    
    public Weapon unequipWeapon() {
    	Weapon weapon = this.weapon;
    	this.weapon = null;
    	return weapon;
    }

}
