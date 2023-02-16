package HW5.Spravochnik.Core.Infrastructure;

public class Contact implements Comparable<Contact>{

    private String firstName;
    private Email email;
    private PhoneNumber phoneNumber;

    public Contact(String firstName,Email email,PhoneNumber phoneNumber){

        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public Email getEmail(){
        return this.email;
    }

    public PhoneNumber getNumber(){
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("First name: %s; Email: %s; Number: %s\n", this.getFirstName(), this.getEmail(),this.getNumber());
    }

    @Override
    public int compareTo(Contact o) {
        return this.getFirstName().compareTo(o.getFirstName());
    }
    
}
