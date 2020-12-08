package day7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BagTypeListProviderTest {

    @Test
    public void parseBagsSetsDarkOliveInnerBagsCorrectly() {
        String path = "C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day7\\testInputDay7.txt";

        BagListProvider provider = new BagListProvider(path);
        List<BagType> bagTypes = provider.getBagList();
        int numberOfBagsThatCanContainADarkOliveBag = 0;

        for(BagType bagType : bagTypes) {
            if (bagType.getInnerBagTypes().contains (new BagType("dark olive"))) {
                numberOfBagsThatCanContainADarkOliveBag++;
            }
        }

        assertEquals(5, numberOfBagsThatCanContainADarkOliveBag);
    }

    @Test
    public void parseBagsSetsShinyGoldInnerBagsCorrectly() {
        String path = "C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day7\\testInputDay7.txt";

        BagListProvider provider = new BagListProvider(path);
        List<BagType> bagTypes = provider.getBagList();
        int numberOfBagsThatCanContainAShinyGoldBag = 0;

        for(BagType bagType : bagTypes) {
            if (bagType.getInnerBagTypes().contains (new BagType("shiny gold"))) {
                numberOfBagsThatCanContainAShinyGoldBag++;
            }
        }

        assertEquals(4, numberOfBagsThatCanContainAShinyGoldBag);
    }

    @Test
    public void parseBagsSetsNoInnerBagsForFadedBlue() {
        String path = "C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day7\\testInputDay7.txt";

        BagListProvider provider = new BagListProvider(path);
        List<BagType> bagTypes = provider.getBagList();

        BagType fadedBlue = null;
        for (BagType bagType : bagTypes) {
            if (bagType.getColor().equals("faded blue")) {
                fadedBlue = bagType;
            }
        }

        assertEquals(0, fadedBlue.getInnerBagTypes().size());
    }

    @Test
    public void completeDataReturns257BagsThatCanContainAShinyGoldBag() {

        String path = "C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day7\\inputDay7.txt";

        BagListProvider provider = new BagListProvider(path);
        List<BagType> bagTypes = provider.getBagList();

        int numberOfBagsThatCanContainAShinyGoldBag = 0;

        for(BagType bagType : bagTypes) {
            if (bagType.getInnerBagTypes().contains (new BagType("shiny gold"))) {
                numberOfBagsThatCanContainAShinyGoldBag++;
            }
        }

        assertEquals(257, numberOfBagsThatCanContainAShinyGoldBag);
    }
}