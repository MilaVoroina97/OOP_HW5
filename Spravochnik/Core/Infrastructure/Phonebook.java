package HW5.Spravochnik.Core.Infrastructure;

import java.util.Map;

public interface Phonebook {

    public void createContact(Contact contact);

    public Contact getContact(String contact);

    public Map<String,Contact> getAllContacts();

    public void changeContact(Contact contact);

    public void delete(String contact);
    
    public Contact findContact(String contact);
}
