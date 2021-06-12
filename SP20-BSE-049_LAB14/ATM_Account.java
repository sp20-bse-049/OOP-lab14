
package lab14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;


public class ATM_Account implements Serializable {
    private String accountNumber;
    private int balance;
    
    public ATM_Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return "ATM_Account{" + "accountNumber='" + accountNumber + '\'' + ", balance=" + balance + '}' + "\n";
    }
    
}

 class ATM_Account_main {
    private static ATM_Account[] atmAccountArray = new ATM_Account[10];
    private static BufferedWriter writer;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public void balanceInquiry (String accountNumber){
        boolean isFound=false;
        for (int i=0;i<10;i++){
            if (atmAccountArray[i].getAccountNumber().equalsIgnoreCase(accountNumber)){
                isFound=true;
                System.out.println("The Account Balance is: "+ atmAccountArray[i].getBalance());
                break;
            }
        }
        if(!isFound)
            System.out.println("No such Account Number Found");
    }
    
    public void withdraw(String accountNumber) throws IOException{
        boolean isFound=false;
        int withdrawAmount;
        for (int i=0;i<10;i++) {
            if (atmAccountArray[i].getAccountNumber().equalsIgnoreCase(accountNumber)) {
                isFound = true;
                System.out.println("Please enter Withdrawl Amount");
                withdrawAmount = Integer.parseInt(br.readLine());
                if (atmAccountArray[i].getBalance() >= withdrawAmount)
                    atmAccountArray[i].setBalance(atmAccountArray[i].getBalance() - withdrawAmount);
                else
                    System.out.println("Sorry!!, not enough balance to withdraw from your Account");
                break;
            }
        }
        if(!isFound)
            System.out.println("No such Account Number Found");
    }
    
    public void deposit(String accountNumber) throws Exception{
        boolean isFound=false;
        int depositAmount;
        for (int i=0;i<10;i++) {
            if (atmAccountArray[i].getAccountNumber().equalsIgnoreCase(accountNumber)) {
                isFound = true;
                System.out.println("Please enter Deposit Amount");
                depositAmount = Integer.parseInt(br.readLine());
                if (depositAmount < 0)
                    System.out.println("Sorry!! You cannot enter Negative Amount to Deposit");
                else
                    atmAccountArray[i].setBalance(atmAccountArray[i].getBalance() + depositAmount);
                
                break;
            }
        }
        if(!isFound)
            System.out.println("No such Account Number Found");
    }
    
    public void transfer(String accountNumberFrom, String accountNumberTo) throws Exception{
        int fromPosition=-1, toPosition=-1;
        int transferAmount;
        for (int i=0;i<10;i++){
            if (atmAccountArray[i].getAccountNumber().equalsIgnoreCase(accountNumberFrom)) {
                fromPosition = i;
                break;
            }
        }
        for (int i=0;i<10;i++){
            if (atmAccountArray[i].getAccountNumber().equalsIgnoreCase(accountNumberTo)) {
                toPosition = i;
                break;
            }
        }
        
        if (fromPosition !=-1 && toPosition !=-1){
            System.out.println("Please enter Amount to transfer");
            transferAmount = Integer.parseInt(br.readLine());
            if (atmAccountArray[fromPosition].getBalance() >= transferAmount) {
                atmAccountArray[fromPosition].setBalance(atmAccountArray[fromPosition].getBalance() - transferAmount);
                atmAccountArray[toPosition].setBalance(atmAccountArray[toPosition].getBalance() + transferAmount);
            }else
                System.out.println("Sorry!! insufficient funds to transfer");
        }
    }
    
    public static void main(String[] args) throws Exception{
        
        ATM_Account account1 = new ATM_Account("123456", 3000);
        ATM_Account account2 = new ATM_Account("234455", 3000);
        ATM_Account account3 = new ATM_Account("25654321", 3000);
        ATM_Account account4 = new ATM_Account("77665544", 3000);
        ATM_Account account5 = new ATM_Account("12344", 3000);
        ATM_Account account6 = new ATM_Account("8374650", 3000);
        ATM_Account account7 = new ATM_Account("187560", 3000);
        ATM_Account account8 = new ATM_Account("23456789011", 3000);
        ATM_Account account9 = new ATM_Account("065432100", 3000);
        ATM_Account account10 = new ATM_Account("998512340", 3000);
        atmAccountArray[0] = account1;
        atmAccountArray[1] = account2;
        atmAccountArray[2] = account3;
        atmAccountArray[3] = account4;
        atmAccountArray[4] = account5;
        atmAccountArray[5] = account6;
        atmAccountArray[6] = account7;
        atmAccountArray[7] = account8;
        atmAccountArray[8] = account9;
        atmAccountArray[9] = account10;
        
        // Write all 10 objects into a file
        writer = new BufferedWriter(new FileWriter("D:\\Account.txt", false));
        writer.write("The Initial Accounts before transaction are:----> \n");
        writer.write(account1.toString());
        writer.write(account2.toString());
        writer.write(account3.toString());
        writer.write(account4.toString());
        writer.write(account5.toString());
        writer.write(account6.toString());
        writer.write(account7.toString());
        writer.write(account8.toString());
        writer.write(account9.toString());
        writer.write(account10.toString());
    
        ATM_Account_main obj1 = new ATM_Account_main();
        obj1.balanceInquiry("12344");
        obj1.withdraw("123456");
        obj1.deposit("123456789");
        obj1.transfer("123456","234455");
        
        obj1.deposit("123456");
        obj1.deposit("12344");
        obj1.deposit("987654321123");
        
        writer.write("The Final Accounts Accounts after transaction are: \n");
        writer.write(account1.toString());
        writer.write(account2.toString());
        writer.write(account3.toString());
        writer.write(account4.toString());
        writer.write(account5.toString());
        writer.write(account6.toString());
        writer.write(account7.toString());
        writer.write(account8.toString());
        writer.write(account9.toString());
        writer.write(account10.toString());
        writer.close();
    }
}
