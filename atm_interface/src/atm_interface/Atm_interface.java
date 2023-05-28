/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atm_interface;

import java.util.Scanner;

class Atm{
    String name;
    String user_Id;
    String password;
    String account_no;
    String user_Pin;
    double balance = 500000;
    int transactions = 0;
    String transaction_History = "";

    //REGISTER 
    public void register()
    {
        
            Scanner sc = new Scanner(System.in);
        
            System.out.println("\nEnter name: ");
            this.name = sc.nextLine();
            System.out.println("Enter UserId: ");
            this.user_Id = sc.nextLine();
            System.out.println("Enter Password: ");
            this.password = sc.nextLine();
            System.out.println("Enter your Account number: ");
            this.account_no = sc.nextLine();
            System.out.println("Enter User pin: ");
            this.user_Pin = sc.next();
            
        
        System.out.println("\n******Registration completed successfully!!!******\n\n====Login to your Account====");
    }

    //LOGING IN TO ATM
    public boolean login() 
    {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in); 
            while (!isLogin)
            {
                System.out.println("\nEnter UserId: ");
                String user_id = sc.nextLine();
                if (user_id.equals(user_Id))  
                { 
                    while (!isLogin)
                    {
                        System.out.print("Enter Your User pin: ");
                        String user_pin = sc.nextLine();
                        if (user_pin.equals(user_Pin)) 
                        { 
                            System.out.println("\n======Login successfull!======\n\n");
                            isLogin = true;
                        }
                        else
                            System.out.println("\nIncorrect Pin entered");
                    }
                }
                else
                    System.out.println("\nUsername not found");
            }
        
        return isLogin;
    }

    //WITHDRAW AMOUNT
    public void withdraw()
    {
        System.out.println("\nEnter the amount to be withdrawn: ");
        Scanner sc = new Scanner(System.in);
            double amount = sc.nextDouble();
            try{
                    if (balance >= amount) 
                    {
                        balance -= amount; 
                        System.out.println("Rs " + amount + " withdrawn.\n");
                        System.out.println("*****Withdrawal Successful!!*****\n");
                        String str = "Rs " + amount + " withdrawn.\n"; 
                        transaction_History = transaction_History.concat(str);
                    } 
                    else
                        System.out.println("\nInsufficient Balance.");
                }
                catch (Exception e){
                }
        
    }

    //DEPOSIT AMOUNT

    public void deposit() 
    {
        System.out.println("\nEnter amount to deposit: ");
        Scanner sc = new Scanner(System.in);
        
            double amount = sc.nextDouble();
            try{
                    if (amount < 100000.00) 
                    {
                        transactions++;
                        balance += amount;
                        System.out.println("Rs " + amount + " deposited\n");
                        System.out.println("*****Deposit successfull!!*****\n");                         
                        String str = "Rs " + amount + " deposited.\n"; 
                        transaction_History = transaction_History.concat(str);
                    } 
                    else
                        System.out.println("\nLimit Exceeded!");
                }
                catch (Exception e) {
                }
        
    }

    //TRANSFER AMOUNT
    public void transfer()
    {
        Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter recepient name :");
            String recepient = sc.nextLine(); 
            System.out.println("Enter amount to be transferred : ");
            double amount = sc.nextDouble();
            try {
                    if (balance >= amount) 
                    {
                        if (amount <= 58000.00) 
                        {
                            transactions++;
                            balance -= amount;
                            System.out.println(" Rs " + amount + " transferred to " + recepient + "\n");
                            System.out.println("*****Successfully transferred to " + recepient +"*****\n");
                            String str = " Rs " + amount + " transferred to " + recepient + "\n"; 
                            transaction_History = transaction_History.concat(str);
                        }
                        else
                            System.out.println("\nsorry! Limit is 150000.00");
                    } 
                    else
                        System.out.println("\nInsufficient Balance.");
                }
                catch (Exception e) {
                }
        
    }

    //CHECK BALANCE IN ACCOUNT
    public void checkBalance() 
    {
        System.out.println("\nAmount present in your account is Rs" + balance);
    }

    //TRANSACTION HISTORY
    public void transHistory() 
    {
        if (transactions == 0) 
            System.out.println("\nEmpty!");
        else
            System.out.println("\nTransaction Details: \n" + transaction_History);
    }
}

//MAIN CLASS
public class ATM_interface extends Atm
{
    public static int takeInput() 
    {
        int input = 0;
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
        return input;
    }


    public static void main(String[] args)
    {
        System.out.println("\n ***************WELCOME TO SBI ATM***************  \n");
        System.out.println("1. Register\n2. Exit");
        System.out.print("=======================");
        System.out.print("\nEnter your choice: ");
        int choice = takeInput();
        if(choice == 1) 
        {
            Atm ai = new Atm();
            System.out.print("=======================\n");
            ai.register();
            while(true)
            {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("=======================\n");
                System.out.print("Enter your choice: ");
                int ch = takeInput();
                if (ch == 1)
                {
                    System.out.print("=======================\n");
                    if (ai.login())
                    {
                        System.out.println("\n\n*********WELCOME BACK " + ai.name + "!!*********\n");
                        boolean isFinished = false;
                        while (!isFinished) 
                        {
                            System.out.println("\n1.Deposit \n2.Withdraw \n3.Transferring \n4.Transaction History \n5.Check Balance");
                            System.out.print("=======================\n");
                            System.out.print("Enter your choice: ");
                            int c = takeInput();
                            switch(c)
                            {
                                case 1:
                                    System.out.print("=======================\n");
                                    ai.deposit();
                                    break;
                                case 2:
                                    System.out.print("=======================\n");
                                    ai.withdraw();
                                    break;
                                case 3:
                                    System.out.print("=======================\n");
                                    ai.transfer();
                                    break;
                                case 4:
                                    System.out.print("=======================\n");
                                    ai.transHistory();
                                    break;
                                case 5:
                                    System.out.print("=======================\n");
                                    ai.checkBalance();
                                    break;
                                case 6:
                                    System.out.print("=======================\n");
                                    isFinished = true;
                                    break;
                                default:
                                    System.out.println("\nWrong Choice!");
                            }
                        }
                    }
                }
                if(ch == 2)
                {
                    System.out.print("=======================\n");
                    System.out.print("\n\n********EXITED SUCCESSFULLY*******\n");
                    System.exit(0);
                }
                else
                {
                    System.out.println("\nEnter valid choice###");
                }
                
                    
            }
        }
        if(choice == 2)
            {
                
                System.exit(0);
            }
        else
            {
                  System.out.println("Enter valid choice");
            }
    }
}