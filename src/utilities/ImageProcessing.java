package utilities;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageProcessing {
	public static BufferedImage getImage(String filename){
		try {
			return ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("The image does not exist");
			e.printStackTrace();
			return null;
		}
	}
	
	public static BufferedImage scaleImage(int width, int height, String filename) {
	    BufferedImage returnImage = null;
	    try {
	        ImageIcon image = new ImageIcon(filename);//path to image
	        returnImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = (Graphics2D) returnImage.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(image.getImage(), 0, 0, width, height, null);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	    return returnImage;
	}

	public static BufferedImage overlayImages(BufferedImage backgroundImage,BufferedImage centeredImage 
			, int xPosition, int yPosition){
		// If the centered Image is any Dimension larger than the background image, it will throw a exception
		if (backgroundImage.getHeight()< centeredImage.getHeight() ||
				backgroundImage.getWidth() < centeredImage.getWidth()){
			try {
				throw new IOException("the centered Image is to Large,  it needs to be smaller than the backGround");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Graphics2D g = backgroundImage.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(backgroundImage, 0, 0, null);
		// make the centeredImage transparent
		//Aparently we dont need this method,  just taking more time out of the system
		//ImageProcessing.getTransparentImage(backgroundImage.getWidth(),backgroundImage.getWidth(),centeredImage);
		g.drawImage(centeredImage, xPosition, yPosition, null);
		g.dispose();
		return backgroundImage;
	}
	
}
