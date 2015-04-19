package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class EntitySpriteFactory {
	// Avatar Sprites
	private static ConcreteEntitySpriteHolder summoner = null;
	private static File summonerFile = new File(
			"src/resources/sprites/summoner.png");
	private static int summonerCols = 18;

	private static ConcreteEntitySpriteHolder sneaker = null;
	private static File sneakerFile = new File(
			"src/resources/sprites/sneak.png");
	private static int sneakerCols = 18;

	private static ConcreteEntitySpriteHolder smasher = null;
	private static File smasherFile = new File(
			"src/resources/sprites/smasher.png");
	private static int smasherCols = 18;

	// Trooper Sprites
	private static ConcreteEntitySpriteHolder darkTrooper = null;
	private static File darkTrooperFile = new File(
			"src/resources/sprites/dark_trooper.png");
	private static int darkTrooperCols = 18;

	private static ConcreteEntitySpriteHolder trooper = null;
	private static File trooperFile = new File(
			"src/resources/sprites/trooper.png");
	private static int trooperCols = 18;

	// Boy
	private static ConcreteEntitySpriteHolder boy = null;
	private static File boyFile = new File("src/resources/sprites/boy.png");
	private static int boyCols = 18;

	// Baldy
	private static ConcreteEntitySpriteHolder baldy = null;
	private static File baldyFile = new File("src/resources/sprites/baldy.png");
	private static int baldyCols = 18;

	// Stache
	private static ConcreteEntitySpriteHolder stache = null;
	private static File stacheFile = new File(
			"src/resources/sprites/stache.png");
	private static int stacheCols = 18;

	// Underling
	private static ConcreteEntitySpriteHolder underling = null;
	private static File underlingFile = new File(
			"src/resources/sprites/underling.png");
	private static int underlingCols = 18;

	// Lady
	private static ConcreteEntitySpriteHolder lady = null;
	private static File ladyFile = new File("src/resources/sprites/lady.png");
	private static int ladyCols = 18;

	// Mad Scientist
	private static ConcreteEntitySpriteHolder madScientist = null;
	private static File madScientistFile = new File(
			"src/resources/sprites/mad_scientist.png");
	private static int madScientistCols = 18;

	public static ConcreteEntitySpriteHolder getHolderFromFileIfNull(
			ConcreteEntitySpriteHolder holder, File file, int cols, String type) {
		if (holder == null) {
			return new ConcreteEntitySpriteHolder(
					EntitySpriteFactory.splitImage(
							EntitySpriteFactory.getImage(file), cols), type);
		}
		return holder;

	}

	public static ConcreteEntitySpriteHolder getSummonerSpriteHolder() {

		summoner = getHolderFromFileIfNull(summoner, summonerFile,
				summonerCols, "summonerSprite");
		return summoner;
	}

	public static ConcreteEntitySpriteHolder getSmasherSpriteHolder() {
		smasher = getHolderFromFileIfNull(smasher, smasherFile, smasherCols,
				"smasherSprite");
		return smasher;
	}

	public static ConcreteEntitySpriteHolder getSneakerSpriteHolder() {
		sneaker = getHolderFromFileIfNull(sneaker, sneakerFile, sneakerCols,
				"sneakSprite");
		return sneaker;
	}

	public static ConcreteEntitySpriteHolder getDarkTrooperSpriteHolder() {
		darkTrooper = getHolderFromFileIfNull(darkTrooper, darkTrooperFile,
				darkTrooperCols, "darkTrooper");
		return darkTrooper;
	}

	public static ConcreteEntitySpriteHolder getBoySpriteHolder() {
		boy = getHolderFromFileIfNull(boy, boyFile, boyCols, "boy");
		return boy;
	}

	public static ConcreteEntitySpriteHolder getBaldySpriteHolder() {
		baldy = getHolderFromFileIfNull(baldy, baldyFile, baldyCols, "baldy");
		return baldy;
	}

	public static ConcreteEntitySpriteHolder getTrooperSpriteHolder() {
		trooper = getHolderFromFileIfNull(trooper, trooperFile, trooperCols,
				"trooper");
		return trooper;
	}

	public static ConcreteEntitySpriteHolder getUnderlingSpriteHolder() {
		underling = getHolderFromFileIfNull(underling, underlingFile,
				underlingCols, "underling");
		return underling;
	}

	public static ConcreteEntitySpriteHolder getLadySpriteHolder() {
		lady = getHolderFromFileIfNull(lady, ladyFile, ladyCols, "lady");
		return lady;
	}

	public static ConcreteEntitySpriteHolder getStacheSpriteHolder() {
		stache = getHolderFromFileIfNull(stache, stacheFile, stacheCols,
				"stache");
		return stache;
	}

	public static ConcreteEntitySpriteHolder getMadScientistSpriteHolder() {
		madScientist = getHolderFromFileIfNull(madScientist, madScientistFile,
				madScientistCols, "madScientist");
		return madScientist;
	}

	public static void printTestImages(BufferedImage[] imgs) {
		// TODO delete this method.
		try {
			for (int i = 0; i < imgs.length; i++) {
				ImageIO.write(imgs[i], "png", new File("img" + i + ".png"));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static BufferedImage getImage(File file) {
		FileInputStream fis = null;
		BufferedImage image = null;

		try {
			fis = new FileInputStream(file);
			image = ImageIO.read(fis);
		} catch (Exception e) {
			System.err.println("File not found! Summoner.png" + e.toString());
		}
		return image;
	}

	public static BufferedImage[] splitImage(BufferedImage image, int cols) {
		int chunkHeight;
		int chunkWidth;
		chunkHeight = image.getHeight();
		chunkWidth = image.getWidth() / cols;
		BufferedImage imgs[] = new BufferedImage[cols];
		for (int i = 0; i != cols; ++i) {
			imgs[i] = image.getSubimage(i * chunkWidth, 0, chunkWidth,
					chunkHeight);
		}
		return imgs;
	}

	public static AbstractEntitySpriteHolder getSpritesFromType(String string) {
		switch (string) {
		case "madScientist":
			return getMadScientistSpriteHolder();
		case "stache":
			return getStacheSpriteHolder();
		case "lady":
			return getLadySpriteHolder();
		case "underling":
			return getUnderlingSpriteHolder();
		case "trooper":
			return getTrooperSpriteHolder();
		case "baldy":
			return getBaldySpriteHolder();
		case "boy":
			return getBoySpriteHolder();
		case "darkTrooper":
			return getDarkTrooperSpriteHolder();
		case "sneakSprite":
			return getSneakerSpriteHolder();
		case "smasherSprite":
			return getSmasherSpriteHolder();
		case "summonerSprite":
			return getSummonerSpriteHolder();

		default:
			throw new IllegalArgumentException("Fuck you");
		}
	}
}
