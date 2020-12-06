package day6;

import java.util.ArrayList;
import java.util.List;

public class CustomsDeclarationGroup {

    private List<CustomsDeclaration> customsDeclarations;

    public CustomsDeclarationGroup(List<CustomsDeclaration> customsDeclarations) {
        this.customsDeclarations = customsDeclarations;
    }

    public String getAllPositiveAnswers() {

        StringBuilder answer = new StringBuilder();
        List<Character> positiveAnswers = new ArrayList<>();
        for (CustomsDeclaration declaration : customsDeclarations) {
            char[] letters = declaration.getPositiveAnswers().toCharArray();
            for (char letter : letters) {
                if(!positiveAnswers.contains(letter)){
                    positiveAnswers.add(letter);
                    answer.append(letter);
                }
            }
        }
        return answer.toString();
    }
}
