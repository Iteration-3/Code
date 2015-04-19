package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class EntitySpriteFactory {
	private static SummonerSpriteHolder Summoner = null;
	private static File summonerFile = new File("src/resources/sprites/summoner.png");
	private static int summonerCols = 18;
	
	public static SummonerSpriteHolder getSummonerSpriteHolder(){
		if(Summoner==null){
		Summoner = new SummonerSpriteHolder(
				EntitySpriteFactory.splitImage(EntitySpriteFactory.getImage(summonerFile),
						summonerCols));
		}
		return Summoner;
	}


	public static void printTestImages(BufferedImage[] imgs){
		//TODO delete this method.
		try{
		   for (int i = 0; i < imgs.length; i++) {  
	            ImageIO.write(imgs[i], "png", new File("img" + i + ".png"));  
	        }  
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public static BufferedImage getImage(File file){
		FileInputStream fis= null;
		BufferedImage image = null;

		try{
			fis = new FileInputStream(file);
			image = ImageIO.read(fis);
		}catch(Exception e){
			System.err.println("File not found! Summoner.png" + e.toString());
		}
		return image;
	}
	public static BufferedImage[] splitImage(BufferedImage image,int cols){
		int chunkHeight;
		int chunkWidth;
		chunkHeight = image.getHeight();
		chunkWidth = image.getWidth()/cols;
		BufferedImage imgs[] = new BufferedImage[cols];
		for(int i = 0; i!=cols;++i){
			imgs[i] = image.getSubimage(i*chunkWidth, 0, chunkWidth, chunkHeight);
		}
		return imgs;
	}



}
