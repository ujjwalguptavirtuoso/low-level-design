package atm;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ATM {

    String atmId;
    Address location;
    CashDispenser cashDispenser;
    CardReader cardReader;
    Screen screen;
    Keypad keypad;
    Deposit deposit;
    BankService bankService;

}

class Address{

    int pinCode;
    String street;
    String city;
    String state;
    String country;
}

class CashDispenser{
    // map of type of currency bill and their count. decrement while dispensing cash.
    Map<CashType, Integer> cashAvailable;

    boolean dispenseCash(int amountToBeDispensed){
        return true;
    }
}

enum CashType{
    HUNDRED, TWOHUNDRED ,FIVEHUNDRED, TWOTHOUSAND;
}

class CardReader{

    public CardInfo fetchCardDetails(){
        return new CardInfo();
    }
}

class CardInfo{

    CardType cardType;
    int cardNo;
    String nameOnCard;
    Bank bank;
    Date expiryDate;
    int cvv ;
    float withdrawLimit;
}

class Bank{
    String name;
    List<ATM> atmList;
}


interface BankService{
   boolean isValidUser(CardInfo cardInfo, String pin);
  // Customer getCustomerDetails(CardInfo cardInfo);
  // public TransactionDetail executeTransaction;
}

enum CardType{
    DEBITCARD, CREDITCARD, POSTPAIDCARD, POINTSCARD;
}

class Screen{

    public void display(String message){
        //display something
        // "Thank you for choosing this ATM"
        // "Please enter your pin"
    }
}

class Keypad{
    public String getInput(){
        return new String();
    }
}

interface Deposit{

    boolean depositFunds(double amount);
}

class CashDeposit implements Deposit{

    @Override
    public boolean depositFunds(double amount) {
        return false;
    }
}

class ChequeDeposit implements Deposit{

    @Override
    public boolean depositFunds(double amount) {
        return false;
    }
}

/**class BankService{

} */