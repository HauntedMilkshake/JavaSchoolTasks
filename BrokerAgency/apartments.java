public class apartments extends broker{
    public String address;
    public String cat;
    public int size;
    //in squares
    double price;
    public void printInfo(){
        System.out.println("Apartment location " + address + " Category: " + cat + " Size in square metres: " + size);
        System.out.println("Info about the assigned broker: ");
    }
}
