//@author Ibrahim GUL
//Date : 17.11.2024

import java.util.Scanner;
class Assignment3{
    private static int accountIndex;
        private static String[] surnames;
                private static String[] names;
                    public static void main(String[] args) {
                        
                        
                        int[] acctNumbardolma ={23445, 31693, 31313, 140804};
                        String[] acctName={"ibrahim sad", "tunahan", "bugra alp", "GaMzE"};
                        String[] acctSurname={"gül", "kaya", "aydin", "bIcAkCI"};
                        String[] acctPIN={"2344", "3169", "31", "0347"};
                        double[] acctBal={4500, 20000, 35000, 20000};
                        bankLogin(acctNumbardolma, acctName, acctSurname, acctPIN, acctBal);
                        
                        
                    }
                    
                    static int menuDisplay(String[] items, Scanner inp ){
                        int choice;
                        for (int i = 0; i < items.length; i++) {
                            System.out.println(i+1 + " - " + items[i]);
                        }
                        System.out.println("0 to Quit");
                        System.out.print("Please enter your selection >> ");
                        choice = inp.next().charAt(0);
                        
                        return choice;
                    }
                    static void atm(String[] names, String[] surnames, double[] balances, int index, Scanner inp){
                        int choice;
                        do{
                            System.out.println("\n\nHello " + names[accountIndex]+ ""+ surnames[accountIndex]+"\nWhat would you like to do today?");//space deleted cause of fixName bug
                            choice = menuDisplay(new String[]{"Account Balance", "Deposit", "Withdrawal", "Change Name"}, inp);
            
            
                            switch (choice) {
                                case '1':
                                    System.out.println("The current balance is: " + (balances[accountIndex]));
                                    System.out.println("Have a nice day.");
                                break;
                                
                                case '2':
                                    System.out.print("Please enter the amount to deposit: ");
                                    double depositAmount = inp.nextDouble();
                                    if (!validDeposit(depositAmount)) {
                                        System.out.println("ERROR: Invalid deposit amount.");
                                    } else {
                                        balances[accountIndex] += depositAmount;
                                        balances[accountIndex] = Math.round(balances[accountIndex] * 100.0) / 100.0;
                                        System.out.println("The current balance is: " + (balances[accountIndex]) + "\nHave a nice day.");
                                    }
                                break;
            
                                case '3':
                                System.out.print("Please enter the amount to withdraw: ");
                                double withdrawAmount = inp.nextDouble();
            
                                if (validWithdrawal(balances[accountIndex], withdrawAmount)) {
                                    balances[accountIndex] -= withdrawAmount;
                                    balances[accountIndex] = Math.round(balances[accountIndex] * 100.0) / 100.0;  
                                    withdrawAmount = Math.round(withdrawAmount * 100.0) / 100.0; 
                                    
                                    System.out.println("You will receive the following:");
            
                                    System.out.println(cashGiven(withdrawAmount));
            
                                    System.out.println("Your account balance is: " + balances[accountIndex] + "\nHave a nice day.");
                                } else {
                                    System.out.println("ERROR: Invalid withdrawal amount.");
                                }
                                break;
                                case '4':
                                System.out.print("Please enter your name >> ");
                                inp.nextLine();
                                names[accountIndex]= inp.nextLine();
                                System.out.print("Please enter your surname >> ");
                                surnames[accountIndex]=inp.nextLine();
                                fixName(names[accountIndex], surnames[accountIndex]);
                                break;
                                case '0':
                                System.out.println("Thank you for using our ATM. Have a nice day!");
                                break;
                            
                                default:
                                System.out.println("Invalid selection.");
                            }
                        }while (choice!='0');
                }
                static int findAcc(int[]acctNum, int number){
                    for (int i = 0; i < acctNum.length; i++) {
                        if(number==acctNum[i]){
                            return i;
                        }
                    }
                    return -1;
                }
                public static void bankLogin(int[] acctNums, String[] acctName, String[] acctSurname, String[] acctPIN, double[] acctBal){
                    names=acctName;
                    surnames= acctSurname;
                    Scanner bankLoginScanner = new Scanner(System.in);//bu metotta oluşturulan scanner, menuDisplay hariç diger tum metotlarda kullaniliyor
                    System.out.print("Please enter your account number >> ");
                    int acctNumber = bankLoginScanner.nextInt();
                    bankLoginScanner.nextLine();//bir satır temizlendi bir string girdisi almak için
                    System.out.print("Please enter your PIN >> ");
                    String accountPIN = bankLoginScanner.nextLine();
                    accountIndex=findAcc(acctNums, acctNumber);
            
                    if(accountIndex==-1){
                        System.out.println("ERROR: Account/PIN combination not found.");
                        bankLoginScanner.close();
                        return;
                    }if (!acctPIN[accountIndex].equals(accountPIN)) {
                        System.out.println("ERROR: Account/PIN combination not found.");
                        bankLoginScanner.close();
                        return;
                    }else{
                        fixName(acctName[accountIndex], acctSurname[accountIndex]);
                        atm(acctName, acctSurname, acctBal, acctNumber, bankLoginScanner);
                    }
                }
                static boolean validDeposit(double depositAmount){
                    if(depositAmount>0){
                        return true;
                    }else{
                       return false; 
                    }
                    
                }
                static boolean validWithdrawal(double accountBalance, double withdrawAmount){
                    if(withdrawAmount>0&& withdrawAmount<=accountBalance){
                        return true;
                    }else{
                        return false;
                    }
                }
                static String cashGiven(double amount){
                    int ikiyuz, yuz, elli, yirmi, on, bes, bir, ellikrs, yirmibeskrs, onkrs, beskrs, birkrs;
                                    
                    amount = Math.round(amount * 100.0) / 100.0; 

                    
                    ikiyuz = (int) (amount / 200);
                    amount %= 200;

                    yuz = (int) (amount / 100);
                    amount %= 100;

                    elli = (int) (amount / 50);
                    amount %= 50;

                    yirmi = (int) (amount / 20);
                    amount %= 20;

                    on = (int) (amount / 10);
                    amount %= 10;

                    bes = (int) (amount / 5);
                    amount %= 5;

                    bir = (int) (amount / 1);
                    amount %= 1;
                    
                    ellikrs = (int) (amount / 0.50);
                    amount %= 0.50;

                    yirmibeskrs = (int) (amount / 0.25);
                    amount %= 0.25;

                    onkrs = (int) (amount / 0.10);
                    amount %= 0.10;

                    beskrs = (int) (amount / 0.05);
                    amount %= 0.05;

                    birkrs = (int) Math.round(amount / 0.01);

                    
                    String bills="";
                    if (ikiyuz > 0) bills += (ikiyuz + " - 200\n");
                    if (yuz > 0) bills+=(yuz + " - 100\n");
                    if (elli > 0) bills+=(elli + " - 50\n");
                    if (yirmi > 0) bills+=(yirmi + " - 20\n");
                    if (on > 0) bills +=(on + " - 10\n");
                    if (bes > 0) bills+=(bes + " - 5\n");
                    if (bir > 0) bills+=(bir + " - 1\n");
                    if (ellikrs > 0) bills+= (ellikrs + " - 0.5\n");
                    if (yirmibeskrs > 0) bills+=(yirmibeskrs + " - 0.25\n");
                    if (onkrs > 0) bills+=(onkrs + " - 0.1\n");
                    if (beskrs > 0) bills+=(beskrs + " - 0.05\n");
                    if (birkrs > 0) bills+=(birkrs + " - 0.01\n");
                    if(bills.endsWith("\n")){
                        bills=bills.substring(0, bills.length()-1);
                    }return bills;
                }
                static void fixName(String name, String surname){
                    String[] names1 = name.split(" ");//name and middle name and surname fixed
                    name="";//account name resetted to empty
                            for (int i = 0; i < names1.length; i++) {
                                name += names1[i].substring(0, 1).toUpperCase() + names1[i].substring(1).toLowerCase()+" ";
                    }
                surnames[accountIndex] = surname.toUpperCase();
                names[accountIndex]=name;
            
    }

}