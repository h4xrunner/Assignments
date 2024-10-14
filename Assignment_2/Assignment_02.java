import java.util.Random;
import java.util.Scanner;
public class Assignment_02{
    
    public static void main(String[] args) {
     String name;
     String surname;
     int balance=-1;
        @SuppressWarnings("resource")
        Scanner opt = new Scanner(System.in);
        System.out.print("Please enter your first name >>");
        name = opt.nextLine();
        
        
        System.out.print("Please enter your surname >>");
        surname = opt.nextLine();
        while(balance<0){
            System.out.print("Please enter your starting balance >>");
        balance = opt.nextInt();
        }
        
        name = name.substring(0,1).toUpperCase()+name.substring(1,name.length()).toLowerCase();
        surname =surname.toUpperCase();
        char option;//created out of do/while cause resetting problem
        Random random = new Random();
        int electricity = random.nextInt(100)*+1;
        int water = random.nextInt(100)*+1;
        int internet = random.nextInt(100)*+1;
        do{
        System.out.println("Hello "+ name+" "+surname);
        System.out.println("What would you like to do today? ");
        System.out.print("B to see your (B)alance \nW to (W)ithdraw cash\nD to (D)eposit cash\nP to (P)ay a bill\nQ to (Q)uit\nPlease enter your selection: ");
        
        double withdrawAmount;
        double depositAmount;
        option= opt.next().charAt(0);//got CHAR
        
        
            switch (option) {
                case 'B':
                    System.out.println("The current balance is: "+ balance);
                    System.out.println("Have a nice day.");
                    break;
                case 'W':
                System.out.print("Please enter the amount to withdraw:");
                withdrawAmount = opt.nextInt();
                if(withdrawAmount>=0&&withdrawAmount<=balance){
                    balance-=withdrawAmount;
                    System.out.println("The current balance is: "+ balance+ "\nHave a nice day");
                }else{
                    System.out.println("ERROR: Invalid withdraw amount.\n\n");
                }
                break;
                case 'D':
                System.out.print("Please enter the amount to deposit: ");
                depositAmount=opt.nextInt();
                if(depositAmount<0){
                    System.out.println("ERROR: Invalid deposit amount.\n\n");
                }else{
                    balance+= depositAmount;
                    System.out.println("The current balance is: "+ balance+ "\nHave a nice day.");
    
                    System.out.print("Please enter your starting balance >>");
                    balance = opt.nextInt();    }
                break;
                case 'P'://THE BIGGEST CASE//////////////////////////////////////////////////7
                System.out.print("Which of the following bills would you like to pay?\n1 - Electricity\n2 - Water\n3 - Internet\nPlease enter your selection >>");
                int optionBill = opt.nextInt();
                switch (optionBill) {
                    case 1:
                        System.out.println("Your Electricity bill is "+electricity);
                        if(balance<electricity){
                            System.out.println("You don't have sufficent funds to pay this bill");
                        }else{
                            System.out.print("Do you wish to pay this bill now (Y/N)?");
                            char billSelection = opt.next().charAt(0);
                            switch (billSelection) {
                                case 'Y':
                                balance -=electricity;
                                electricity=0;
                                System.out.println("Thank you for payment.");
                                    
                                    break;
                                case 'N':
                                
                                break;
                                default:
                                System.out.println("Invalid selection");
                                    break;
                            }
                        }
                        break;
                        case 2:
                        System.out.println("Your Water bill is "+water);
                        if(balance<water){
                            System.out.print("You don't have sufficent funds to pay this bill");
                        }else{
                            System.out.print("Do you wish to pay this bill now (Y/N)?");
                            char billSelection = opt.next().charAt(0);
                            switch (billSelection) {
                                case 'Y':
                                balance -=water;
                                water=0;
                                System.out.println("Thank you for payment.");
                                    
                                break;
                                case 'N':
                                
                                break;
                                default:
                                System.out.println("Invalid selection");
                                    break;
                            }
                        }
                        break;
                        case 3:
                        System.out.println("Your Internet bill is "+internet);
                        if(balance<internet){
                            System.out.print("You don't have sufficent funds to pay this bill");
                        }else{
                            System.out.print("Do you wish to pay this bill now (Y/N)?");
                            char billSelection = opt.next().charAt(0);
                            switch (billSelection) {
                                case 'Y':
                                balance -=internet;
                                internet=0;
                                System.out.println("Thank you for payment.");
                                    
                                    break;
                                case 'N':
                                break;
                                default:
                                System.out.println("Invalid selection");
                                    break;
                            }
                        }
                        break;
                
                    default:
                        break;
                }
                break;
                case 'Q':
                System.out.println("Thank you for using our ATM. Have a nice day!");
                break;
                case '5':
                break;
                default:
                System.out.println("Invalid selection.\n\n");
                    break;
            }
        }while(option!='Q'&&option != '5');
        

    }

}