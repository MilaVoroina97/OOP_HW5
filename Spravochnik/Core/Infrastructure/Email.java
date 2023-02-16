package HW5.Spravochnik.Core.Infrastructure;

import HW5.Spravochnik.Core.Exceptions.BadEmailException;

public class Email {

    private String nameOfEmail;
    public Email(String nameOfEmail) throws BadEmailException{

        if(isCorrect(nameOfEmail)) this.nameOfEmail = nameOfEmail;
        else throw new BadEmailException();
    }

    private boolean isCorrect(String value){
        if(value.contains("@")) return true;
        return false;
    }

    public String getEmail(){
        return this.nameOfEmail;
    }

    public void setEmail(String value){
        this.nameOfEmail = value;
    }

    @Override
    public String toString(){
        return this.getEmail();
    }
    
}
