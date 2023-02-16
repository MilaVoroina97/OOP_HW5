package HW5.Spravochnik.Core.Infrastructure;

import java.util.HashMap;
import java.util.Map;

public class PhonebookMap implements Phonebook{

    private Map<String,Contact> phonebook;

    public PhonebookMap(Map<String,Contact> phonebook){

        this.phonebook = phonebook;

    }

    public PhonebookMap(){
        phonebook = new HashMap<String,Contact>();
    }

    public Map<String,Contact> getPhoneBook(){
        return this.phonebook;
    }
    @Override
    public void createContact(Contact contact) {

        try{
            this.phonebook.put(contact.getFirstName(), contact);
            System.out.println("Contact has been created");
        }catch (UnsupportedOperationException | NullPointerException | IllegalArgumentException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public Contact getContact(String contact) { //read

        if(this.getPhoneBook().containsKey(contact)) return this.getPhoneBook().get(contact);
        else System.out.println("There is not such contact");
        return null;
    }

    @Override
    public Map<String, Contact> getAllContacts() {
        return this.phonebook;
    }

    @Override
    public void changeContact(Contact contact) {
        try{
            this.phonebook.replace(contact.getFirstName(), contact);
            System.out.println("Contact has been changed");
        }catch (UnsupportedOperationException | NullPointerException | IllegalArgumentException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(String contact) {
        try{

            this.phonebook.remove(contact);
            System.out.println("Contact has beed deleted");

        }catch(UnsupportedOperationException | NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public Contact findContact(String contact) {
        return this.getPhoneBook().get(contact);
    }
    
}
