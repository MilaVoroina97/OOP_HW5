package HW5.Spravochnik.UI;



import HW5.Spravochnik.Core.ExportImport.ExportImportFile;
import HW5.Spravochnik.Core.Infrastructure.Phonebook;
import HW5.Spravochnik.Core.Infrastructure.PhonebookMap;
import HW5.Spravochnik.Core.MVP.Model;
import HW5.Spravochnik.Core.MVP.Presenter;
import HW5.Spravochnik.Core.MVP.View;

public class App {

    public static void start(){
        Phonebook phonebook = new PhonebookMap();
        ExportImportFile file = new ExportImportFile("phonebook.txt", phonebook);
        Model model = new Model(phonebook,file);
        View view = new ConsoleView();
        Presenter presenter = new Presenter(model, view);
        presenter.load();
        presenter.getMenu();
        presenter.save();

    }
    
}
