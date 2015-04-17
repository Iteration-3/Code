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
}
