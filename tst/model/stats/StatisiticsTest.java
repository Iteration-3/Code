package model.stats;

import static org.junit.Assert.assertEquals;
import model.statistics.EntityStatistics;
import model.statistics.Statistics;

import org.junit.Before;
import org.junit.Test;

import utilities.structuredmap.StructuredMap;

public class StatisiticsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void saveStatsTest() {
        Statistics stats = new Statistics();
        stats.setAgility(50);
        stats.setStrength(25);

        StructuredMap map = stats.getStructuredMap();
        System.out.println(map.getJson());

        Statistics stats2 = new Statistics(map);
        assertEquals(stats.getStrength(), stats2.getStrength());
        assertEquals(stats.getAgility(), stats2.getAgility());
    }

    @Test
    public void saveEntityStatsTest() {
        EntityStatistics stats = new EntityStatistics();
        stats.setAgility(50);
        stats.setExperience(10000);

        StructuredMap map = stats.getStructuredMap();

        System.out.println(map.getJson());

        EntityStatistics stats2 = new EntityStatistics(map);

        assertEquals(stats.getAgility(), stats2.getAgility());
        assertEquals(stats.getExperience(), stats2.getExperience());
    }

}
