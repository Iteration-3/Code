package view;

import java.awt.image.BufferedImage;

class SummonerSpriteHolder extends EntitySpriteHolder {
	private BufferedImage[] images;
	public SummonerSpriteHolder(BufferedImage[] images) {
		this.images=images;
	}
	
	protected BufferedImage[] getImages(){
		return images;
	}
	
	@Override
	protected Sprite getUp(int i) {
		if(i >2){
			throw new IndexOutOfBoundsException();
			}
		return new Sprite(this.getImages()[9+i]);
	}
	@Override
	protected Sprite getDown(int i) {
		if(i >2){
			throw new IndexOutOfBoundsException();
			}
		return new Sprite(this.getImages()[0+i]);
	}
	@Override
	protected Sprite getUpLeft(int i) {
		if(i >2){
			throw new IndexOutOfBoundsException();
			}
		return new Sprite(this.getImages()[12+i]);
	}
	@Override
	protected Sprite getDownLeft(int i) {
		if(i >2){
			throw new IndexOutOfBoundsException();
			}
		return new Sprite(this.getImages()[15+i]);
	}
	@Override
	protected Sprite getUpRight(int i) {
		if(i >2){
			throw new IndexOutOfBoundsException();
			}
		return new Sprite(this.getImages()[6+i]);
	}
	@Override
	protected Sprite getDownRight(int i) {
		if(i >2){
			throw new IndexOutOfBoundsException();
			}
		return new Sprite(this.getImages()[3+i]);
	}
	


}
