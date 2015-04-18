package model.slots;

import model.entity.NPC;
import model.entity.Smasher;
import model.entity.Sneak;
import model.entity.Summoner;
import model.item.Boots;
import model.item.ChestPiece;
import model.item.Gloves;
import model.item.Helmet;
import model.item.Leggings;
import model.item.Projectile;
import model.item.Shield;
import model.item.SmasherWeapon;
import model.item.TwoHandedWeapon;
import model.item.Weapon;
import model.statistics.Statistics;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.EquipmentView;
import view.SlotView;

public class EquipmentManager implements Saveable {
    private EquipmentSlot<Helmet> helmetSlot;
    private EquipmentSlot<ChestPiece> chestPieceSlot;
    private EquipmentSlot<Leggings> leggingsSlot;
    private WeaponSlot<?> weaponSlot;
    private EquipmentSlot<Shield> shieldSlot;
    private EquipmentSlot<Boots> bootsSlot;
    private EquipmentSlot<Gloves> glovesSlot;
    private EquipmentSlot<Projectile> projectileSlot;
    private DoubleEquipmentSlot<TwoHandedWeapon, SmasherWeapon, Shield> THWSlot;

    private EquipmentView equipmentView;

    public EquipmentManager(Smasher avatar) {
        this.equipmentView = new EquipmentView();
        SmasherWeaponSlot weaponSlot = new SmasherWeaponSlot();
        this.weaponSlot = weaponSlot;
        this.setSlots();
        this.THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon, SmasherWeapon, Shield>(weaponSlot, this.shieldSlot);
        this.registerSlots();
    }
    
    public EquipmentManager(StructuredMap map) {
        
    }

    @Override
    public StructuredMap getStructuredMap() {
        StructuredMap map = new StructuredMap();
        if(helmetSlot.get() != null ) {
            map.put("helmetSlot", helmetSlot.get().getStructuredMap());
        }
        
        if(chestPieceSlot.get() != null) {
            map.put("chestPieceSlot", chestPieceSlot.get().getStructuredMap());
        }
        
        if(leggingsSlot.get() != null) {
            map.put("leggingsSlot", leggingsSlot.get().getStructuredMap());
        }
        
        if(shieldSlot.get() != null ) {
            map.put("shieldSlot", shieldSlot.get().getStructuredMap());
        }
        
        if(bootsSlot.get() != null) {
            map.put("bootsSlot", bootsSlot.get().getStructuredMap());
        }
        
        if(glovesSlot.get() != null) {
            map.put("glovesSlot", glovesSlot.get().getStructuredMap());
        }
        
        if(projectileSlot.get() != null) {
            map.put("projectileSlot", projectileSlot.get().getStructuredMap());
        }
        
        //TODO Weapon and TWO handed weapon
        return map;
    }

    public EquipmentManager(Summoner avatar) {
        this.equipmentView = new EquipmentView();
        this.weaponSlot = new SummonerWeaponSlot();
        this.setSlots();
        this.registerSlots();
    }

    public EquipmentManager(Sneak avatar) {
        this.equipmentView = new EquipmentView();
        this.weaponSlot = new SneakWeaponSlot();
        this.setSlots();
        this.registerSlots();
    }

    public EquipmentManager(NPC npc) {
        this.weaponSlot = new NPCWeaponSlot();
        this.setSlots();
    }

    private void setSlots() { // TODO (Weapon)
        this.helmetSlot = new EquipmentSlot<Helmet>();
        this.chestPieceSlot = new EquipmentSlot<ChestPiece>();
        this.leggingsSlot = new EquipmentSlot<Leggings>();
        this.shieldSlot = new EquipmentSlot<Shield>();
        this.bootsSlot = new EquipmentSlot<Boots>();
        this.glovesSlot = new EquipmentSlot<Gloves>();
        this.projectileSlot = new EquipmentSlot<Projectile>();
    }

    protected boolean hasTHW() {
        return this.THWSlot != null;
    }

    public void merge(Statistics statistics) {
        if (hasTHW()) {
            this.THWSlot.merge(statistics);
        }
        helmetSlot.merge(statistics);
        chestPieceSlot.merge(statistics);
        leggingsSlot.merge(statistics);
        weaponSlot.merge(statistics);
        shieldSlot.merge(statistics);
        bootsSlot.merge(statistics);
        glovesSlot.merge(statistics);
        projectileSlot.merge(statistics);
    }

    public void registerSlots() {
        this.equipmentView.registerBoots(this.setSlotView(this.bootsSlot));
        this.equipmentView.registerChestPiece(this.setSlotView(this.chestPieceSlot));
        this.equipmentView.registerLeggings(this.setSlotView(this.leggingsSlot));
        this.equipmentView.registerHelmet(this.setSlotView(this.helmetSlot));
        this.equipmentView.registerGloves(this.setSlotView(this.glovesSlot));
        this.equipmentView.registerShield(this.setSlotView(this.shieldSlot));
        this.equipmentView.registerWeapon(this.setSlotView(this.weaponSlot));
        this.equipmentView.registerProjectile(this.setSlotView(this.projectileSlot));
    }

    private SlotView setSlotView(EquipmentSlot<?> slot) {
        SlotView slotView = new SlotView();
        slot.setView(slotView);
        return slotView;
    }

    /************************* UNEQUIP ************************************/
    public Projectile unequipProjectile() {
        return this.projectileSlot.unequip();
    }

    public Gloves unequipGloves() {
        return this.glovesSlot.unequip();
    }

    public Boots unequipBoots() {
        return this.bootsSlot.unequip();
    }

    public Shield unequipShield() {
        return this.shieldSlot.unequip();
    }

    public Weapon unequipWeapon() {
        return this.weaponSlot.unequip();
    }

    public Leggings unequipLeggings() {
        return this.leggingsSlot.unequip();
    }

    public ChestPiece unequipChestPiece() {
        return this.chestPieceSlot.unequip();
    }

    public Helmet unequipHelmet() {
        return this.helmetSlot.unequip();
    }

    public TwoHandedWeapon unequipTHW() {
        return this.THWSlot.unequip();
    }

    /************************* EQUIP **************************/

    public boolean equip(Projectile item) {
        return this.projectileSlot.equip(item);
    }

    public boolean equip(Gloves item) {
        return this.glovesSlot.equip(item);
    }

    public boolean equip(Boots item) {
        return this.bootsSlot.equip(item);
    }

    public boolean equip(TwoHandedWeapon item) {
        if (this.hasTHW()) {
            return this.THWSlot.equip(item);
        } else {
            return false;
        }
    }

    public boolean equip(Shield item) {
        if (this.hasTHW()) {
            return this.THWSlot.equipSecondSlot(item);
        } else {
            return this.shieldSlot.equip(item);
        }
    }

    public boolean equip(Weapon item) {
        return this.weaponSlot.equip(item);
    }

    public boolean equip(Leggings item) {
        return this.leggingsSlot.equip(item);
    }

    public boolean equip(ChestPiece item) {
        return this.chestPieceSlot.equip(item);
    }

    public boolean equip(Helmet item) {
        return this.helmetSlot.equip(item);
    }

    public boolean canEquip(Weapon weapon) {
        return this.weaponSlot.canEquip(weapon);
    }

    public EquipmentView getView() {
        return this.equipmentView;
    }

    public boolean THWSlotHasItem() {
        if (hasTHW()) {
            return this.THWSlot.has();
        }
        return false;
    }

}
