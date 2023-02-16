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


    
    
}
