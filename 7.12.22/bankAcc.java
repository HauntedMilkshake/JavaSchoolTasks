public class bankAcc extends savings{
    private String name;
    private String iban;
    private String egn;
    private String address;
    public void setName(String n){
        this.name = n;
    }
    public void setIban(String i){
        this.iban = i;
    }
    public void setEgn(String e){
        this.egn = e;
    }
    public void setAddress(String a){
        this.address = a;
    }
    public String getName(){
        return name;
    }
    
    public String getEgn(){
        return egn;
    }
    public String getIban(){
        return iban;
    }
    public String getAddress(){
        return address;
    }
    public void printInfo(){
        System.out.println("Name: " + name);
        System.out.println("EGN " + egn);
        System.out.println("iban: " + iban);
        System.out.println("Address: " + address);
    }
}
