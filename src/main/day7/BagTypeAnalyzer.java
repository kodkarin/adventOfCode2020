package day7;

public class BagTypeAnalyzer {

    public int getTotalNumberOfInnerBags (BagType bagType) {
        int numberOfBags = 0;

        if (bagType.getRules().isEmpty()) {
            return 0;
        } else {
            for (Rule rule : bagType.getRules()) {
                numberOfBags += rule.getNumber();
                BagType innerBag = new BagType(rule.getColor());
                innerBag = bagType.getInnerBagTypes().get(bagType.getInnerBagTypes().indexOf(innerBag));
                numberOfBags +=  rule.getNumber() * getTotalNumberOfInnerBags(innerBag);
            }
            return numberOfBags;
        }
    }
}
