import java.util.Random;
import java.util.Scanner;
public class Assignment_02{
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
     String name;
     String surname;
     double balance=-1;
        @SuppressWarnings("resource")
        Scanner opt = new Scanner(System.in);
        System.out.print("Please enter your first name >>");
        name = opt.nextLine();
        
        
        System.out.print("Please enter your surname >>");
        surname = opt.nextLine();

        System.out.print("Please enter your starting balance >>");//balance error message
        balance = opt.nextDouble();
        while(balance<0){
            System.out.println("ERROR: Invalid balance");
            System.out.print("Please enter your starting balance >>");
            balance = opt.nextDouble();
        }
        String[] names = name.split(" ",2);
        for (int i=0;i<names.length;i++) {
            names[i] = names[i].substring(0,1).toUpperCase()+names[i].substring(1).toLowerCase();
        }
        
        //name = name.substring(0,1).toUpperCase()+name.substring(1,name.length()).toLowerCase();
        surname =surname.toUpperCase();
        char option;//created out of do/while cause resetting problem
        Random random = new Random();
        int electricity = random.nextInt(100)*+1;
        int water = random.nextInt(100)*+1;
        int internet = random.nextInt(100)*+1;
        int ikiyuz=0;
        int yuz=0;
        int elli=0;
        int yirmi=0;
        int on=0;
        int bes=0;
        int bir=0;
        int ellikrs=0;
        int yirmibeskrs=0;
        int onkrs=0;
        int beskrs=0;
        int birkrs=0;
        do{
        System.out.print("Hello ");
        for (String a : names) {
            System.out.print(a+" ");
        }
        System.out.println(" "+ surname);
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
                withdrawAmount = opt.nextDouble();

                if(withdrawAmount>=0&&withdrawAmount<=balance){
                    balance-=withdrawAmount;
                    
                    ikiyuz =(int) (withdrawAmount/200);
                    withdrawAmount %=200;
                    
                    yuz = (int) (withdrawAmount/100);
                    withdrawAmount %= 100;
                    
                    elli = (int) (withdrawAmount/50);
                    withdrawAmount %=50;

                    yirmi = (int) (withdrawAmount/20);
                    withdrawAmount %=20;

                    on = (int) (withdrawAmount/10);
                    withdrawAmount %=10;

                    bes = (int) (withdrawAmount/5);
                    withdrawAmount %=5;

                    bir = (int) (withdrawAmount/1);
                    withdrawAmount %= 1;

                    ellikrs = (int) (withdrawAmount/0.5);
                    withdrawAmount %=0.5;

                    yirmibeskrs = (int) (withdrawAmount/0.25);
                    withdrawAmount %= 0.25;

                    onkrs = (int) (withdrawAmount/0.1);
                    withdrawAmount %=0.1;

                    beskrs = (int) (withdrawAmount/0.05);
                    withdrawAmount %=0.05;

                    birkrs = (int) (withdrawAmount/0.01);
                    withdrawAmount %=0.01;
                    if(ikiyuz > 0) System.out.println(ikiyuz + " - 200");
                    if(yuz > 0) System.out.println(yuz + " - 100");
                    if(elli > 0) System.out.println(elli + " - 50");
                    if(yirmi > 0) System.out.println(yirmi + " - 20");
                    if(on > 0) System.out.println(on + " - 10");
                    if(bes > 0) System.out.println(bes + " - 5");
                    if(bir > 0) System.out.println(bir + " - 1");
                    if(ellikrs > 0) System.out.println(ellikrs + " - 0.5");
                    if(yirmibeskrs > 0) System.out.println(yirmibeskrs + " - 0.25");
                    if(onkrs > 0) System.out.println(onkrs + " - 0.1");
                    if(beskrs > 0) System.out.println(beskrs + " - 0.05");
                    if(birkrs > 0) System.out.println(birkrs + " - 0.01");


                    System.out.println("You will receive the following:");

                    System.out.println("The current balance is: "+ balance+ "\nHave a nice day");
                }else{
                    System.out.println("ERROR: Invalid withdraw amount.\n\n");
                }
                break;
                case 'D':
                System.out.print("Please enter the amount to deposit: ");
                depositAmount=opt.nextDouble();
                if(depositAmount<0){
                    System.out.println("ERROR: Invalid deposit amount.\n\n");
                }else{
                    balance+= depositAmount;
                    System.out.println("The current balance is: "+ balance+ "\nHave a nice day.");
                }

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