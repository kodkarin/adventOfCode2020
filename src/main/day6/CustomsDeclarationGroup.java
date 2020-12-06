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

    public String getCommonAnswers() {

        char[] commonLetters = customsDeclarations.get(0).getPositiveAnswers().toCharArray();

        for (CustomsDeclaration declaration : customsDeclarations) {
            if (commonLetters.length > 0) {
                char[] letters = declaration.getPositiveAnswers().toCharArray();
                StringBuilder newCommonLetters = new StringBuilder();
                for (char letter : letters) {
                    for (char commonLetter : commonLetters) {
                        if (commonLetter == letter) {
                            newCommonLetters.append(letter);
                        }
                    }
                }
                commonLetters = newCommonLetters.toString().toCharArray();
            }
        }
        StringBuilder answer = new StringBuilder();
        for (char letter : commonLetters) {
            answer.append(letter);
        }
        return answer.toString();
    }
}
