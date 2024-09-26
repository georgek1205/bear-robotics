import Controller.ATMController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATMController atmController = new ATMController();

        System.out.print("Insert Card : ");
        Scanner scan = new Scanner(System.in);
        String insertingCard = scan.nextLine();
        atmController.insertCard(insertingCard);

        System.out.print("Please input PIN : ");
        String pin = scan.nextLine();
        atmController.enterPin(pin);

        atmController.selectAccount();
        String choice = scan.nextLine();
        int amount;
        if(choice.equals("1")){
            System.out.print("Insert amount you would like to deposit : ");
            amount = scan.nextInt();
            if(amount > 0){
                atmController.deposit(amount);
            }
        } else if (choice.equals("2")){
            System.out.print("Insert amount you would like to withdraw : ");
            amount = scan.nextInt();
            if(amount > 0){
                atmController.withdraw(amount);
            }
        }

        scan.close();
    }
}
