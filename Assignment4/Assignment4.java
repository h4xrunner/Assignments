import java.io.*;
import java.nio.Buffer;
public class Assignment4 {
    public static void main(String[] args) throws IOException {
        String baseFileName=args[0];
        int numOfAccounts= countAccounts(baseFileName+"_AccountInfo.txt");
        int[] acctNums = new int[numOfAccounts];
        String[] acctNames = new String[numOfAccounts];
        String[] acctSurnames = new String[numOfAccounts];
        double[] balances = new double[numOfAccounts];
        

        
        File logCreater = new File(baseFileName+".log");

        if(!logCreater.exists()){
            logCreater.createNewFile();
        }

        File accountInfoOut = new File(baseFileName+"_AccountInfoOut.txt");
        if(!accountInfoOut.exists()){
            accountInfoOut.createNewFile();
        }

        

        
        BufferedWriter logWriter = new BufferedWriter(new FileWriter(baseFileName+".log"));
          
        readAccountInfo(acctNums, acctNames, acctSurnames, balances, baseFileName+"_AccountInfo.txt");
        for (int i = 0; i < numOfAccounts; i++) {
            System.out.println(acctNums[i]+" "+acctNames[i]+" "+acctSurnames[i]+" "+balances[i]);
        }
        System.out.println(transfer(acctNums, balances, 98765, 67890, 1));
        for (int i = 0; i < numOfAccounts; i++) {
            System.out.println(acctNums[i]+" "+acctNames[i]+" "+acctSurnames[i]+" "+balances[i]);
        }
        writeAccountInfo(acctNums, acctNames, acctSurnames, balances, baseFileName+"_AccountInfoOut.txt");

    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static int countAccounts(String filename)throws IOException{
        int accountCount=0;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while(reader.readLine()!=null){
            accountCount++;
        }
        reader.close();
        return accountCount;
    }
    static void readAccountInfo(int[] acctNums, String[] names, String[] surnames, double[] balances, String filename) throws IOException{
        BufferedReader infoReader = new BufferedReader(new FileReader(filename));
        int index=0;//at the end of while, integer i should increase one
        String line;//
        String[] lineInfo = new String[countAccounts(filename)];
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
    static void writeAccountInfo(int[] acctNums, String[] names, String[] surnames, double[] balances, String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        
        
        for (int i = 0; i < acctNums.length; i++) {
            writer.write(acctNums[i]+" "+names[i]+" "+surnames[i]+" "+balances[i]);
            writer.newLine();
            
        }         
        writer.close();
    }

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

    static int transfer(int[] acctNums, double[] balances, int acctNumFrom, int acctNumTo, double amount)throws IOException{
        

        if(findAcc(acctNums, acctNumTo)==-1){
            return 3; 
        }else if(findAcc(acctNums, acctNumFrom)==-1){
            return 2;
        }else if (isWithdrawalValid(balances[findAcc(acctNums, acctNumFrom)], amount)==false) {
            return 1;
        }else{
            balances[findAcc(acctNums, acctNumFrom)]-=amount;
            balances[findAcc(acctNums, acctNumTo)]+=amount;
            return 0;
        }
        
        
    }
    static void processBillPayInfo(int[] acctNums, double[] balances, String filename, BufferedWriter logWriter) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            return; // Skip if no bill payment file
        }

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line="";
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String billPayNum = parts[0];
            int acctNumFrom = Integer.parseInt(parts[1]);
            String billType = parts[2];
            double amount = Double.parseDouble(parts[3]);

            int index = findAcc(acctNums, acctNumFrom);
            if (index == -1 || !withdrawal(balances, index, amount)) {
                logWriter.write("Bill Pay " + billPayNum + " (" + billType + ") failed: NSF - Insufficient Funds");
            } else {
                logWriter.write("Bill Pay " + billPayNum + " (" + billType + ") successful.");
            }
            logWriter.newLine();
        }
        reader.close();
    }
    static void processTransferInfo(int[] acctNums, double[] balances, String filename, BufferedWriter logWriter) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String transferNum = parts[0];
            int acctNumFrom = Integer.parseInt(parts[1]);
            int acctNumTo = Integer.parseInt(parts[2]);
            double amount = Double.parseDouble(parts[3]);

            int result = transfer(acctNums, balances, acctNumFrom, acctNumTo, amount);
            logWriter.write("Transfer " + transferNum + " resulted in code " + result + ": " + getResultDescription(result));
            logWriter.newLine();
        }
        reader.close();
    }
    static String getResultDescription(int result) {
        switch (result) {
            case 0:
                return "STX - Transfer Successful";
            case 1:
                return "NSF - Insufficient Funds";
            case 2:
                return "FNF - From Account not found";
            case 3:
                return "TNF - To Account not found";
            default:
                return "UNK - Unknown Error";
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