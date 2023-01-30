import java.util.*;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int initInt(){
        int n;
        do{
            System.out.println("Enter a number: ");
            n = sc.nextInt();
        }while(n < 0);
        return n;
    }
    public static String initS(){
        String n;
        do{
            System.out.println("Enter: ");
            n = sc.next();
        }while(n.length() != 10);
        return n;
    }
    public static void searchByCat(apartments[] a){
        System.out.println("1 Studio");
        System.out.println("2 Micro");
        System.out.println("3 Loft");
        String search = sc.next();
        for(int i = 0; i < a.length; i++){
            if(search.equals(a[i].cat)){
                System.out.println("Found a match at: " + (i + 1));
                a[i].printInfo();
                a[i].printBrokerInfo();
            }
        }
            
    }
    public static void searchByPrice(apartments[] a){
        System.out.println("Search by price");
        System.out.println("lower bound: ");
        int l = initInt();
        System.out.println("upper bound: ");
        int u = initInt();
        for(int i = 0; i < a.length; i++){
            if(a[i].price > l && a[i].price < u ){
                System.out.println("Found a match at: " + (i + 1));
                a[i].printInfo();
                a[i].printBrokerInfo();
            }
        }
    }
    public static void searchBySize(apartments[] a){
        System.out.println("Search by size");
        System.out.println("lower bound: ");
        int l = initInt();
        System.out.println("upper bound: ");
        int u = initInt();
        for(int i = 0; i < a.length; i++){
            if(a[i].size > l && a[i].size < u ){
                System.out.println("Found a match at: " + (i + 1));
                a[i].printInfo();
                a[i].printBrokerInfo();
            }
        }
    }
    public static void menu(apartments[] a){
        System.out.println("        Menu        ");
        System.out.println("1. Search by house category");
        System.out.println("2. Search between 2 prices");
        System.out.println("3. Search between ap size");
        System.out.println("4. Exit");
        int c = initInt();
        switch(c){
            case 1:
            searchByCat(a);
            menu(a);
            break;
            case 2:
            searchByPrice(a);
            menu(a);
            break;
            case 3:
            searchBySize(a);
            menu(a);
            break;
            case 4:
            break;
        }
    }
    public static void main(String[] args){
        int size = 0;
        size = initInt();
        apartments[] apartmentComplex = new apartments[size];
        for(int i = 0; i < size; i ++){
            apartmentComplex[i] = new apartments();
        }
        for(int i = 0; i < size; i ++){
            System.out.println("Info for broker : " + (i + 1));
            System.out.println("Name : ");
            apartmentComplex[i].name = sc.next();
            System.out.println("Address ");
            apartmentComplex[i].brokerAddress = sc.next();
            System.out.println("email: ");
            apartmentComplex[i].email = sc.next();
            System.out.println("EGN: ");
            apartmentComplex[i].EGN = initS();
            System.out.println("phone number: ");
            apartmentComplex[i].phoneNumber = initS();
            System.out.println("Aprtment adress he/she is assigned to: ");
            apartmentComplex[i].address = sc.next();
            System.out.println("Category for ap: ");
            System.out.println("1 Studio");
            System.out.println("2 Micro");
            System.out.println("3 Loft");
            apartmentComplex[i].cat = sc.next();
            System.out.println("Size: ");
            apartmentComplex[i].size = initInt();
            System.out.println("Price: ");
            apartmentComplex[i].price = sc.nextDouble();
            
        }
        menu(apartmentComplex);
    }
}
