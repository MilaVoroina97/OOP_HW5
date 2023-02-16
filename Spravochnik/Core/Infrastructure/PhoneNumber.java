package HW5.Spravochnik.Core.Infrastructure;

public class PhoneNumber {

    private String number;


    public PhoneNumber(String number){

        if(isCorrect(number)) this.number = number;

    }

    public String getPhoheNumber(){
        return this.number;
    }

    private boolean isCorrect(String number) throws NumberFormatException{

        if(number.contains("+")){
            Integer.parseInt(number.substring(1));
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.getPhoheNumber();
    }
    
}
