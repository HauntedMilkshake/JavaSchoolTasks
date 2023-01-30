public class savings extends currentAcc{
    boolean hasSavingsAccount = true;
    private double savings;
    public void setSavings(double s){
            this.savings = s;
    } 
    public double getSavings(){
        return savings;
    }
    public void printInfoS(){
        System.out.println("Current savings amount: " + savings);
    } 
}
