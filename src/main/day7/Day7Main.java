package day7;

import java.util.List;

public class Day7Main {

    public static void main(String[] args) {
        BagListProvider provider = new BagListProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day7\\inputDay7.txt");
        List<BagType> allBagTypes = provider.getBagList();

        int numberOfBagsThatCanContainAShinyGoldenBag = 0;

        for(BagType bagType : allBagTypes) {
            if (bagType.getInnerBagTypes().contains (new BagType("shiny gold")) ) {
                numberOfBagsThatCanContainAShinyGoldenBag++;
            }
        }
        System.out.println(numberOfBagsThatCanContainAShinyGoldenBag);

        BagTypeAnalyzer analyzer = new BagTypeAnalyzer();
        BagType shinyGold = new BagType("shiny gold");
        shinyGold = allBagTypes.get(allBagTypes.indexOf(shinyGold));

        System.out.println(analyzer.getTotalNumberOfInnerBags(shinyGold));
    }
}
