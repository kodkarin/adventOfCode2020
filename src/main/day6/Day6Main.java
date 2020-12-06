package day6;

import java.util.List;

public class Day6Main {

    public static void main(String[] args) {

        CustomsDeclarationsProvider provider = new CustomsDeclarationsProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day6\\inputDay6.txt");
        List<CustomsDeclarationGroup> customsDeclarationGroups = provider.getCustomsDeclarationGroups();

        int resultPart1 = 0;
        for (CustomsDeclarationGroup group : customsDeclarationGroups) {
            resultPart1 += group.getAllPositiveAnswers().length();
        }
        System.out.println(resultPart1);

        int resultPart2 = 0;
        for (CustomsDeclarationGroup group : customsDeclarationGroups) {
            resultPart2 += group.getCommonAnswers().length();
        }
        System.out.println(resultPart2);
    }
}
