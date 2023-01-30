public class currentAcc {
    boolean hasCurrentAcc = true;
    private double money; 
    public double getMoney(){
        return money;
    }
    public void setMoney(double m){
        this.money = m;
    }
    public void printCurrentAmount(){
        System.out.println("print current amount: " + money);
    }
}
