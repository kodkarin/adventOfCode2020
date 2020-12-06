package day6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomsDeclarationGroupTest {

    @Test
    public void getCustomsDeclarationsReturnsTheCorrectAnswer() {
        CustomsDeclaration declaration1 = new CustomsDeclaration("abcx");
        CustomsDeclaration declaration2 = new CustomsDeclaration("abcy");
        CustomsDeclaration declaration3 = new CustomsDeclaration("abcz");

        List<CustomsDeclaration> declarations = new ArrayList<>();
        declarations.add(declaration1);
        declarations.add(declaration2);
        declarations.add(declaration3);

        CustomsDeclarationGroup group = new CustomsDeclarationGroup(declarations);

        String positiveAnswers = group.getAllPositiveAnswers();

        assertEquals("abcxyz", positiveAnswers);

    }

}