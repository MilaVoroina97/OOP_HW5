package HW5.Spravochnik.UI;

import java.util.Scanner;

import HW5.Spravochnik.Core.ExportImport.ExportImportFile;
import HW5.Spravochnik.Core.Infrastructure.Phonebook;
import HW5.Spravochnik.Core.Infrastructure.PhonebookMap;
import HW5.Spravochnik.Core.MVP.Model;

public class App {

    public static void start(){
        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = new PhonebookMap();
        ExportImportFile file = new ExportImportFile("phonebook.txt", phonebook);
        Model model = new Model(file);
        
    }
    
}
