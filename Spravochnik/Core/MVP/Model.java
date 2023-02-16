package HW5.Spravochnik.Core.MVP;

import HW5.Spravochnik.Core.ExportImport.ExportImportFile;
import HW5.Spravochnik.Core.Infrastructure.Phonebook;

public class Model {

    private Phonebook phonebook;
    private ExportImportFile file;

    public Model(Phonebook phonebook,ExportImportFile file){

        this.phonebook = phonebook;
        this.file = file;
    }
    public Model(ExportImportFile file){
        this.file = file;
        this.file.loadBook();
    }

    public Phonebook getPhonebookModel(){
        return this.phonebook;
    }

    public ExportImportFile getFile(){
        return this.file;
    }

    public void load(){
        this.phonebook = file.loadBook();
    }

    public void save(){
        file.saveBook(this.phonebook);
    }
}
