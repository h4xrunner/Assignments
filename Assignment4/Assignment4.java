import java.io.*;
public class Assignment4 {
    public static void main(String[] args) throws IOException {
        int numOfAccounts= countAccounts("Assignment4_AccountInfo.txt");
        int[] acctNums = new int[numOfAccounts];
        String[] acctNames = new String[numOfAccounts];
        String[] acctSurnames = new String[numOfAccounts];
        double[] balances = new double[numOfAccounts];
        
          
        readAccountInfo(acctNums, acctNames, acctSurnames, balances, "Assignment4_AccountInfo.txt");
        for (int i = 0; i < numOfAccounts; i++) {
            System.out.println(acctNums[i]+" "+acctNames[i]+" "+acctSurnames[i]+" "+balances[i]);
        }
        System.out.println(transfer(acctNums, balances, 98765, 67890, 150));
        for (int i = 0; i < numOfAccounts; i++) {
            System.out.println(acctNums[i]+" "+acctNames[i]+" "+acctSurnames[i]+" "+balances[i]);
        }

    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static int countAccounts(String filename)throws IOException{
        int accountCount=0;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while(reader.readLine()!=null){
            accountCount++;
        }
        reader.close();
        return accountCount;
    }//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static void readAccountInfo(int[] acctNums, String[] names, String[] surnames, double[] balances, String filename) throws IOException{
        BufferedReader infoReader = new BufferedReader(new FileReader(filename));
        int index=0;//at the end of while, integer i should increase one
        String line;//
        String[] lineInfo = new String[countAccounts("Assignment4_AccountInfo.txt")];
        while((line=infoReader.readLine())!=null){//readLine() her çağırıldığınde bir kez okuduğundan while içinde bile çağrılsa bir kez görevini yapmış sayılır.
            int id;
            double balance;
            lineInfo = line.split(" ");
            id=Integer.parseInt(lineInfo[0]);
            acctNums[index]=id;
            names[index]=lineInfo[1];
            surnames[index]=lineInfo[2];
            balance=Double.parseDouble(lineInfo[3]);
            balances[index]=balance;
            index++;
        }
        infoReader.close();
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static boolean deposit(double[] balances, int index, double amount){
        if(!isDepositValid(amount)){
            return false;
        }else{
            balances[index]+=amount;
            return true;
        }
    }
    static boolean withdrawal(double[] balances, int index, double amount){
        if(!isWithdrawalValid(balances[index], amount)){
            return false;
        }else{
            balances[index]-=amount;
            return true;
        }
    }

    static int transfer(int[] acctNums, double[] balances, int acctNumFrom, int acctNumTo, double amount){
        if(findAcc(acctNums, acctNumTo)==-1){
            return 1; 
        }else if(findAcc(acctNums, acctNumFrom)==-1){
            return 2;
        }else if (isWithdrawalValid(balances[findAcc(acctNums, acctNumFrom)], amount)==false) {
            return 3;
        }else{
            balances[findAcc(acctNums, acctNumFrom)]-=amount;
            balances[findAcc(acctNums, acctNumTo)]+=amount;
            return 0;
        }
        
        
    }



    static int findAcc(int[]acctNum, int number){
        for (int i = 0; i < acctNum.length; i++) {
            if(number==acctNum[i]){
                return i;
            }
        }
        return -1;
    }
    static boolean isDepositValid(double depositAmount){
        if(depositAmount>0){
            return true;
        }else{
           return false; 
        }
        
    }
    static boolean isWithdrawalValid(double accountBalance, double withdrawAmount){
        if(withdrawAmount>0&& withdrawAmount<=accountBalance){
            return true;
        }else{
            return false;
        }
    }


}