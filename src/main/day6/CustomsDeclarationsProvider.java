package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomsDeclarationsProvider {

    private String path;

    public CustomsDeclarationsProvider(String path) {
        this.path = path;
    }

    public List<CustomsDeclarationGroup> getCustomsDeclarationGroups() {

        List<CustomsDeclarationGroup> declarationGroups = new ArrayList<>();

        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            List<CustomsDeclaration> declarations = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String customsDeclarationForm = scanner.nextLine();
                if (!customsDeclarationForm.isBlank()) {
                    declarations.add(new CustomsDeclaration(customsDeclarationForm));
                } else {
                    declarationGroups.add(new CustomsDeclarationGroup(declarations));
                    declarations = new ArrayList<>();
                }
            }
            if (!declarations.isEmpty()) {
                declarationGroups.add(new CustomsDeclarationGroup(declarations));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return declarationGroups;
    }
}
