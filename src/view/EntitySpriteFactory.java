package view;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public class EntitySpriteFactory {
	// Avatar Sprites
	private static ConcreteEntitySpriteHolder summoner = null;

	private static String summonerFilePath = "/sprites/summoner.png";

	private static int summonerCols = 18;

	private static ConcreteEntitySpriteHolder sneaker = null;

	private static String sneakerFilePath = "/sprites/sneak.png";

	private static int sneakerCols = 18;

	private static ConcreteEntitySpriteHolder smasher = null;

	private static String smasherFilePath= "/sprites/smasher.png";

	private static int smasherCols = 18;

	// Trooper Sprites
	private static ConcreteEntitySpriteHolder darkTrooper = null;

	private static String darkTrooperFilePath = "/sprites/dark_trooper.png";

	private static int darkTrooperCols = 18;

	private static ConcreteEntitySpriteHolder trooper = null;

	private static String trooperFilePath = "/sprites/trooper.png";

	private static int trooperCols = 18;

	// Boy
	private static ConcreteEntitySpriteHolder boy = null;
	private static String boyFilePath = "/sprites/boy.png";
	private static int boyCols = 18;

	// Baldy
	private static ConcreteEntitySpriteHolder baldy = null;
	private static String baldyFilePath = "/sprites/baldy.png";
	private static int baldyCols = 18;

	// Stache
	private static ConcreteEntitySpriteHolder stache = null;

	private static String stacheFilePath = "/sprites/stache.png";

	private static int stacheCols = 18;

	// Underling
	private static ConcreteEntitySpriteHolder underling = null;

	private static String underlingFilePath = "/sprites/underling.png";

	private static int underlingCols = 18;

	// Lady
	private static ConcreteEntitySpriteHolder lady = null;
	private static String ladyFilePath = "/sprites/lady.png";
	private static int ladyCols = 18;

	// Mad Scientist
	private static ConcreteEntitySpriteHolder madScientist = null;
	private static String madScientistFilePath = "/sprites/mad_scientist.png";
	private static int madScientistCols = 18;

	
	public static ConcreteEntitySpriteHolder getHolderFromFileIfNull(ConcreteEntitySpriteHolder holder, String filePath, int cols, String type){
		if(holder==null){
		return new ConcreteEntitySpriteHolder(
				EntitySpriteFactory.splitImage(EntitySpriteFactory.getImage(filePath),
						cols), type);
		}
		return holder;

	}


	public static ConcreteEntitySpriteHolder getSummonerSpriteHolder() {

		summoner = getHolderFromFileIfNull(summoner, summonerFilePath,
				summonerCols, "summonerSprite");
		return summoner;
	}

	public static ConcreteEntitySpriteHolder getSmasherSpriteHolder() {
		smasher = getHolderFromFileIfNull(smasher, smasherFilePath, smasherCols,
				"smasherSprite");
		return smasher;
	}

	public static ConcreteEntitySpriteHolder getSneakerSpriteHolder() {
		sneaker = getHolderFromFileIfNull(sneaker, sneakerFilePath, sneakerCols,
				"sneakSprite");
		return sneaker;
	}

	public static ConcreteEntitySpriteHolder getDarkTrooperSpriteHolder() {
		darkTrooper = getHolderFromFileIfNull(darkTrooper, darkTrooperFilePath,
				darkTrooperCols, "darkTrooper");
		return darkTrooper;
	}

	public static ConcreteEntitySpriteHolder getBoySpriteHolder() {
		boy = getHolderFromFileIfNull(boy, boyFilePath, boyCols, "boy");
		return boy;
	}

	public static ConcreteEntitySpriteHolder getBaldySpriteHolder() {
		baldy = getHolderFromFileIfNull(baldy, baldyFilePath, baldyCols, "baldy");
		return baldy;
	}

	public static ConcreteEntitySpriteHolder getTrooperSpriteHolder() {
		trooper = getHolderFromFileIfNull(trooper, trooperFilePath, trooperCols,
				"trooper");
		return trooper;
	}

	public static ConcreteEntitySpriteHolder getUnderlingSpriteHolder() {
		underling = getHolderFromFileIfNull(underling, underlingFilePath,
				underlingCols, "underling");
		return underling;
	}

	public static ConcreteEntitySpriteHolder getLadySpriteHolder() {
		lady = getHolderFromFileIfNull(lady, ladyFilePath, ladyCols, "lady");
		return lady;
	}

	public static ConcreteEntitySpriteHolder getStacheSpriteHolder() {
		stache = getHolderFromFileIfNull(stache, stacheFilePath, stacheCols,
				"stache");
		return stache;
	}

	public static ConcreteEntitySpriteHolder getMadScientistSpriteHolder() {
		madScientist = getHolderFromFileIfNull(madScientist, madScientistFilePath,
				madScientistCols, "madScientist");
		return madScientist;
	}

	public static BufferedImage getImage(String filePath){
		BufferedImage image = ImageProcessing.getImage(filePath);
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
