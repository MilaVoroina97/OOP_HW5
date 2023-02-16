package HW5.Spravochnik.Core.MVP;

import java.util.Collection;

import HW5.Spravochnik.Core.Infrastructure.Contact;

public interface View {

    public void menu();
    public int getCommand();
    public void invalidCommand();
    public String[] addContact();
    public String[] changeContact(Collection<Contact> contacts);
    public String deleteContact(Collection<Contact> contacts);
    public void showContact(Contact contact);
    public void showAllContacts(Collection<Contact> contacts);

    
}
