package day7;

import java.util.ArrayList;
import java.util.List;

public class BagType {

    private String color;
    private List<Rule> rules;
    private List<BagType> innerBagTypes;

    public BagType(String color) {
        this.color = color;
        this.rules = new ArrayList<>();
        this.innerBagTypes = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void addInnerBag(BagType innerBagType) {
        innerBagTypes.add(innerBagType);
    }

    public List<BagType> getInnerBagTypes() {
        return innerBagTypes;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BagType)) {
            return false;
        } else return (((BagType) obj).getColor().equals(color));
    }

    @Override
    public int hashCode() {
         return 5  + (this.color != null ? this.color.hashCode() : 0);
    }
}
