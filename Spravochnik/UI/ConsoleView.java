package HW5.Spravochnik.UI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import HW5.Spravochnik.Core.Infrastructure.Contact;
import HW5.Spravochnik.Core.MVP.View;
import java.util.Scanner;


public class ConsoleView implements View{

     Scanner scanner;

    public ConsoleView(){

        scanner = new Scanner(System.in);
    }

    @Override
    public void menu() {

        Map<Integer,String> menuMap = new HashMap<>();
        menuMap.put(0,"Quit");
        menuMap.put(1, "Add contact");
        menuMap.put(2, "Change contact in your phonebook");
        menuMap.put(3,"Remove contact from your phonebook");
        menuMap.put(4,"Show all contacts");
        menuMap.put(5,"Show information about chosen contact");
        System.out.println("Please,choose one action from menu: ");
        for(int i = 0; i < menuMap.size(); i++){
            System.out.printf("%d - %s\n", i, menuMap.get(i));
        }
        
    }

    @Override
    public int getUserCommand() {

        while(true){
            System.out.println("Please,enter number of command: ");
            if(this.scanner.hasNextInt()) return this.scanner.nextInt();
            else {
                System.out.println("This is not a integer number , try again: ");
                break;
            }
        }
        return 0;
    }

    @Override
    public void invalidCommand() {
        System.out.println("This is not a number od existing command, try again.");
        
    }

    @Override
    public String[] addContactMenu() {
        System.out.println("Enter name of contact : ");
        String name = this.scanner.next();
        System.out.println("Enter email of contact : ");
        String email = this.scanner.next();
        System.out.println("Enter number of contact : ");
        String phoneNumber = this.scanner.next();
        return new String[]{name,email,phoneNumber};
    }

    @Override
    public String[] changeContactMenu(Collection<Contact> contacts) {
        System.out.println("Please, fill this fields to change contact");
        System.out.println("Enter name of contact : ");
        String name = this.scanner.next();
        System.out.println("Enter email of contact : ");
        String email = this.scanner.next();
        System.out.println("Enter number of contact : ");
        String phoneNumber = this.scanner.next();
        return new String[]{name,email,phoneNumber};
    }

    @Override
    public String deleteContactMenu(Collection<Contact> contacts) {
        System.out.println("Please, fill this fields to delete contact");
        System.out.println("Enter name of contact : ");
        String name = this.scanner.next();
        return name;
    }

    @Override
    public void showContact(Contact contact) {
        String message = "Founded contact : ";
        System.out.printf("%s - %s\n", message, contact);
        
    }

    @Override
    public void showAllContacts(Collection<Contact> contacts) {
       System.out.println("Here is all contacts in your phonebook");
       List<Contact> contactList = new ArrayList<>(contacts);
       Collections.sort(contactList);
       for(Contact c : contactList){
        System.out.println(c);
       }
        
    }

    @Override
    public String searching() {
        System.out.println("Enter a name to search contact: ");
        return this.scanner.next();
    }
    
}
