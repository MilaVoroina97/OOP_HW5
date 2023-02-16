package HW5.Spravochnik.Core.MVP;

import HW5.Spravochnik.Core.Exceptions.BadEmailException;
import HW5.Spravochnik.Core.Infrastructure.Contact;
import HW5.Spravochnik.Core.Infrastructure.Email;
import HW5.Spravochnik.Core.Infrastructure.PhoneNumber;

public class Presenter {

    private Model model;
    private View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;

    }

    public void load(){
        model.load();
    }

    public void save(){
        model.save();
    }

    public void getMenu(){

        while(true){
            view.menu();
            int command = view.getCommand();
            switch(command){
                case 0:
                    return;
                case 1 :

            }
        }
    }


    private Contact makeContact(String[] lines){

        String name = lines[0];
        try{

            Email email = new Email(lines[1]);
            PhoneNumber number = new PhoneNumber(lines[2]);
            Contact contact = new Contact(name, email, number);
            return contact;

        } catch (NumberFormatException e) {
            System.out.println("This is invalid phone number");
        } catch (BadEmailException e) {
            System.out.println("This is invalid email");
        }

        return null;
    }

    public void addContact(String[] lines){

        Contact contact = makeContact(lines);
        if(contact !=null){
            this.model.getPhonebookModel().createContact(contact);
            System.out.println("Contact was successfully added");
        }
    }

    public void changeContact(String[] lines){

        String name = lines[0];
        if(!this.model.getPhonebookModel().getAllContacts().containsKey(name)){
            System.out.println("There is not such contact, so it will be added");
            addContact(lines);
        }else{
            Contact contact = makeContact(lines);
            this.model.getPhonebookModel().changeContact(contact);
            System.out.println("Contact has been successfully changed");
        }
    }

    public void deleteContact(String value){

        Contact contact = this.model.getPhonebookModel().findContact(value);
        if(contact!=null){
            this.model.getPhonebookModel().delete(value);
            System.out.println("Contact was successfully deleted");
        }else System.out.println("Contact is empty or was not found");

    }
}
