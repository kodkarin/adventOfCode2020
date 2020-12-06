package day6;

import java.util.List;

public class Day6Main {

    public static void main(String[] args) {

        CustomsDeclarationsProvider provider = new CustomsDeclarationsProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day6\\inputDay6.txt");
        List<CustomsDeclarationGroup> customsDeclarationGroups = provider.getCustomsDeclarationGroups();

        int result = 0;

        for (CustomsDeclarationGroup group : customsDeclarationGroups) {
            result += group.getAllPositiveAnswers().length();
        }
        System.out.println(result);
    }
}
