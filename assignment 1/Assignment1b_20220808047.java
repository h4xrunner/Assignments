//Author İbrahim Gül
//Date 26/09/2024
//Version 2024.1

import java.util.Scanner;

class Assignment1b_20220808047{
    
    
    public static void main(String[] args) {
        Scanner opt = new Scanner(System.in);
        double balance = 0;
        System.out.print("Please enter the balance: ");
        balance = opt.nextInt();
        System.out.println("What would you like to do today?");
        System.out.print("1 to see your Balance \n2 to withdraw cash\n3 to Deposit cash\n4 to Exit\nPlease enter your selection: ");
        int option;
        double withdrawAmount;
        double depositAmount;
        option= opt.nextInt();
        switch (option) {
            case 1:
                System.out.println("The current balance is: "+ balance);
                System.out.println("Have a nice day.");
                break;
            case 2:
            System.out.print("Please enter the amount to withdraw:");
            withdrawAmount = opt.nextInt();
            if(withdrawAmount>=0&&withdrawAmount<=balance){
                balance-=withdrawAmount;
                System.out.println("The current balance is: "+ balance+ "\nHave a nice day");
            }else{
                System.out.println("ERROR: Invalid withdraw amount.");
            }
            break;
            case 3:
            System.out.print("Please enter the amount to deposit: ");
            depositAmount=opt.nextInt();
            if(depositAmount<0){
                System.out.println("ERROR: Invalid deposit amount.");
            }else{
                balance+= depositAmount;
                System.out.println("The current balance is: "+ balance+ "\nHave a nice day.");

            }
            break;
            case 4:
            break;
            default:
            System.out.println("ERROR: Invalid selection. Exiting System.");
                break;
        }

    }
}
