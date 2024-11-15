import java.util.Scanner;
class Assignment3{
    private static int accountIndex;
        Scanner inp = new Scanner(System.in);
        public static void main(String[] args) {
            
            
            int[] acctNum ={23445, 31693, 31313};
            String[] acctName={"ibrahim", "tunahan", "bugra alp"};
            String[] acctSurname={"gül", "kaya", "aydin"};
            String[] acctPIN={"2344", "3169", "31"};
            double[] acctBal={4500, 20000, 35000};
            bankLogin(acctNum, acctName, acctSurname, acctPIN, acctBal);
            
            
        }
        
        static int menuDisplay(String[] items, Scanner inp ){
            int choice;
            for (int i = 0; i < 4; i++) {
                System.out.println(i+1 + " - " + items[i]);
            }
            System.out.println(items[4]);
            System.out.print("Please enter your selection >> ");
            choice = inp.next().charAt(0);
            
            return choice;
        }
        static void atm(String[] names, String[] surnames, double[] balances, int index, Scanner inp){
            int choice;
            do{
                System.out.println("\n\nHello " + names[accountIndex]+ " "+ surnames[accountIndex]+"\nWhat would you like to do today?");
                choice = menuDisplay(new String[]{"Account Balance", "Deposit", "Withdrawal", "Change Name", "0 to Quit"}, new Scanner(System.in));


                switch (choice) {
                    case '1':
                        System.out.println("The current balance is: " + (balances[accountIndex]));
                        System.out.println("Have a nice day.");
                    break;
                    
                    case '2':
                        System.out.print("Please enter the amount to deposit: ");
                        double depositAmount = inp.nextDouble();
                        if (depositAmount < 0) {
                            System.out.println("ERROR: Invalid deposit amount.");
                        } else {
                            balances[accountIndex] += depositAmount;
                            balances[accountIndex] = Math.round(balances[accountIndex] * 100.0) / 100.0;
                            System.out.println("The current balance is: " + (balances[accountIndex]) + "\nHave a nice day.");
                        }
                    break;

                    case '3':
                    int ikiyuz, yuz, elli, yirmi, on, bes, bir, ellikrs, yirmibeskrs, onkrs, beskrs, birkrs;
                    System.out.print("Please enter the amount to withdraw: ");
                    double withdrawAmount = inp.nextDouble();

                    if (withdrawAmount >= 0 && withdrawAmount <= balances[accountIndex]) {
                        balances[accountIndex] -= withdrawAmount;
                        balances[accountIndex] = Math.round(balances[accountIndex] * 100.0) / 100.0;  
                        withdrawAmount = Math.round(withdrawAmount * 100.0) / 100.0; 

                        
                        ikiyuz = (int) (withdrawAmount / 200);
                        withdrawAmount %= 200;

                        yuz = (int) (withdrawAmount / 100);
                        withdrawAmount %= 100;

                        elli = (int) (withdrawAmount / 50);
                        withdrawAmount %= 50;

                        yirmi = (int) (withdrawAmount / 20);
                        withdrawAmount %= 20;

                        on = (int) (withdrawAmount / 10);
                        withdrawAmount %= 10;

                        bes = (int) (withdrawAmount / 5);
                        withdrawAmount %= 5;

                        bir = (int) (withdrawAmount / 1);
                        withdrawAmount %= 1;

                        
                        ellikrs = (int) (withdrawAmount / 0.50);
                        withdrawAmount %= 0.50;

                        yirmibeskrs = (int) (withdrawAmount / 0.25);
                        withdrawAmount %= 0.25;

                        onkrs = (int) (withdrawAmount / 0.10);
                        withdrawAmount %= 0.10;

                        beskrs = (int) (withdrawAmount / 0.05);
                        withdrawAmount %= 0.05;

                        birkrs = (int) Math.round(withdrawAmount / 0.01);

                        
                        System.out.println("You will receive the following:");

                        if (ikiyuz > 0) System.out.println(ikiyuz + " - 200");
                        if (yuz > 0) System.out.println(yuz + " - 100");
                        if (elli > 0) System.out.println(elli + " - 50");
                        if (yirmi > 0) System.out.println(yirmi + " - 20");
                        if (on > 0) System.out.println(on + " - 10");
                        if (bes > 0) System.out.println(bes + " - 5");
                        if (bir > 0) System.out.println(bir + " - 1");
                        if (ellikrs > 0) System.out.println(ellikrs + " - 0.5");
                        if (yirmibeskrs > 0) System.out.println(yirmibeskrs + " - 0.25");
                        if (onkrs > 0) System.out.println(onkrs + " - 0.1");
                        if (beskrs > 0) System.out.println(beskrs + " - 0.05");
                        if (birkrs > 0) System.out.println(birkrs + " - 0.01");

                        System.out.println("The current balance is: " + balances[accountIndex] + "\nHave a nice day.");
                    } else {
                        System.out.println("ERROR: Invalid withdrawal amount.");
                    }
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
        
        Scanner bankLoginScanner = new Scanner(System.in);
        System.out.print("Please enter your account number >> ");
        int acctNumber = bankLoginScanner.nextInt();
        bankLoginScanner.nextLine();//bir satır temizlendi bir string girdisi almak için
        System.out.print("Please enter your PIN >> ");
        String accountPIN = bankLoginScanner.nextLine();
        accountIndex=findAcc(acctNums, acctNumber);

        if(accountIndex==-1){
            System.out.println("ERROR: Account/PIN combination not found.");
            return;
        }else{
            
            
            String[] names = acctName[accountIndex].split(" ");//name and middle name and surname fixed
                for (int i = 0; i < names.length; i++) {
                    acctName[accountIndex] = names[i].substring(0, 1).toUpperCase() + names[i].substring(1).toLowerCase();
                }
            acctSurname[accountIndex] = acctSurname[accountIndex].toUpperCase();
            
        
        atm(acctName, acctSurname, acctBal, acctNumber, bankLoginScanner);
        }
    }
    static void validDepositAmount(){}
    static void validWithdrawal(){}
    static void cashGiven(){}

}