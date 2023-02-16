package HW5.Spravochnik.Core.Exceptions;

public class BadEmailException extends Exception{
    
    public BadEmailException(){
        super("You should enter email with @");
    }
}
