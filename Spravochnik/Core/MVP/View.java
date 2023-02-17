package HW5.Spravochnik.Core.MVP;

import java.util.Collection;

import HW5.Spravochnik.Core.Infrastructure.Contact;

public interface View {

    public void menu();
    public int getUserCommand();
    public void invalidCommand();
    public String[] addContactMenu();
    public String[] changeContactMenu(Collection<Contact> contacts);
    public String deleteContactMenu(Collection<Contact> contacts);
    public void showContact(Contact contact);
    public void showAllContacts(Collection<Contact> contacts);
    public String searching(); 

    
}
