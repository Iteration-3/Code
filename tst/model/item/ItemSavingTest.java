package model.item;

import static org.junit.Assert.assertEquals;
import model.statistics.EntityStatistics;
import model.statistics.Statistics;

import org.junit.Test;

import utilities.structuredmap.StructuredMap;
import view.item.BasicItemView;

public class ItemSavingTest {

    @Test
    public void testConsumable() {
        ConsumableItem item = new ConsumableItem(new BasicItemView(), new EntityStatistics(), 4.5);
        StructuredMap map = item.getStructuredMap();
        System.out.println(map.getJson());

        ConsumableItem testItem = new ConsumableItem(new BasicItemView(), map.getStructuredMap("consumableItem"));

        assertEquals(map.getJson(), testItem.getStructuredMap().getJson());
    }

    @Test
    public void testHelmet() {
        Helmet helmet = new Helmet(new BasicItemView(), new Statistics());
        StructuredMap map = helmet.getStructuredMap();
        System.out.println(map.getJson());

        Helmet helmet2 = new Helmet(new BasicItemView(), map.getStructuredMap("helmet"));
        assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
    }

    @Test
    public void testChestPiece() {
        ChestPiece helmet = new ChestPiece(new BasicItemView(), new Statistics());
        StructuredMap map = helmet.getStructuredMap();
        System.out.println(map.getJson());

        ChestPiece helmet2 = new ChestPiece(new BasicItemView(), map.getStructuredMap("chestPiece"));
        assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
    }

    @Test
    public void testLeggings() {
        Leggings helmet = new Leggings(new BasicItemView(), new Statistics());
        StructuredMap map = helmet.getStructuredMap();
        System.out.println(map.getJson());

        Leggings helmet2 = new Leggings(new BasicItemView(), map.getStructuredMap("leggings"));
        assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
    }

    @Test
    public void testBoots() {
        Boots helmet = new Boots(new BasicItemView(), new Statistics());
        StructuredMap map = helmet.getStructuredMap();
        System.out.println(map.getJson());

        Boots helmet2 = new Boots(new BasicItemView(), map.getStructuredMap("boots"));
        assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
    }

    @Test
    public void testGloves() {
        Gloves helmet = new Gloves(new BasicItemView(), new Statistics());
        StructuredMap map = helmet.getStructuredMap();
        System.out.println(map.getJson());

        Gloves helmet2 = new Gloves(new BasicItemView(), map.getStructuredMap("gloves"));
        assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
    }

    @Test
    public void testProjectile() {
        Projectile helmet = new Projectile(new BasicItemView(), new Statistics());
        StructuredMap map = helmet.getStructuredMap();
        System.out.println(map.getJson());

        Projectile helmet2 = new Projectile(new BasicItemView(), map.getStructuredMap("projectile"));
        assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
    }

}
