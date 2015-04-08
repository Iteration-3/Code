package model.slots;

import utilities.Point;
import model.item.TakeableItem;

public class Inventory {
	private static final int ROW = 5;
	private static final int COL = 5;
	private InventorySlot[][] slots;
	
	public Inventory(){
		this.setInventory();
	}

	private void setInventory(){
		this.slots = new InventorySlot[ROW][COL];
		for (int i = 0 ; i < ROW ; i++){
			for (int j = 0; j < COL; j++){
				this.setSlot(i,j);
			}
		}
	}
	
	private void setSlot(int x,int y){
		slots[x][y] = new InventorySlot();
	}

	private boolean findAndEquip(TakeableItem item){
		for (int i = 0 ; i < ROW ; i++){
			for (int j = 0; j < COL; j++){
				boolean slotDoesNotHave = ! this.slotHas(i, j);
				if (slotDoesNotHave){
					this.insertItem(i,j,item);
					return true;
				}
			}
		}
		return false;
	}

	// this is private because it forces a insert,  can cause RTE
	private void insertItem(int i,int j,TakeableItem item){
		this.slots[i][j].insert(item);
	}
	
	//takeItem will take the item from the contianer,  this will remove the item from the SLots
	private TakeableItem takeItem(TakeableItem item) throws Exception{
		for (int i = 0 ; i < ROW ; i++){
			for (int j = 0; j < COL; j++){
				if (this.slotHasItem(item, i, j)){
					return this.remove(i,j);
				}
			}
		}
		throw new Exception("You dont have that Item in the Inventory");
	}
	
	/********************INSERTS****************************/
	public boolean insert(TakeableItem item){
		return this.findAndEquip(item);
	}
	
	public boolean insert( int x, int y, TakeableItem item){
		if (this.slotHas(x,y)){
			return false;
		}
		else{
			this.insertItem(x,y,item);
			return true;
		}
	}
	
	public boolean insert(Point point,TakeableItem item){
		return this.insert(point.getX(),point.getY(),item);
	}
	
	/********************HAS*********************************/
	public boolean slotHas(int x, int y){
		return this.slotHas(new Point(x,y));
	}

	public boolean slotHas(Point point){
		return this.slots[point.getX()][point.getY()].has();
	}
	
	public boolean slotHasItem(TakeableItem item, Point point){
		return this.slotHasItem(item, point.getX(), point.getY());
	}

	public boolean slotHasItem(TakeableItem item,int x,int y){
		return this.slots[x][y].hasItem(item);
	}

	/*************REMOVE********************************************/
	public TakeableItem remove(TakeableItem item) throws Exception{
		return this.takeItem(item);
	}
	
	public TakeableItem remove(int x, int y){
		return this.slots[x][y].remove();
	}
	
	public TakeableItem remove(Point point){
		return this.remove(point.getX(),point.getY());
	}
}
