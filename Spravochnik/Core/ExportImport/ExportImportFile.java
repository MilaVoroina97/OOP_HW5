package HW5.Spravochnik.Core.ExportImport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import HW5.Spravochnik.Core.Exceptions.BadEmailException;
import HW5.Spravochnik.Core.Exceptions.UncorrectTXTFile;
import HW5.Spravochnik.Core.Infrastructure.Contact;
import HW5.Spravochnik.Core.Infrastructure.Email;
import HW5.Spravochnik.Core.Infrastructure.PhoneNumber;
import HW5.Spravochnik.Core.Infrastructure.Phonebook;

public class ExportImportFile implements Export,Import{

    private String path;
    private Phonebook newPhonebook;

    public ExportImportFile(String path,Phonebook newPhonebook){

        this.path = path;
        this.newPhonebook = newPhonebook;

    }


    @Override
    public Phonebook loadBook(){
        try{
            File file = new File(this.path);
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            createLines(bf);  
            bf.close();
            return this.newPhonebook;         
        } catch (IOException e) {
            System.out.println("Cannot read from file");
        } catch (NullPointerException e) {
            System.out.println("Cannot read from empty file");
        } catch (UncorrectTXTFile e) {
            System.out.println("This file cannot be loaded.");
        }
        return this.newPhonebook;
    }

    private void createLines(BufferedReader bf) throws IOException, UncorrectTXTFile{

        String line = bf.readLine();
        boolean errors = false;
        while(line !=null){
            String[] lines = line.split(";");
            String name = lines[0];
            try{

                Email email = new Email(lines[1]);
                PhoneNumber number = new PhoneNumber(lines[2]);
                Contact contact = new Contact(name, email, number);
                this.newPhonebook.createContact(contact);

            }catch ( BadEmailException| NumberFormatException e){

                errors = true;

            }

            line = bf.readLine();
        }
        if(errors) throw new UncorrectTXTFile();

    }

    @Override
    public void saveBook(Phonebook phonebook) {

        try{

            File file = new File(this.path);
            FileWriter fr = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(fr);
            writeInFile(bf, phonebook);
            bf.close();

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }


    private void writeInFile(BufferedWriter wr, Phonebook phonebook) throws IOException{
        for(Contact c : phonebook.getAllContacts().values()){
            wr.write(String.format("%s;%s;%s\n", c.getFirstName(), c.getEmail(), c.getNumber()));
        }
    }
    
}
