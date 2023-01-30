import java.util.*;

import javax.swing.event.MenuKeyEvent;
import javax.swing.plaf.synth.SynthSplitPaneUI;
class main{
    public static Scanner sc = new Scanner(System.in);
    public static int validateInt(){
        int i;
        do{
            System.out.println("Enter here: ");
            i = sc.nextInt();
        }while(i < 0);
        return i;
    }
    public static double validateDouble(){
        double i;
        do{
            System.out.println("Enter here: ");
            i = sc.nextDouble();
        }while(i < 0);
        return i;
    }
    public static String validateEgn(){
        String egn; 
        do{
            System.out.println("Enter here: ");
            egn = sc.next();
        }while(egn.length() != 10);
        return egn;
    }
    public static String validateIban(){
        String iban; 
        do{
            System.out.println("Enter here: ");
            iban = sc.next();
        }while(iban.length() != 5);
        return iban;
    }
    public static void insertMoney(bankAcc[] arr){
        System.out.println("Enter ammount of money to insert" );
        double m = validateDouble();
        System.out.println("Enter iban");
        String iban = validateIban();
        for(int i = 0; i < arr.length; i ++){
            if(arr[i].getIban().equals(iban)){
                if(arr[i].hasSavingsAccount){
                    System.out.println("do u want to insert in savings account 1 - no 2 - yes ");
                    int choice = sc.nextInt();
                    if(choice == 1){
                        double n = arr[i].getMoney() + m;
                        arr[i].setMoney(n);
                    }else if(choice == 2){
                        double n = arr[i].getMoney() + m;
                        arr[i].setSavings(n);
                    }
                }else{
                    double n = arr[i].getMoney() + m;
                    arr[i].setMoney(n);
                }
            }
        }
    }
    public static void withdraw(bankAcc[] arr){
        System.out.println("Enter ammount of money to withdraw" );
        double m = validateDouble();
        System.out.println("Enter iban");
        String iban = validateIban();
        for(int i = 0; i < arr.length; i ++){
            if(arr[i].getIban().equals(iban)){
                if(arr[i].hasSavingsAccount){
                    System.out.println("do u want to withdraw from in savings account 1 - yes 2 - no ");
                    int choice = sc.nextInt();
                    if(choice == 1){
                        if(arr[i].getSavings() >= m){
                            double n = arr[i].getSavings() - m;
                            arr[i].setSavings(n);
                        }else{
                            System.out.println("Invalid number to withdraw");
                        }
                    }else if(choice == 2){
                        if(arr[i].getMoney() > m){
                            double n = arr[i].getMoney() - m;
                            arr[i].setSavings(n);
                        }else{
                            System.out.println("Invalid number to withdraw");

                        }
                    }
                }else{
                    if(arr[i].getMoney() > m){
                        double n = arr[i].getMoney() - m;
                        arr[i].setMoney(n);
                    }else{
                        System.out.println("Invalid money to withdraw");
                    }
                }
            }
        }
    }
    public static void printInfo(bankAcc[] arr){
        
        System.out.println("Enter iban");
        String iban = validateIban();
        for(int i = 0; i < arr.length; i++){
            if(arr[i].getIban().equals(iban)){
                arr[i].printCurrentAmount();
                arr[i].printInfo();           
            } 
        }
    }
    public static void menu(bankAcc[] arr){
        System.out.println("MENU");
        System.out.println("Insert money into an account 1 ");
        System.out.println("Withdraw money 2");
        System.out.println("print info 3");
        int choice = sc.nextInt();
        switch(choice){
            case 1: insertMoney(arr);
            menu(arr);
            break;
            case 2: 
            withdraw(arr);
            menu(arr);
            break;
            case 3: 
            printInfo(arr);
            menu(arr);
            break;
        }
    }
    
    public static void main(String[] args){
        int size = validateInt();
        bankAcc accounts[] = new bankAcc[size]; 
        for(int i = 0; i < size; i++){
            accounts[i] = new bankAcc();
        }
        for(int i = 0; i < size; i ++){
            System.out.println("info for bank account " + (i + 1));
            System.out.println("Name: ");
            accounts[i].setName(sc.next());
            System.out.println("EGN: ");
            accounts[i].setEgn(validateEgn());
            System.out.println("Address: ");
            accounts[i].setAddress(sc.next());
            System.out.println("IBAN");
            System.out.println("Does he/she have a savings account or just a current account 1 - no 2 - yes");
            int choice = sc.nextInt();
            if(choice == 1){
                accounts[i].hasSavingsAccount = false;
            }else{
                System.out.println("Savings amount: ");
                accounts[i].setSavings(validateDouble());
            }
            System.out.println("Current amount: ");
            accounts[i].setMoney(validateInt());
            

        }
        menu(accounts);
    }
}