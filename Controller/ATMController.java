package Controller;

import Account.Account;
import Account.savingAccount;
import Card.Card;
import Card.debitCard;

import java.util.HashMap;
import java.util.Map;

public class ATMController {
    private Map<String, Card> cardRepository;
    private Map<String, Account> accountRepository;
    private Card insertedCard;
    private Account insertedAccount;
    private boolean isAuthenticated;

    public ATMController() {
        cardRepository = new HashMap<>();
        accountRepository = new HashMap<>();

        Card shinhanCard = new debitCard("77777777", "1111");
        Card kookminCard = new debitCard("99999999", "2222");
        Card wooriCard = new debitCard("33333333", "2222");

        cardRepository.put(shinhanCard.getCardNum(), shinhanCard);
        cardRepository.put(kookminCard.getCardNum(), kookminCard);
        cardRepository.put(wooriCard.getCardNum(), wooriCard);

        Account shinhanAccount = new savingAccount(3000);
        Account kookminAccount = new savingAccount(4000);
        Account wooriAccount = new savingAccount(5000);

        accountRepository.put(shinhanCard.getCardNum(), shinhanAccount);
        accountRepository.put(kookminCard.getCardNum(), kookminAccount);
        accountRepository.put(wooriCard.getCardNum(), wooriAccount);
    }

    public void insertCard(String cardNumber){
        if(cardRepository.containsKey(cardNumber)){
            insertedCard = cardRepository.get(cardNumber);
            isAuthenticated = false;
            System.out.println("Card is inserted. Press PIN : ");
        }else{
            System.out.println("Cannot read Card");
        }
    }

    public void enterPin(String pin){
        if(insertedCard != null && insertedCard.isValidPin(pin)){
            isAuthenticated = true;
            insertedAccount = accountRepository.get(insertedCard.getCardNum());
            System.out.println("Welcome!, Select Account");
        }else{
            System.out.println("Invalid Pin! Insert Card again!");
        }
    }

    public void selectAccount(){
        if(isAuthenticated){
            System.out.println("Remaining balance : " + insertedAccount.getBalance());
            System.out.println("[1. Deposit] [2.Withdrawl]");
        }else{
            System.out.println("Invalid approach : not authenticated");
        }
    }

    public void deposit(int amount){
        if(isAuthenticated && insertedAccount != null){
            insertedAccount.deposit(amount);
        }else{
            System.out.println("Invalid approach : not authenticated");
        }
    }

    public void withdraw(int amount) {
        if(isAuthenticated && insertedAccount != null) {
            withdraw(amount);
        }else{
            System.out.println("Invalid approach : not authenticated");
        }
    }
}
