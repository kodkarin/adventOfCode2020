package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BagListProvider {

    private String path;
    private List<BagType> allBagTypes;

    public BagListProvider(String path) {
        this.path = path;
        allBagTypes = new ArrayList<>();
    }

    public List<BagType> getBagList() {

        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                 parseBag(scanner.nextLine());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return allBagTypes;
    }

    private void parseBag(String inputString) {
        String[] bagRules = inputString.split("bags contain");
        String color = bagRules[0].trim();
        BagType newBagType = new BagType(color);

        if (allBagTypes.contains(newBagType)) {
            newBagType = allBagTypes.get(allBagTypes.indexOf(newBagType));
        } else {
            allBagTypes.add(newBagType);
        }

        setRules(newBagType, bagRules[1]);
        addAllInnerBags(newBagType);
        addToInnerBags(newBagType);
    }

    private void setRules(BagType bagType, String rulesToBe) {
        String[] separateRules = rulesToBe.split(",");
        if (!(separateRules[0].trim().equals("no other bags."))) {
            for (String ruleString : separateRules) {
                int numberOfBags = Integer.parseInt(ruleString.substring(1, 2));
                String innerBag = ruleString.replace(".", "")
                        .replace("bags", "")
                        .replace("bag", "")
                        .trim()
                        .substring(2);
                Rule rule = new Rule(numberOfBags, innerBag);
                bagType.addRule(rule);
            }
        }
    }

    private void addAllInnerBags(BagType bagType) {
        addBagsFromRules(bagType);
    }

    private void addBagsFromRules(BagType bagType) {
        if (!(bagType.getRules().isEmpty())) {
            for (Rule rule : bagType.getRules()) {
                BagType innerBagType = new BagType(rule.getColor());
                if (allBagTypes.contains(innerBagType)) {
                    innerBagType = allBagTypes.get(allBagTypes.indexOf(innerBagType));
                    if (!(innerBagType.getRules().isEmpty())) {
                        addInnerBagsFromRules(bagType, innerBagType);
                    }
                } else {
                    allBagTypes.add(innerBagType);
                }
                addToInnerBagsIfNotPresent(bagType, innerBagType);
            }
        }
    }
    private void addToInnerBags(BagType bagType) {
        for (BagType possibleOuterBag : allBagTypes) {
            if (possibleOuterBag.getInnerBagTypes().contains(bagType)) {
                for (BagType innerBag : bagType.getInnerBagTypes()) {
                    addToInnerBagsIfNotPresent(possibleOuterBag, innerBag);
                }
            }
        }
    }

    private void addInnerBagsFromRules(BagType bagType, BagType innerBagType) {
        for (BagType possibleInnerBagType : innerBagType.getInnerBagTypes()) {
            addToInnerBagsIfNotPresent(bagType, possibleInnerBagType);
        }
    }

    private void addToInnerBagsIfNotPresent(BagType bagType, BagType possibleInnerBagType) {
        if ( bagType != possibleInnerBagType && (!(bagType.getInnerBagTypes().contains(possibleInnerBagType)))) {
            bagType.addInnerBag(possibleInnerBagType);
        }
    }
}
