package view;

import java.awt.image.BufferedImage;

class ConcreteEntitySpriteHolder extends AbstractEntitySpriteHolder {
	public ConcreteEntitySpriteHolder(BufferedImage[] images) {
		this.setUp(images);
		this.setDown(images);
		this.setDownLeft(images);
		this.setDownRight(images);
		this.setUpLeft(images);
		this.setUpRight(images);
	}
	private BufferedImage[] getImages(BufferedImage[] src, int index){
		BufferedImage temp[]=new BufferedImage[3];
		System.arraycopy(src, index,temp, 0, 3);
		return temp;
	}
	
	private Sprite up;
	@Override
	protected void setUp(BufferedImage[] images) {
		//9-11 is up poses.
		up = new Sprite(getImages(images,9));
		
	}
	private Sprite down;
	@Override
	protected void setDown(BufferedImage[] images) {
		//0-2 is down
		down = new Sprite(getImages(images,0));
		
	}
	private Sprite upLeft;
	@Override
	protected void setUpLeft(BufferedImage[] images) {
		// TODO Auto-generated method stub
		//12-14 is down
		upLeft = new Sprite(getImages(images,12));
		
	}
	private Sprite downLeft;
	@Override
	protected void setDownLeft(BufferedImage[] images) {
		// TODO Auto-generated method stub
		//15-17 is downLeft
		downLeft = new Sprite(getImages(images,15));
		
	}
	private Sprite upRight;
	@Override
	protected void setUpRight(BufferedImage[] images) {
		// TODO Auto-generated method stub
		//6-8 is upRight
		upRight = new Sprite(getImages(images,6));
		
	}
	private Sprite downRight;
	@Override
	protected void setDownRight(BufferedImage[] images) {
		// TODO Auto-generated method stub
		//3-5 is downRight
		downRight = new Sprite(getImages(images,3));
		
	}

	@Override
	protected Sprite getUp() {
		return up;
	}

	@Override
	protected Sprite getDown() {
		return down;
	}

	@Override
	protected Sprite getUpLeft() {
		return upLeft;
	}

	@Override
	protected Sprite getDownLeft() {
		return downLeft;
	}

	@Override
	protected Sprite getUpRight() {
		return upRight;
	}

	@Override
	protected Sprite getDownRight() {
		return downRight;
	}

	
	
	


}
